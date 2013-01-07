package de.dm.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.sidafe.logEntries.ACAP;
import de.sidafe.logEntries.ADIO;
import de.sidafe.logEntries.AFUS;
import de.sidafe.logEntries.AIND;
import de.sidafe.logEntries.AJUM;
import de.sidafe.logEntries.AMEA;
import de.sidafe.logEntries.ARES;
import de.sidafe.logEntries.AZEN;
import de.sidafe.logEntries.BATCH;
import de.sidafe.logEntries.BLOCK;
import de.sidafe.logEntries.BTEST;
import de.sidafe.logEntries.DT;
import de.sidafe.logEntries.LIM2;
import de.sidafe.logEntries.LIM3;
import de.sidafe.logEntries.MCL;
import de.sidafe.logEntries.PF;
import de.sidafe.logEntries.TJET;
import de.sidafe.logEntries.TS;
import de.sidafe.util.ILogEntry;
import de.sidafe.util.impl.LogEntryNode;

public class KnotenErzeuger {
	private final String BATCH = "@BATCH";
	private final String BTEST = "@BTEST";
	private final String BLOCK = "@BLOCK";
	private final String AJUM = "@A-JUM";
	private final String LIM2 = "@LIM2";
	private final String PF = "@PF";
	private final String AMEA = "@A-MEA";
	private final String ARES = "@A-RES";
	private final String ACAP = "@A-CAP";
	private final String ADIO = "@A-DIO";
	private final String AFUS = "@A-FUS";
	private final String AIND = "@A-IND";
	private final String AZEN = "@A-ZEN";
	private final String LIM3 = "@LIM3";
	private final String MCL = "@M-CL";
	private final String TJET = "@TJET";
	private final String TS = "@TS";
	private final String DT = "@D-T";
	private ILogEntry logEntry;
	private LogEntryNode logEntryNode;

	public LogEntryNode erzeugeKnoten(final List<String> aStringNode) {
		boolean nodeSupported = true;
		List<String> stringNode = aStringNode;
		if (stringNode.get(0).equalsIgnoreCase(BATCH)) {
			logEntry = new BATCH();
			stringNode = anpassenStringNodeBATCH(stringNode);
		} else if (stringNode.get(0).equalsIgnoreCase(BTEST)) {
			logEntry = new BTEST();
			stringNode = anpassenStringNodeBTEST(stringNode);
		} else if (stringNode.get(0).equalsIgnoreCase(BLOCK)) {
			logEntry = new BLOCK();
		} else if (stringNode.get(0).equalsIgnoreCase(AJUM)) {
			logEntry = new AJUM();
		} else if (stringNode.get(0).equalsIgnoreCase(LIM2)) {
			logEntry = new LIM2();
		} else if (stringNode.get(0).equalsIgnoreCase(PF)) {
			logEntry = new PF();
		} else if (stringNode.get(0).equalsIgnoreCase(AMEA)) {
			logEntry = new AMEA();
		} else if (stringNode.get(0).equalsIgnoreCase(ARES)) {
			logEntry = new ARES();
		} else if (stringNode.get(0).equalsIgnoreCase(ACAP)) {
			logEntry = new ACAP();
		} else if (stringNode.get(0).equalsIgnoreCase(ADIO)) {
			logEntry = new ADIO();
		} else if (stringNode.get(0).equalsIgnoreCase(AFUS)) {
			logEntry = new AFUS();
		} else if (stringNode.get(0).equalsIgnoreCase(AIND)) {
			logEntry = new AIND();
		} else if (stringNode.get(0).equalsIgnoreCase(AZEN)) {
			logEntry = new AZEN();
		} else if (stringNode.get(0).equalsIgnoreCase(LIM3)) {
			logEntry = new LIM3();
		} else if (stringNode.get(0).equalsIgnoreCase(MCL)) {
			logEntry = new MCL();
		} else if (stringNode.get(0).equalsIgnoreCase(TJET)) {
			logEntry = new TJET();
		} else if (stringNode.get(0).equalsIgnoreCase(TS)) {
			logEntry = new TS();
		} else if (stringNode.get(0).equalsIgnoreCase(DT)) {
			logEntry = new DT();
		} else {
			nodeSupported = false;
			logUnsupportedNode(stringNode.get(0));
		}
		if (nodeSupported) {
			logEntryNode = createLogEntryNode(stringNode);
		}
		return logEntryNode;
	}

	private void logUnsupportedNode(final String aNodeName) {
		try {
			FileWriter writer = new FileWriter(
					new File("UnsupportedNodes.txt"), true);
			writer.write(aNodeName);
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String> anpassenStringNodeBATCH(final List<String> aStringNode) {
		List<String> stringNode = aStringNode;
		if (stringNode.size() == 14) {
			stringNode.add(""); // tatsaechliche Agilentlogdaten != Format.pdf
		}
		return stringNode;
	}

	private List<String> anpassenStringNodeBTEST(final List<String> aStringNode) {
		List<String> stringNode = aStringNode;
		if (stringNode.size() == 13) {
			stringNode.add(""); // tatsaechliche Agilentlogdaten != Format.pdf
		}
		return stringNode;
	}

	private LogEntryNode createLogEntryNode(final List<String> aStringNode) {
		List<String> stringNode = aStringNode;
		stringNode = removeNodeName(stringNode);
		logEntry.setLogEntryValues(new ArrayList<String>(stringNode));
		logEntryNode = new LogEntryNode();
		logEntryNode.setLogEntry(logEntry);
		return logEntryNode;
	}

	private List<String> removeNodeName(final List<String> aStringNode) {
		List<String> stringNode = aStringNode;
		stringNode.remove(0);
		return stringNode;
	}
}
