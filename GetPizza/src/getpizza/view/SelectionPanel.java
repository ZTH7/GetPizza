package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class SelectionPanel extends JScrollPane implements Observer {

	Controller _ctrl;
	List<Producto> carta;
	JPanel _panel;
	
	public SelectionPanel(Controller ctrl) {
		_ctrl = ctrl;
		// carta = _ctrl.obtenerCarta()
		InitGUI();
	}
	
	void InitGUI() {
		_panel = new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
		_panel.setBackground(new Color(255, 204, 153));

		setViewportView(_panel);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(40, 60, 520, 390);
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
			carta.remove(p);
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
