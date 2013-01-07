package de.dm.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.dm.main.ParserModule;
import de.dm.util.NodeCreatorUtil;
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
import de.sidafe.util.impl.LogEntryNode;

public class KnotenEinhaengenTest {

	private KnotenEinhaenger knotenEinhaenger;
	private NodeCreatorUtil testNodeCreator;
	private Injector injector = Guice.createInjector(new ParserModule());

	@Before
	public void setUp() throws Exception {
		knotenEinhaenger = injector.getInstance(KnotenEinhaenger.class);
		testNodeCreator = injector.getInstance(NodeCreatorUtil.class);
	}

	@Test
	public void testAddKnotenBATCH() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		assertEquals(BATCH.class, batch.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		assertEquals(BTEST.class, btest.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		assertEquals(BLOCK.class, block0.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ajum = block0.getSubNodes().get(0);
		assertEquals(AJUM.class, block0_ajum.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ajum = block0.getSubNodes().get(0);
		ILogEntryNode block0_ajum_lim2 = block0_ajum.getSubNodes().get(0);
		assertEquals(LIM2.class, block0_ajum_lim2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode btest_pf = btest.getSubNodes().get(1);
		assertEquals(PF.class, btest_pf.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block1 = btest.getSubNodes().get(2);
		assertEquals(BLOCK.class, block1.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block1 = btest.getSubNodes().get(2);
		ILogEntryNode block1_ajum = block1.getSubNodes().get(0);
		assertEquals(AJUM.class, block1_ajum.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block1 = btest.getSubNodes().get(2);
		ILogEntryNode block1_ajum = block1.getSubNodes().get(0);
		ILogEntryNode block1_ajum_lim2 = block1_ajum.getSubNodes().get(0);
		assertEquals(LIM2.class, block1_ajum_lim2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2_BLOCK() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block1
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block2
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block2 = btest.getSubNodes().get(3);
		assertEquals(BLOCK.class, block2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2_BLOCK_AJUM() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block1
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block2
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block2 = btest.getSubNodes().get(3);
		ILogEntryNode block2_ajum = block2.getSubNodes().get(0);
		assertEquals(AJUM.class, block2_ajum.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2_BLOCK_AJUM_LIM2() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block1
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block2
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block2 = btest.getSubNodes().get(3);
		ILogEntryNode block2_ajum = block2.getSubNodes().get(0);
		ILogEntryNode block2_ajum_lim2 = block2_ajum.getSubNodes().get(0);
		assertEquals(LIM2.class, block2_ajum_lim2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2_BLOCK_AJUM_LIM2_BLOCK() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block1
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block2
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block3
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block3 = btest.getSubNodes().get(4);
		assertEquals(BLOCK.class, block3.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AJUM_LIM2_PF_BLOCK_AJUM_LIM2_BLOCK_AJUM_LIM2_BLOCK_AJUM() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodePF());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block1
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block2
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block3
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAJUM());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block3 = btest.getSubNodes().get(4);
		ILogEntryNode block3_ajum = block3.getSubNodes().get(0);
		ILogEntryNode block3_ajum_lim2 = block3_ajum.getSubNodes().get(0);
		assertEquals(LIM2.class, block3_ajum_lim2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AMEA() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAMEA());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_amea = block0.getSubNodes().get(0);
		assertEquals(AMEA.class, block0_amea.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AMEA_LIM2_AMEA_LIM2() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAMEA());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAMEA());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM2());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_amea2 = block0.getSubNodes().get(1);
		ILogEntryNode block0_amea2_lim2 = block0_amea2.getSubNodes().get(0);
		assertEquals(LIM2.class, block0_amea2_lim2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_TS() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTS());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode ts = btest.getSubNodes().get(1);
		assertEquals(TS.class, ts.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ACAP() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeACAP());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_acap = block0.getSubNodes().get(0);
		assertEquals(ACAP.class, block0_acap.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ACAP_LIM3() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeACAP());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM3());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_acap = block0.getSubNodes().get(0);
		ILogEntryNode block0_acap_lim3 = block0_acap.getSubNodes().get(0);
		assertEquals(LIM3.class, block0_acap_lim3.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ADIO() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeADIO());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_adio = block0.getSubNodes().get(0);
		assertEquals(ADIO.class, block0_adio.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ARES() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ares = block0.getSubNodes().get(0);
		assertEquals(ARES.class, block0_ares.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ARES_ARES() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ares0 = block0.getSubNodes().get(0);
		assertEquals(ARES.class, block0_ares0.getLogEntry().getClass());
		ILogEntryNode block0_ares1 = block0.getSubNodes().get(1);
		assertEquals(ARES.class, block0_ares1.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ARES_ARES_AMEA() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAMEA());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ares0 = block0.getSubNodes().get(0);
		assertEquals(ARES.class, block0_ares0.getLogEntry().getClass());
		ILogEntryNode block0_ares1 = block0.getSubNodes().get(1);
		assertEquals(ARES.class, block0_ares1.getLogEntry().getClass());
		ILogEntryNode block0_amea = block0.getSubNodes().get(2);
		assertEquals(AMEA.class, block0_amea.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_ARES_LIM3() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeARES());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeLIM3());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_ares = block0.getSubNodes().get(0);
		ILogEntryNode block0_ares_lim3 = block0_ares.getSubNodes().get(0);
		assertEquals(LIM3.class, block0_ares_lim3.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_TJET() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_tjet = block0.getSubNodes().get(0);
		assertEquals(TJET.class, block0_tjet.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_TJET_TJET() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_tjet2 = block0.getSubNodes().get(1);
		assertEquals(TJET.class, block0_tjet2.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_TJET_TJET_TJET() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeTJET());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_tjet3 = block0.getSubNodes().get(2);
		assertEquals(TJET.class, block0_tjet3.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AIND() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAIND());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_aind = block0.getSubNodes().get(0);
		assertEquals(AIND.class, block0_aind.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AZEN() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAZEN());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_azen = block0.getSubNodes().get(0);
		assertEquals(AZEN.class, block0_azen.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_BLOCK_AFUS() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBLOCK()); // Block0
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeAFUS());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode block0 = btest.getSubNodes().get(0);
		ILogEntryNode block0_afus = block0.getSubNodes().get(0);
		assertEquals(AFUS.class, block0_afus.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_MCL() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeMCL());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode mcl = btest.getSubNodes().get(0);
		assertEquals(MCL.class, mcl.getLogEntry().getClass());
	}

	@Test
	public void testAddKnotenBATCH_BTEST_DT() {
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBATCH());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeBTEST());
		knotenEinhaenger.addKnoten(testNodeCreator.createNodeDT());
		knotenEinhaenger.flush();
		LogEntryNode node = knotenEinhaenger.getRoot();
		ILogEntryNode batch = node;
		ILogEntryNode btest = batch.getSubNodes().get(0);
		ILogEntryNode dt = btest.getSubNodes().get(0);
		assertEquals(DT.class, dt.getLogEntry().getClass());
	}

}
