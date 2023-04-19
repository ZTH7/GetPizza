package getpizza.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class TrolleyPanel extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	List<Producto> productos;
	JPanel _panel;

	public TrolleyPanel(Controller ctrl) {
		
		productos = new ArrayList<>();
		_ctrl = ctrl;
		InitGUI();
		
		_ctrl.addClientObserver(this);
	}
	
	void InitGUI() {
		_panel = new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
		_panel.setBackground(new Color(255, 204, 153));
		
		for (Producto p : productos) {
			_panel.add(createProduct(p));
		}

		setViewportView(_panel);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(590, 60, 240, 340);
	}

	void setProducts() {

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

		JButton remove = new JButton("-");
		remove.setPreferredSize(new Dimension(50, 20));
		remove.addActionListener(e -> {
			_ctrl.removeProducto(p);
		});
		
		prod.add(nombre);
		prod.add(Box.createHorizontalStrut(20));
		prod.add(precio);
		prod.add(Box.createHorizontalGlue());
		prod.add(remove);
		prod.setMaximumSize(new Dimension(240, 40));
		prod.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prod;
	}

	@Override
	public void onProductAdded(Producto p) {
		productos.add(p);
		InitGUI();
	}

	@Override
	public void onProductRemoved(Producto p) {
		productos.remove(p);
		InitGUI();
	}

	@Override
	public void onCodeUsed(Codigo codigo) {
	}

	@Override
	public void onOrderSended(Pedido pedido) {
	}

	@Override
	public void onMenuOptionChanged(boolean personalizado) {
		// TODO Auto-generated method stub
		
	}
}
