package de.dm.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.dm.main.ParserModule;

public class ZeilenParserTest {

	private ZeilenParser zeilenParser;
	private Injector injector = Guice.createInjector(new ParserModule());

	@Before
	public void beforeTest() {
		zeilenParser = injector.getInstance(ZeilenParser.class);
	}

	@Test
	public void testHasMoreStringNodesTrue() {
		String inpu = "{@BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||";
		zeilenParser.parseZeile(inpu);
		assertTrue(zeilenParser.hasMoreStringNodes());
	}

	@Test
	public void testHasMoreStringNodesFalse() {
		String inpu = "{@BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||";
		zeilenParser.parseZeile(inpu);
		zeilenParser.getNextNode();
		assertFalse(zeilenParser.hasMoreStringNodes());
	}

	@Test
	public void testHasMoreStringNodesEmpty() {
		String inpu = "";
		zeilenParser.parseZeile(inpu);
		assertFalse(zeilenParser.hasMoreStringNodes());
	}

	@Test
	public void testGetNextNode() {
		String inpu = "{@BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||";
		ArrayList<String> inp = new ArrayList<String>();
		inp.add("@BATCH");
		inp.add("501-6338-02");
		inp.add("50");
		inp.add("12");
		inp.add("1");
		inp.add("");
		inp.add("btest");
		inp.add("040107103921");
		inp.add("");
		inp.add("solmb3t1");
		inp.add("501-6338-02");
		inp.add("RevA");
		inp.add("");
		inp.add("");
		inp.add("");
		zeilenParser.parseZeile(inpu);
		assertTrue(zeilenParser.getNextNode().equals(inp));
	}

	@Test
	public void testGetNextFirst() {
		String inpu = "{@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}";
		ArrayList<String> stringNode = new ArrayList<String>();
		stringNode.add("@A-JUM");
		stringNode.add("0");
		stringNode.add("+7.630803E+06");
		zeilenParser.parseZeile(inpu);
		assertTrue(zeilenParser.getNextNode().equals(stringNode));
	}

	@Test
	public void testGetNextSecond() {
		String inpu = "{@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}";
		zeilenParser.parseZeile(inpu);
		zeilenParser.getNextNode();
		ArrayList<String> stringNode = new ArrayList<String>();
		stringNode.add("@LIM2");
		stringNode.add("+9.999999E+99");
		stringNode.add("+1.000000E+04");
		assertTrue(zeilenParser.getNextNode().equals(stringNode));
	}

	@Test
	public void testGetNextBracket() {
		String zeile = "{";
		zeilenParser.parseZeile(zeile);
		ArrayList<String> stringNode = new ArrayList<String>();
		assertTrue(zeilenParser.getNextNode().equals(stringNode));
	}

	@Test
	public void testGetNextBracket2() {
		String zeile = "}}";
		zeilenParser.parseZeile(zeile);
		ArrayList<String> stringNode = new ArrayList<String>();
		List<String> output = zeilenParser.getNextNode();
		assertTrue(output.equals(stringNode));
	}
}
