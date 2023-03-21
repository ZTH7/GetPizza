package getpizza.launcher;

import javax.swing.*;
import getpizza.view.*;

public class Main {
	public static void main(String[] args) {
		BottomPage bottom = new BottomPage();
		JPanel login = new Login();
		JPanel registry = new Registry();
		JPanel menuPage = new MainPage();
		
		bottom.getContentPane().add(login);
		
		JDialog payConfirm = new PayConfirm(bottom);
		
		bottom.setVisible(true);
	}
}
