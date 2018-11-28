//#SDP subject 2003 - 2018

/*

This file is part of the SDP project named simplediagram

University of South-Eastern Norway

Textbook: http://evalanche.hbv.no/pat
More information: https://sites.google.com/site/mitsoptew 

*/ 

/** author V: Holmstedt */

package svg;

import org.w3c.dom.Element;

import easylib.xml.DOMFactory;
import easylib.xml.SuperXML;

public class Svg extends SuperXML {

	public void store(ISVGdiagram diagram) {
		try {
			helper = new DOMFactory("http://www.w3.org/2000/svg", "svg",
					"-//W3C//DTD SVG 1.1//EN",
					"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd");
			document = helper.getDocument();
			root = document.getDocumentElement();
			createTree(diagram);
			save("diagram.svg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createTree(ISVGdiagram diagram) {
		root.setAttribute("xmlns", "http://www.w3.org/2000/svg");
		Element title = document.createElement("title");
		title.appendChild(document.createTextNode("DIAGRAM "
				+ diagram.diagramName()));
		root.appendChild(title);
		Numberlist nl = new Numberlist();
		// figurliste for diagrammet
		for (ISVGfigure gf : diagram.figureList()) {
			Element figurenode = document.createElement("g");
			figurenode.setAttribute("id", nl.number(gf.figureName()));
			// elementliste for figuren
			for (ISVGelement ge : gf.elementList()) {
				Element elementnode = document.createElement("g");
				elementnode.setAttribute("id", nl.number(ge.renderable()));
				Element content = document.createElement(ge.renderable());
				for (String[] a : ge.attrList(gf.getLocation())) {
					content.setAttribute(a[0], a[1]);
				}
				elementnode.appendChild(content);
				content.appendChild(document.createTextNode(ge.label()));
				figurenode.appendChild(elementnode);
			}
			root.appendChild(figurenode);
		}
	}

}
