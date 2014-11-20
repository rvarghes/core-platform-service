/*
 * XMLHelper.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 25, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

//jaxp-api.jar
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.sql.RowSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kcdata.abe.framework.logging.ABELogger;


public class XMLHelper // implements DataHelper
{

private Document doc = null;
private boolean isInitialized = false;
private String xmlString = null;

public static final int INSERT_BEFORE_FIRST_CHILD = 1;
public static final int INSERT_AFTER_LAST_CHILD = 2;

public static final int FORMAT_XML = 2;
public static final int FORMAT_XML_UUENCODED = 4; 

private ABELogger Logger = ABELogger.getLogger(XMLHelper.class);

// -- Take a string here?
public XMLHelper(String xml) {

	setXML(xml);   

} // -- public XMLHelper(String xml)

public XMLHelper() {

}



public String getElementByXPath(String xPath)  {
	return getElementByXPath(xPath, 0);
}

public String getElementByXPath(String xPath, int elementOrdinalPosition)  {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	String result = null;

	try {
    
	  NodeList nodes = processXPath(xPath);
    
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(elementOrdinalPosition);
		if (el.hasChildNodes()) {
		  // -- Is one of these child nodes a text node?
		  NodeList children = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  result = child.getNodeValue();
			  break;
			}
		  } // -- for (i = 0; i < children.getLength(); i++) {
		} // -- if (!el.hasChildNodes()) {
	  }
	} catch (Exception e) {
		String msg = "Error getting element value using XPath: " + xPath + ", e: " + e.toString(); 
		Logger.error(msg);
	}
  
	return result;
  
}


public Element getElementNode(String xPath)  {
  
	// expects there to be a [@something='something'] in the xpath so the ordinal is not needed
	// however, if multiple nodes are returned, the first is selected 

	Element result = null;

	try {
    
	  NodeList nodes = processXPath(xPath);
    
	  if (nodes.getLength() >= 1) {
		result = (Element) nodes.item(0);
	  }
    
	} catch (Exception e) {
		Logger.error("XMLHelper.getElementNode: Error getting element node using XPath: " + xPath + ", e: " + e.toString());
	}
  
	return result;
  
}

	public int getElementPositionByXPath(String xPath, String nodeText) {
		
		int retval = -1;
		try {
			
			NodeList nodes = processXPath(xPath);
			if (nodes!=null) {
				
			  int noNodes = nodes.getLength();
			  if (noNodes >= 1) {
				for (int j = 0; j < noNodes; j++) {
					Element el = (Element) nodes.item(j);
					if (el.hasChildNodes()) {
					  // -- Is one of these child nodes a text node?
					  NodeList children = el.getChildNodes();
					  for (int i = 0; i < children.getLength(); i++) {
						Node child = children.item(i);
						if (child instanceof Text) {
						  // -- Replace contents of child text node
						  if (child.getNodeValue().equals(nodeText)) {
							retval = j;
							break;
						  }
						}
					  // -- for (i = 0; i < children.getLength(); i++) {  
					  } 
					  // -- If we found what we were looking for in the text of 
					  //    the current element, then we are done.
					  if (retval > -1) break;
					// -- if (!el.hasChildNodes()) {
					} 
				}
			  }
				
			// -- if (nodes!=null) {
			}		
			
		} catch (Exception e) {
			Logger.error("Error initializing XPath in XMLHelper");
		}
		
		return retval;
	}


	public int getTargetElementPositionByXPath(String xPathAllNodes, String xPathTargetNode) {
		// returns parent node's ordinal position according to the xpath
		// xpathTargetNode is expected to have query info that selects one node
		// if not, the first is selected
		// xpathAllNodes is the same xpath to all nodes of the same type but without the query info
		
		int retval = -1;
		try {
			
			NodeList targetNodes = processXPath(xPathTargetNode);
			if (targetNodes!=null) {
				
			  int noNodes = targetNodes.getLength();
			  if (noNodes >= 1) {
		      	
				//preserve the target node
				Element elTarget = (Element) targetNodes.item(0);		      	
	
				//get list of all nodes
				NodeList allNodes = processXPath(xPathAllNodes);				
				noNodes = allNodes.getLength();
				
				//iterate until we match the target with an element in the list
				for (int j = 0; j < noNodes; j++) {
					Element el = (Element) allNodes.item(j);
		
					if (el.equals(elTarget)) {
							retval = j;
							break;
					} // if
				} // for
			  } // if >= 1
			} // if != null		
			
		} catch (Exception e) {
			Logger.error("Error in XMLHelper.getTargetElementPositionByXPath: " + e.toString());
		}
		
		return retval;
	}

	public int insertElementAtTargetPositionFromXML(String xPathAllNodes, String xPathTargetNode, String elementXML) {
		// returns parent node's ordinal position according to the xpath
		// inserts a new node at that position created with elementXML
		// xpathTargetNode is expected to have query info that selects one node
		// if not, the first is selected
		// xpathAllNodes is the same xpath to all nodes of the same type but without the query info
		
		int retval = -1;
		try {
			
			NodeList targetNodes = processXPath(xPathTargetNode);
			if (targetNodes!=null) {
				
			  int noNodes = targetNodes.getLength();
			  if (noNodes >= 1) {
		      	
				//preserve the target node
				Element elTarget = (Element) targetNodes.item(0);		      	
	
				//get list of all nodes
				NodeList allNodes = processXPath(xPathAllNodes);				
				noNodes = allNodes.getLength();
				
				//iterate until we match the target with an element in the list
				for (int j = 0; j < noNodes; j++) {
					Element el = (Element) allNodes.item(j);
		
					if (el.equals(elTarget)) {
							retval = j;

							Document docInsert = XMLDocFromString(elementXML);  
							Element elInsert = docInsert.getDocumentElement();
    
							//add to parent node, inserting BEFORE the target node
							(el.getParentNode()).insertBefore(doc.importNode(elInsert, true), el);
            				
							break;
					} // if
				} // for
			  } // if >= 1
			} // if != null		
			
		} catch (Exception e) {
			Logger.error("Error in XMLHelper.getTargetElementPositionByXPath: " + e.toString());
		}
		
		return retval;
	}


	public int getElementCountByXPath(String xPath) {
		
		int retval = 0;
		try {
			
			NodeList nodes = processXPath(xPath);
			if (nodes!=null) 
			  return nodes.getLength();	
			else
			  Logger.error("No nodes returned in getElementCountByXPath() using: " + xPath);		
			
		} catch (Exception e) {
			Logger.error("Error using XPath in getElementCountByXPath():" + e.toString());
		}
		
		Logger.error("About to return " + Integer.toString(retval) + " in getElementCountByXPath(" +  xPath + ").");
		return retval;
	}


 public NodeList processXPath(String xPath) throws SAXException {

    
    
	  NodeList retval = null;
	  if (doc==null) return retval;
	  if (xPath==null) return retval;
	  try {
		  retval = XPathAPI.selectNodeList((Node)doc.getDocumentElement(), xPath);
	  } catch (Exception e) {
		Logger.error("Err in processXPath: " + e.toString());
	  }
    
	  if (retval==null) {
		Logger.error("No nodes returned using xPath: " + xPath);
		Logger.error("Current xml is: " + this.getXML());
	  }
    
	  return retval;
    
	}


public void setXML(String xml) {
	
	try {
		doc = XMLDocFromString(xml);
		isInitialized = true;
		xmlString = xml;
	} catch (Exception e) {
		isInitialized = false;
	}
}

public Document XMLDocFromString(String xml) throws Exception { 

	Document doc = null;
  
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// -- validate? factory.setValidating(true);  
	try {
  
	  DocumentBuilder db = factory.newDocumentBuilder();
	  StringReader s = new StringReader(xml);
	  InputSource is = new InputSource((Reader)s);
	  doc = (Document)db.parse(is);

	} catch (SAXException sxe) {
	   Exception e = sxe;
	   if (sxe.getException() != null) e = sxe.getException();
	   //e.printStackTrace();
	   Logger.error("Sax exception: " + e.toString());
	   throw new Exception("Sax exception: " + e.toString());

	} catch (ParserConfigurationException pce) {
	  //pce.printStackTrace();
	  Logger.error("ParserConfigurationException: " + pce.toString());
	  throw new Exception("ParserConfigurationException: " + pce.toString());

	} catch (IOException ioe) {
	  //ioe.printStackTrace();
	  Logger.error("IOException: " + ioe.toString());
	  throw new Exception("IOException: " + ioe.toString());      
	}

	return doc; 

}


// -- Now that parsed, how construct? Single method to expose 
//    any property? Methods to return number of occurrences of
//    given element? etc.
public void setElement(String elementName, String value, int elementOrdinalPosition, String elementXML) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	if (value==null) return;

	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  // -- Note that this assumes AT LEAST one such element exists
	  if ((nodes.getLength()-1) < elementOrdinalPosition) {
		Document docInsert = XMLDocFromString(elementXML);
		Element elInsert = docInsert.getDocumentElement();
		nodes.item(0).getParentNode().appendChild(doc.importNode(elInsert, true));
	  }   
	} catch (Exception e) {
	  Logger.error("XMLHelp setElement: Error inserting new element to be populated: " + elementName + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}

	setElement(elementName, value, elementOrdinalPosition);
 
}

// -- Note, ordinalPosition is 0-based
//    Do we need a signature to set an attribute on all?
//    Methods to get number of occurrences of el?
public void setElement(String elementName, String value, int elementOrdinalPosition) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");
	
	if (value==null) return;

	try {
    
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  int noNodes = nodes.getLength();
	  if (noNodes >= 1) {
      
		if ((elementOrdinalPosition + 1) > noNodes) return;
        
		Element el = (Element) nodes.item(elementOrdinalPosition);
		// -- Should have some verification that incoming text does not include
		//    <s, >s, etc. If so, translate to entitys or use CData section, e.g.
		//    value = validateXMLText(value);

		// -- We will either replace or insert child textNode
		Node text = doc.createTextNode(value);
		if (!el.hasChildNodes()) {
		  el.appendChild(text);
		} else {
		  // -- Is one of the child notes text that we must replace?
		  NodeList list = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  child.setNodeValue(value);
			  break;
			}
		  }
		  // -- Did we find a TextNode? If not, append.
		  if (i==list.getLength()) {
			el.appendChild(text);  
		  }
		}
	  }
	} catch (Exception e) {
	  Logger.error("Error setting element value: " + elementName + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
 
}


public void setElement(String elementName, String value) {
	setElement(elementName, value, 0);
}


public boolean setElementByXPath(String xPath, String value) {
  
	// If xPath does not select a single node, the first node in the 
	// returned set is used

	boolean result = false;	
	if (value==null) return(false);

	try {
    
	  NodeList nodes = processXPath(xPath);
    
	  int noNodes = -1;
	  if (nodes != null) 
		noNodes = nodes.getLength();

	  if (noNodes >= 1) {
        
		Element el = (Element) nodes.item(0);
		// -- Should have some verification that incoming text does not include
		//    <s, >s, etc. If so, translate to entitys or use CData section, e.g.
		//    value = validateXMLText(value);

		// -- We will either replace or insert child textNode
		Node text = doc.createTextNode(value);
		if (!el.hasChildNodes()) {
		  el.appendChild(text);
		  result=true;          
		} else {
		  // -- Is one of the child notes text that we must replace?
		  NodeList list = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  child.setNodeValue(value);
			  result=true;
			  break;
			}
		  }
		  // -- Did we find a TextNode? If not, append.
		  if (i==list.getLength()) {
			el.appendChild(text);  
			result=true;
		  }
		}
	  }
	} catch (Exception e) {
	  Logger.error("Error setting element value: " + xPath + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
 
 return(result);
 
}


public boolean setAllElementsByXPath(String xPath, String value) {
  
	// All nodes in the returned set is used

	boolean result = false;	
	if (value==null) return(false);

	try {
    
	  NodeList nodes = processXPath(xPath);
    
	  int noNodes = -1;
	  if (nodes != null) 
		noNodes = nodes.getLength();

	  if (noNodes >= 1) {
	  for (int n=0; n < noNodes; n++ ) {    
		Element el = (Element) nodes.item(n);
		// -- Should have some verification that incoming text does not include
		//    <s, >s, etc. If so, translate to entitys or use CData section, e.g.
		//    value = validateXMLText(value);

		// -- We will either replace or insert child textNode
		Node text = doc.createTextNode(value);
		if (!el.hasChildNodes()) {
		  el.appendChild(text);
		} else {
		  // -- Is one of the child notes text that we must replace?
		  NodeList list = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  child.setNodeValue(value);
			  result=true;
			  break;
			}
		  }
		  // -- Did we find a TextNode? If not, append.
		  if (i==list.getLength()) {
			el.appendChild(text);  
			result=true;
		  }
		}
	  } //for
	  }
	} catch (Exception e) {
	  Logger.error("Error setting element value: " + xPath + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
 
 return(result);
 
}

// -- Note, ordinalPosition is 0-based
//    Do we need a signature to set an attribute on all?
//    Methods to get number of occurrences of el?
public void setElementByXPath(String xPath, String value, int elementOrdinalPosition) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");
	
	if (value==null) return;

	try {
    
	  NodeList nodes = processXPath(xPath);
	  if (nodes==null) return;
	  int noNodes = nodes.getLength();
	  if (noNodes >= 1) {
      
		if ((elementOrdinalPosition + 1) > noNodes) return;
        
		Element el = (Element) nodes.item(elementOrdinalPosition);
		// -- Should have some verification that incoming text does not include
		//    <s, >s, etc. If so, translate to entitys or use CData section, e.g.
		//    value = validateXMLText(value);

		// -- We will either replace or insert child textNode
		Node text = doc.createTextNode(value);
		if (!el.hasChildNodes()) {
		  el.appendChild(text);
		} else {
		  // -- Is one of the child notes text that we must replace?
		  NodeList list = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  child.setNodeValue(value);
			  break;
			}
		  }
		  // -- Did we find a TextNode? If not, append.
		  if (i==list.getLength()) {
			el.appendChild(text);  
		  }
		}
	  }
	} catch (Exception e) {
	  Logger.error("Error setting element value: " + xPath + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
 
}


public boolean hasElement(String elementName) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");
	boolean result = false;
  
	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  result = (nodes.getLength() >= 1); 
	} catch (Exception e) {
	  Logger.error("Error detecting presence of element: " + elementName + ", e: " + e.toString());
	  Logger.error("XML is: " + xmlString);
	  // throw e;
	}
	return result;   
}

public void deleteElement(String elementName, String parentElement) {
	deleteElement(elementName, parentElement, 0);
}

public void deleteElement(String elementName, String parentElement, int elementOrdinalPosition) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	try {
	  NodeList nodes = doc.getElementsByTagName(parentElement);
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(elementOrdinalPosition);
		if (el.hasChildNodes()) {
		  NodeList list = el.getChildNodes();
		  for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			if (child.getNodeName().equals(elementName) ) {
			  el.removeChild(child);
			  break;
			}
		  }
		}
	  }
	} catch (Exception e) {
	  Logger.error("Error deleting element value: " + elementName + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
}

public int deleteAllElementsByXPath(String xpath) {
  
	// returns num of elements deleted
	// does not throw an exception or print errors, since it sends back the number of deletions
	// and we want to use this without checking the existence of the nodes first 
	// for performance reasons
	int result = 0;
	
	try {
	  NodeList nodes = processXPath(xpath);
	  int node_count = nodes.getLength(); 
	  int i;
	  if (node_count >= 1) {
		for (i=0; i < node_count; i++) { 
			Element el = (Element) nodes.item(i);
			result ++;
			try {
				(el.getParentNode()).removeChild(el);
			} catch (Exception e) {}
		}
	  }
	} catch (Exception e) {}
  
	return(result);
}  

public void insertElementFromXML(String parentElement, String elementXML) {
	insertElementFromXML(parentElement, INSERT_AFTER_LAST_CHILD, elementXML, 0);
}

public void insertElementFromXML(String parentElement, int position, String elementXML) {
	insertElementFromXML(parentElement, position, elementXML, 0);
}

public void insertElementFromXML(String parentElement, String elementXML, int elementOrdinalPosition) {
	insertElementFromXML(parentElement, INSERT_AFTER_LAST_CHILD, elementXML, elementOrdinalPosition);
}
  
public void insertElementFromXMLByXPath(String xPath, String elementXML) {
	insertElementFromXMLByXPath(xPath, INSERT_AFTER_LAST_CHILD, elementXML);
}

public void insertElementFromXMLByXPath(String xPath, int position, String elementXML) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	try {
	  // -- Prepare node to insert
	  Document docInsert = XMLDocFromString(elementXML);  
	  Element elInsert = docInsert.getDocumentElement();
    
	  NodeList nodes = processXPath(xPath);
    
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(0);
		if (el.hasChildNodes()) {
		  switch (position) {
			case INSERT_AFTER_LAST_CHILD:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;
			case INSERT_BEFORE_FIRST_CHILD:
			  //rcs corrected order of parameter elements by swapping them            
			  el.insertBefore(doc.importNode(elInsert, true), el.getFirstChild());
			  break;
			default:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;           
		  }
		} else {
		  el.appendChild(doc.importNode(elInsert, true));
		}
	  } else {
		// -- Throw error? Have function return false?
	  }
	} catch (Exception e) {
	  Logger.error("Error inserting\n" + elementXML + "\nusing XPath:\n" + xPath + "\n, e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
}
  
public void insertElementFromXML(String parentElement, int position, String elementXML, int elementOrdinalPosition) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	try {
	  // -- Prepare node to insert
	  Document docInsert = XMLDocFromString(elementXML);  
	  Element elInsert = docInsert.getDocumentElement();
    
	  NodeList nodes = doc.getElementsByTagName(parentElement);
	  int noNodes = -1;
	  if (nodes != null)
		noNodes = nodes.getLength();
	  if (noNodes >= 1) {
		Element el = (Element) nodes.item(elementOrdinalPosition);
		if (el.hasChildNodes()) {
		  switch (position) {
			case INSERT_AFTER_LAST_CHILD:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;
			case INSERT_BEFORE_FIRST_CHILD:
			  //rcs corrected order of parameter elements by swapping them            
			  el.insertBefore(doc.importNode(elInsert, true), el.getFirstChild());
			  break;
			default:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;           
		  }
		} else {
		  el.appendChild(doc.importNode(elInsert, true));
		}
	  } else {
		Logger.error("No nodes returned using doc.getElementsByTagName(\"" + parentElement + "\")");
	  }
	} catch (Exception e) {
	  Logger.error("Error inserting element value: " + parentElement + ", e: " + e.toString());
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
}


public void insertElementFromXML(Element parentElement, String elementXML) {
	insertElementFromXML(parentElement, INSERT_AFTER_LAST_CHILD, elementXML);
}

public void insertElementFromXML(Element parentElement, int position, String elementXML) {
	insertElementFromXML(parentElement, position, elementXML, 0);
}

public void insertElementFromXML(Element el, int position, String elementXML, int elementOrdinalPosition) {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	try {
	  // -- Prepare node to insert
	  Document docInsert = XMLDocFromString(elementXML);  
	  Element elInsert = docInsert.getDocumentElement();

	   if (el.hasChildNodes()) {
		  switch (position) {
			case INSERT_AFTER_LAST_CHILD:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;
			case INSERT_BEFORE_FIRST_CHILD:
			  el.insertBefore(doc.importNode(elInsert, true), el.getFirstChild());
			  break;
			default:
			  el.appendChild(doc.importNode(elInsert, true));
			  break;           
		  }
		} else {
		  el.appendChild(doc.importNode(elInsert, true));
		}

	} catch (Exception e) {
	  Logger.error("Error inserting element value: " + e.toString());
	  Logger.error("New Element XML is: " + elementXML);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
}

	public void replaceElementFromXML(Element el, String elementXML) {
	// this replaces the current el node with a new one from XML

	try {
	  // -- Prepare node to insert
	  Document docInsert = XMLDocFromString(elementXML);  
	  Element elInsert = docInsert.getDocumentElement();
	  // syntax: replace (new, old)
	  (el.getParentNode()).replaceChild(doc.importNode(elInsert, true), el);
	
	} catch (Exception e) {
	  Logger.error("Error replacing element: " + e.toString());
	  Logger.error("New Element XML is: " + elementXML);
	  // throw e;
	}
}


public String getAttribute(String elementName, String attributeName) throws Exception {
	return getAttribute(elementName, attributeName, 0);
}

public String getElement(String elementName) {
	return getElement(elementName, 0);
}

// -- Note, ordinalPosition is 0-based
public String getElement(String elementName, int elementOrdinalPosition)  {
  
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	String result = null;

	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(elementOrdinalPosition);
		if (el.hasChildNodes()) {
		  // -- Is one of these child nodes a text node?
		  NodeList children = el.getChildNodes();
		  int i = 0;
		  for (i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Text) {
			  // -- Replace contents of child text node
			  result = child.getNodeValue();
			  break;
			}
		  } // -- for (i = 0; i < children.getLength(); i++) {
		} // -- if (!el.hasChildNodes()) {
	  }
	} catch (Exception e) {
		String msg = "Error setting element value: " + elementName + ", e: " + e.toString(); 
	  Logger.error(msg);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
  
	return result;
  
}

public String getAttribute(String elementName, String attributeName, int elementOrdinalPosition) throws Exception {

	String result = "";
    
	// if (! isInitialized) throw new Exception("XMLHelper not isInitialized");

	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(elementOrdinalPosition);
		result = el.getAttribute(attributeName);    
	  }
	} catch (Exception e) {
	  Logger.error("Error getting attribute using elementName: " + elementName + ", attributeName: " + attributeName);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
	return result;

}

// -- The value should always be an object, as in String, Integer, Boolean, etc.
public void setAttribute(String elementName, String attributeName, String value) throws Exception {

	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  if (nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(0);
		el.getAttributeNode(attributeName).setValue(value);    
	  }
	} catch (Exception e) {
		String msg = "Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName;
	  Logger.error(msg);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
  
}


public String getAttributeByXPath(String xPath, String attributeName) {

	String result = "";

	try {
	  NodeList nodes = processXPath(xPath);
	  if ((nodes!=null) && nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(0);
		result = el.getAttribute(attributeName);    
	  }
	} catch (Exception e) {
		String msg = "CBE: Non-fatal Error setting attribute using elementName: " + xPath + ", attributeName: " + attributeName;
		Logger.error(msg);
	}

	return(result);    
}

public void setAttributeByXPath(String xPath, String attributeName, String value) throws Exception {

	try {
	  NodeList nodes = processXPath(xPath);
	  if ((nodes!=null) && nodes.getLength() >= 1) {
		Element el = (Element) nodes.item(0);
		el.getAttributeNode(attributeName).setValue(value);    
	  }
	} catch (Exception e) {
		String msg = "Error setting attribute using elementName: " + xPath + ", attributeName: " + attributeName;
	  Logger.error(msg);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
  
}

// -- The value should always be an object, as in String, Integer, Boolean, etc.
public void setAttribute(String elementName, int pos, String attributeName, String value) {

	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  if (nodes!=null && nodes.getLength() >= pos) {
		Element el = (Element) nodes.item(pos);
		el.setAttribute(attributeName, value);    
	  }
	} catch (Exception e) {
		String msg = "Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName;
	  Logger.error(msg);
	  Logger.error("XML is: " + getXML());
	  // throw e;
	}
  
}


public boolean addAttribute(String elementName, String attributeName, String value) throws Exception {

	int n=0;
	boolean success = false;
		
	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
		el.setAttribute(attributeName, value);    
		success=true;     	
	  } // for n
	} catch (Exception e) {
		success=false; 
	  Logger.error("XMLHelper.addAttribute - Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName);
	  //Logger.error("XML is: " + getXML(), false);
	  // throw e;
	}  		

	return (success);
}


public boolean addAttributeByXPath(String xPath, String attributeName, String value) {

	int n=0;
	boolean success = false;
		
	try {
	  NodeList nodes = processXPath(xPath);    	
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
		el.setAttribute(attributeName, value);    
		success=true;     	
	  } // for n
	} catch (Exception e) {
		success=false; 
	  Logger.error("XMLHelper.addAttribute - Error setting attribute using xPath: " + xPath + ", attributeName: " + attributeName);
	  //Logger.error("XML is: " + getXML(), false);
	  // throw e;
	}  		

	return (success);
}

public String toString() {
	return getXML();
}


// -- Return raw XML. May want to implement interface that defines
//    methods for returning it in other forms as well -- arrays, 
//    maps, etc.
public String getXML() {
	String result = "";
	try {
		result = transformXML();
	} catch (Exception e) {
		// --
	}
	return result;
}

public String transformXML() throws Exception {
	return transformXML(doc, "");
}

public String transformXML(String xslt) throws Exception {
	return transformXML(doc, xslt);
} 


public String transformXML(String xml, String xslt) throws Exception {
	Document doc = XMLDocFromString(xml);
	return transformXML(doc, xslt);
}

public String transformXML(Document doc, String xslt) throws Exception {
  
	String result = "";
    
	try {
	  Transformer transformer = null;
	  if (xslt.equals("")) {
		transformer = TransformerFactory.newInstance().newTransformer();
	  } else {
		StreamSource in = new StreamSource((InputStream)new ByteArrayInputStream(xslt.getBytes()));
		transformer = TransformerFactory.newInstance().newTransformer(in);
	  } 
	  Source source = new DOMSource(doc);
	  ByteArrayOutputStream out = new ByteArrayOutputStream();
	  Result transResult = new StreamResult( out );
	  transformer.transform( source, transResult );
	  //result = transResult.toString();
	  result = out.toString();
	} catch (Exception e) {
		String msg = "Error getting XML in XMLHelper: " + e.toString();
	  Logger.error(msg);
	}	
	
	return result;
}	

public String intToXMLBool(int in) {
	return (in==0) ? "false" : "true";
}

public boolean getIsInitialized() {
	return isInitialized;
}

public static String getRowSetAsXML(RowSet rs) {
	
	StringBuffer sb = new StringBuffer();

	
	return sb.toString();
}

public int setAttributeByNodeValueList( String elementName, String[] elementValues, String attributeName, String[] attributeValues) {

		Vector elementValuesVector = new Vector();
		Vector attributeValuesVector = new Vector();
		
		int listlength = elementValues.length;
		int i;
  
		for (i=0; i < listlength; i++) {
			elementValuesVector.addElement(elementValues[i]);
			attributeValuesVector.addElement(attributeValues[i]);
		}
  	 	

	return(	setAttributeByNodeValueList( elementName, elementValuesVector, attributeName, attributeValuesVector) );
	
}
	
public int setAttributeByNodeValueList( String elementName, Vector elementValues, String attributeName, Vector attributeValues) {
// element Name - the name of the element you want to do comparisons on
// element Values - parallel list to AttribValues, if element value = a value in the list, the corresponding attribute value is set	
// returns number of replacements made
// length of elementValues must be the same as length of AttributeValues
	int replacements=0;
	int n=0, j=0, i=0;
	int valuecount = elementValues.size();
	if (valuecount == attributeValues.size()) {
	String result = null;
	
	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
			
		if (el.hasChildNodes()) {
			// -- Is one of these child nodes a text node?
			NodeList children = el.getChildNodes();
			result = null;
			for (i = 0; i < children.getLength(); i++) {
			   Node child = children.item(i);
				if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  result = child.getNodeValue();
			   break;
			  }
			} // -- for i
      	
			if (result != null ) {		
				//compare each elementvalue against the node value
				for (j=0; j < valuecount; j++) {

					if (result.equals(elementValues.elementAt(j))) {
						el.setAttribute(attributeName, (String)attributeValues.elementAt(j));    
						replacements++;
						break;
					} // if
				} //for j
			} // if result
		} // if el
      	
	  } // for n
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeByNodeValueList - Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName);
	  //Logger.error("XML is: " + getXML(), false);
	  // throw e;
	}  		
		
	} else {
		Logger.error("XMLHelper.setAttributeByNodeValueList - Unable to set attributes - length of arrays is different: elementValues=" + String.valueOf(elementValues.size()) + ", attributeValues=" + String.valueOf(attributeValues.size()));  		
	}
	
	//Logger.error("XMLHelper.setAttributeByNodeValueList - Replaced=" + String.valueOf(replacements), false);
	return replacements;
	
} //setAttributeByNodeValueList


public int setAttributeByAttribValueList( String elementName, String testAttributeName, Vector testAttributeValues, String newAttributeName, Vector newAttributeValues, boolean indExactMatch ) {
	// similar to setAttributeByNodeValueList, except the newAttributeName is
	// set on the same element node as the test attribute
// element Name - the name of the element containing testAttribName you want to do comparisons on
// testAttributeValues - parallel list to newAttribValues, if test node value = a value in the list, the corresponding attribute value is set	
// returns number of replacements made
// length of testAttribValues must be the same as length of newAttributeValues
// ind exact match says whether the node needs to be exacty matched, or if the node can just contain the test value as a substring

	int replacements=0;
	int n=0, j=0;
	int valuecount = testAttributeValues.size();
	if (valuecount == newAttributeValues.size()) {
	String result = null;
	
	try {
	  NodeList nodes = doc.getElementsByTagName(elementName);
    
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
		String xmlAttrib = el.getAttribute(testAttributeName);
		
		if (xmlAttrib != null) {
			//compare each element attrib value against the test attrib value
			for (j=0; j < valuecount; j++) {			
				if ( indExactMatch ) {
					if ( xmlAttrib.equals(testAttributeValues.elementAt(j)) ) {
						el.setAttribute(newAttributeName, (String)newAttributeValues.elementAt(j));    
						replacements++;
						break;
					} // if
				} else { //see if the substring is in there 
					if ( xmlAttrib.indexOf((String)(testAttributeValues.elementAt(j))) > -1 ) {
						el.setAttribute(newAttributeName, (String)newAttributeValues.elementAt(j));    
						replacements++;
						break;
					} // if												
				} //if exactmatch
			} //for j			
		} //if !null
	  } // for n
    
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeByAttribValueList - Error setting attribute using : " + elementName + "/@" + testAttributeName + ", newAttributeName: " + newAttributeName);
	  //Logger.error("XML is: " + getXML(), false);
	  // throw e;
	}  		
		
	} else {
		Logger.error("XMLHelper.setAttributeByAttribValueList - Unable to set attributes - length of arrays is different: testAttributeValues=" + String.valueOf(testAttributeValues.size()) + ", newAttributeValues=" + String.valueOf(newAttributeValues.size()));  		
	}
	
	//Logger.error("XMLHelper.setAttributeByAttribValueList - " + newAttributeName + " attribs created=" + String.valueOf(replacements), false);
	return replacements;
	
} //setAttributeByAttribValueList




public int setAttributeByAttribValueList( String xpath, String testAttributeName, Vector testAttributeValues, String newAttributeName, String newAttributeValue ) {
	// similar to setAttributeByNodeValueList, except the newAttributeName is
	// set on the same element node as the test attribute
	//good for setting checkboxes
// xpath - the name of the element containing testAttribName you want to do comparisons on
// testAttributeValues , if test node value = a value in the list, the corresponding attribute value is set	
// returns number of replacements made

	int replacements=0;
	int n=0, j=0;
	int valuecount = testAttributeValues.size();

	String result = null;
	
	try {
	  NodeList nodes = processXPath(xpath);      
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
		String xmlAttrib = el.getAttribute(testAttributeName);
		
		if (xmlAttrib != null) {
			//compare each element attrib value against the test attrib value
			for (j=0; j < valuecount; j++) {			
				if ( xmlAttrib.equals(testAttributeValues.elementAt(j)) ) {
					el.setAttribute(newAttributeName, newAttributeValue);    
					replacements++;
					break;
				} // if
			} //for j			
		} //if !null
	  } // for n
    
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeByAttribValueList - Error setting attribute using xpath= " + xpath + "/@" + testAttributeName + ", newAttributeName: " + newAttributeName);
	  //Logger.error("XML is: " + getXML(), false);
	  // throw e;
	}  		
	
	//Logger.error("XMLHelper.setAttributeByAttribValueList - " + newAttributeName + " attribs created=" + String.valueOf(replacements), false);
	return replacements;
	
} //setAttributeByAttribValueList


  	
public int setAttributeDateFormatPlusWeekday( String elementName, String attributeName ) {
// reformats a date in node elementName as friendly string and puts it in that node's attributes as attributeName 	
// returns number of attributes done - these appear in both leg and segment nodes

	int replacements=0;
	int n=0, j=0, i=0;

	String result = null;
	
	try {
  	
	  // set up date formatting	
	  SimpleDateFormat sourceFormatter = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss");
	  SimpleDateFormat targetFormatter = new SimpleDateFormat ("E, MMM dd 'at' hh:mm a");  
	      	
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  //NodeList nodes = processXPath(elementName);
    
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
			
		if (el.hasChildNodes()) {
			// -- Is one of these child nodes a text node?
			NodeList children = el.getChildNodes();
			result = null;
			for (i = 0; i < children.getLength(); i++) {
			   Node child = children.item(i);
				if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  result = child.getNodeValue();
			   break;
			  }
			} // -- for i
      	
			if (result != null ) {		
				//grab each elementvalue and reformat into attributename
				ParsePosition pos = new ParsePosition(0);
				el.setAttribute(attributeName, targetFormatter.format(sourceFormatter.parse(result, pos)) );
				replacements++;
			} // if result
		} // if el
      	
	  } // for n
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeDateFormat - Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName);

	}  		
		
	//Logger.error("XMLHelper.setAttributeDateFormat - Replaced=" + String.valueOf(replacements), false);
	return replacements;  

} //plus weekday


public int setAttributeDateFormat( String elementName, String attributeName ) {
// reformats a date in node elementName as friendly string and puts it in that node's attributes as attributeName 	
// returns number of attributes done - these appear in both leg and segment nodes

	int replacements=0;
	int n=0, j=0, i=0;

	String result = null;
	
	try {
  	
	  // set up date formatting	
	  SimpleDateFormat sourceFormatter = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss");
	  SimpleDateFormat targetFormatter = new SimpleDateFormat ("MMM dd, hh:mm a");  
	      	
	  NodeList nodes = doc.getElementsByTagName(elementName);
	  //NodeList nodes = processXPath(elementName);
    
	  int nodecount = nodes.getLength();
		
	  //perform this operation an all nodes found
	  for (n=0; n < nodecount; n++) {
		Element el = (Element) nodes.item(n);
			
		if (el.hasChildNodes()) {
			// -- Is one of these child nodes a text node?
			NodeList children = el.getChildNodes();
			result = null;
			for (i = 0; i < children.getLength(); i++) {
			   Node child = children.item(i);
				if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  result = child.getNodeValue();
			   break;
			  }
			} // -- for i
      	
			if (result != null ) {		
				//grab each elementvalue and reformat into attributename
				ParsePosition pos = new ParsePosition(0);
				el.setAttribute(attributeName, targetFormatter.format(sourceFormatter.parse(result, pos)) );
				replacements++;
			} // if result
		} // if el
      	
	  } // for n
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeDateFormat - Error setting attribute using elementName: " + elementName + ", attributeName: " + attributeName);

	}  		
		
	//Logger.error("XMLHelper.setAttributeDateFormat - Replaced=" + String.valueOf(replacements), false);
	return replacements;  

}



public int setAttributeDurations( ) {
// calculates the total flight duration by generating the duration of all legs, then setting the FlightSelection duration sort
// reformats a date in node elementName as friendly string and puts it in that node's attributeName 	
// returns number of replacements done

	int replacements=0;
	int n=0, j=0, i=0;
	
	String result = null;
	
	try {
  
	  // set up date formatting	
	  SimpleDateFormat sourceFormatter = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss");
	  SimpleDateFormat sortFormatter = new SimpleDateFormat ("yMMddHHmm");
	    	
	  // expecting to get Leg nodes
	  NodeList legs = doc.getElementsByTagName("Leg");
	  int legcount = legs.getLength();

	  // get only the first encountered  arrivaldatetime and departdatetime (note descendent segment nodes have these too)		
	  // to generate the duration for that leg.
	  
	  //perform this operation an all nodes found
	  for (n=0; n < legcount; n++) {
		Element leg = (Element) legs.item(n);
		
		try {

			// get the arrival string from first child			
			NodeList datetimeElements = leg.getElementsByTagName("ArrivalDateTime");
			Element el = (Element) datetimeElements.item(0);			
			// -- Is one of these child nodes a text node?
			NodeList children = el.getChildNodes();
			String sArrival = null;
			for (i = 0; i < children.getLength(); i++) {
			   Node child = children.item(i);
				if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  sArrival = child.getNodeValue();
				 break;
				}
			} // -- for i
       	         	
			// now get the departure string	
			datetimeElements = leg.getElementsByTagName("DepartDateTime");
			el = (Element) datetimeElements.item(0);			
			// -- Is one of these child nodes a text node?
			children = el.getChildNodes();
			String sDepart = null;
			for (i = 0; i < children.getLength(); i++) {
			   Node child = children.item(i);
				if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  sDepart = child.getNodeValue();
				break;
				}
			} // -- for i
		
			//Convert them to dates
			// don't take into account the timezones since we're not showing the duration, so the flight times are all relative to each other
			// this will only be a problem on flights spanning daylight savings days and times when comparing durations
			ParsePosition pos1 = new ParsePosition(0);            	
			java.util.Date dArrival = sourceFormatter.parse(sArrival, pos1);					         	         	
			ParsePosition pos2 = new ParsePosition(0);            	
			java.util.Date dDepart = sourceFormatter.parse(sDepart, pos2);					         	         				         	

			//set the FlightSelection parent's attribute "earliest sort" if this is outgoing leg
			//note the century and decade are not significant to the sort
			if ( ((String) leg.getAttribute("DirectionCode")).equals("O") ) {
				((Element) leg.getParentNode()).setAttribute("EarliestSort", sortFormatter.format(dDepart));
			}       	
			         				
			// record the difference in minutes as an attribute in the leg			
			// milliseconds -> minutes conversion is 1/60000
			Long duration = new Long((long) ((dArrival.getTime() - dDepart.getTime()) / 60000) );			
			//Logger.error("Duration=" + duration.toString());
			leg.setAttribute("Duration", duration.toString());       			
			replacements++;

		} catch (Exception e) { 
			 Logger.error("XMLHelper.setAttributeDurations - Encountered problem processing leg #" + Integer.toString(n));
		}  		
      	
	  } // for n
    
	  // now that we've processed all the durations, record their sums in a flight selection attribute
	  NodeList flights = doc.getElementsByTagName("FlightSelection");
	  int flightcount = flights.getLength();
	  
	  //perform this operation an all nodes found
	  for (n=0; n < flightcount; n++) {
		Element flight = (Element) flights.item(n);

			
		// set the internally-used document-order flight# (0..#offlights)
		flight.setAttribute("NodeID", Integer.toString(n));

		//collect both leg durations and sum
		legs = flight.getElementsByTagName("Leg");
		legcount = legs.getLength(); //should always be 2
		long sumDuration = 0;
		for ( j=0; j < legcount; j++) {
			sumDuration = sumDuration + Long.parseLong( (String) ((Element) legs.item(j)).getAttribute("Duration") );
		}

		// finally set the attribute
		flight.setAttribute("DurationSort", Long.toString(sumDuration));
		
	  }      
    
	} catch (Exception e) {

	  Logger.error("XMLHelper.setAttributeDurations Error: " + e.toString());

	}  		
		
	//Logger.error("XMLHelper.setAttributeDurations - Replaced=" + String.valueOf(replacements), false);
	return replacements;  

}


public static String getElementTextValue(Element el) {
	String result = "";
	int i;
	
		// -- Is one of these child nodes a text node?
		NodeList children = el.getChildNodes();

		for (i = 0; i < children.getLength(); i++) {
		   Node child = children.item(i);
			if (child instanceof Text) {
			 // -- Retrieve contents of child text node
			  result = child.getNodeValue();
			break;
			}
		} // -- for i
     	
	return(result);
} 


public static String setElementTextValue(Element el, String new_value) {
	String result = "";
	int i;
	
		// -- Is one of these child nodes a text node?
		NodeList children = el.getChildNodes();

		for (i = 0; i < children.getLength(); i++) {
		   Node child = children.item(i);
			if (child instanceof Text) {
			 // -- set contents of child text node
			  child.setNodeValue(new_value);
			break;
			}
		} // -- for i
     	
	return(result);
} 

public static String getDescendentTextValue(Element elParent, String targetName) {
	// use this when you don't want to search through the whole doc with XPath
	// the param element is the starting node
	// the target name is the element name for which we want the value 
	// we only get the first value encountered if there is more than one descendent node named targetName
	
	String result = "";
	int i;
	
	if (elParent != null) {
		
		NodeList descendents = elParent.getElementsByTagName(targetName);
		if (descendents.getLength() > 0) {
			Element el = (Element) descendents.item(0);
			// -- Is one of these child nodes a text node?
			NodeList children = el.getChildNodes();
			int count = children.getLength();
			for (i = 0; i < count; i++) {
			  Node child = children.item(i);
			  if (child instanceof Text) {
				 // -- Retrieve contents of child text node
				  result = child.getNodeValue();
				break;
			  }	
			} // -- for i
		}
	}
	       	
	return(result);
} 

public Element importNode(Element el, boolean deep) {
//used (from outside this class) to copy a node from another doc to this one
//targetNode.appendChild(airlineHelper.importNode(el, true));

	return(	(Element) doc.importNode(el, deep) );
}

public boolean setRadioSelected (String xpath, String testValue) {
//intended to mark "selected" the HTML form field input radio containing the value=testValue
//returns true if the value was set

	boolean result = false;
	int i;
		try {
			if (testValue != null) {
				NodeList options = processXPath(xpath);
				int optioncount = options.getLength();
				for (i=0; i<optioncount ; i++) {
					Element el = (Element) options.item(i);	
					String attrib = (String)el.getAttribute("value");
					if ( (attrib != null) && (attrib.equals(testValue)) ) {
						el.setAttribute("checked", "Y");
						result = true;
						break;
					} //if				
				 } //for i
			} // if
		} catch (Exception e) {
			Logger.error("XMLHelper setRadioSelected - Non-critical error setting '" + testValue + "' in node '" + xpath + ":" + e.toString());
		}
		
	return(result);				
}

public boolean createSequentialAttribute (String xpath, String attributeName) {

	return(createSequentialAttribute(xpath, attributeName, 0) );				
}

public boolean createSequentialAttribute (String xpath, String attributeName, int start_index) {
//intended to mark each node with a NodeId attribute
//returns true if the value was set

	boolean result = false;
	int i;
		try {
			NodeList options = processXPath(xpath);
			int optioncount = options.getLength();
			for (i=0; i<optioncount ; i++) {
				Element el = (Element) options.item(i);	
					el.setAttribute(attributeName, Integer.toString(i + start_index));
					result = true;
			 } //for i
		} catch (Exception e) {
			Logger.error("XMLHelper createNodeIDAttributes - Non-critical error setting '" + attributeName + "' in node '" + xpath + ":" + e.toString());
		}
		
	return(result);				
}

/**
	 * Author: Hemanth Kumar Guntupalli
	 * Method to get the part of the XML document in the form of String
	 * @param xPath
	 * @return
	 */
	public String getXMLofXPath(String xPath) {
		String result = null;
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Source source = new DOMSource(this.getElementNode(xPath));
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Result transResult = new StreamResult( out );
			transformer.transform( source, transResult );
			result = out.toString();
		}
		catch(Exception e) {
		}
		return result;
	}
	
//	This method is for the Goolge Analytics to get the options values
	 public Vector getOptions(String xPath){
		
		 Vector options = new Vector();
		 Element el = null;
		 NodeList nodes = null;
		 String opt,price,qty = "1";
		 Vector ids =  new Vector();
		 Vector prices = new Vector();
		 Vector qtys = new Vector();
		
		 try{	
			 nodes = processXPath(xPath);
			 if (nodes != null) {
				 int nodescount = nodes.getLength();
				 for (int i = 0; i< nodescount; i ++) {
					 el = (Element) nodes.item(i);
					 price = el.getAttribute("Price");
					 opt = XMLHelper.getElementTextValue(el);
					 ids.addElement(opt);
					 prices.addElement(price);
					 qtys.addElement(qty);
				 }
				 options.addElement(ids);
				 options.addElement(prices);
				 options.addElement(qtys);
			 }
			
			 for(int i = 0; i < ids.size();i++){
				 for (int j = i+1; j < ids.size(); j++) {
					 if(ids.elementAt(i).equals(ids.elementAt(j))){
						 ids.setElementAt("", j);
						 String s = (String)qtys.elementAt(i);
						 int ss = Integer.parseInt(s);
						 ss++;;
						 s = Integer.toString(ss);
						 qtys.setElementAt(s, i);
					 }
				 }
			 }
		 }
		 catch(Exception e){
		 }
		
	 return options;
}

//method to convert Document to String
//Method added by Nagesh for CQ6651
public String getStringFromDocument(Document doc)
{
	try
	{
	   DOMSource domSource = new DOMSource(doc);
	   StringWriter writer = new StringWriter();
	   StreamResult result = new StreamResult(writer);
	   TransformerFactory tf = TransformerFactory.newInstance();
	   Transformer transformer = tf.newTransformer();
	   transformer.transform(domSource, result);
	   return writer.toString();
	}
	catch(Exception ex)
	{
	   ex.printStackTrace();
	   return null;
	}
}


} //class
