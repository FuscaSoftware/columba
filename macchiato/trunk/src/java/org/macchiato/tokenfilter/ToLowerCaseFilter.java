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
package org.macchiato.tokenfilter;

import org.macchiato.tokenizer.Token;
import org.macchiato.tokenizer.Tokenizer;

/**
 * Convert every token to lower-case characters.
 * 
 * @author fdietz
 */
public class ToLowerCaseFilter extends AbstractTokenizerFilter {

	/**
	 * @param tokenizer
	 */
	public ToLowerCaseFilter(Tokenizer tokenizer) {
		super(tokenizer);

	}

	/**
	 * @see org.macchiato.tokenizer.AbstractTokenizer#nextToken()
	 */
	public Token nextToken() {
		Token token= getTokenizer().nextToken();
		if (token.equals(Token.EOF))
			return token;
		if (token.equals(Token.SKIP))
			return token;

		token.setString(token.getString().toLowerCase());

		return token;
	}

}
