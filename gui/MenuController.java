//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */


package gui;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import controller.Controller;
import easylib.gui.MMenu;


public class MenuController extends JMenuBar {

	public MenuController() {
		MMenu file = new MMenu("fil");
		MMenu tools = new MMenu("verktøy");	
		MMenu help = new MMenu("hjelp");
		file.add(Controller.storesvg);
		file.add(Controller.aexit);
		tools.add(new JCheckBoxMenuItem(Controller.controlshadow));
		tools.add(new JMenuItem(Controller.newdiagram));
		help.add(Controller.aabout);
		add(file);
		add(tools);		
		add(help);
	}

}
