/*
 * @(#)file      SnmpMibEntry.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.20
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

// java imports
// 
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Enumeration;

// jmx imports
//
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpVarBind;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMibOid;
import com.sun.management.snmp.agent.SnmpMibNode;

/**
 * Represents a node in an SNMP MIB which corresponds to a table entry
 * meta node.
 * <P>
 * This class is used by the class generated by <CODE>mibgen</CODE>.
 * You should not need to use this class directly.
 *
 * @since Java DMK 5.1
 */

public abstract class SnmpMibEntry extends SnmpMibNode 
    implements Serializable {

    /**
     * Tells whether the given arc identifies a variable (scalar object) in 
     * this entry.
     *
     * @param arc An OID arc.
     *
     * @return <CODE>true</CODE> if `arc' leads to a variable.
     */
    public abstract boolean isVariable(long arc);

    /**
     * Tells whether the given arc identifies a readable scalar object in 
     * this entry.
     *
     * @param arc An OID arc.
     *
     * @return <CODE>true</CODE> if `arc' leads to a readable variable.
     */
    public abstract boolean isReadable(long arc);

    /**
     * Get the next OID arc corresponding to a readable scalar variable.
     *
     */
    public long getNextVarId(long id, Object userData)  
	throws SnmpStatusException {
	long nextvar = super.getNextVarId(id,userData);
	while (!isReadable(nextvar)) 
	    nextvar = super.getNextVarId(nextvar,userData);
	return nextvar;
    }

    /**
     * Returns the value of the columnar object identified by the given
     * OID arc.
     * This method is used internally. You shouldn't need to call it 
     * directly.
     *
     * @param arc OID arc of the querried columnar object.
     *
     * @param userData A contextual object containing user-data.
     *        This object is allocated through the <code>
     *        {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *        for each incoming SNMP request.
     *
     * @return The <CODE>SnmpValue</CODE> of the columnar object identified 
     *         by <CODE>arc</CODE>.
     *
     * @exception SnmpStatusException If the arc is not valid, or if
     *    access is denied.
     *
     **/
    //    public abstract SnmpValue get(long arc, Object userData) 
    //	throws SnmpStatusException ;

    /**
     * Sets the value of the columnar object identified by the given
     * OID arc.
     * This method is used internally. You shouldn't need to call it 
     * directly.
     *
     * @param x New value for the columnar object identified by 
     *    <CODE>arc</CODE>
     *
     * @param arc OID arc of the columnar object whose value is set.
     *
     * @param userData A contextual object containing user-data.
     *        This object is allocated through the <code>
     *        {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *        for each incoming SNMP request.
     *
     * @return The new <CODE>SnmpValue</CODE> of the columnar object 
     *    identified by <CODE>arc</CODE>.
     *
     * @exception SnmpStatusException If the arc is not valid, or if
     *    access is denied.
     *
     **/
    //     public abstract SnmpValue set(SnmpValue x, long arc, Object userData) 
    //	throws SnmpStatusException ;

    /**
     * Checks that the new desired value of the columnar object identified 
     * by the given OID arc is valid.
     * This method is used internally. You shouldn't need to call it directly.
     *
     * @param x New value for the columnar object identified by 
     *    <CODE>arc</CODE>
     *
     * @param arc OID arc of the columnar object whose value is set.
     *
     * @param userData A contextual object containing user-data.
     *        This object is allocated through the <code>
     *        {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *        for each incoming SNMP request.
     *
     * @exception SnmpStatusException If the arc is not valid, or if
     *    access is denied, or if the new desired value is not valid.
     *
     **/
    //    public abstract void check(SnmpValue x, long arc, Object userData) 
    //	throws SnmpStatusException ;

    /**
     * Checks whether the given OID arc identifies a variable (columnar 
     * object).
     *
     * @param userData A contextual object containing user-data.
     *        This object is allocated through the <code>
     *        {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
     *        for each incoming SNMP request.
     *
     * @exception If the given `arc' does not identify any variable in this
     *    group, throws an SnmpStatusException.
     */
    public void validateVarId(long arc, Object userData) 
	throws SnmpStatusException {
	if (isVariable(arc) == false) throw noSuchNameException;
    }

//     /**
//      * Checks whether the given OID arc identifies a readable scalar 
//      * object.
//      *
//      * @param arc OID arc of the columnar object we want to check.
//      *
//      * @param userData A contextual object containing user-data.
//      *        This object is allocated through the <code>
//      *        {@link com.sun.management.snmp.agent.SnmpUserDataFactory}</code>
//      *        for each incoming SNMP request.
//      *
//      * @exception If the given `arc' does not identify any readable variable
//      *    in this entry, throws an SnmpStatusException.
//      */
//     public void validateReadableVarId(long arc, Object userData) 
// 	throws SnmpStatusException {
// 	if (isVariable(arc) == false) throw noSuchNameException;
// 	if (isReadable(arc) == false) 
// 	    throw new SnmpStatusException(SnmpStatusException.noAccess);
//     }

    /**
     * Generic handling of the <CODE>get</CODE> operation.
     * <p>The actual implementation of this method will be generated
     * by mibgen. Usually, this implementation only delegates the
     * job to some other provided runtime class, which knows how to
     * access the MBean. The current toolkit thus provides two 
     * implementations:
     * <ul><li>The standard implementation will directly access the
     *         MBean through a java reference,</li>
     *     <li>The generic implementation will access the MBean through
     *         the MBean server.</li>
     * </ul>
     * <p>Both implementations rely upon specific - and distinct, set of
     * mibgen generated methods.
     * <p> You can override this method if you need to implement some
     * specific policies for minimizing the accesses made to some remote
     * underlying resources.
     * <p>
     *
     * @param req   The sub-request that must be handled by this node.
     *
     * @param depth The depth reached in the OID tree.
     *
     * @exception SnmpStatusException An error occurred while accessing 
     *  the MIB node.
     */
    abstract public void get(SnmpMibSubRequest req, int depth) 
	throws SnmpStatusException;

    /**
     * Generic handling of the <CODE>set</CODE> operation.
     * <p>The actual implementation of this method will be generated
     * by mibgen. Usually, this implementation only delegates the
     * job to some other provided runtime class, which knows how to
     * access the MBean. The current toolkit thus provides two 
     * implementations:
     * <ul><li>The standard implementation will directly access the
     *         MBean through a java reference,</li>
     *     <li>The generic implementation will access the MBean through
     *         the MBean server.</li>
     * </ul>
     * <p>Both implementations rely upon specific - and distinct, set of
     * mibgen generated methods.
     * <p> You can override this method if you need to implement some
     * specific policies for minimizing the accesses made to some remote
     * underlying resources.
     * <p>
     *
     * @param req   The sub-request that must be handled by this node.
     *
     * @param depth The depth reached in the OID tree.
     *
     * @exception SnmpStatusException An error occurred while accessing 
     *  the MIB node.
     */
    abstract public void set(SnmpMibSubRequest req, int depth) 
	throws SnmpStatusException;

    /**
     * Generic handling of the <CODE>check</CODE> operation.
     *
     * <p>The actual implementation of this method will be generated
     * by mibgen. Usually, this implementation only delegates the
     * job to some other provided runtime class, which knows how to
     * access the MBean. The current toolkit thus provides two 
     * implementations:
     * <ul><li>The standard implementation will directly access the
     *         MBean through a java reference,</li>
     *     <li>The generic implementation will access the MBean through
     *         the MBean server.</li>
     * </ul>
     * <p>Both implementations rely upon specific - and distinct, set of
     * mibgen generated methods.
     * <p> You can override this method if you need to implement some
     * specific policies for minimizing the accesses made to some remote
     * underlying resources, or if you need to implement some consistency
     * checks between the different values provided in the varbind list.
     * <p>
     *
     * @param req   The sub-request that must be handled by this node.
     *
     * @param depth The depth reached in the OID tree.
     *
     * @exception SnmpStatusException An error occurred while accessing 
     *  the MIB node.
     */
    abstract public void check(SnmpMibSubRequest req, int depth) 
	throws SnmpStatusException;

}
