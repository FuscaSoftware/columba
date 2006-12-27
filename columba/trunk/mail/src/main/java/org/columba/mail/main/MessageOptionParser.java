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

package org.columba.mail.main;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MessageOptionParser {

	private static final int KEY = 0;

	private static final int VALUE = 1;

	private static final int QUOTED_VALUE = 2;

	public static CharSequence[] tokenizeList(CharSequence input) {
		if (input == null)
			throw new IllegalArgumentException("input == null");

		List<CharSequence> result = new ArrayList<CharSequence>();
		boolean quoted = false;

		int start = 0;
		int i;

		for (i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			switch (c) {
			case '\"': {
				quoted ^= true;
				break;
			}

			case ',': {
				if (!quoted) {
					result.add(input.subSequence(start, i));
					start = i + 1;
				}
				break;
			}
			}
		}
		if (start < i) {
			result.add(input.subSequence(start, i));
		}

		return (CharSequence[]) result.toArray(new CharSequence[0]);
	}

	public static Map<String,String> parse(String in) {
		if (in == null)
			throw new IllegalArgumentException("in == null");

		Hashtable<String, String> map = new Hashtable<String, String>();
		CharSequence[] sequence = tokenizeList(in);
		for (int i = 0; i < sequence.length; i++) {
			String s = (String) sequence[i];
			// remove whitespaces
			s = s.trim();

			// split key/value pairs
			int index = s.indexOf('=');
			if (index != -1) {
				String key = s.substring(0, index);
				String value = s.substring(index + 1, s.length());
				map.put(key, value);
			}
		}

		return map;
	}
}
