package de.dm.main;
import com.google.inject.Guice;
import com.google.inject.Injector;

import de.dm.controller.LogProcessor;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ParserModule());		
		LogProcessor logProcessor = injector.getInstance(LogProcessor.class);
		logProcessor.getBaum("Logdata.txt");
	}
}
