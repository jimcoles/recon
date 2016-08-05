/*
 * Copyright (c) Jim Coles (jameskcoles@gmail.com) 2016. through present.
 *
 * Licensed under the following license agreement:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Also see the LICENSE file in the repository root directory.
 */
package org.jkcsoft.recon.data;

import org.jkcsoft.space.lang.Oid;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

//import com.jkc.dms.Connector;

/**
 * The top level server object for the Systematic data management system.
 * Internally, other objects will call into this one to get Java objects
 * with Oids.
 * <p>
 * Patterns and Responsibilities:
 * Command Processor - coordinates Connections and piping operation requests
 * to Querier, Differencer, Reconciler.
 * <p>
 * Bean Type: Session or Service
 *
 * @author Jim Coles
 * @version 1.0
 */
public class DataSystemManager extends DataSystem {
    //----------------------------------------------------------------------------
    // Private instance vars
    //----------------------------------------------------------------------------

    //----------------------------------------------------------------------------
    // Constructor(s) (private, package, protected, public)
    //----------------------------------------------------------------------------
    public DataSystemManager() {

    }

    //----------------------------------------------------------------------------
    // Public methods - accessors, mutators, other
    //----------------------------------------------------------------------------

    /**
     * Quick and dirty just to get things going.
     */
    public void export()
            throws Exception {
        Class.forName("COM.cloudscape.core.JDBCDriver").newInstance();
// from ant build: jdbc:rmi://localhost:1099/jdbc:cloudscape:IdServiceDB
// from cs doc ex:  java.sql.Connection conn = DriverManager.getConnection("jdbc:cloudscape:toursDB");
//    String csurl = "jdbc:cloudscape:rmi://localhost:1099/jdbc:cloudscape:IdServiceDB";  --> No Suitable Driver
//    String csurl = "jdbc:cloudscape:rmi:IdServiceDB";  --> No Suitable Driver
        String csurl = "jdbc:cloudscape:IdServiceDB";
        System.out.println("connection url: " + csurl);
        java.sql.Connection conn = DriverManager.getConnection(csurl);
        try {
            DatabaseMetaData dbmeta = conn.getMetaData();
            ResultSet tables = dbmeta.getTables("", "", "", new String[]{});
        } finally {
            conn.close();
        }
    }


    //---- <Accessors and Mutators> ----------------------------------------------

    //---- </Accessors and Mutators> ----------------------------------------------

    //----------------------------------------------------------------------------
    // Package methods
    //----------------------------------------------------------------------------

    DataSystem getDataSystem(Oid oid)
            throws Exception {
        return null;
    }


/*
  Connector getConnectorForDataSystem(Oid oid)
    throws Exception
  {
    return null;
  }
*/

    //----------------------------------------------------------------------------
    // Private methods
    //----------------------------------------------------------------------------
}