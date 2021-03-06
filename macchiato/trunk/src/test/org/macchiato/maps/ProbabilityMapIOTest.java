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
package org.macchiato.maps;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.macchiato.tokenizer.Token;

/**
 * 
 *
 * @author fdietz
 */
public class ProbabilityMapIOTest{

    @Test
	public void test() {

		ProbabilityMap map= new ProbabilityMapImpl();
		map.addToken(new Token("fred"), 0.4f);
		map.addToken(new Token("castor"), 0.6f);

		try {
			ProbabilityMapIO.save(map, new File("test.map"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ProbabilityMap map2= new ProbabilityMapImpl();

		try {
			ProbabilityMapIO.load(map2, new File("test.map"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Assert.assertEquals(0.4, map2.getProbability(new Token("fred")), 0.01);
		Assert.assertEquals(0.6, map2.getProbability(new Token("castore")), 0.01);

	}

}
