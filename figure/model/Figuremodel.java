//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import figure.graphics.Element;
import figure.graphics.TextElement;

abstract public class Figuremodel implements IFigure {

	protected String figureName;
	public Point start;
	protected Dimension virtual;
	protected Point reference;

	protected ArrayList<Element> elements = new ArrayList<Element>();

	public ArrayList<Element> getElements() {
		return elements;
	}

	public Dimension realDimension(Scaler scaler) {
		return new Dimension((int) Math.round(virtual.width * scaler.wFactor),
				(int) Math.round(virtual.height * scaler.hFactor));
	}

	public void editTextelement() {
		for (Element e : elements) {
			if (e instanceof TextElement) {
				((TextElement) e).edit();
			}
		}
	}

	protected abstract Figuremodel instance(int x, int y);

	public Figuremodel newInstance(int x, int y) {
		return instance(x, y);
	}

	public String getFigureName() {
		return figureName;
	}

}