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
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import svg.AttribFactory;

public class ConnectElement extends Element {

	public ConnectElement() {
		element = new Line2D.Double();
	}

	public Rectangle orientation(Point[] u) {
		x1 = u[0].x;
		y1 = u[0].y;
		x2 = u[1].x;
		y2 = u[1].y;
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		int lx1 = 0, lx2 = 0, ly1 = 0, ly2 = 0;
		if (x2 <= x1) lx2 = width;
		else lx1 = width;
		if (y2 <= y1) ly2 = height;
		else ly1 = height;
		((Line2D.Double) element).setLine(lx1, ly1, lx2, ly2);
		return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), width, height);
	}

	public String renderable() {
		return "line";
	}

	public ArrayList<String[]> attrList(Point offset) {
		return AttribFactory.line((Line2D.Double) element, offset);
	}

}
