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

import javax.swing.Icon;

import easylib.controller.ISupercontroller;
import easylib.controller.SuperAction;
import easylib.controller.Supercontroller;
import gui.ApplicationFrame;

public class Controller extends Supercontroller implements IActionlist {

	public static SuperAction insert;
	public static SuperAction delete;
	public static SuperAction cnect;
	public static SuperAction storesvg;
	public static SuperAction controlshadow;
	public static SuperAction edtext;
	public static SuperAction newdiagram;
	
	public static void init(ISupercontroller ui) {
		superinit(ui);
		insert = new AInsert(INSERT);
		edtext = new AEdtext(EDTEXT);
		delete = new ADelete(DELETE);
		cnect = new AConnect(CONNECT);
		storesvg = new AStoresvg(STORESVG);
		controlshadow = new AShadow(SHADOW);
		newdiagram = new ANewDiagram(NEWDIAGRAM);
	}

	public static void insert(ActionEvent e) {
		((ApplicationFrame)ui).insertFigure(e);
	}

	public static void delete(ActionEvent e) {
		((ApplicationFrame)ui).deleteFigure(e);
	}

	public static void edtext(ActionEvent e) {
		((ApplicationFrame)ui).edtext(e);
	}

	public static void connect(ActionEvent e) {
		((ApplicationFrame)ui).connect(e);
	}

	public static void finishConnection(Object e) {
		((ApplicationFrame)ui).finishConnection(e);
	}

	public static void shadow(ActionEvent e) {		
		((ApplicationFrame)ui).shadow(e);		
	}

	public static void setShadow(float d) {
		((ApplicationFrame)ui).setShadow(d);
	}

	public static void storesvg(ActionEvent e) {
		((ApplicationFrame)ui).storesvg(e);
	}

	public static void newDiagram(ActionEvent e) {
		((ApplicationFrame)ui).newDiagram();
	}

}
