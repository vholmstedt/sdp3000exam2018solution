//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;

import svg.ISVGelement;
import figure.model.IFigure;
import figure.model.Scaler;

abstract public class Element implements IFigure, ISVGelement {

	protected Hold connectionrule = Hold.NONE;
	public Point virtualstart, virtualstop, realstart, realstop;

	public String label() {
		return "";
	}

	public boolean isHot(Point d) {
		return false;
	}

	public ArrayList<Point> anchorList() {
		ArrayList<Point> p = new ArrayList<Point>();
		if (connectionrule == Hold.FRONT) {
			p.add(realstart);
		} else if (connectionrule == Hold.END) {
			p.add(realstop);
		} else if (connectionrule == Hold.TRACE) {
			return traceresult();
		}
		return p;
	}

	// lag på nytt når nødvendig
	protected ArrayList<Point> traceresult() {
		return null;
	}

	protected Shape element = null;
	protected int x1, y1, x2, y2;

	public void realpixels(Scaler d) {
		x1 = (int) Math.round(virtualstart.x * d.wFactor);
		y1 = (int) Math.round(virtualstart.y * d.hFactor);
		x2 = (int) Math.round(virtualstop.x * d.wFactor);
		y2 = (int) Math.round(virtualstop.y * d.hFactor);
		realstart = new Point(x1, y1);
		realstop = new Point(x2, y2);
	}

	public void render(Graphics g) {
		((Graphics2D) g).draw(element);
	}

}
