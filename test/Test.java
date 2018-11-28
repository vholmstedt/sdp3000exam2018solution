//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package test;

import javax.swing.JFrame;

import svg.ISVGdiagram;

public class Test {
	
	JFrame testvindu;
	
	
	public Test(ISVGdiagram diagram) {
		testvindu = new Testvindu(diagram);		
	}
}
