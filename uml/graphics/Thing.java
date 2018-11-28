//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package uml.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import svg.ISVGelement;
import figure.graphics.Element;
import figure.model.Figuremodel;
import figure.model.Scaler;

public class Thing extends MoveableFigure {

	private Dimension thing;
	public ArrayList<Point> anchors = new ArrayList<Point>();

	public Thing(Figuremodel figuremodel) {
		model = figuremodel;
		thing = model.realDimension(new Scaler(SCREEN));
		setBounds(model.start.x, model.start.y, thing.width, thing.height);
		realpixels(model);
	}

	public void setReady(boolean b) {
		ready = b;
	}

	private void realpixels(Figuremodel model) {
		Scaler s = new Scaler(thing);
		for (Element fig : model.getElements()) {
			fig.realpixels(s);
			anchors.addAll(fig.anchorList());
		}
	}

	public boolean sameClass(Thing figure) {
		return model.getClass() == figure.model.getClass();
	}

	public void editTextelement() {
		model.editTextelement();
		repaint();
	}

	public ArrayList<ISVGelement> elementList() {
		ArrayList<Element> fes = model.getElements();
		ArrayList<ISVGelement> a = new ArrayList<ISVGelement>();
		for (Element fe : fes) {
			a.add(fe);
		}
		return a;
	}

}
