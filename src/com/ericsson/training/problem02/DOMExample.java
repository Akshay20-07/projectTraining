package com.ericsson.training.problem02;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ericsson.training.common.ConstantFile;


public class DOMExample {

	static Logger logger=Logger.getLogger(DOMExample.class.getName());
	public static FileHandler fileHandle;


	public static void main(String[] args) {
		DOMExample xmlFile = new DOMExample();
		xmlFile.xmlWrite();
		xmlFile.xmlRead(ConstantFile.INPUT_FILEPATH);
		xmlFile.xmlMerge();
		try {
		fileHandle = new FileHandler(ConstantFile.XML_LOG_FILE);
		fileHandle.setLevel(Level.FINE);
		logger.addHandler(fileHandle);
		fileHandle.setFormatter(new SimpleFormatter());
		logger.setUseParentHandlers(true); 
		}
		catch( SecurityException|IOException e ) {
			logger.warning(e.getMessage());
		}

	}


	public void xmlRead(String fileName) {
		File inputFile = new File(fileName);
		DocumentBuilderFactory documentBuilderfactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderfactory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputFile);
			document.getDocumentElement().normalize();
			String rootNode = document.getDocumentElement().getNodeName();
			logger.info(ConstantFile.ROOT_ELEMENT + rootNode);
			//System.out.println("Root Element:" + rootNode);
			NodeList nList = document.getFirstChild().getChildNodes();
			for (int index = 0; index < nList.getLength(); index++) {
				Node nNode = nList.item(index);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					//System.out.println(nNode.getNodeName());
					Element showElement = (Element) nNode;
					logger.info(showElement.getAttributes().item(1) + ConstantFile.AND + showElement.getAttributes().item(0));
					//System.out.println(showElement.getAttributes().item(1) + ConstantFile.AND+ showElement.getAttributes().item(0));
					logger.info("title:" + showElement.getFirstChild().getNextSibling().getTextContent());
					//System.out.println("title:" + showElement.getFirstChild().getNextSibling().getTextContent());
					logger.info("author:" + showElement.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent());
					//System.out.println("author:" + showElement.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent());
					logger.info("year:" + showElement.getLastChild().getPreviousSibling().getPreviousSibling().getPreviousSibling().getTextContent());
					//System.out.println("year:" + showElement.getLastChild().getPreviousSibling().getPreviousSibling().getPreviousSibling().getTextContent());
					logger.info("price:" + showElement.getLastChild().getPreviousSibling().getTextContent());
					//System.out.println("price:" + showElement.getLastChild().getPreviousSibling().getTextContent());
					}
			}
		} catch (IOException | SAXException | IllegalArgumentException | ParserConfigurationException e) {
			logger.warning(e.getMessage());
		}
		logger.info("xmlRead compiled");
	}

	public void xmlMerge() {
		try {
			DocumentBuilderFactory documentBuildereactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuildereactory.newDocumentBuilder();
			Document document1 = documentBuilder.parse(new File(ConstantFile.CHECK_FILE));
			Document document2 = documentBuilder.parse(new File(ConstantFile.MERGE_FILE));

			NodeList nList = document1.getFirstChild().getChildNodes();
			//System.out.println(nList.getLength());
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element showElement = (Element) nNode;
						String price = showElement.getLastChild().getPreviousSibling().getTextContent();
						if ((price.equals(ConstantFile.PRICE_VALUE)) == true) {
							logger.info(showElement.getTextContent());
							System.out.println(showElement.getTextContent());
							Node copy = document2.importNode(showElement, true);
							document2.getDocumentElement().appendChild(copy);

						}
					}
			}

			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new DOMSource(document2);
			StreamResult result = new StreamResult(new File(ConstantFile.RESULT_FILE));
			transformer.transform(source, result);
			logger.fine("XML got Merged");
		} catch (IOException | SAXException | IllegalArgumentException | ParserConfigurationException
				| TransformerException e) {
			logger.warning(e.getMessage());			
		}
	
	}

	/**
	 * xmlWrite() method is used for creating a xml file named as wrote.xml having
	 * elements such as book,title,author,year,price.
	 * 
	 * @return null
	 * @throws Exception
	 * @see DocumentBuilderFactory,DocumentBuilder,TransformFactory,Tranformer,DOMSource,StreamResult
	 */
	public  void xmlWrite() {
		DocumentBuilderFactory documentBuildFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuildFactory.newDocumentBuilder();
			//TODO
			//FIXME:
			
			// root Element
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement(ConstantFile.LIBRARY);
			document.appendChild(rootElement);

			// book Element
			Element firstChild = document.createElement(ConstantFile.BOOK);
			rootElement.appendChild(firstChild);

			// set attribute
			Attr attribute = document.createAttribute(ConstantFile.CATEGORY);
			attribute.setValue(ConstantFile.NEWS);
			firstChild.setAttributeNode(attribute);
			// other method to set attribute
			firstChild.setAttribute(ConstantFile.VOLUME,ConstantFile.VOLUME_NO);

			// title
			Element firstSubChild = document.createElement(ConstantFile.TITLE);
			firstSubChild.appendChild(document.createTextNode(ConstantFile.TODAY));
			firstChild.appendChild(firstSubChild);
			// author
			Element secondSubChild = document.createElement(ConstantFile.AUTHOR);
			secondSubChild.appendChild(document.createTextNode(ConstantFile.ROWLING));
			firstChild.appendChild(secondSubChild);
			// year
			Element thirdSubChild = document.createElement(ConstantFile.YEAR);
			thirdSubChild.appendChild(document.createTextNode(ConstantFile.YEAR_2K18));
			firstChild.appendChild(thirdSubChild);
			// price
			Element fourSubChild = document.createElement(ConstantFile.PRICE);
			fourSubChild.appendChild(document.createTextNode(ConstantFile.VALUE_45));
			firstChild.appendChild(fourSubChild);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(ConstantFile.OUTPUT_FILEPATH).getPath());

			//StreamResult consoleResult = new StreamResult(System.out);
			//transformer.transform(source, consoleResult)
			;
			transformer.transform(source, result);
			logger.info("XMLFile Written");
			//System.out.println("File saved!");

		} catch (IllegalArgumentException | ParserConfigurationException | TransformerException e) {
			logger.warning(e.getMessage());
		}
	}
}