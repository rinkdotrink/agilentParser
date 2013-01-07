package de.dm.main;
import com.google.inject.AbstractModule;

import de.dm.controller.KnotenEinhaenger;
import de.dm.controller.KnotenErzeuger;
import de.dm.controller.LogProcessor;
import de.dm.controller.TestNodeCreator;
import de.dm.controller.ZeilenParser;


public class ParserModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(KnotenErzeuger.class);
		bind(KnotenEinhaenger.class);
		bind(ZeilenParser.class);
		bind(LogProcessor.class);
		bind(TestNodeCreator.class);
	}
}