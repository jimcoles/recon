/*
 * Copyright (c) Jim Coles (jameskcoles@gmail.com) 2016. through present.
 *
 * Licensed under the following license agreement:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Also see the LICENSE file in the repository root directory.
 */
package org.jkcsoft.recon.commands.r1.rdb2xml;

import org.jkcsoft.java.jdbc.JdbcUtil;
import org.jkcsoft.java.util.Strings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.*;
import java.util.List;

/**
 * A simple main() app that takes an RDB table / view and pipes it to an xml file.
 * Here to motivate the more generic logic.
 * <p>
 * TODO: XML api in which consumer declares usage at construction time and underlying impl is
 * optimized to usage, e.g., SAX parser for full-one-pass read; builder for random read/write;
 * stream for one-pass write; XPATH for specific subset read
 */
public class RdbToXml_1 {
    public static void main(String[] args) {
        // TODO: use generic command-line to message xform; pass generic parameterized request
        //       to doer.
        try {
            RdbToXml_1 doer = new RdbToXml_1();
            doer.doTransform("CURRENT_OPENINGS", "REQ_NUM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doTransform(String tableName, String sequenceColumn) throws Exception {
        Document retDoc = null;
        String strSql = "SELECT * FROM " + tableName + " ORDER BY " + sequenceColumn;
        try {
//           DataSource ds = SQLDriver;
            Connection conn = DriverManager.getConnection("");
            conn.setAutoCommit(false);
            try {
                PreparedStatement ps = conn.prepareStatement(strSql);
                ResultSet rs = ps.executeQuery();
                try {
                    String xmlElemRootName = dbToXmlName(tableName);
                    Document retDoc1 = null;
                    String strListTagName = xmlElemRootName + "-list";
                    List lColNames = null;
                    Element xelemList = null, xelemItem = null, xelemAttr = null;
                    // build start of doc
                    retDoc1 = getDbf().newDocumentBuilder().newDocument();
                    xelemList = retDoc1.createElement(strListTagName);
                    retDoc1.appendChild(xelemList);
                    //
                    ResultSetMetaData rsm = rs.getMetaData();
                    lColNames = JdbcUtil.buildColList(rsm);
                    int ncols = lColNames.size();
                    while (rs.next()) {
                        xelemItem = retDoc1.createElement(xmlElemRootName);
                        xelemList.appendChild(xelemItem);
                        for (int idx = 0, idx1 = 1; idx < ncols; idx++, idx1++) {
                            xelemAttr = retDoc1.createElement(lColNames.get(idx).toString());
                            Object oValue = rs.getObject(idx1);
                            Node xValue = null;
                            if (oValue != null) {
                                String textValue = null;
                                int coltype = rsm.getColumnType(idx + 1);
                                // NOTE: use either CDATA or Text nodes depending on data type.
                                if (coltype == Types.CLOB) {
                                    Clob clob = (Clob) oValue;
                                    textValue = JdbcUtil.clobToString(clob, "");
                                    xValue = retDoc1.createCDATASection(textValue);
                                } else if (coltype == Types.DATE) {
                                    textValue = Long.toString(((Date) oValue).getTime());
                                    xValue = retDoc1.createTextNode(textValue);
                                } else if (coltype == Types.TIMESTAMP) {
                                    textValue = Long.toString(((Timestamp) oValue).getTime());
                                    xValue = retDoc1.createTextNode(textValue);
                                } else if (coltype == Types.TIME) {
                                    textValue = Long.toString(((Time) oValue).getTime());
                                    xValue = retDoc1.createTextNode(textValue);
                                } else {
                                    textValue = Strings.toStringDef(oValue.toString(), "");
                                    xValue = retDoc1.createCDATASection(textValue);
                                }
                                xelemAttr.appendChild(xValue);
                            }
                            xelemItem.appendChild(xelemAttr);
                        }
                    }
                    retDoc = retDoc1;
                } finally {
                    JdbcUtil.safeClose(rs);
                }
            } finally {
                JdbcUtil.safeCommit(conn);
                JdbcUtil.safeClose(conn);
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * ABC_EFG  --> abc-efg
     * <p>
     * AbcEfg --> abc-efg
     *
     * @param in
     * @return
     */
    private String dbToXmlName(String in) {
        String out = null;

        out = in.toLowerCase();
        out.replace('_', '-');

        return out;
    }

    /**
     * Little DBF factory
     */
    private DocumentBuilderFactory getDbf() {
        // init the XML builder factory for use in this app.
        DocumentBuilderFactory dbf = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
        } catch (javax.xml.parsers.FactoryConfigurationError ex) {
            System.out.println("Exception initializing JAXP document builder factory -->");
            ex.printStackTrace();
            System.out.println("\nInternal Exception -->");
            Exception ex1 = ex.getException();
            if (ex1 != null) {
                ex1.printStackTrace();
            }
        }

        dbf.setValidating(false);
        dbf.setIgnoringComments(true);
        // next three lines are new to jaxp 1.1
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setCoalescing(true);
        dbf.setExpandEntityReferences(false);

        return dbf;
    }
}
