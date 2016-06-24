/*
 * @(#)file      ASTSyntaxDefinition.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   4.8
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
 *
 */


/* Generated By:JJTree: Do not edit this line. ASTSyntaxDefinition.java */

package com.sun.jdmk.tools.mibgen;

public class ASTSyntaxDefinition extends SimpleNode {
  protected String symbolName;
  protected ASTNamedType type;

  ASTSyntaxDefinition(int id) {
    super(id);
  }

  ASTSyntaxDefinition(Parser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
      return new ASTSyntaxDefinition(id);
  }

  public static Node jjtCreate(Parser p, int id) {
      return new ASTSyntaxDefinition(p, id);
  }
  
  public void resolve(SyntaxHandler handler) {
    
    handler.addResolution(symbolName, this);
    
    // Now resolve the content of the syntax ...
    //
    for(int i=0; i <children.length; i++) {
      SimpleNode aNode= (SimpleNode) children[i];
      aNode.resolve(handler);
    }
  }
  
  public boolean isEnumeratedType() {
    
    if (type != null) {
     return type.isEnumeratedType();
    }
     return false;
  }
  
  public String getSnmpSyntax() {
    String mbeanSyntax= SyntaxMapper.getSnmpSyntax(symbolName);
    if (mbeanSyntax != null)
      return mbeanSyntax;
    
    // Well ask the type definition how it can be represented ...
    //
    return type.getSnmpSyntax();
  }

  public String getMbeanSyntax() {
    String mbeanSyntax= SyntaxMapper.getMbeanSyntax(symbolName);
    if (mbeanSyntax != null)
      return mbeanSyntax;
    
    // Well ask the type definition how it can be represented ...
    //
    return type.getMbeanSyntax();
    
  }
  
  public Enumerated getEnumeratedDef() {
    
    if (type != null) {
     return new Enumerated(symbolName,type.getEnumeratedDef());
    }
     return new Enumerated();
  }

 public long getFixedLength() {
    return type.getFixedLength();
  }
}