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

public class AStoresvg extends SuperAction {

	public AStoresvg(Usecase usecase) {
		super(usecase);
		putValue(Action.SHORT_DESCRIPTION, "lagre som svg");
		putValue(Action.LONG_DESCRIPTION, "lagre som svg");
	}

	public void actionPerformed(ActionEvent e) {
		Controller.storesvg(e);
	}

}
