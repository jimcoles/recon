/*
 * Copyright (c) Jim Coles (jameskcoles@gmail.com) 2016. through present.
 *
 * Licensed under the following license agreement:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Also see the LICENSE file in the repository root directory.
 */

/*
 * LicenseMgr.java
 *
 * Created on April 9, 2002, 11:49 AM
 */

package org.jkcsoft.recon.license;

/**
 * Controls access to the SSC IMS features based on the active license.
 * Important if we are to make money.  Support the following:
 * <p>
 * Trial Version Mode
 * <p>
 * N-machine Mode
 * <p>
 * Site License Mode
 * <p>
 * TODO: Develop license key nomenclature, encryption and encoding scheme.
 * <p>
 * Classes likely to be involved:
 * <p>
 * Product / Sub-Product
 * <p>
 * Product Version
 * <p>
 * Product Instance
 * .serialNumber
 * <p>
 * LicenseType
 * TrialLicense
 * NMachineLicense
 * SiteLicense
 * <p>
 * (Product Instance) LicenseGrant - Associates and authorizes a specific
 * ProductInstance to a License class
 * .productinstanceid
 * .productid
 * .licenseTypeCode
 * .numberOfLicenses
 * <p>
 * LicensedMachine - tie each license to specific machine id?
 * .machineId
 * <p>
 * InstalledCustomer - Our big "C".
 * .customerId
 * <p>
 * RegistrationKey - Is this the same as the LicenseGrant.  Given to Customers
 * after they register a given ProductInstance.
 * <p>
 * CentralLicenseServerProxy - Need an object to call into our central server
 * for customer-driven registration? OR, just link to our web site and
 * email them their Registration Keys.
 * <p>
 * Other Models:
 * Rational Rose -
 * <p>
 * Borland JBuilder -
 *
 * @author J. Coles
 * @version 1.0
 */
public class LicenseMgr {
    /**
     * Creates new LicenseMgr
     */
    public LicenseMgr() {

    }
}
