package getpizza.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;

import javax.swing.*;
import getpizza.control.SACliente;
import getpizza.model.Codigo;
import getpizza.model.Menu;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class PayConfirm extends JDialog implements Observer {

	private static final long serialVersionUID = 1L;

	int x, y;
	Pedido pedido;
	Menu carrito;
	JFrame _parent;
	JButton confirm;
	SACliente sacliente;
	ButtonGroup group;
	JPanel _panel, contentPanel;
	JRadioButton efectivo, tarjeta;
	JTextField codigoDescuento, direccion;
	JLabel preTotal, prefinal, descuentoTips;
	float precioTotal, precioFinal, numDescuento;

	public PayConfirm(JFrame parent, SACliente sacliente, Menu carrito) {
		super(parent);
		this._parent = parent;
		this.sacliente = sacliente;
		this.carrito = carrito;

		InitGUI();

		// sacliente.addObserver(this);
	}

	void InitGUI() {
		setContentPanel();
		setButton();
		setupMouse();
		setTitle();
		setResizable(false);
		setUndecorated(true);
		setCentralPanel();

		setPayMethod();
		setPrecioTotal();
		setDescuentoOption();
		setCodigoDescuento();
		setDescuentoTips();
		setPrecioFinal();
		setDireccion();

		setBounds(300, 200, 340, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void setPrecioTotal() {
		precioTotal = carrito.getPrecioTotal();
		JLabel preTotal = new JLabel("Precio Total: " + precioTotal);
		preTotal.setForeground(new Color(0, 0, 0));
		preTotal.setBounds(10, 10, 180, 20);
		contentPanel.add(preTotal);
	}

	void setDescuentoOption() {
		JLabel text = new JLabel("¿Desea aplicar descuento?");
		text.setForeground(new Color(0, 0, 0));
		text.setBounds(10, 40, 180, 20);
		contentPanel.add(text);

		JComboBox<String> descuentoOption = new JComboBox<>();
		descuentoOption.setBounds(10, 70, 180, 20);
		descuentoOption.addItem("Sin descuento");
		descuentoOption.addItem("Descuento por día");
		descuentoOption.addItem("Descuento por membresía");
		descuentoOption.addItem("Descuento por puntos");
		descuentoOption.addItem("Descuento por código");
		// TODO
		descuentoOption.addActionListener(e -> {
			switch(descuentoOption.getSelectedIndex()) {
			case 0:
				numDescuento = 0;
			case 1:
				if(LocalDate.now().getDayOfWeek().getValue() == 5)
					numDescuento = 5;
				else
					numDescuento = 0;
				precioFinal = precioTotal - numDescuento;
				descuentoTips.setText("Se ha aplicado un descuento del " + numDescuento);
				prefinal.setText("Precio Final: " + precioFinal);
			case 2:
				// TODO
			case 3:
				// TODO
			}
		});

		contentPanel.add(descuentoOption);
	}

	void setCodigoDescuento() {
		JLabel text = new JLabel("Cógido descuento: ");
		text.setForeground(new Color(0, 0, 0));
		text.setBounds(10, 100, 120, 20);
		contentPanel.add(text);

		codigoDescuento = new JTextField(8);
		codigoDescuento.setBounds(130, 100, 120, 20);
		codigoDescuento.setBackground(new Color(255, 255, 255, 220));
		contentPanel.add(codigoDescuento);
	}

	void setDescuentoTips() {
		numDescuento = 0;
		descuentoTips = new JLabel("Se ha aplicado un descuento del " + numDescuento);
		descuentoTips.setForeground(new Color(0, 0, 0));
		descuentoTips.setBounds(10, 130, 230, 20);
		contentPanel.add(descuentoTips);
	}

	void setPrecioFinal() {
		precioFinal = carrito.getPrecioTotal();
		prefinal = new JLabel("Precio Final: " + precioFinal);
		prefinal.setForeground(new Color(0, 0, 0));
		prefinal.setBounds(10, 160, 180, 20);
		contentPanel.add(prefinal);
	}

	void setDireccion() {
		JLabel text = new JLabel("Dirección:");
		text.setForeground(new Color(0, 0, 0));
		text.setBounds(10, 190, 230, 20);
		contentPanel.add(text);

		direccion = new JTextField(8);
		direccion.setBounds(10, 220, 230, 20);
		direccion.setBackground(new Color(255, 255, 255, 220));
		// textField.setText(_ctrl.getCliente().getDireccion());
		contentPanel.add(direccion);
	}

	void setPayMethod() {
		JLabel text = new JLabel("¿Como desea pagar?");
		text.setForeground(new Color(0, 0, 0));
		text.setBounds(10, 250, 180, 20);
		contentPanel.add(text);

		group = new ButtonGroup();
		tarjeta = new JRadioButton("Con tarjeta");
		tarjeta.setBounds(20, 275, 180, 30);
		tarjeta.setOpaque(false);
		tarjeta.setSelected(true);
		group.add(tarjeta);
		contentPanel.add(tarjeta);

		efectivo = new JRadioButton("Efectivo");
		efectivo.setBounds(20, 295, 180, 30);
		efectivo.setOpaque(false);
		group.add(efectivo);
		contentPanel.add(efectivo);
	}

	void setTitle() {
		JLabel title = new JLabel("Bill");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(100, 10, 140, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		_panel.add(title);
	}

	void setButton() {
		confirm = new JButton("Confirm");
		confirm.addActionListener(e -> {
			pedido = new Pedido();
			pedido.setDireccion(direccion.getText());
			pedido.setPrecio(precioTotal);
			pedido.setPrecioFinal(precioFinal);
			pedido.setConDatafono(rootPaneCheckingEnabled);
			pedido.setConDatafono(tarjeta.isSelected());
			sacliente.sendOrder(pedido);
		});
		confirm.setForeground(new Color(21, 60, 70));
		confirm.setBounds(60, 410, 100, 30);
		confirm.setBackground(new Color(250, 192, 61));

		_panel.add(confirm);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> this.dispose());
		cancel.setForeground(new Color(21, 60, 70));
		cancel.setBounds(180, 410, 100, 30);
		cancel.setBackground(new Color(134, 144, 138));

		_panel.add(cancel);
	}

	void setCentralPanel() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(255, 204, 153));
		contentPanel.setBounds(40, 50, 260, 340);
		contentPanel.setVisible(true);

		_panel.add(contentPanel);
	}

	void setupMouse() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - x, p.y + e.getY() - y);
			}
		});
	}

	void setContentPanel() {
		_panel = new JPanel();
		_panel.setLayout(null);
		_panel.setBackground(new Color(248, 247, 240));
		this.setContentPane(_panel);
	}

	@Override
	public void onProductAdded(Producto p) {
		// TODO Auto-generated method stub

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
