/* 
 * @(#)file      SnmpTableEntryFactory.java 
 * @(#)author    Sun Microsystems, Inc. 
 * @(#)version   1.11 
 * @(#)date      07/10/01 
 * 
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU General
 * Public License Version 2 only ("GPL") or the Common Development and
 * Distribution License("CDDL")(collectively, the "License"). You may not use
 * this file except in compliance with the License. You can obtain a copy of the
 * License at http://opendmk.dev.java.net/legal_notices/licenses.txt or in the 
 * LEGAL_NOTICES folder that accompanied this code. See the License for the 
 * specific language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file found at
 *     http://opendmk.dev.java.net/legal_notices/licenses.txt
 * or in the LEGAL_NOTICES folder that accompanied this code.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.
 * 
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * 
 *       "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding
 * 
 *       "[Contributor] elects to include this software in this distribution
 *        under the [CDDL or GPL Version 2] license."
 * 
 * If you don't indicate a single choice of license, a recipient has the option
 * to distribute your version of this file under either the CDDL or the GPL
 * Version 2, or to extend the choice of license to its licensees as provided
 * above. However, if you add GPL Version 2 code and therefore, elected the
 * GPL Version 2 license, then the option applies only if the new code is made
 * subject to such option by the copyright holder.
 * 
 */ 

package com.sun.management.snmp.agent;

import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpMibSubRequest;

/**
 * This interface is implemented by mibgen generated table objects
 * inheriting from {@link com.sun.management.snmp.agent.SnmpTableSupport}.
 * <p>
 * It is used internally by the metadata whenever a remote SNMP manager
 * requests the creation of a new entry through an SNMP SET.
 * </p>
 * <p>
 * At creation, the mibgen generated table object retrieves its 
 * corresponding metadata from the MIB and registers with 
 * this metadata as a SnmpTableEntryFactory.
 * </p>
 *
 *
 * @since Java DMK 5.1
 **/

public interface SnmpTableEntryFactory extends SnmpTableCallbackHandler {

    /**
     * This method is called by the SNMP runtime whenever a new entry
     * creation is requested by a remote manager.
     *
     * The factory is responsible for instantiating the appropriate MBean
     * and for registering it with the appropriate metadata object.
     *
     * Usually this method will:
     * <ul>
     * <li>Check whether the creation can be accepted
     * <li>Instantiate a new entry
     * <li>Possibly register this entry with the MBeanServer, if needed.
     * <li>Call <code>addEntry()</code> on the given <code>meta</code> object.
     * </ul>
     * This method is usually generated by <code>mibgen</code> on table
     * objects (inheriting from 
     * {@link com.sun.management.snmp.agent.SnmpTableSupport}). <br>
     *
     * <p><b><i>
     * This method is called internally by the SNMP runtime whenever a 
     * new entry creation is requested by a remote SNMP manager.
     * You should never need to call this method directly.
     * </i></b></p>
     *
     * @param request The SNMP subrequest containing the sublist of varbinds
     *                for the new entry.
     * @param rowOid  The OID indexing the conceptual row (entry) for which 
     *                the creation was requested.
     * @param depth   The depth reached in the OID tree (the position at
     *                which the columnar object ids start in the OIDs
     *                included in the varbind).
     * @param meta    The metadata object impacted by the subrequest
     *
     * @exception SnmpStatusException The new entry cannot be created.
     *
     **/
    public void createNewEntry(SnmpMibSubRequest request, SnmpOid rowOid,
			       int depth, SnmpMibTable meta) 
	throws SnmpStatusException;
}

