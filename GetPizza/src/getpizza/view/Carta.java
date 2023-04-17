package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import getpizza.model.Bebida;
import getpizza.model.Pizza;
import getpizza.model.Postre;
import getpizza.model.Producto;

public class Carta extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;
	List<Pizza> pizza;
	List<Bebida> bebida;
	List<Postre> postre;

	public Carta() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(255, 255, 255, 160));

		InitGUI();
		InitProducts();
		InitProdutPanel();
	}

	void InitGUI() {
		setViewportView(contentPanel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(60, 50, 408, 390);
		setOpaque(false);
	}

	void InitProducts() {
		pizza = new ArrayList<>();
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
//		pizza.add(new Producto("Barbacoa_Gourmet-2603", "Barbacoa Gourmet", "test, test, test", 10));
		bebida = new ArrayList<>();
		postre = new ArrayList<>();
	}

	void InitProdutPanel() {
		contentPanel.add(createTitle("<html>" + "<a><center>Pizza</center></a>"
				+ "<HR align=center width=300 color=#153C46 size=1>" + "</html>"));
		for (Producto p : pizza) {
			contentPanel.add(createProductPanel(p));
			contentPanel.add(Box.createVerticalStrut(10));
		}

		contentPanel.add(createTitle("<html>" + "<a><center>Postre</center></a>"
				+ "<HR align=center width=300 color=#153C46 size=1>" + "</html>"));
		for (Producto p : postre) {
			contentPanel.add(createProductPanel(p));
			contentPanel.add(Box.createVerticalStrut(10));
		}

		contentPanel.add(createTitle("<html>" + "<a><center>Bebida</center></a>"
				+ "<HR align=center width=300 color=#153C46 size=1>" + "</html>"));
		for (Producto p : bebida) {
			contentPanel.add(createProductPanel(p));
			contentPanel.add(Box.createVerticalStrut(10));
		}
	}

	JLabel createTitle(String name) {
		JLabel title = new JLabel(name);
		title.setForeground(new Color(21, 60, 70));
		title.setFont(new Font(null, 1, 20));
		title.setAlignmentX(Box.CENTER_ALIGNMENT);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		return title;
	}

	JPanel createProductPanel(Producto producto) {
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(255, 255, 255, 160)); // TODO change a color

		JLabel nombre = new JLabel("<html>" + "<p><center>" + producto.getNombre() + "</center></p>"
				+ "<p><center>Precio: " + Float.toString(producto.getPrecio()) + "</center></p>" + "</html>");

		JLabel desc = new JLabel(producto.getDesc());

		JLabel ImgLabel = new JLabel();
		ImgLabel.setPreferredSize(new Dimension(80, 80));
		ImgLabel.setMaximumSize(new Dimension(80, 80));
		ImgLabel.setLocation(0, 0);

		ImageIcon Icon = new ImageIcon("Resource/" + producto.getId() + ".jpg");
		ImgLabel.setIcon(Icon);

		prod.add(nombre);
		prod.add(desc);
		prod.add(Box.createHorizontalStrut(40));
		prod.add(Box.createHorizontalGlue());
		prod.add(ImgLabel);
		prod.setMaximumSize(new Dimension(408, 80));
		prod.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prod;
	}

}
