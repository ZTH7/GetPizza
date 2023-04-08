package getpizza.view;

import java.awt.*;
import javax.swing.*;

public class Products extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;

	public Products(String str) {
		contentPanel = new JPanel(new GridLayout(5, 2));
		contentPanel.setBackground(new Color(255, 255, 255, 160));

		InitGUI();

		switch (str) {
		case "Oferta":
			ofertaIni();
			break;
		case "Pizza":
			pizzaIni();
			break;
		case "Bebida":
			bebidaIni();
			break;
		case "Postre":
			postreIni();
			break;
		}

	}

	void InitGUI() {
		setViewportView(contentPanel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		// setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(60, 50, 408, 390);
		setOpaque(false);
	}

	void ofertaIni() {

	}

	void pizzaIni() {

	}

	void bebidaIni() {

	}

	void postreIni() {

	}

}
