package de.dm.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.inject.Inject;

import de.sidafe.util.ILogEntryNode;

public class LogProcessor {

	private KnotenErzeuger knotenErzeuger;
	private KnotenEinhaenger knotenEinhaenger;
	private ZeilenParser zeilenParser;

	@Inject
	public LogProcessor(KnotenErzeuger aKnotenErzeuger,
			KnotenEinhaenger aKnotenEinhaenger, ZeilenParser aZeilenParser) {
		knotenErzeuger = aKnotenErzeuger;
		knotenEinhaenger = aKnotenEinhaenger;
		zeilenParser = aZeilenParser;
	}

	public ILogEntryNode getBaum(final String aFileName) {
		erstelleBaum(aFileName);
		return knotenEinhaenger.getRoot();
	}

	private void erstelleBaum(final String aFileName) {
		BufferedReader in = null;
		String zeile = "";
		try {
			in = new BufferedReader(new FileReader(aFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while ((zeile = in.readLine()) != null) {
				zeilenParser.parseZeile(zeile);
				while (zeilenParser.hasMoreStringNodes()) {
					ILogEntryNode knoten = knotenErzeuger
							.erzeugeKnoten(zeilenParser.getNextNode());
					if (knoten != null) {
						knotenEinhaenger.addKnoten(knoten);
					}
				}
			}
			knotenEinhaenger.flush();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}