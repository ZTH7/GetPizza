package getpizza.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import getpizza.model.Carrito;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class Trolley extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	Carrito carrito;
	JPanel _panel;

	public Trolley() {
		InitGUI();
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

	public void setProducts() {

	}

	public JPanel createProduct(Producto p) {
		// TODO
		return null;
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
