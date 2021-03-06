/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Ristretto Mail API.
 *
 * The Initial Developers of the Original Code are
 * Timo Stich and Frederik Dietz.
 * Portions created by the Initial Developers are Copyright (C) 2004
 * All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */
package org.columba.ristretto.coder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

public class FallbackCharsetDecoderInputStreamTest {

	@Test
	public void testUS_ASCII_butwindows_1252() {
		String test = "\u2014mple";
		try {
			InputStream in = new FallbackCharsetDecoderInputStream( new ByteArrayInputStream( test.getBytes("windows-1252")), Charset.forName("us-ascii") );
			StringBuffer result = new StringBuffer();
			int next = in.read();
			while( next != -1) {
				result.append( (char) next );
				next = in.read();
			}
			
			Assert.assertEquals( test, result.toString());
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUTF8() {
		String test = "S\u0034mple Str\00edng";
		try {
			InputStream in = new FallbackCharsetDecoderInputStream( new ByteArrayInputStream( test.getBytes("UTF-8")), Charset.forName("UTF-8") );
			StringBuffer result = new StringBuffer();
			int next = in.read();
			while( next != -1) {
				result.append( (char) next );
				next = in.read();
			}
			
			Assert.assertTrue( result.toString().equals(test));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
				
	}
	
	@Test
	public void testUTF8_2() {
		String test = "\u0413\u0424";
		try {
			InputStream in = new FallbackCharsetDecoderInputStream( new ByteArrayInputStream( test.getBytes("UTF-8")), Charset.forName("UTF-8") );
			StringBuffer result = new StringBuffer();
			int next = in.read();
			while( next != -1) {
				result.append( (char) next );
				next = in.read();
			}
			
			Assert.assertTrue( result.toString().equals(test));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
				
	}

}
