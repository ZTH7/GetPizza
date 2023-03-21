package getpizza.view;

import java.awt.*;
import javax.swing.*;

public class Products extends JScrollPane {

	private static final long serialVersionUID = 1L;
	
	public Products() {
		JPanel panel = new JPanel(new GridLayout(10, 2));
		panel.setBackground(new Color(255, 255, 255, 160));
		
		setViewportView(panel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		//setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setOpaque(false);
	}
}
