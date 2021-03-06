/* 
 * @(#)file      SnmpGenericMetaServer.java 
 * @(#)author    Sun Microsystems, Inc. 
 * @(#)version   1.8 
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

// jmx imports
//
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpStatusException;

/**
 * <p>
 * This interface defines the methods that must be implemented by an
 * SNMP metadata object that needs to interact with an
 * {@link com.sun.management.snmp.agent.SnmpGenericObjectServer} object.
 * </p>
 *
 * <p>
 * All these methods are usually generated by <code>mibgen</code> when
 * run in generic-metadata mode.
 * </p>
 *
 * <p><b><i>
 * This interface is used internally between the generated Metadata and 
 * the SNMP runtime and you shouldn't need to worry about it, because 
 * you will never have to use it directly.
 * </b></i></p>
 *
 *
 * @since Java DMK 5.1
 **/ 
public interface SnmpGenericMetaServer {

    /**
     * Construct an attribute value (as returned by Attribute::getValue())
     * from an SnmpValue. The returned attribute value can be used to 
     * construct an Attribute object.
     *
     * @param id The OID arc identifying the variable for which the
     *           value is constructed.
     * @param value The SnmpValue from which the Attribute::value will be
     *              constructed.
     * @return The attribute value built from the given <code>value</code>.
     * @exception SnmpStatusException if the attribute value cannot be built 
     *            from the given SnmpValue <code>value</code>.
     * 
     */
    Object buildAttributeValue(long id, SnmpValue value)
	throws SnmpStatusException;

    /**
     * Construct an SnmpValue from an Attribute value as returned by 
     * Attribute::getValue(). 
     *
     * @param id The OID arc identifying the variable for which the
     *           value is constructed.
     * @param value The attribute value as returned by Attribute::getValue().
     *
     * @return The SnmpValue built from the given <code>value</code>.
     * @exception SnmpStatusException if the SnmpValue cannot be built from
     *            the given <code>value</code>.
     **/
    SnmpValue buildSnmpValue(long id, Object value)
	throws SnmpStatusException;

    /**
     * Return the name of the attribute corresponding to the 
     * SNMP variable identified by the given <code>id</code>.
     *
     * @param id The OID arc identifying the variable.
     *
     * @return The name of the variable identified by the given 
     *         <code>id</code>.
     *
     * @exception SnmpStatusException if the given <code>id</code> does not
     *            correspond to a known variable.
     */
    String getAttributeName(long id)
	throws SnmpStatusException;

    /**
     * Check the access rights for a SET operation. 
     * 
     * @param x  The new requested value.
     * @param id The OID arc identifying the variable for which the SET is
     *           requested.
     * @param data A contextual object containing user-data.
     *           This object is allocated through the <code>
     *           {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *           for each incoming SNMP request.
     * @exception SnmpStatusException if the SET operation must be rejected.
     */
    void checkSetAccess(SnmpValue x, long id, Object data) 
	throws SnmpStatusException;
    
    /**
     * Check the access rights for a GET operation. 
     * 
     * @param id The OID arc identifying the variable for which the SET is
     *           requested.
     * @param data A contextual object containing user-data.
     *           This object is allocated through the <code>
     *           {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *           for each incoming SNMP request.
     * @exception SnmpStatusException if the SET operation must be rejected.
     */
    void checkGetAccess(long id, Object data) 
	throws SnmpStatusException;
    
}

