//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package gui.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

import svg.ISVGdiagram;
import svg.Svg;
import uml.graphics.Thing;
import uml.model.Actormodel;
import uml.model.Usecasemodel;
import figure.graphics.Figure;
import figure.model.IFigure;

public class Domainview extends JPanel implements IFigure {

	private Shadow sh = new Shadow();
	private JTabbedPane tabbedPanel = new JTabbedPane();

	public Domainview() {
		setLayout(new BorderLayout());
		add(tabbedPanel);
		newDiagram();
		add(sh, BorderLayout.SOUTH);
		setShadow(Shadows.LOW.f());
		setBackground(Color.WHITE);
	}
	
	private Figure figureSource(ActionEvent e) {
		Component c = (Component) e.getSource();
		JComponent jc = (JComponent) c.getParent();
		return (Figure) ((JPopupMenu) jc).getInvoker();
	}
	
	public void insertFigure(ActionEvent e) {
		Thing theAffectedThing = (Thing) figureSource(e);
		Diagram.getInstanceByThing(theAffectedThing).addFigure(theAffectedThing.newInstance());
		repaint();
	}

	public void connect(ActionEvent e) {
		Thing theAffectedThingf = (Thing) figureSource(e);
		Diagram.getInstanceByThing(theAffectedThingf).connect(theAffectedThingf);
		repaint();
	}

	public void setShadow(float d) {
		int theOpenTab = tabbedPanel.getSelectedIndex();
		Diagram theVisibleDiagram = (Diagram) tabbedPanel.getComponentAt(theOpenTab);
		theVisibleDiagram.setShadow(d);
	}

	public void deleteFigure(ActionEvent e) {
		Thing theAffectedThing = (Thing) figureSource(e);
		Diagram.getInstanceByThing(theAffectedThing).deleteFigure(figureSource(e));
	}

	public void shadow(ActionEvent e) {
		sh.setVisible(((AbstractButton)e.getSource()).isSelected());		
	}

	public void storesvg(ActionEvent e) {
		int theOpenTab = tabbedPanel.getSelectedIndex();
		ISVGdiagram theVisibleDiagram = (ISVGdiagram) tabbedPanel.getComponentAt(theOpenTab);
		new Svg().store(theVisibleDiagram);
	}
	
	public void edtext(ActionEvent e) {
		Thing theAffectedThing = (Thing) figureSource(e);
		Diagram.getInstanceByThing(theAffectedThing).edtext(theAffectedThing);
	}

	public void finishConnection(Object e) {
		Thing theAffectedThing = (Thing) e;
		Diagram.getInstanceByThing(theAffectedThing).finishConnection(theAffectedThing);
	}

	public void newDiagram() {
		Diagram d;
		tabbedPanel.add("" + (Diagram.countInstances() + 1), d = Diagram.newInstance("Brukstilfeller og aktører"));
		d.addFigure(new Actormodel(100, 50));
		d.addFigure(new Usecasemodel(200, 55));
	}

}
