//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public interface IFigure {

	double VIRTUAL_WIDTH = 1000;
	double VIRTUAL_HEIGHT = 1000;
	Dimension SCREEN = new Dimension(500, 500);
	Font LABELFONT = new Font("monospace", Font.PLAIN, 11);
	int HOTDISTANCE = 2;

	enum Hold {
		NONE, FRONT, END, TRACE
	}
	enum LabelAlign {
		CENTER, BOTTOM
	}

	enum Shadows {
		EAGER(Color.GREEN), WAIT(Color.BLUE), READY(Color.RED), 
		LOW(0.03f), HIGH(0.10f);

		private Color c;
		private float f;

		Shadows(Color c) {
			this.c = c;
		}

		Shadows(float f) {
			this.f = f;
		}

		public Color c() {
			return c;
		}

		public float f() {
			return f;
		}

		public void f(float f) {
			this.f = f;
		}
	}

}