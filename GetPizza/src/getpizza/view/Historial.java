package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class Historial extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	JPanel contentPanel;
	Controller ctrl;
	
	public Historial(Controller ctrl) {
		this.ctrl = ctrl;
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(255, 255, 255, 160));

		InitGUI();
		InitHistoriaPanel();
		repaint();
		
		ctrl.addClientObserver(this);
	}

	void InitGUI() {
		setViewportView(contentPanel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(60, 50, 408, 390);
		setOpaque(false);
	}
	
	void InitHistoriaPanel() {
		for (Pedido p : ctrl.getCliente().getHistoria()) {
			contentPanel.add(createHitoriaPanel(p));
			contentPanel.add(Box.createVerticalStrut(10));
		}
	}
	
	JPanel createHitoriaPanel(Pedido pedido) {
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(234, 216, 154));

		JLabel nombre = new JLabel("<html><p><center>" + pedido.getId() + "</center></p>" + "<p><center>Precio: <strike>"
				+ Float.toString(pedido.getPrecio()) + "</strike>  " + pedido.getPrecioFinal() + "</center></p>"
				+ "<p>" + pedido.getDireccion() + "</p>"
				+ "</html>");
		nombre.setPreferredSize(new Dimension(140, 80));
		
		prod.add(nombre);
		prod.add(Box.createHorizontalGlue());
		prod.setMaximumSize(new Dimension(408, 80));
		prod.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prod;
	}

	@Override
	public void onProductAdded(Producto p) {
	}

	@Override
	public void onProductRemoved( Producto p) {
	}

	@Override
	public void onCodeUsed(Codigo codigo) {
	}

	@Override
	public void onOrderSended(Pedido pedido) {
		contentPanel.add(createHitoriaPanel(pedido));
		contentPanel.add(Box.createVerticalStrut(10));
		contentPanel.repaint();
	}

}
