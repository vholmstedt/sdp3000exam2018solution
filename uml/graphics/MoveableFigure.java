//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package uml.graphics;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import controller.Controller;
import figure.graphics.Element;
import figure.graphics.Figure;

abstract class MoveableFigure extends Figure implements MouseMotionListener {

	private Point offset;

	public void mouseDragged(MouseEvent e) {
		if (moveable) {
			Point p = e.getPoint();
			Point l = getLocation();
			l.translate(p.x - offset.x, p.y - offset.y);
			if (!getParent().contains(l))
				return;
			setLocation(l);
		}
	}

	public void mouseMoved(MouseEvent e) {
		offset = e.getPoint();
		markMovable(moveable = isHot(e.getPoint()));
	}

	{
		addMouseMotionListener(this);
		setFont(LABELFONT);
		addMouseListener(new MouseAdapter() {

			public void mouseExited(MouseEvent e) {
				markMovable(false);
			}

			public void mouseClicked(MouseEvent e) {
				if (ready) {
					Controller.finishConnection(e.getComponent());
				}
			}
		});

	}

	public boolean isHot(Point d) {
		for (Element fe : model.getElements()) {
			if (fe.isHot(d))
				return true;
		}
		return false;
	}

}
