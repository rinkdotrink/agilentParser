package de.dm.controller;

import java.util.ArrayList;

import com.google.inject.Inject;

import de.sidafe.util.impl.LogEntryNode;

public class TestNodeCreator {
	
	private KnotenErzeuger knotenErzeuger;
	
	@Inject
	public TestNodeCreator(KnotenErzeuger aKnotenErzeuger) {
		this.knotenErzeuger = aKnotenErzeuger;
	}
	
	public LogEntryNode createNodeBATCH() {
		// @BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||
		ArrayList<String> batchValues = new ArrayList<String>();
		batchValues.add("@BATCH");
		batchValues.add("501-6338-02");
		batchValues.add("50");
		batchValues.add("12");
		batchValues.add("1");
		batchValues.add("");
		batchValues.add("btest");
		batchValues.add("040107103921");
		batchValues.add("");
		batchValues.add("solmb3t1");
		batchValues.add("501-6338-02");
		batchValues.add("RevA");
		batchValues.add("");
		batchValues.add("");
		batchValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(batchValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeBTEST() {
		// @BTEST|5016338409302|00|040107105353|000350|0|all||n|n|040107105943||1
		ArrayList<String> btestValues = new ArrayList<String>();
		btestValues.add("@BTEST");
		btestValues.add("5016338409302");
		btestValues.add("00");
		btestValues.add("040107105353");
		btestValues.add("000350");
		btestValues.add("0");
		btestValues.add("all");
		btestValues.add("");
		btestValues.add("n");
		btestValues.add("n");
		btestValues.add("040107105943");
		btestValues.add("");
		btestValues.add("1");
		btestValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(btestValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeBLOCK() {
		ArrayList<String> block1Values = new ArrayList<String>();
		block1Values.add("@BLOCK");
		block1Values.add("polarity_check");
		block1Values.add("00");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(block1Values);
		return logEntryNode;
	}

	public LogEntryNode createNodeAJUM() {
		// @A-JUM|0|+3.478301E+00{@LIM2|+8.000000E+00|+0.000000E+00}}
		ArrayList<String> ajum1Values = new ArrayList<String>();
		ajum1Values.add("@A-JUM");
		ajum1Values.add("0");
		ajum1Values.add("+3.478301E+00");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(ajum1Values);
		return logEntryNode;
	}

	public LogEntryNode createNodeLIM2() {
		// @A-JUM|0|+3.478301E+00{@LIM2|+8.000000E+00|+0.000000E+00}}
		ArrayList<String> lim2_1Values = new ArrayList<String>();
		lim2_1Values.add("@LIM2");
		lim2_1Values.add("+8.000000E+00");
		lim2_1Values.add("+0.000000E+00");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(lim2_1Values);
		return logEntryNode;
	}

	public LogEntryNode createNodePF() {
		// @PF|pins|0|0
		ArrayList<String> pf1Values = new ArrayList<String>();
		pf1Values.add("@PF");
		pf1Values.add("pins");
		pf1Values.add("0");
		pf1Values.add("0");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(pf1Values);
		return logEntryNode;
	}

	public LogEntryNode createNodeAMEA() {
		// @A-MEA|0|+1.201013E+01|in{@LIM2|+1.320000E+01|+1.090910E+01}}
		ArrayList<String> amea1Values = new ArrayList<String>();
		amea1Values.add("@A-MEA");
		amea1Values.add("0");
		amea1Values.add("+1.201013E+01");
		amea1Values.add("in");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(amea1Values);
		return logEntryNode;
	}

	public LogEntryNode createNodeTS() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@TS");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeACAP() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-CAP");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeLIM3() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@LIM3");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeADIO() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-DIO");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeARES() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-RES");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeTJET() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@TJET");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeAIND() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-IND");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}

	public LogEntryNode createNodeAZEN() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-ZEN");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger
				.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}
	
	public LogEntryNode createNodeAFUS(){
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@A-FUS");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}
	
	public LogEntryNode createNodeMCL() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@M-CL");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(logEntryValues);
		return logEntryNode;
	}
	
	public LogEntryNode createNodeDT() {
		ArrayList<String> logEntryValues = new ArrayList<String>();
		logEntryValues.add("@D-T");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		logEntryValues.add("");
		LogEntryNode logEntryNode = knotenErzeuger.erzeugeKnoten(logEntryValues);
		return logEntryNode;		
	}
}
