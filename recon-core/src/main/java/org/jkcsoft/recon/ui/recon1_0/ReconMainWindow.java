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

import javax.swing.*;
import java.awt.*;

public class ReconMainWindow extends JFrame {
    public ReconMainWindow() throws HeadlessException {
        add(new ReconMainFrame());
    }
}
