package module1.chapter8;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;
import java.net.URL;

public class ReadOrWriteXML {
	public static Document readXMLFromFileXML(File f) throws SAXException, IOException{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db;
		try {

			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
			return doc;

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	public static Document readXMLFromURL(URL url) throws SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db;
		try {

			db = dbf.newDocumentBuilder();
			Document doc = db.parse(url.openStream());
			return doc;

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
