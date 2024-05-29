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

		//SwingUtilities.invokeLater(() -> {
			//Presentation presentation;
			try
			{
				Presentation presentation = new Presentation();
				SlideViewer slideViewer = new SlideViewer(presentation);
				SlideViewerFrame slideViewerFrame = new SlideViewerFrame(JABVERSION, slideViewer);
				// Check if argv length is greater than 0, if zero we want to load the demo.
				String fileName = argv.length > 0 ? argv[0] : "demo";
				System.out.println("Loading presentation from: " + fileName); // Debug print
				presentation = AccessorFactory.GetFactory(fileName).CreateReader().Read(fileName);

				slideViewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				slideViewerFrame.setSize(800, 600); // Set an appropriate size for the frame
				slideViewerFrame.setVisible(true);
				// Revalidate and repaint to ensure the components are displayed
				slideViewerFrame.revalidate();
				slideViewerFrame.repaint();

				System.out.println("Presentation loaded and viewer displayed."); // Debug print

			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

