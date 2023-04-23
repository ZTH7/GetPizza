package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import getpizza.control.Controller;
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
		contentPanel.add(createTitle(
				"<html><a><center>Pedidos</center></a>" + "<HR align=center width=300 color=#153C46 size=1></html>"));
		for (Pedido p : ctrl.getCliente().getHistoria()) {
			contentPanel.add(createHitoriaPanel(p));
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
	
	JPanel createHitoriaPanel(Pedido pedido) {
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(234, 216, 154));
		
		DecimalFormat df = new DecimalFormat("#.##");

		JLabel nombre = new JLabel("<html><p><center> ID: " + pedido.getId() + "</center></p>"
				+ "<p> Precio: <strike>" + Float.toString(pedido.getPrecio()) + "</strike>  "
				+ pedido.getPrecioFinal() + "</p>"
				+ "<p> Precio descontado: " + df.format((pedido.getPrecio() - pedido.getPrecioFinal())) + "</p>"
				+ "<p> Dirección: " + pedido.getDireccion() + "</p>"
				+ "<p> Método de pago: " + (pedido.getConDatafono() ? "Tarjeta de crédito" : "Efectivo") + "</p>"
				+ "</html>");
		nombre.setPreferredSize(new Dimension(140, 100));
		
		prod.add(nombre);
		prod.add(Box.createHorizontalGlue());
		prod.setMaximumSize(new Dimension(408, 100));
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
	public void onCodeUsed(String codigo) {
	}

	@Override
	public void onOrderSended(Pedido pedido) {
		contentPanel.add(createHitoriaPanel(pedido));
		contentPanel.add(Box.createVerticalStrut(10));
		contentPanel.repaint();
	}

}
