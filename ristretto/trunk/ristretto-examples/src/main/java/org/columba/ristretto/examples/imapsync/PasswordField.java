// The contents of this file are subject to the Mozilla Public License Version 1.1
// (the "License"); you may not use this file except in compliance with the
// License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
//
// Software distributed under the License is distributed on an "AS IS" basis,
// WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
// for the specific language governing rights and
// limitations under the License.
//
// The Original Code is "The Columba Project"
//
// The Initial Developers of the Original Code are Frederik Dietz and Timo Stich.
// Portions created by Frederik Dietz and Timo Stich are Copyright (C) 2003.
//
// All Rights Reserved.
package org.columba.ristretto.examples.imapsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PasswordField class - read a password from a user
 * 
 * @author timo
 */
public class PasswordField {

  /**
   * readPassword method
   * 
   * @param prompt
   *          The prompt to display to the user
   * @return The password as entered by the user
   */
  public static String readPassword(String prompt) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String password = "";

    try {
      password = in.readLine();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    // return the password entered by the user
    return password;
  }
}