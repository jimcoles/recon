/*
 * Copyright (c) Jim Coles (jameskcoles@gmail.com) 2016. through present.
 *
 * Licensed under the following license agreement:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Also see the LICENSE file in the repository root directory.
 */

package org.jkcsoft.recon.ui.recon1_0;

import org.jkcsoft.recon.data.DataSystem;
import org.jkcsoft.space.lang.Oid;

/**
 * Responsible for applying the data operation set for a given unit
 * of work.  Manages transactions.
 *
 * @author Jim Coles
 * @version 1.0
 */
public class Reconciler {
    public static void main(String args[]) {
        ReconMainFrame wMain = new ReconMainFrame();
        wMain.initTree();
        wMain.setVisible(true);
    }

    //---------------------------------------------------------------------------
    // Constructor(s)
    //---------------------------------------------------------------------------
    public Reconciler() {
    }

    //---------------------------------------------------------------------------
    // Public methods
    //---------------------------------------------------------------------------

    // <Primary Operations>

    /**
     * Creates a DifferenceList by comparing data in one system to those in
     * another.  Also generates a default reconcile action list.
     */
    public void difference(Oid dataSystemFromOid, Oid dataSystemToOid)
            throws Exception {

    }

    /**
     * Applies a reconcile action set to the from and to data system data sets
     * resulting in, in general, updates to both systems.
     */
    public void reconcile()
            throws Exception {
        // todo: Use pesimistic locking for multi-row operations.

    }

    // </Primary Operations>

    //---------------------------------------------------------------------------
    // Private methods
    //---------------------------------------------------------------------------

    /**
     * Algorithm: <br>
     * - Connect to each DataSystem
     * - Get Cursors to each DataSet
     * NOTE: DataSet queries must sort sets by an attribute combination that
     * includes a unique key.  In general, need some 'equivalence' relation to
     * use to determine which record of one DataSystem is the counterpart of
     * the other DataSystem.
     * <p>
     * - Traverse dsFrom and dsTo simultaneously
     * - Build the DifferenceList based on whether records
     * - exist in one DataSystem but not the other
     * - in both DataSystems but different
     */
    public void _difference(DataSystem dsFrom, DataSystem dsTo)
            throws Exception {
        // connect to dsFrom


        // connect to dsTo

        // get cursor to dsFrom

        // get cursor to


    }

    public void _reconcile(DataSystem dsFrom, DataSystem dsTo)
            throws Exception {

    }

}