package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	
	JRadioButton p, m, g, n, a, r, q, t, qt, sb;
	String tam[] = { "Pequeño", "Mediano", "Grande" };
	String masa[] = { "Napolitana", "Americana", "Romana" };
	String base[] = { "Queso", "Tomate", "Queso y tomate", "Sin base" };
	
	
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
				+ "<p><center>" + Float.toString(p.getPrecio()) + " euros" + "</center></p>"
				+ "</html>");
		
		JButton add = new JButton("+");
		
		// TODO: add.addActionListener()
		
		prod.add(nombre);
		prod.add(precio);
		prod.add(add);
		
		
		// Opciones de masa, base y tamanyo
		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		
		// Opciones de masa
		
		n = new JRadioButton(this.masa[0]);
		a = new JRadioButton(this.masa[1]);
		r = new JRadioButton(this.masa[2]);
		
		
		
		ButtonGroup selectmasa = new ButtonGroup();
		selectmasa.add(n);
		selectmasa.add(a);
		selectmasa.add(r);
		
		JPanel selectMasa = new JPanel();
		selectMasa.setLayout(new BoxLayout(selectMasa, BoxLayout.X_AXIS));
		
		JLabel masa = new JLabel("<html>"
				+ "<p><center>Elegir masa</center></p>"
				+ "</html>");
		
		selectMasa.add(masa);
		selectMasa.add(n);
		selectMasa.add(a);
		selectMasa.add(r);
		
		// Opciones de tam
		
		this.g = new JRadioButton(this.tam[0]);
		this.m = new JRadioButton(tam[1]);
		this.p = new JRadioButton(tam[2]);
		
		ButtonGroup tamanyo = new ButtonGroup();
		tamanyo.add(g);
		tamanyo.add(this.m);
		tamanyo.add(this.p);
		
		JPanel selectTam = new JPanel();
		selectTam.setLayout(new BoxLayout(selectTam, BoxLayout.X_AXIS));
		
		JLabel elegirtam = new JLabel("<html>"
				+ "<p><center>Elegir tamaño</center></p>"
				+ "</html>");
		
		selectTam.add(elegirtam);
		selectTam.add(g);
		selectTam.add(m);
		selectTam.add(this.p);
		
		// Opciones de base
		
		this.q = new JRadioButton(this.base[0]);
		this.t = new JRadioButton(base[1]);
		this.qt = new JRadioButton(base[2]);
		this.sb = new JRadioButton(base[3]);
		
		ButtonGroup base = new ButtonGroup();
		base.add(q);
		base.add(this.t);
		base.add(this.qt);
		base.add(this.sb);
		
		JPanel selectBase = new JPanel();
		selectBase.setLayout(new BoxLayout(selectBase, BoxLayout.X_AXIS));
		
		JLabel elegirbase = new JLabel("<html>"
				+ "<p><center>Elegir base</center></p>"
				+ "</html>");
		
		selectBase.add(elegirbase);
		selectBase.add(q);
		selectBase.add(t);
		selectBase.add(qt);
		selectBase.add(sb);

		
		options.add(selectTam);
		options.add(selectMasa);
		options.add(selectBase);
		
		
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
