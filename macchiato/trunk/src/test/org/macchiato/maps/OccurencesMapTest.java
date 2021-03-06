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

import org.junit.Assert;
import org.junit.Test;
import org.macchiato.tokenizer.Token;

/**
 * @author fdietz
 */
public class OccurencesMapTest {

    @Test
    public void testStats() {
        OccurencesMapImpl stats = new OccurencesMapImpl();

        stats.addToken("snake");
        stats.addToken("snake");
        stats.addToken("tiger");
        stats.addToken("dragon");

        Assert.assertEquals(2, stats.getOccurences("snake"));
        Assert.assertEquals(1, stats.getOccurences("tiger"));
        Assert.assertEquals(1, stats.getOccurences("dragon"));
    }

    @Test
    public void testPercentage() {
        OccurencesMapImpl stats = new OccurencesMapImpl();

        // 5 snakes
        stats.addToken("snake");
        stats.addToken("snake");
        stats.addToken("snake");
        stats.addToken("snake");
        stats.addToken("snake");
        
        stats.addToken("tiger");
        stats.addToken("dragon");
        stats.addToken("camel");
        stats.addToken("bird");
        stats.addToken("fly");
        
        // 50% of those tokens are of value "snake"
        Assert.assertEquals(0.5, stats.getTokenCountInPercentage(new Token("snake")) , 0);
    }

}
