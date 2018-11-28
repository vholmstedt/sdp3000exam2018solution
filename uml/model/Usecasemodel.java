//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package uml.model;

import java.awt.Dimension;
import java.awt.Point;

import figure.graphics.EllipseElement;
import figure.graphics.TextElement;
import figure.model.Figuremodel;

public class Usecasemodel extends Figuremodel {

	// Figuren plasseres på en virtuell flate på 1000X1000
	// Figurens mål er innenfor en ny virtuell flate på 1000X1000
	// Alle posisjoner og størrelser er i virtuelle mål

	public Usecasemodel(int x, int y) {
		figureName = "Usecase";
		start = new Point(x, y);
		virtual = new Dimension(150, 80);
		elements.add(new EllipseElement(new Point(500, 978), new Point(920, 920),
				Hold.TRACE));
		elements.add(new TextElement("Brukstilfelle", LabelAlign.CENTER));
	}

	protected Figuremodel instance(int x, int y) {
		return new Usecasemodel(x, y);
	}

}
