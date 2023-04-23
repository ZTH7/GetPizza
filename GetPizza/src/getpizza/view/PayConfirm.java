package getpizza.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.UUID;

import javax.swing.*;

import getpizza.control.Controller;
import getpizza.misc.DBHelper;
import getpizza.misc.Utils;
import getpizza.model.Descuento;
import getpizza.model.DescuentoPorCodigo;
import getpizza.model.DescuentoPorDia;
import getpizza.model.DescuentoPorMembresia;
import getpizza.model.DescuentoPorPuntos;
import getpizza.model.Menu;
import getpizza.model.Pedido;

public class PayConfirm extends JDialog {

	private static final long serialVersionUID = 1L;

	int x, y;
	Pedido pedido;
	Menu carrito;
	JFrame _parent;
	JButton confirm, aplicarDescuento;
	Controller _ctrl;
	ButtonGroup group;
	JPanel _panel, contentPanel;
	JRadioButton efectivo, tarjeta;
	JTextField codigoDescuento, direccion;
	JLabel preTotal, prefinal, descuentoTips, descuentoArea;
	float precioTotal, precioFinal;
	Descuento descuento = new Descuento();

	public PayConfirm(JFrame parent, Controller _ctrl, Menu carrito) {
		super(parent);
		this._parent = parent;
		this._ctrl = _ctrl;
		this.carrito = carrito;

		InitGUI();
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
			switch (descuentoOption.getSelectedIndex()) {
			case 0:
				descuento = new Descuento();
				break;
			case 1:
				descuento = new DescuentoPorDia();
				break;
			case 2:
				descuento = new DescuentoPorMembresia(_ctrl.getRangoCliente());
				break;
			case 3:
				descuento = new DescuentoPorPuntos();
				break;
			case 4:
				descuento = new DescuentoPorCodigo();
				break;
			}
			setDescuentoArea();
		});

		contentPanel.add(descuentoOption);
	}

	void setDescuentoTips() {
		descuentoTips = new JLabel("Se ha aplicado un descuento del 0.0%");
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
		direccion.setText(_ctrl.getCliente().getDireccion());
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
			pedido.setId(UUID.randomUUID().toString());
			pedido.setDireccion(direccion.getText());
			pedido.setPrecio(precioTotal);
			pedido.setPrecioFinal(precioFinal);
			pedido.setConDatafono(rootPaneCheckingEnabled);
			pedido.setConDatafono(tarjeta.isSelected());
			_ctrl.sendOrder(pedido, descuento);
			this.dispose();
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

	void updateTipsPanel() {
		descuento.aplicarDescuento(precioTotal);
		precioFinal = (float) Math.round((precioTotal - descuento.getPrecioDescontado()) * 100) / 100f;
		if(precioFinal < 0) {
			precioFinal = 0;
			
		}
		descuentoTips.setText("Se ha aplicado un descuento del " + descuento.getPorcentaje() * 100 + "%");
		prefinal.setText("Precio Final: " + precioFinal);
	}

	void setDescuentoArea() {
		if (descuentoArea == null && codigoDescuento == null) {
			descuentoArea = new JLabel();
			descuentoArea.setForeground(new Color(0, 0, 0));
			descuentoArea.setBounds(10, 100, 60, 20);
			contentPanel.add(descuentoArea);

			codigoDescuento = new JTextField(8);
			codigoDescuento.setBounds(70, 100, 90, 20);
			codigoDescuento.setBackground(new Color(255, 255, 255, 220));
			contentPanel.add(codigoDescuento);

			aplicarDescuento = new JButton("<html><center>Aplicar</center></html>");
			aplicarDescuento.setForeground(new Color(21, 60, 70));
			aplicarDescuento.setBounds(170, 100, 80, 20);
			aplicarDescuento.setBackground(new Color(250, 192, 61));
			contentPanel.add(aplicarDescuento);
		}

		if (descuento.getClass() == DescuentoPorCodigo.class) {
			for (ActionListener al : aplicarDescuento.getActionListeners())
				aplicarDescuento.removeActionListener(al);
			aplicarDescuento.addActionListener(e -> {
				boolean ok = true;
				String code = codigoDescuento.getText();
				for (String str : _ctrl.getCliente().getCodigosUsados()) {
					if (code.equals(str)) {
						ok = false;
						break;
					}
				}
				if (ok) {
					for (DescuentoPorCodigo codigo : DBHelper.getInstance().getCodigo()) {
						if (code.equals(codigo.getCodigo())) {
							descuento = codigo;
							ok = false;
							break;
						}
					}
					if (!ok)
						updateTipsPanel();
					else
						Utils.showErrorMsg("El Codigo no existe.");
				} else
					Utils.showErrorMsg("El Codigo ya está utilizado.");
			});
			descuentoArea.setText("Cógido: ");
			codigoDescuento.setVisible(true);
			descuentoArea.setVisible(true);
			aplicarDescuento.setVisible(true);
		} else if (descuento.getClass() == DescuentoPorPuntos.class) {
			for (ActionListener al : aplicarDescuento.getActionListeners())
				aplicarDescuento.removeActionListener(al);
			aplicarDescuento.addActionListener(e -> {
				try {
					int punt = Integer.parseInt(codigoDescuento.getText());
					if(punt < 0)
						Utils.showErrorMsg("Los puntos introducidos no pueden ser negativos");
					else if(punt > _ctrl.getCliente().getMembresia().getPunto()){
						Utils.showErrorMsg("No tiene puntos suficientes");
					}
					else {
						((DescuentoPorPuntos)descuento).setPuntos(punt);
						updateTipsPanel();
					}
				}catch(Exception ex) {
					Utils.showErrorMsg("Solo se admite cifras numéricas");
				}
			});
			descuentoArea.setText("Puntos: ");
			codigoDescuento.setVisible(true);
			descuentoArea.setVisible(true);
			aplicarDescuento.setVisible(true);
		} else {
			codigoDescuento.setVisible(false);
			descuentoArea.setVisible(false);
			aplicarDescuento.setVisible(false);
			updateTipsPanel();
		}

		validate();
		repaint();
	}

	void setContentPanel() {
		_panel = new JPanel();
		_panel.setLayout(null);
		_panel.setBackground(new Color(248, 247, 240));
		this.setContentPane(_panel);
	}

}
