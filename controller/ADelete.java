//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */


package controller;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import easylib.controller.SuperAction;
import easylib.controller.Usecase;

/**
 * @author segovia
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ADelete extends SuperAction {

	public ADelete(Usecase usecase) {
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "fjern figuren eller forbindelsen");
		putValue(Action.LONG_DESCRIPTION,
				"fjern denne forbindelsen, eller figuren og dens forbindelser");
	}

	public void actionPerformed(ActionEvent e) {
		Controller.delete(e);
	}

}
