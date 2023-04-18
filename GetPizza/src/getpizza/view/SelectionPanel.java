package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import getpizza.control.Controller;
import getpizza.model.Bebida;
import getpizza.model.Codigo;
import getpizza.model.Masa;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Pizza;
import getpizza.model.Postre;
import getpizza.model.Producto;

public class SelectionPanel extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	List<Pizza> cartaPizza;
	List<Bebida> cartaBebida;
	List<Postre> cartaPostre;
	JPanel _panel;
	
	public SelectionPanel(Controller ctrl) {
		_ctrl = ctrl;
		
		InitGUI();
	}
	
	void InitGUI() {
		_panel = new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
		_panel.setBackground(new Color(255, 204, 153));
		
		// carta = _ctrl.obtenerCarta()
		
		// Hacer un for de cada producto de cada carta, crear el JPanel con createProduct y añadirlo al _panel
		
		_panel.add(createProduct(new Pizza()));

		setViewportView(_panel);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(40, 60, 520, 390);
	}
	
	JPanel createProduct(Producto p) {
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));
		
		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(255, 255, 255, 160)); // TODO change a color

		JLabel nombre = new JLabel("<html>"
				+ "<p><center>" + p.getNombre() + "</center></p>"
				+ "</html>");

		JLabel precio = new JLabel("<html>"
				+ "<p><center>" + Float.toString(p.getPrecio()) + "</center></p>"
				+ "</html>");
		
		prod.add(nombre);
		prod.add(Box.createHorizontalStrut(20));
		prod.add(precio);
		prod.add(Box.createHorizontalGlue());
		
		// Opciones de masa, base y tamanyo
		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		
		// Opciones de masa
		
		JPanel checkBoxMasa = new JPanel();
		checkBoxMasa.setLayout(new BoxLayout(checkBoxMasa, BoxLayout.X_AXIS));
		
		JLabel masa = new JLabel("<html>"
				+ "<p><center>Elegir masa</center></p>"
				+ "</html>");
		
		JCheckBox masa1 = new JCheckBox("Napolitana");
		JCheckBox masa2 = new JCheckBox("Americana");
		JCheckBox masa3 = new JCheckBox("Romana");
		
		checkBoxMasa.add(masa);
		checkBoxMasa.add(masa1);
		checkBoxMasa.add(masa2);
		checkBoxMasa.add(masa3);
		
		// Opciones de base

		JPanel checkBoxBase = new JPanel();
		checkBoxBase.setLayout(new BoxLayout(checkBoxBase, BoxLayout.X_AXIS));
		
		JLabel base = new JLabel("<html>"
				+ "<p><center>Elegir base</center></p>"
				+ "</html>");
		
		JCheckBox base1 = new JCheckBox("Queso");
		JCheckBox base2 = new JCheckBox("Tomate");
		JCheckBox base3 = new JCheckBox("Queso y tomate");
		JCheckBox base4 = new JCheckBox("Queso y tomate");
		
		
		checkBoxBase.add(base);
		checkBoxBase.add(base1);
		checkBoxBase.add(base2);
		checkBoxBase.add(base3);
		
		// Opciones de tamaño

		JPanel checkBoxtam = new JPanel();
		checkBoxtam.setLayout(new BoxLayout(checkBoxtam, BoxLayout.X_AXIS));
		
		JLabel tam = new JLabel("<html>"
				+ "<p><center>Elegir tamaño</center></p>"
				+ "</html>");
		
		JCheckBox tam1 = new JCheckBox("Napolitana");
		JCheckBox tam2 = new JCheckBox("Americana");
		JCheckBox tam3 = new JCheckBox("Romana");
		
		checkBoxtam.add(tam);
		checkBoxtam.add(tam1);
		checkBoxtam.add(tam2);
		checkBoxtam.add(tam3);

		
		options.add(checkBoxtam);
		options.add(checkBoxMasa);
		options.add(checkBoxBase);
		
		
		prodtotal.add(prod);
		prodtotal.add(options);
		
		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
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
