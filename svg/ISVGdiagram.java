//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package svg;

import java.util.ArrayList;

public interface ISVGdiagram {
	String diagramName();
	ArrayList<ISVGfigure> figureList();
}
