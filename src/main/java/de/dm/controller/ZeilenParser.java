package de.dm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZeilenParser {

	private List<String> inputList;

	public void parseZeile(final String aZeile) {
		String zeile = aZeile;
		zeile = zeile.replaceAll("\\{", "|");
		zeile = zeile.replaceAll("\\}", "");
		String[] zeileParsed = zeile.split("\\|", -1);
		inputList = new LinkedList<String>(Arrays.asList(zeileParsed));
		inputList.remove("");
	}

	public boolean hasMoreStringNodes() {
		boolean hasMoreElements = false;
		for (String element : inputList) {
			if (element.contains("@")) {
				hasMoreElements = true;
			}
		}
		return hasMoreElements;
	}

	public List<String> getNextNode() {
		int counter = 0;
		ArrayList<String> stringNodeOutput = new ArrayList<String>();
		for (Iterator<String> it = inputList.iterator(); it.hasNext();) {
			String inputListElement = it.next();
			if (inputListElement.startsWith("@")) {
				counter++;
			}
			if (counter == 1) {
				stringNodeOutput.add(inputListElement);
				it.remove();
			}
		}
		return stringNodeOutput;
	}
}