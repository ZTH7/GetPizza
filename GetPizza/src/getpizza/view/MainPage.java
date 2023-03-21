package getpizza.view;

import java.awt.*;
import javax.swing.*;

public class MainPage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel avatar, buttonsPanel, cardsPanel;
	JButton Oferta, Pizza, Bebida, Postre, Carrito, Profile;

	public MainPage() {
		super(new BorderLayout());
		buttonsPanel = createButtons();
		add(buttonsPanel, BorderLayout.WEST);
		add(ProductPanel(), BorderLayout.CENTER);

		setBounds(0, 0, 800, 480);
		setOpaque(false);
	}

	private JPanel createAvatarImg() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(176, 150));
		panel.setPreferredSize(new Dimension(176, 150));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("Get Pizza");
		title.setForeground(new Color(0xE0FAAB00, true));
		title.setFont(new Font(null, 1, 30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setMaximumSize(new Dimension(176, 50));
		title.setPreferredSize(new Dimension(176, 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(title);

		return panel;
	}

	private JPanel createButtons() {
		JPanel panel = new ButtonPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(176, 480));

		avatar = createAvatarImg();
		panel.add(avatar);

		panel.add(addButton(Oferta, "Oferta"));
		panel.add(addButton(Pizza, "Pizza"));
		panel.add(addButton(Bebida, "Bebida"));
		panel.add(addButton(Postre, "Postre"));
		panel.add(addButton(Carrito, "Carrito"));

		return panel;
	}

	private JPanel ProductPanel() {
		JPanel panel = new JPanel(null);
		panel.setOpaque(false);

		Products ap = new Products();
		ap.setBounds(60, 50, 408, 390);

		panel.add(ap);

		return panel;
	}

	private JButton addButton(JButton button, String name) {
		ImageIcon icon = new ImageIcon("Resource/NormalButton.png");
		ImageIcon icon3 = new ImageIcon("Resource/RolloverButton.png");
		Image scaledImage = icon.getImage().getScaledInstance(176, 50, Image.SCALE_SMOOTH);
		Image scaledImage3 = icon3.getImage().getScaledInstance(176, 50, Image.SCALE_SMOOTH);

		button = new JButton(name, new ImageIcon(scaledImage));

		button.setBorderPainted(false);
		button.setForeground(Color.GREEN);
		button.setContentAreaFilled(false);
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(176, 50));
		button.setPreferredSize(new Dimension(176, 50));
		button.setRolloverIcon(new ImageIcon(scaledImage3));
		button.setSelectedIcon(new ImageIcon(scaledImage3));
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		button.addActionListener((e) -> {
			CardLayout cl = (CardLayout) cardsPanel.getLayout();
			cl.show(cardsPanel, name);
		});
		return button;
	}
}

class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Image img;

	public ButtonPanel() {
		ImageIcon icon = new ImageIcon("Resource/Buttonbkg.jpg");
		img = icon.getImage();
		icon.setImage(img.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
