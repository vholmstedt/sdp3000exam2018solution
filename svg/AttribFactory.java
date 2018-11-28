//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package svg;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;

public class AttribFactory {
	
	public static ArrayList<String[]> line(Double l, Point o) {
		Point2D a = l.getP1();
		Point2D b = l.getP2();
		ArrayList<String[]> p = new ArrayList<String[]>();
		p.add(new String[] { "x1", "" + (a.getX() + o.x) });
		p.add(new String[] { "y1", "" + (a.getY() + o.y) });
		p.add(new String[] { "x2", "" + (b.getX() + o.x) });
		p.add(new String[] { "y2", "" + (b.getY() + o.y) });
		p.add(new String[] { "style", "fill:none; stroke:black; stroke-width:1;" });
		return p;
	}

	static public ArrayList<String[]> text(Point a, Point o) {
		ArrayList<String[]> p = new ArrayList<String[]>();
		p.add(new String[] { "x", "" + (a.x + o.x) });
		p.add(new String[] { "y", "" + (a.y + o.y) });
		p.add(new String[] { "style", "font-size:11px" });
		return p;
	}

	static public ArrayList<String[]> ellipse(RectangularShape rs, Point o) {
		ArrayList<String[]> att = new ArrayList<String[]>();
		double cx, cy, rx, ry;
		rx = rs.getWidth() / 2;
		ry = rs.getHeight() / 2;
		cx = (rs.getX() + o.x + rx);
		cy = (rs.getY() + o.y + ry);
		att.add(new String[] { "cx", "" + cx });
		att.add(new String[] { "cy", "" + cy });
		att.add(new String[] { "rx", "" + rx });
		att.add(new String[] { "ry", "" + ry });
		att.add(new String[] { "style", "fill:none; stroke:black; stroke-width:1;" });
		return att;
	}

}
