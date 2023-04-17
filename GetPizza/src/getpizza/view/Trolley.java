package getpizza.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import getpizza.control.Controller;
import getpizza.control.SACliente;
import getpizza.model.Carrito;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class Trolley extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	Carrito carrito;
	JPanel _panel;

	public Trolley(Controller _ctrl) {
		this.carrito = new Carrito();
		
		InitGUI();
		
		//_ctrl.addClientObserver(this);
	}
	
	void InitGUI() {
		_panel = new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
		_panel.setBackground(new Color(108, 169, 132));

		setViewportView(_panel);
		getVerticalScrollBar().setBackground(new Color(108, 169, 132));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(590, 60, 240, 340);
	}

	void setProducts() {

	}

	public Carrito getCarrito() {
		return this.carrito;
	}
	
	JPanel createProduct(Producto p) {
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(255, 255, 255, 160)); // TODO change a color

		JLabel nombre = new JLabel("<html>"
				+ "<p><center>" + p.getNombre() + "</center></p>"
				+ "</html>");

		JLabel precio = new JLabel("<html>"
				+ "<p><center>" + Float.toString(p.getPrecio()) + "</center></p>"
				+ "</html>");

		JButton remove = new JButton("Eliminar");
		remove.setPreferredSize(new Dimension(50, 20));
		remove.addActionListener(e -> {
			carrito.removeProducto(p);
			repaint();
		});
		
		prod.add(nombre);
		prod.add(Box.createHorizontalStrut(20));
		prod.add(precio);
		prod.add(Box.createHorizontalGlue());
		prod.add(remove);
		prod.setMaximumSize(new Dimension(240, 20));
		prod.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prod;
	}

	@Override
	public void onProductAdded(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProductRemoved(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCodeUsed(Codigo codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onOrderSended(Pedido pedido) {
		// TODO Auto-generated method stub

	}
}
