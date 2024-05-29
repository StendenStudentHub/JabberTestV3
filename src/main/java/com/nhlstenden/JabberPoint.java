package com.nhlstenden;

import com.nhlstenden.factory.XMLAccessorFactory;
import com.nhlstenden.strategy.MyStyle;
import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.command.SlideViewer;
import com.nhlstenden.command.SlideViewerFrame;
import com.nhlstenden.factory.AccessorFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.nhlstenden.facade.GeneratePresentation.generatePresentation;

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
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	public static void main(String[] argv)
	{
			Presentation presentation = new Presentation();
			SlideViewer slideViewer = new SlideViewer(presentation);
			new SlideViewerFrame(JABVERSION, slideViewer);
			try
			{
				// Check if argv length is greater than 0, if zero we want to load the demo.
				if(argv.length == 0)
				{
					//System.out.println("length is zero");
					//String fileName = "dump.xml";
					//AccessorFactory.GetFactory(fileName).CreateReader().Read(fileName);

					ArrayList<Integer> levels = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
					ArrayList<String> slideTwoTitles = new ArrayList<String>(Arrays.asList("title 1", "title 2", "title 3"));
					ArrayList<String> slideTwoTexts = new ArrayList<String>(Arrays.asList("text 1", "text 2", "text 3"));

					Presentation generatedPresentation = generatePresentation(JABVERSION, levels, slideTwoTitles, slideTwoTexts);
					AccessorFactory.GetFactory(generatedPresentation).CreateReader().Read(generatedPresentation);
				}
				else
				{
					System.out.println("length is more than zero");
					String fileDemoName = "test.xml";
					XMLAccessorFactory.GetFactory(fileDemoName).CreateReader().Read(fileDemoName);
				}

				presentation.setSlideNumber(0);
				
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
			}
	}
}

