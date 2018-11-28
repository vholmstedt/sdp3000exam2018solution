//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package gui.domain;

import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;
import figure.model.IFigure;

class Shadow extends JPanel implements ChangeListener, IFigure {

	private JSlider setAlpha = null;
	final private int slidermax = 600;

	Shadow() {
		setLayout(new GridLayout(2, 0));
		add(new JLabel("Styrke på visning av pekeområde", JLabel.CENTER));
		setAlpha = new JSlider(0, slidermax);
		setAlpha.setMajorTickSpacing(10);
		setAlpha.createStandardLabels(10);
		setAlpha.setPaintTicks(true);
		setAlpha.setPaintTrack(true);
		setAlpha.setValue((int) Math.round(Shadows.LOW.f() * 1000));
		labels();
		setAlpha.addChangeListener(this);
		add(setAlpha);
		setVisible(false);
	}

	private void labels() {
		Hashtable<Integer, JLabel> l = new Hashtable<Integer, JLabel>();
		l.put(0, new JLabel("usynlig"));
		l.put(slidermax / 10, new JLabel("svak"));
		l.put(slidermax / 2, new JLabel("sterk"));
		setAlpha.setLabelTable(l);
		setAlpha.setPaintLabels(true);
	}

	public void stateChanged(ChangeEvent arg0) {
		Controller.setShadow((float) setAlpha.getValue() / 1000.0f);
	}

}
