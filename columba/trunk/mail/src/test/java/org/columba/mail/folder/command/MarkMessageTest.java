//The contents of this file are subject to the Mozilla Public License Version
//1.1
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
//The Initial Developers of the Original Code are Frederik Dietz and Timo
//Stich.
//Portions created by Frederik Dietz and Timo Stich are Copyright (C) 2003.
//
//All Rights Reserved.

package org.columba.mail.folder.command;

import java.io.ByteArrayInputStream;

import org.columba.core.command.NullWorkerStatusController;
import org.columba.mail.command.MailFolderCommandReference;
import org.columba.mail.folder.AbstractFolderTst;
import org.columba.mail.folder.FolderTstHelper;
import org.columba.mail.folder.MailboxTstFactory;
import org.columba.ristretto.message.Flags;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author fdietz
 */
public class MarkMessageTest extends AbstractFolderTst {

	private Object uid;

	private ByteArrayInputStream inputStream;

	/**
	 * @param arg0
	 */
	public MarkMessageTest(Class factory) {
		super(factory);
	}

    @Test
	public void testMarkAsReadMessage() throws Exception {

		//    	 create Command reference
		MailFolderCommandReference ref = new MailFolderCommandReference(
				getSourceFolder(), new Object[] { uid });
		ref.setMarkVariant(MarkMessageCommand.MARK_AS_READ);

		// create copy command
		MarkMessageCommand command = new MarkMessageCommand(ref);

		// execute command -> use mock object class as worker which does
		// nothing
		command.execute(NullWorkerStatusController.getInstance());

		Flags flags = getSourceFolder().getFlags(uid);

		Assert.assertEquals("message should be marked as read", true, flags.getSeen());

	}

    @Test
	public void testMarkAsFlaggedMessage() throws Exception {

		//    	 create Command reference
		MailFolderCommandReference ref = new MailFolderCommandReference(
				getSourceFolder(), new Object[] { uid });

		ref.setMarkVariant(MarkMessageCommand.MARK_AS_FLAGGED);

		// create copy command
		MarkMessageCommand command = new MarkMessageCommand(ref);

		// execute command -> use mock object class as worker which does
		// nothing
		command.execute(NullWorkerStatusController.getInstance());

		Flags flags = getSourceFolder().getFlags(uid);

		Assert.assertEquals("message should be marked as flagged", true, flags
				.getFlagged());

	}

   @Test
	public void testMarkAsExpungedMessage() throws Exception {

		//   	 create Command reference
		MailFolderCommandReference ref = new MailFolderCommandReference(
				getSourceFolder(), new Object[] { uid });
		ref.setMarkVariant(MarkMessageCommand.MARK_AS_EXPUNGED);

		// create copy command
		MarkMessageCommand command = new MarkMessageCommand(ref);

		// execute command -> use mock object class as worker which does
		// nothing
		command.execute(NullWorkerStatusController.getInstance());

		Flags flags = getSourceFolder().getFlags(uid);

		Assert.assertEquals("message should be marked as expunged", true, flags
				.getDeleted());

	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
    @Override
	public void setUp() throws Exception {
		// create folders, etc.
		super.setUp();

		// add message "0.eml" as inputstream to folder
		String input = FolderTstHelper.getString(0);
		// create stream from string
		inputStream = FolderTstHelper.getByteArrayInputStream(input);
		// add stream to folder
		uid = getSourceFolder().addMessage(inputStream);

	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
    @Override
	public void tearDown() throws Exception {
		// close streams
		inputStream.close();

		// delete folders
		super.tearDown();

	}
}