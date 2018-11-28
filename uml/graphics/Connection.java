//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package uml.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import svg.ISVGelement;
import figure.graphics.ConnectElement;
import figure.graphics.Figure;
import figure.model.Logic;

public class Connection extends Figure {

	private Thing a, b;
	private ConnectElement ce;

	public Connection(Thing a, Thing b) {
		this.a = a;
		this.b = b;
		ce = new ConnectElement();
		realPixels();
	}

	public void paint(Graphics g) {
		realPixels();
		ce.render(g);
		shadow((Graphics2D) g);
	}

	private void realPixels() {
		setBounds(ce.orientation(Logic.nearest(a, b)));
	}

	public boolean has(Figure f) {
		return f == a || f == b;
	}

	public boolean isConnected(Thing a, Thing b) {
		return has(a) && has(b);
	}

	public String figureName() {
		return "Connection";
	}

	public ArrayList<ISVGelement> elementList() {
		ArrayList<ISVGelement> elements = new ArrayList<ISVGelement>();
		elements.add(ce);
		return elements;
	}

}
