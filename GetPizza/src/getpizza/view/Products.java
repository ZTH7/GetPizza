package getpizza.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class Products extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;

	public Products(String str) {
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
