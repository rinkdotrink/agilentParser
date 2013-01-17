package de.dm.controller;

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
import de.sidafe.util.ILogEntryNode;

public class KnotenEinhaenger {

	private ILogEntryNode root;
	private ILogEntryNode blockTemp;
	private List<ILogEntryNode> ajumTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> afusTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> aindTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> azenTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> lim2Temps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> ameaTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> acapTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> lim3Temps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> adioTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> aresTemps = new ArrayList<ILogEntryNode>();
	private List<ILogEntryNode> tjetTemps = new ArrayList<ILogEntryNode>();

	public void addKnoten(final ILogEntryNode aKnoten) {
		ILogEntryNode knoten = aKnoten;
		Class<? extends ILogEntry> knotenName = knoten.getLogEntry().getClass();
		if (knotenName.equals(BATCH.class)) {
			root = knoten;
		} else if (knotenName.equals(BTEST.class)) {
			root.getSubNodes().add(knoten);
		} else if (knotenName.equals(BLOCK.class)) {
			saveOrFlushAndSave(knoten);
		} else if (knotenName.equals(AJUM.class)) {
			ajumTemps.add(knoten);
		} else if (knotenName.equals(ARES.class)) {
			aresTemps.add(knoten);
		} else if (knotenName.equals(AMEA.class)) {
			ameaTemps.add(knoten);
		} else if (knotenName.equals(AFUS.class)) {
			afusTemps.add(knoten);
		} else if (knotenName.equals(AIND.class)) {
			aindTemps.add(knoten);
		} else if (knotenName.equals(AZEN.class)) {
			azenTemps.add(knoten);
		} else if (knotenName.equals(ACAP.class)) {
			acapTemps.add(knoten);
		} else if (knotenName.equals(ADIO.class)) {
			adioTemps.add(knoten);
		} else if (knotenName.equals(TJET.class)) {
			tjetTemps.add(knoten);
		} else if (knotenName.equals(LIM2.class)) {
			lim2Temps.add(knoten);
		} else if (knotenName.equals(LIM3.class)) {
			lim3Temps.add(knoten);
		} else if (knotenName.equals(PF.class)) {
			addToBTEST(knoten);
		} else if (knotenName.equals(TS.class)) {
			addToBTEST(knoten);
		} else if (knotenName.equals(MCL.class)) {
			addToBTEST(knoten);
		} else if (knotenName.equals(DT.class)) {
			addToBTEST(knoten);
		}
	}

	public ILogEntryNode getRoot() {
		return root;
	}

	private void saveOrFlushAndSave(final ILogEntryNode aKnoten) {
		if (blockTemp == null) {
			blockTemp = aKnoten;
		} else {
			flush();
			blockTemp = aKnoten;
		}
	}

	private void addToBTEST(final ILogEntryNode aKnoten) {
		flush();
		ILogEntryNode btest = root.getSubNodes().get(0);
		btest.getSubNodes().add(aKnoten);
	}

	public void flush() {
		flushTemps();
		clearTemps();
	}

	private void flushTemps() {
		if (blockTemp != null) {
			flushTemps(ajumTemps, lim2Temps);
			flushTemps(aresTemps, lim3Temps);
			flushTemps(ameaTemps, lim2Temps);
			flushTemps(afusTemps, lim2Temps);
			flushTemps(aindTemps, lim3Temps);
			flushTemps(azenTemps, lim3Temps);
			flushTemps(acapTemps, lim3Temps);
			flushTemps(adioTemps, lim2Temps);
			flushTjetTemps();
			flushBlockTemp();
		}
	}

	private void flushTjetTemps() {
		if (!tjetTemps.isEmpty()) {
			for (ILogEntryNode tjetTemp : tjetTemps) {
				blockTemp.getSubNodes().add(tjetTemp);
			}
		}
	}

	private void flushBlockTemp() {
		if (!root.getSubNodes().isEmpty()) {
			root.getSubNodes().get(0).getSubNodes().add(blockTemp);
		}
	}

	private void flushTemps(final List<ILogEntryNode> aParents,
			final List<ILogEntryNode> aChildren) {
		if (!aParents.isEmpty()) {
			assignChildren2Parents(aParents, aChildren);
		}
	}

	private void clearTemps() {
		blockTemp = null;
		ajumTemps.clear();
		ameaTemps.clear();
		lim2Temps.clear();
		lim3Temps.clear();
		acapTemps.clear();
		adioTemps.clear();
		aresTemps.clear();
		aindTemps.clear();
		azenTemps.clear();
		afusTemps.clear();
		tjetTemps.clear();
	}

	private void assignChildren2Parents(final List<ILogEntryNode> aParents,
			final List<ILogEntryNode> aChildren) {
		List<ILogEntryNode> parents = aParents;
		List<ILogEntryNode> children = aChildren;
		for (int i = 0; i < parents.size(); i++) {
			if (!children.isEmpty()) {
				parents.get(i).getSubNodes().add(children.get(0));
				children.remove(0);
			}
			blockTemp.getSubNodes().add(parents.get(i));
		}
	}
}