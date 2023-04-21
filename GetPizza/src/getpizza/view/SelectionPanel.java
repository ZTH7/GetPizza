package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import getpizza.control.Controller;
import getpizza.model.Bebida;
import getpizza.model.Codigo;
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
		
		cartaPizza = _ctrl.getPizzas();
		cartaBebida = _ctrl.getBebidas();
		cartaPostre = _ctrl.getPostres();

		InitGUI();
	}

	void InitGUI() {
		_panel = new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
		_panel.setBackground(new Color(255, 204, 153));

		// Hacer un for de cada producto de cada carta, crear el JPanel con
		// createProduct y añadirlo al _panel
		
		JLabel pizzaTitle = new JLabel("<html><center>Pizzas</center></html>");
		
		_panel.add(pizzaTitle);
		
		for (Pizza p : cartaPizza) {
			_panel.add(createPizza(p));
		}
		
		
		JLabel postreTitle = new JLabel("<html><center>Postres</center></html>");
		
		_panel.add(postreTitle);
		
		for (Postre po : cartaPostre) {
			_panel.add(createPostre(po));
		}
		
		JLabel bebidaTitle = new JLabel("<html><center>Bebidas</center></html>");
		
		_panel.add(bebidaTitle);
		
		for (Bebida b : cartaBebida) {
			_panel.add(createBebida(b));
		}

		setViewportView(_panel);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(40, 60, 520, 390);
	}

	JPanel createPizza(Producto p) {
		JPanel prodtotal = createBebida(p);

		// Opciones de masa

		JPanel radioButtonMasa = new JPanel();
		radioButtonMasa.setLayout(new BoxLayout(radioButtonMasa, BoxLayout.X_AXIS));

		JLabel masa = new JLabel("<html><center>Elegir masa</center></html>");
		masa.setPreferredSize(new Dimension(140, 30));
		masa.setMaximumSize(new Dimension(140, 30));

		ButtonGroup masagroup = new ButtonGroup();
		JRadioButton masa1 = new JRadioButton("Napolitana");
		masa1.setSelected(true);
		masagroup.add(masa1);
		JRadioButton masa2 = new JRadioButton("Americana");
		masagroup.add(masa2);
		JRadioButton masa3 = new JRadioButton("Romana");
		masagroup.add(masa3);

		radioButtonMasa.add(masa);
		radioButtonMasa.add(masa1);
		radioButtonMasa.add(masa2);
		radioButtonMasa.add(masa3);
		radioButtonMasa.add(Box.createHorizontalGlue());

		// Opciones de base

		JPanel radioButtonBase = new JPanel();
		radioButtonBase.setLayout(new BoxLayout(radioButtonBase, BoxLayout.X_AXIS));

		JLabel base = new JLabel("<html><center>Elegir base</center></html>");
		base.setPreferredSize(new Dimension(140, 30));
		base.setMaximumSize(new Dimension(140, 30));

		ButtonGroup basegroup = new ButtonGroup();
		JRadioButton base1 = new JRadioButton("Queso");
		base1.setSelected(true);
		basegroup.add(base1);
		JRadioButton base2 = new JRadioButton("Tomate");
		basegroup.add(base2);
		JRadioButton base3 = new JRadioButton("Queso y tomate");
		basegroup.add(base3);
		JRadioButton base4 = new JRadioButton("Sin base");
		basegroup.add(base4);

		radioButtonBase.add(base);
		radioButtonBase.add(base1);
		radioButtonBase.add(base2);
		radioButtonBase.add(base3);
		radioButtonBase.add(base4);
		radioButtonBase.add(Box.createHorizontalGlue());

		
		prodtotal.add(radioButtonMasa);
		prodtotal.add(radioButtonBase);

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}
	
	JPanel createBebida(Producto p) {
		JPanel prodtotal = createPostre(p);
		
		// Opcion de tamanyo
		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		// Opciones de tamaño

		JPanel radioButtonTam = new JPanel();
		radioButtonTam.setLayout(new BoxLayout(radioButtonTam, BoxLayout.X_AXIS));

		JLabel tam = new JLabel("<html><center>Elegir tamaño</center></html>");
		tam.setPreferredSize(new Dimension(140, 30));
		tam.setMaximumSize(new Dimension(140, 30));

		ButtonGroup tamgroup = new ButtonGroup();
		JRadioButton tam1 = new JRadioButton("Grande");
		tam1.setSelected(true);
		tamgroup.add(tam1);
		JRadioButton tam2 = new JRadioButton("Mediana");
		tamgroup.add(tam2);
		JRadioButton tam3 = new JRadioButton("Pequeña");
		tamgroup.add(tam3);

		radioButtonTam.add(tam);
		radioButtonTam.add(tam1);
		radioButtonTam.add(tam2);
		radioButtonTam.add(tam3);
		radioButtonTam.add(Box.createHorizontalGlue());

		options.add(radioButtonTam);

		prodtotal.add(options);

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}
	
	JPanel createPostre(Producto p) {
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));

		JPanel prod = new JPanel();
		prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
		prod.setBackground(new Color(255, 255, 255, 160)); // TODO change a color

		JLabel nombre = new JLabel("<html><p><center>" + p.getNombre() + "</center></p></html>");

		JLabel precio = new JLabel("<html><p><center>" + Float.toString(p.getPrecio()) + " euros</center></p></html>");

		
		JButton add = new JButton("+");
		
		add.addActionListener((e) -> {
			_ctrl.addProducto(p);
		});
		
		prod.add(nombre);
		prod.add(precio);
		prod.add(add);
		prod.add(Box.createHorizontalGlue());

		prodtotal.add(prod);

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}

	@Override
	public void onProductAdded(Producto p) {
		
	}

	@Override
	public void onProductRemoved(Producto p) {
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
