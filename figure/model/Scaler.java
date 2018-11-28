//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package figure.model;

import java.awt.Dimension;

final public class Scaler implements IFigure {

	public double hFactor;
	public double wFactor;

	public Scaler(Dimension dimension) {
		wFactor = dimension.getWidth() / VIRTUAL_WIDTH;
		hFactor = dimension.getHeight() / VIRTUAL_HEIGHT;
	}

}
