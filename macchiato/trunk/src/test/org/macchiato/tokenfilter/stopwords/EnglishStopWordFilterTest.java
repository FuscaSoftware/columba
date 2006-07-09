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
package org.macchiato.tokenfilter.stopwords;

import java.util.Vector;

import junit.framework.TestCase;

import org.macchiato.tokenizer.Token;
import org.macchiato.tokenizer.WhitespaceStringTokenizer;

/**
 * @author fdietz
 */
public class EnglishStopWordFilterTest extends TestCase {

    /**
     * Constructor for EnglishStopWordFilterTest.
     * @param arg0
     */
    public EnglishStopWordFilterTest(String arg0) {
        super(arg0);
    }

    public void test() {
        String input = "by snake but peter and pan the";
        WhitespaceStringTokenizer tokenizer =
            new WhitespaceStringTokenizer(input);
        EnglishStopWordFilter f = new EnglishStopWordFilter(tokenizer);

        // should be
        Vector v1 = new Vector();
        v1.add("snake");
        v1.add("peter");
        v1.add("pan");

        Vector v2 = new Vector();
        Token token = new Token();

        while (!token.equals(Token.EOF)) {
            token = f.nextToken();
            if (!token.equals(Token.SKIP))
                v2.add(token.getString());
        }

        for (int i = 0; i < v1.size(); i++) {
            assertEquals((String) v1.get(i), (String) v2.get(i));
        }
    }

}
