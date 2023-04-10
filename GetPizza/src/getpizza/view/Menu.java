package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import getpizza.model.Producto;

public class Menu extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;
	List<Producto> pizza, bebida, postre;

	public Menu() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		// contentPanel = new JPanel(new GridLayout(5, 2));

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
		bebida = new ArrayList<>();
		postre = new ArrayList<>();
	}

	void InitProdutPanel() {
		contentPanel.add(createTitle("Pizza"));
		for (Producto p : pizza) {
			contentPanel.add(createProduct(p));
			add(Box.createHorizontalStrut(10));
		}

		contentPanel.add(createTitle("Postre"));
		for (Producto p : postre) {
			contentPanel.add(createProduct(p));
			add(Box.createHorizontalStrut(10));
		}

		contentPanel.add(createTitle("Bebida"));
		for (Producto p : bebida) {
			contentPanel.add(createProduct(p));
			add(Box.createHorizontalStrut(10));
		}
	}

	JLabel createTitle(String name) {
		JLabel title = new JLabel(name); // TODO format title

		return title;
	}

	JPanel createProduct(Producto producto) {
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(255, 255, 255, 160)); // TODO change a color

		JLabel nombre = new JLabel(producto.getNombre()); // TODO format nombre

		JLabel ImgLabel = new JLabel();
		ImgLabel.setPreferredSize(new Dimension(20, 80)); // TODO change dimension and location
		ImgLabel.setLocation(0, 0);

		ImageIcon Icon = new ImageIcon("Resource/" + producto.getNombre() + ".jpg");
		ImgLabel.setIcon(Icon);


		prod.add(nombre);
		prod.add(Box.createHorizontalGlue());
		prod.add(ImgLabel);

		return prod;
	}

}
