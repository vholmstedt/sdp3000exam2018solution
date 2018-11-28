//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */


package controller;

import easylib.controller.Usecase;


/**
 * @author segovia
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
interface IActionlist {
	Usecase DELETE = new Usecase("fjern", null);
	Usecase INSERT = new Usecase("ny figur", null);
	Usecase CONNECT = new Usecase("koble figurer", null);
	Usecase STORESVG = new Usecase("lagre som svg", null);
	Usecase SHADOW = new Usecase("skygge", null);
	Usecase EDTEXT = new Usecase("rediger tekst", null);
	Usecase NEWDIAGRAM = new Usecase("nytt diagram", null);
}
