/*
 * Copyright (c) Jim Coles (jameskcoles@gmail.com) 2016. through present.
 *
 * Licensed under the following license agreement:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Also see the LICENSE file in the repository root directory.
 */
package org.jkcsoft.recon.commands.r2;

import org.w3c.dom.Node;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Reconciles data in an XML file to an RDB table assuming this mapping:
 * <p>
 * <[entity]-table>
 * <[entity]>
 * <col-1>value</col-1>
 * <col-2>value</col-2>
 * </[entity]>
 * </[entity]-table>
 */
public class ReconXmlToRdb {

    public void doRecon() throws Exception {
        Node xmlRoot = null;
        Connection rdbConn = null;

        String xmlIdAttr = "id";

        String rdbIdCol = "oid";

//        XPathAPI.
//
//        if () {
//
//        }


    }

    Node findXmlEntityNode(Node parentNode)
            throws Exception {
        return null;
    }

    ResultSet findRdbEntityRow(Connection conn)
            throws Exception {
        return null;
    }

}
