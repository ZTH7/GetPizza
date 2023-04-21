package getpizza.view;

import java.awt.Color;
import java.awt.Font;
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
		
		rango = new JLabel();
		rango.setForeground(new Color(21, 60, 70));
		rango.setFont(new Font(null, 1, 18));
		rango.setBounds(120, 80, 200, 60);
		rango.setOpaque(false);
		add(rango);
		punto = new JLabel();
		punto.setForeground(new Color(21, 60, 70));
		punto.setFont(new Font(null, 1, 18));
		punto.setBounds(120, 120, 200, 60);
		punto.setOpaque(false);
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
    
	public void setData() {
		rango.setText("<html><p><center>Rango: "
				+ ctrl.getCliente().getMembresia().rango.name()
				+ "</center></p></html>");
		punto.setText("<html><p><center>Punto: "
				+ ctrl.getCliente().getMembresia().puntos
				+ "</center></p></html>");
    }

	@Override
	public void onProductAdded(Producto p) {
	}

	@Override
	public void onProductRemoved(Producto p) {
	}

	@Override
	public void onCodeUsed(Codigo codigo) {
	}

	@Override
	public void onOrderSended(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

}
