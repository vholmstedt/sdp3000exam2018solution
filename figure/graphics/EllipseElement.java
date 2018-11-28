//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.graphics;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

import svg.AttribFactory;
import figure.model.Scaler;

public class EllipseElement extends Element {

	public EllipseElement(Point a, Point b, Hold c) {
		element = new Ellipse2D.Double();
		connectionrule = c;
		virtualstart = new Point(a.x - (b.x / 2), a.y - (b.y));
		virtualstop = b;
	}

	public void realpixels(Scaler figscaler) {
		super.realpixels(figscaler);
		((Ellipse2D.Double) element).setFrame(x1, y1, x2, y2);
	}
	
	protected ArrayList<Point> traceresult() {
		ArrayList<Point> pl = new ArrayList<Point>();
		PathIterator pi = ((Shape) element).getPathIterator(null);
		double[] d = new double[6];
		while (true) {
			pi.next();
			if (pi.isDone())
				break;
			pi.currentSegment(d);
			pl.add(new Point((int) Math.round(d[0]), (int) Math.round(d[1])));
		}
		return pl;
	}

	public ArrayList<String[]> attrList(Point offset) {
		return AttribFactory.ellipse(element.getBounds(), offset);
	}

	public String renderable() {
		return "ellipse";
	}

	public boolean isHot(Point d) {
		return element.contains(d);
	}

}
