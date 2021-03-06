/*
 * @(#)file      GroupImpl.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.9
 * @(#)lastedit  07/03/08
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
 *
 */


package com.sun.management.snmp.uacl;



import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;
import java.net.UnknownHostException;


import java.security.Principal; 
import java.security.acl.Group; 


/**
 * This class is used to represent a subnet mask (a group of hosts matching the same 
 * IP mask).
 * 
 * @see java.security.acl.Group
 * @see java.security.Principal
 */

class GroupImpl extends PrincipalImpl implements Group, Serializable {
    private static final long serialVersionUID = -8313979202179750837L;
  
    /**
     * Constructs an empty group.
     * @exception UnknownHostException Not implemented
     */
    public GroupImpl () throws UnknownHostException {
    }
  
    /**
     * Constructs a group using the specified subnet mask.
     *
     * @param mask The subnet mask to use to build the group.
     * @exception UnknownHostException if the subnet mask cann't be built.
     */
    public GroupImpl (String mask) throws UnknownHostException {
	super(mask);
    }
  
    /**
     * Adds the specified member to the group. 
     *
     * @param p the principal to add to this group. 
     * @return true if the member was successfully added, false if the 
     *     principal was already a member. 
     */
    public boolean addMember(Principal p) {
	// we don't need to add members because the ip address is a subnet 
	// mask 
	return true;	
    }

    public int hashCode() {
	return super.hashCode();	
    }
  
    /**
     * Compares this group to the specified object. Returns true if the object
     * passed in matches the group represented.
     *
     * @param p the object to compare with.
     * @return true if the object passed in matches the subnet mask, 
     *         false otherwise.
     */
    public boolean equals (Object p) {
	if (p instanceof PrincipalImpl || p instanceof GroupImpl){
	    if ((super.hashCode() & p.hashCode()) == p.hashCode()) return true;
	    else return false;
	} else {
	    return false;
	}
    }
  
    /**
     * Returns true if the passed principal is a member of the group.
     *
     * @param p the principal whose membership is to be checked.
     * @return true if the principal is a member of this group, false 
     *  otherwise. 
     */
    public boolean isMember(Principal p) {
	if ((p.hashCode() & super.hashCode()) == p.hashCode()) return true;
	else return false;
    }
  
    /**
     * Returns an enumeration which contains the subnet mask.
     *
     * @return an enumeration which contains the subnet mask.
     */
    public Enumeration members(){
	Vector v = new Vector(1);
	v.addElement(this);
	return v.elements();
    }
  
    /**
     * Removes the specified member from the group. (Not implemented)
     *
     * @param p the principal to remove from this group.
     * @return allways return true.
     */
    public boolean removeMember(Principal p) {
	return true;
    }
  
    /**
     * Prints a string representation of this group.
     *
     * @return  a string representation of this group.
     */
    public String toString() {
	return ("GroupImpl :"+super.getName());
    }
}


