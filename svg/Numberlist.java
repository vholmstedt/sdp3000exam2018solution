//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package svg;

import java.util.Hashtable;

public class Numberlist extends Hashtable<String, Integer> {

	public String number(String key) {
		if (!containsKey(key)) {
			put(key, 0);
		}
		put(key, get(key) + 1);
		return key + "_" + get(key);
	}

}
