package uk.ac.aber.dcs.cs221.wordladders;

import uk.ac.aber.dcs.cs221.wordladders.view.*;

public class Manager {
	private Screen screen;
	
	public Manager() {
		screen = new Screen();
		screen.writeMenu();
	}
}
