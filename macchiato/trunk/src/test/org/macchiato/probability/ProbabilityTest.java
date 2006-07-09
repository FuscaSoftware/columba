//The contents of this file are subject to the Mozilla Public License Version 1.1
//(the "License"); you may not use this file except in compliance with the 
//License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
//
//Software distributed under the License is distributed on an "AS IS" basis,
//WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License 
//for the specific language governing rights and
//limitations under the License.
//
//The Original Code is "The Columba Project"
//
//The Initial Developers of the Original Code are Frederik Dietz and Timo Stich.
//Portions created by Frederik Dietz and Timo Stich are Copyright (C) 2003. 
//
//All Rights Reserved.
package org.macchiato.probability;

import junit.framework.TestCase;

/**
 * @author fdietz
 */
public class ProbabilityTest extends TestCase {

    /**
     * Constructor for ProbabilityTest.
     * @param arg0
     */
    public ProbabilityTest(String arg0) {
        super(arg0);
    }
    
    public void test() {
        float result = Probability.calc(5, 2);
        
        assertEquals(0.71, result, 0.01);
    }

}
