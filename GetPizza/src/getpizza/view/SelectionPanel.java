package getpizza.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.google.gson.Gson;

import getpizza.control.Controller;
import getpizza.misc.DBHelper;
import getpizza.model.Base;
import getpizza.model.Bebida;
import getpizza.model.Cliente;
import getpizza.model.Ingrediente;
import getpizza.model.Masa;
import getpizza.model.Pizza;
import getpizza.model.PizzaPersonalizada;
import getpizza.model.Postre;
import getpizza.model.Producto;
import getpizza.model.Tamanyo;

public class SelectionPanel extends JScrollPane {

	private static final long serialVersionUID = 1L;

//	Map<String, Integer> bases = Map.of("Sin base", 0, "Queso", 1, "Tomate", 2, "Queso y Tomate", 3);
//	Map<String, Integer> masas = Map.of("Napolitana", 0, "Romana", 1, "Americana", 2);
//	Map<String, Integer> tamanyos = Map.of("Pequeña", 0, "Mediana", 1, "Grande", 2);
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
		
		_panel.add(new JLabel("<html><center>Pizzas</center></html>"));
		for (Pizza p : cartaPizza)
			_panel.add(createPizza(p));

		_panel.add(createPizzaPers());

		_panel.add(new JLabel("<html><center>Postres</center></html>"));
		for (Postre p : cartaPostre)
			_panel.add(createPostre(p));

		_panel.add(new JLabel("<html><center>Bebidas</center></html>"));
		for (Bebida p : cartaBebida)
			_panel.add(createBebida(p));

		setViewportView(_panel);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(40, 60, 520, 390);
	}

	JPanel createPizza(Pizza p) {
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));

		JPanel titulo = createTitulo(p);
		ButtonGroup tamgroup = new ButtonGroup();
		ButtonGroup masagroup = new ButtonGroup();
		ButtonGroup basegroup = new ButtonGroup();
		
		JButton add = new JButton("+");
		add.addActionListener((e) -> {
			p.setTamanyo(Tamanyo.values()[Integer.parseInt(tamgroup.getSelection().getActionCommand())]);
			p.setMasa(Masa.values()[Integer.parseInt(masagroup.getSelection().getActionCommand())]);
			p.setBase(Base.values()[Integer.parseInt(basegroup.getSelection().getActionCommand())]);
			Gson gson = new Gson();
			_ctrl.addProducto(gson.fromJson(gson.toJson(p), Pizza.class));
		});
		titulo.add(add);
		titulo.add(Box.createHorizontalGlue());

		prodtotal.add(titulo);
		prodtotal.add(createTamanyo(tamgroup));
		prodtotal.add(createMasa(masagroup));
		prodtotal.add(createBase(basegroup));

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}

	JPanel createPizzaPers() {
		PizzaPersonalizada pp = new PizzaPersonalizada();
		pp.setNombre("Pizza Personalizada");
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));

		List<Ingrediente> ingredientes = DBHelper.getInstance().getIngrediente();

		JPanel titulo = new JPanel();
		titulo.setLayout(new BoxLayout(titulo, BoxLayout.X_AXIS));
		titulo.setBackground(new Color(255, 255, 255, 160));

		JLabel nombre = new JLabel("<html><p><center>" + pp.getNombre() + "</center></p></html>");
		JLabel precio = new JLabel("<html><p><center>" + Float.toString(pp.getPrecio()) + " euros</center></p></html>");

		titulo.add(nombre);
		titulo.add(precio);
		
		ButtonGroup tamgroup = new ButtonGroup();
		ButtonGroup masagroup = new ButtonGroup();
		ButtonGroup basegroup = new ButtonGroup();

		JButton add = new JButton("+");
		add.addActionListener((e) -> {
			pp.setTamanyo(Tamanyo.values()[Integer.parseInt(tamgroup.getSelection().getActionCommand())]);
			pp.setMasa(Masa.values()[Integer.parseInt(masagroup.getSelection().getActionCommand())]);
			pp.setBase(Base.values()[Integer.parseInt(basegroup.getSelection().getActionCommand())]);
			Gson gson = new Gson();
			_ctrl.addProducto(gson.fromJson(gson.toJson(pp), Bebida.class));
		});
		titulo.add(add);
		titulo.add(Box.createHorizontalGlue());

		prodtotal.add(titulo);
		prodtotal.add(createTamanyo(tamgroup));
		prodtotal.add(createMasa(masagroup));
		prodtotal.add(createBase(basegroup));

		for (Ingrediente i : ingredientes) {
			prodtotal.add(createIngrediente(i, pp, () ->{
				precio.setText("<html><p><center>" + Float.toString(pp.getPrecio()) + " euros</center></p></html>");
			}));
		}

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}

	JPanel createBebida(Bebida p) {
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));

		JPanel titulo = createTitulo(p);		
		ButtonGroup tamgroup = new ButtonGroup();
		
		JButton add = new JButton("+");
		add.addActionListener((e) -> {
			p.setTamanyo(Tamanyo.values()[Integer.parseInt(tamgroup.getSelection().getActionCommand())]);
			Gson gson = new Gson();
			_ctrl.addProducto(gson.fromJson(gson.toJson(p), Bebida.class));
		});
		titulo.add(add);
		titulo.add(Box.createHorizontalGlue());

		prodtotal.add(titulo);
		prodtotal.add(createTamanyo(tamgroup));

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}

	JPanel createPostre(Postre p) {
		JPanel prodtotal = new JPanel();
		prodtotal.setLayout(new BoxLayout(prodtotal, BoxLayout.Y_AXIS));

		JPanel titulo = createTitulo(p);
		JButton add = new JButton("+");
		add.addActionListener((e) -> {
			_ctrl.addProducto(p);
		});
		titulo.add(add);
		titulo.add(Box.createHorizontalGlue());
		
		prodtotal.add(titulo);

		prodtotal.setMaximumSize(new Dimension(500, 130));
		prodtotal.setAlignmentX(Box.CENTER_ALIGNMENT);
		return prodtotal;
	}

	JPanel createIngrediente(Ingrediente ing, PizzaPersonalizada pp, Runnable refresh) {
		JPanel ingrePanel = new JPanel();
		ingrePanel.setLayout(new BoxLayout(ingrePanel, BoxLayout.X_AXIS));

		JLabel Nombre = new JLabel(
				"<html><center>" + ing.getNombre() + "</center></html>");
		Nombre.setPreferredSize(new Dimension(140, 30));
		Nombre.setMaximumSize(new Dimension(140, 30));
		
		JLabel Precio = new JLabel(
				"<html><center>Precio: " + ing.getPrecio() + " euros</center></html>");
		Precio.setPreferredSize(new Dimension(140, 30));
		Precio.setMaximumSize(new Dimension(140, 30));

		JLabel num = new JLabel("0");
		JButton resta = new JButton("-");
		resta.addActionListener(e -> {
			int tmp = Integer.parseInt(num.getText());
			if (tmp > 0) {
				pp.removeIngrediente(ing);
				num.setText(Integer.toString(tmp - 1));
				refresh.run();
			}
		});
		JButton suma = new JButton("+");
		suma.addActionListener(e -> {
			pp.addIngrediente(ing);
			num.setText(Integer.toString(Integer.parseInt(num.getText()) + 1));
			refresh.run();
		});

		ingrePanel.add(Nombre);
		ingrePanel.add(Box.createHorizontalStrut(10));
		ingrePanel.add(Precio);
		ingrePanel.add(Box.createHorizontalStrut(10));
		ingrePanel.add(resta);
		ingrePanel.add(Box.createHorizontalStrut(10));
		ingrePanel.add(num);
		ingrePanel.add(Box.createHorizontalStrut(10));
		ingrePanel.add(suma);
		ingrePanel.add(Box.createHorizontalGlue());

		return ingrePanel;
	}

	JPanel createBase(ButtonGroup basegroup) {
		JPanel radioButtonBase = new JPanel();
		radioButtonBase.setLayout(new BoxLayout(radioButtonBase, BoxLayout.X_AXIS));

		JLabel base = new JLabel("<html><center>Elegir base</center></html>");
		base.setPreferredSize(new Dimension(140, 30));
		base.setMaximumSize(new Dimension(140, 30));

		JRadioButton base1 = new JRadioButton("Sin base");
		base1.setActionCommand("0");
		base1.setSelected(true);
		basegroup.add(base1);
		JRadioButton base2 = new JRadioButton("Queso");
		base1.setActionCommand("1");
		basegroup.add(base2);
		JRadioButton base3 = new JRadioButton("Tomate");
		base1.setActionCommand("2");
		basegroup.add(base3);
		JRadioButton base4 = new JRadioButton("Queso y tomate");
		base1.setActionCommand("3");
		basegroup.add(base4);

		radioButtonBase.add(base);
		radioButtonBase.add(base1);
		radioButtonBase.add(base2);
		radioButtonBase.add(base3);
		radioButtonBase.add(base4);
		radioButtonBase.add(Box.createHorizontalGlue());
		return radioButtonBase;
	}

	JPanel createTamanyo(ButtonGroup tamgroup) {
		JPanel radioButtonTam = new JPanel();
		radioButtonTam.setLayout(new BoxLayout(radioButtonTam, BoxLayout.X_AXIS));

		JLabel tam = new JLabel("<html><center>Elegir tamaño</center></html>");
		tam.setPreferredSize(new Dimension(140, 30));
		tam.setMaximumSize(new Dimension(140, 30));

		JRadioButton tam1 = new JRadioButton("Pequeña");
		tam1.setActionCommand("0");
		tam1.setSelected(true);
		tamgroup.add(tam1);
		JRadioButton tam2 = new JRadioButton("Mediana");
		tam2.setActionCommand("1");
		tamgroup.add(tam2);
		JRadioButton tam3 = new JRadioButton("Grande");
		tam3.setActionCommand("2");
		tamgroup.add(tam3);

		radioButtonTam.add(tam);
		radioButtonTam.add(tam1);
		radioButtonTam.add(tam2);
		radioButtonTam.add(tam3);
		radioButtonTam.add(Box.createHorizontalGlue());
		return radioButtonTam;
	}

	JPanel createMasa(ButtonGroup masagroup) {
		JPanel radioButtonMasa = new JPanel();
		radioButtonMasa.setLayout(new BoxLayout(radioButtonMasa, BoxLayout.X_AXIS));

		JLabel masa = new JLabel("<html><center>Elegir masa</center></html>");
		masa.setPreferredSize(new Dimension(140, 30));
		masa.setMaximumSize(new Dimension(140, 30));

		JRadioButton masa1 = new JRadioButton("Napolitana");
		masa1.setActionCommand("0");
		masa1.setSelected(true);
		masagroup.add(masa1);
		JRadioButton masa2 = new JRadioButton("Romana");
		masa2.setActionCommand("1");
		masagroup.add(masa2);
		JRadioButton masa3 = new JRadioButton("Americana");
		masa3.setActionCommand("2");
		masagroup.add(masa3);

		radioButtonMasa.add(masa);
		radioButtonMasa.add(masa1);
		radioButtonMasa.add(masa2);
		radioButtonMasa.add(masa3);
		radioButtonMasa.add(Box.createHorizontalGlue());
		return radioButtonMasa;
	}

	JPanel createTitulo(Producto p) {
		JPanel titulo = new JPanel();
		titulo.setLayout(new BoxLayout(titulo, BoxLayout.X_AXIS));
		titulo.setBackground(new Color(255, 255, 255, 160));

		JLabel nombre = new JLabel("<html><p><center>" + p.getNombre() + "</center></p></html>");
		JLabel precio = new JLabel("<html><p><center>" + Float.toString(p.getPrecio()) + " euros</center></p></html>");

		titulo.add(nombre);
		titulo.add(precio);

		return titulo;
	}
}
