//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import svg.ISVGfigure;
import uml.graphics.Thing;
import figure.model.Figuremodel;
import figure.model.IFigure;
import gui.Contextmenu;

abstract public class Figure extends JComponent implements ISVGfigure, IFigure {

	private Shadows alpha = Shadows.LOW;
	private Shadows state = Shadows.WAIT;
	protected boolean moveable = false;
	protected boolean ready = false;
	protected Figuremodel model = null;

	public void setShadow(float d) {
		Shadows.LOW.f(d);
		markMovable(false);
	}

	protected void shadow(Graphics2D g) {
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha
				.f()));
		g.setColor(ready ? Shadows.READY.c() : state.c());
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public void markMovable(boolean b) {
		alpha = (b ? Shadows.HIGH : Shadows.LOW);
		state = (b ? Shadows.EAGER : Shadows.WAIT);
		repaint();
	}

	public void paint(Graphics g) {
		for (Element fig : model.getElements()) {
			fig.render(g);
		}
		shadow((Graphics2D) g);
	}

	public String figureName() {
		return model.getFigureName();
	}

	public Figuremodel newInstance() {
		return model.newInstance(getX() + 30, getY() + 30);
	}

	{
		JPopupMenu rightclick = new Contextmenu(this instanceof Thing);
		setComponentPopupMenu(rightclick);		
	}

}
