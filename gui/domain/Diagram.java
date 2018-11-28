//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package gui.domain;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import figure.graphics.Figure;
import figure.model.Figuremodel;
import figure.model.Logic;
import svg.ISVGdiagram;
import svg.ISVGfigure;
import uml.graphics.Connection;
import uml.graphics.Thing;
import uml.model.Actormodel;
import uml.model.Usecasemodel;

public class Diagram extends JPanel implements ISVGdiagram {

	private Design design = new Design();
	private String name;
	
	static private ArrayList<Diagram> list = new ArrayList<Diagram>();
	
	

	private Diagram(String name) {
		this.name = name;
		setLayout(null);
		setBackground(Color.WHITE);
	}
	
	public void addFigure(Figuremodel fm) {
		Thing t = new Thing(fm);
		design.addFigure(t);
		add(t);
	}

	private void deleteFromConnectors(Figure figure) {
		ArrayList<Connection> con = new ArrayList<Connection>();
		for (Connection c : design.connectors) {
			if (c.has(figure)) {
				remove(c);
			} else {
				con.add(c);
			}
		}
		design.connectors = con;
	}

	public void deleteFigure(Figure figure) {
		if (Logic.deletable(figure, design.figures)) {
			deleteFromConnectors(figure);
			design.removeFigure(figure);
			design.removeConnector(figure);
			remove(figure);
		} else {
			Controller.setStatustext("Sletter ikke den siste!");
		}
		repaint();
	}

	public void finishConnection(Thing target) {
		add(design.finishConnection(target));
		repaint();
	}
	
	public void connect(Thing umlthing) {
		design.prepareConnection(umlthing);
	}

	public void setShadow(float d) {
		design.setShadow(d);
	}
	
	public void edtext(Thing figure) {
		figure.editTextelement();
	}

	public String diagramName() {
		return name;
	}

	public ArrayList<ISVGfigure> figureList() {
		return new ArrayList<ISVGfigure>(design.all());
	}

	public static Diagram newInstance(String string) {
		Diagram a;
		list.add(a = new Diagram(string));
		return a;
	}

//	public static Diagram getInstance(int i) {	
//		return list.get(0);
//	}

	public static Diagram getInstanceByThing(Thing i) {
		int n = list.indexOf(i.getParent());
		return list.get(n);
	}

	public static int countInstances() {	
		return list.size();
	}
	
}
