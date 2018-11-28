//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */


package gui;

import javax.swing.JPopupMenu;

import controller.Controller;

final public class Contextmenu extends JPopupMenu {

	public Contextmenu(boolean b) {
		if (b) {
			add(Controller.cnect).addMouseListener(Controller.cnect);
			add(Controller.insert).addMouseListener(Controller.insert);
			add(Controller.edtext).addMouseListener(Controller.edtext);
			addSeparator();
		}
		add(Controller.delete).addMouseListener(Controller.delete);
	}

}
