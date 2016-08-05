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

/**
 * The top level notion of data systems upon which
 * our DMS acts with data operations.  Examples are an RDBMS, XML Files,
 * a JNDI directory, a email folder system such as Outlook.
 * <p>
 * DataSystems can have multiple child sub-systems.
 *
 * @author Jim Coles
 * @version 1.0
 */

public abstract class DataSystem {

    public DataSystem() {
    }
}