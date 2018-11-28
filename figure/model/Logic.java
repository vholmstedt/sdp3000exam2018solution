//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.model;

import java.awt.Point;
import java.util.ArrayList;

import uml.graphics.Connection;
import uml.graphics.Thing;
import figure.graphics.Figure;

public class Logic {

	static public ArrayList<Figure> concat(ArrayList<Thing> figures,
			ArrayList<Connection> connectors) {
		ArrayList<Figure> f = new ArrayList<Figure>(figures);
		f.addAll(connectors);
		return f;
	}

	static public boolean deletable(Figure f, ArrayList<Thing> list) {
		if (f instanceof Connection)
			return true;
		int n = 0;
		for (Thing fig : list) {
			if (fig.sameClass((Thing) f)) {
				n++;
			}
		}
		return n > 1;
	}

	static public Point[] nearest(Thing consumer, Thing provider) {
		int h = Integer.MAX_VALUE;
		Point[] closest = new Point[2];
		for (Point here : consumer.anchors) {
			Point consumerp = point(consumer, here);
			for (Point there : provider.anchors) {
				Point providerp = point(provider, there);
				h = nearer(h, closest, consumerp, providerp);
			}
		}
		return safeDistance(closest);
	}

	static private Point[] safeDistance(Point[] p) {
		if (p[0].x == p[1].x)
			p[1].x++;
		if (p[0].y == p[1].y)
			p[1].y--;
		return p;
	}

	static private Point point(Thing c, Point offset) {
		return new Point(c.getX() + offset.x, c.getY() + offset.y);
	}

	static private int hyph(Point a, Point b) {
		double ar = Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2);
		return (int) Math.round(Math.sqrt(ar));
	}

	static private int nearer(int d, Point[] closest, Point a, Point b) {
		int newdistance = hyph(a, b);
		if (d > newdistance) {
			d = newdistance;
			closest[0] = a;
			closest[1] = b;
		}
		return d;
	}

}
