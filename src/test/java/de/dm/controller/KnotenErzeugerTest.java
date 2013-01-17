package de.dm.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.dm.main.ParserModule;
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
import de.sidafe.util.ILogEntryNode;

public class KnotenErzeugerTest {

	private NodeCreatorUtil testNodeCreator;
	private Injector injector = Guice.createInjector(new ParserModule());

	@Before
	public void setUp() throws Exception {
		testNodeCreator = injector.getInstance(NodeCreatorUtil.class);
	}

	@Test
	public void testErzeugeKnotenBATCH() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeBATCH();
		assertEquals(BATCH.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenBTEST() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeBTEST();
		assertEquals(BTEST.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenBLOCK() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeBLOCK();
		assertEquals(BLOCK.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenAJUM() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeAJUM();
		assertEquals(AJUM.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenLIM2() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeLIM2();
		assertEquals(LIM2.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenPF() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodePF();
		assertEquals(PF.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenAMEA() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeAMEA();
		assertEquals(AMEA.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenARES() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeARES();
		assertEquals(ARES.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenACAP() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeACAP();
		assertEquals(ACAP.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenADIO() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeADIO();
		assertEquals(ADIO.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenAFUS() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeAFUS();
		assertEquals(AFUS.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenAIND() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeAIND();
		assertEquals(AIND.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenAZEN() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeAZEN();
		assertEquals(AZEN.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenLIM3() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeLIM3();
		assertEquals(LIM3.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenMCL() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeMCL();
		assertEquals(MCL.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenTJET() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeTJET();
		assertEquals(TJET.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testErzeugeKnotenTS() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeTS();
		assertEquals(TS.class, logEntryNode.getLogEntry().getClass());
	}

	@Test
	public void testKnotenErzeugenDT() {
		ILogEntryNode logEntryNode = testNodeCreator.createNodeDT();
		assertEquals(DT.class, logEntryNode.getLogEntry().getClass());
	}

}