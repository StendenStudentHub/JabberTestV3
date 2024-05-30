package com.nhlstenden;

import com.nhlstenden.factory.*;
import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.command.SlideViewer;
import com.nhlstenden.command.SlideViewerFrame;

import javax.swing.*;
import java.io.IOException;

/**
 * JabberPoint Main Programma
 * <p>
 * This program is distributed under the terms of the accompanying COPYRIGHT.txt
 * file (which is NOT the GNU General Public License). Please read it. Your use
 * of the software constitutes acceptance of the terms in the COPYRIGHT.txt
 * file.
 * </p>
 *
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint
{
	//Constants
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/*The main program */
	public static void main(String[] argv)
	{
			Presentation presentation;
			try
			{
				//Check if the argv is corresponding zero
				if(argv.length == 0)
				{
					//Setup the fileName and load the presentation
					String fileName = "src/main/java/com/nhlstenden/resources/test.xml";
					presentation = AccessorFactory.GetFactory(fileName).CreateReader().Read(fileName);
					SlideViewer slideViewer = new SlideViewer(presentation);
					new SlideViewerFrame(JABVERSION, slideViewer);
				}
				else
				{
					new XMLReader().Read("src/main/java/com/nhlstenden/resources/test.xml");
				}
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
			}
	}
}

