package getpizza.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BottomPage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int x, y;

	public BottomPage() {
		super("Get Pizza");

		setBounds(300, 250, 704, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);

		setBackground();
		setBackground(new Color(255,255,255,0));
		setCloseButton();

		setupMouse();
	}

	void setupMouse() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - x, p.y + e.getY() - y);
			}
		});
	}

	void setBackground() {
		ImageIcon icon = new ImageIcon("Resource/background.jpg");
		icon.setImage(
				icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));

		setContentPane(new JPanel(null) {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		});
	}

	void setCloseButton() {
		JLabel closeText = new JLabel();
		closeText.setBounds(this.getWidth() - 44, 0, 44, 33);
		closeText.setBackground(new Color(255, 255, 255, 30));
		closeText.setOpaque(true);

		JButton close = new JButton("X");
		close.setForeground(new Color(255, 255, 255, 178));
		close.setBounds(this.getWidth() - 44, 0, 44, 33);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.addActionListener(e -> {
			dispose();
		});

		getContentPane().add(close);
		getContentPane().add(closeText);
	}
}
