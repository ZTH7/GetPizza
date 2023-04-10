package getpizza.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class UserInfo extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;

	public UserInfo() {
		contentPanel = new JPanel(new GridLayout(5, 2));
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
