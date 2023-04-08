package getpizza.launcher;

import getpizza.control.Controller;

public class Main {
	public static void main(String[] args) {
		Controller ctrl = new Controller();

		try {
			ctrl.run();
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
}
