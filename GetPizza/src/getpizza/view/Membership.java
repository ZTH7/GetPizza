package getpizza.view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;
import getpizza.model.Rango;

public class Membership extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	Controller ctrl;
	JLabel rango, punto;
	
	public Membership(Controller ctrl) {
		this.ctrl = ctrl;
		
		InitGUI();
		ctrl.addClientObserver(this);
	}

	void InitGUI() {
		setLayout(null);
		setBounds(60, 50, 408, 390);
		setBackground(new Color(255, 255, 255, 160));
		//TODO 
//		rango = new JLabel("<html><p><center>Rango: "
//				+ ctrl.getCliente().getMembresia().rango.name()
//				+ "</center></p></html>");
//		punto = new JLabel("<html><p><center>Punto: "
//				+ ctrl.getCliente().getMembresia().puntos
//				+ "</center></p></html>");
		
		rango = new JLabel("<html><p><center>Rango: 0</center></p></html>");
		rango.setForeground(new Color(21, 60, 70));
		rango.setFont(new Font(null, 1, 20));
		rango.setBounds(170, 80, 150, 60);
		add(rango);
		punto = new JLabel("<html><p><center>Punto: 0</center></p></html>");
		punto.setForeground(new Color(21, 60, 70));
		punto.setFont(new Font(null, 1, 20));
		punto.setBounds(170, 140, 150, 60);
		add(punto);
	}
	
	public void setRango(Rango rango) {
		this.rango.setText("Rango: " + rango.name());
        repaint();
    }

    public void setPunto(int punto) {
        this.punto.setText("Punto: " + punto);
        repaint();
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
