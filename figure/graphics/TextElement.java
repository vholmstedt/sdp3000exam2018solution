//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.graphics;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import svg.AttribFactory;
import figure.model.Scaler;

public class TextElement extends Element {

	private String label;
	private LabelAlign align;

	public TextElement(String label, LabelAlign align) {
		this.align = align;
		this.label = label;
	}

	public String renderable() {
		return "text";
	}

	public String label() {
		return label;
	}

	public ArrayList<String[]> attrList(Point offset) {
		return AttribFactory.text(new Point(x1, y1), offset);
	}

	private boolean metricsdone = false;

	public void render(Graphics g) {
		if (!metricsdone) {
			doMetrics(g);
		}
		g.drawString(label, x1, y1);
	}

	private void doMetrics(Graphics g) {
		FontMetrics fm = ((Graphics2D) g).getFontMetrics();
		Rectangle2D.Float rect = (Rectangle2D.Float) fm.getStringBounds(label, 0,
				label.length(), g);
		int w = Math.round(rect.width);
		int h = Math.round(rect.height);
		Rectangle gwidth = g.getClipBounds();
		x1 = (gwidth.width / 2) - (w / 2);
		y1 = (align == LabelAlign.CENTER) ? (gwidth.height / 2) + ((h / 4))
				: gwidth.height - fm.getDescent();
		metricsdone = true;
	}

	public void edit() {
		String n = JOptionPane.showInputDialog("Rediger \"" + label + "\"");
		if (n != null) {
			label = n;
			metricsdone = false;
		}
	}

	public void realpixels(Scaler s) {
	}

}
