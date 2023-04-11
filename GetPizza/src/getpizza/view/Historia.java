package getpizza.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import getpizza.control.Controller;

public class Historia extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;

	public Historia(Controller _ctrl) {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(255, 255, 255, 160));

		InitGUI();
	}

	void InitGUI() {
		setViewportView(contentPanel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(60, 50, 408, 390);
		setOpaque(false);
	}

}
