package getpizza.view;

import java.awt.*;
import javax.swing.*;

import getpizza.model.Producto;

public class Trolley extends JScrollPane {

	private static final long serialVersionUID = 1L;
	
	public Trolley() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255, 255, 255, 160));
		
		setViewportView(panel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setOpaque(false);
	}
	
	public void setButton() {
		
	}
	
	public void setProducts() {
		
	}
	
	public JPanel createProduct(Producto p) {
		//TODO
		return null;
	}
}
