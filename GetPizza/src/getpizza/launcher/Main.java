package getpizza.launcher;

import javax.swing.*;
import getpizza.view.*;

public class Main {
	public static void main(String[] args) {
		BottomPage bottom = new BottomPage();
		JPanel menuPage = new MainPage();
		
		bottom.getContentPane().add(menuPage);
		
		JDialog payConfirm = new PayConfirm(bottom);
		
		bottom.setVisible(true);
	}
}
