package getpizza.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class PayConfirm extends JDialog implements Observer {

	private static final long serialVersionUID = 1L;

	int x, y;
	float precioTotal, precioFinal;
	JFrame _parent;
	JPanel _panel, contentPanel;
	JButton confirm;
	JLabel preTotal, prefinal;
	JTextField codigoDescuento, direccion;
	ActionListener confirmListener;
	ButtonGroup group;
	JRadioButton efectivo, tarjeta;
	Controller _ctrl;

	public PayConfirm(JFrame parent, Controller ctrl) {
		super(parent);
		this._parent = parent;
		this._ctrl = ctrl;

		InitGUI();

		//ctrl.addClientObserver(this);
	}

	void InitGUI() {
		setContentPanel();
		setButton();
		setupMouse();
		setTitle();
		_panel.setBackground(new Color(248, 247, 240));
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
		JLabel text = new JLabel("Precio Total: " + precioTotal);
		text.setForeground(new Color(0, 0, 0));
		text.setBounds(10, 10, 180, 20);
		contentPanel.add(text);
	}

	void setDescuentoOption() {
		preTotal = new JLabel("¿Desea aplicar descuento?");
		preTotal.setForeground(new Color(0, 0, 0));
		preTotal.setBounds(10, 40, 180, 20);
		contentPanel.add(preTotal);
		
		JComboBox<String> descuentoOption = new JComboBox<>();
		descuentoOption.setBounds(10, 70, 180, 20);
        descuentoOption.addItem("Sin descuento");
        descuentoOption.addItem("Descuento por día");
        descuentoOption.addItem("Descuento por membresía");
        descuentoOption.addItem("Descuento por puntos");
        descuentoOption.addItem("Descuento por código");
        //TODO
        descuentoOption.addActionListener(e -> {
        	
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
		//textField.setText(_ctrl.getCliente().getDireccion());
		contentPanel.add(codigoDescuento);
	}

	void setDescuentoTips() {
		prefinal = new JLabel("Se ha aplicado un descuento del " + precioFinal);
		prefinal.setForeground(new Color(0, 0, 0));
		prefinal.setBounds(10, 130, 230, 20);
		contentPanel.add(prefinal);
	}

	void setPrecioFinal() {
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
		//textField.setText(_ctrl.getCliente().getDireccion());
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
		confirm.addActionListener(confirmListener);
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
		this.setContentPane(_panel);
	}

	public void setConfirmListener(ActionListener al) {
		confirm.addActionListener(al);
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

	public static void main(String[] arg) {
		new PayConfirm(null, null);
	}
	
}
