package getpizza.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.*;

import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class PayConfirm extends JDialog implements Observer {

	private static final long serialVersionUID = 1L;

	int x, y;
	JFrame _parent;
	JPanel _panel;
	JButton confirm;
	JScrollPane _centralPanel;
	ActionListener confirmListener;

	public PayConfirm(JFrame parent) {
		super(parent);
		this._parent = parent;

		InitGUI();
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

		setBounds(300, 200, 340, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void setTitle() {
		JLabel title = new JLabel("Bill");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(100, 10, 140, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		_panel.add(title);
	}

	void setProductsList(List<Producto> products) {
		String list = "";
		for (Producto product : products) {
			list += product.getNombre();
			list += product.getPrecio();
		}

		JLabel title = new JLabel(list);
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(80, 20, 140, 30);
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

	public void setConfirmListener(ActionListener confirmListener) {
		confirm.removeActionListener(this.confirmListener);
		this.confirmListener = confirmListener;
		confirm.addActionListener(confirmListener);
	}

	void setCentralPanel() {
		JPanel panel = new JPanel(new GridLayout(10, 2));
		panel.setBackground(new Color(113, 152, 71));

		_centralPanel = new JScrollPane();
		_centralPanel.setViewportView(panel);
		_centralPanel.getVerticalScrollBar().setBackground(new Color(113, 152, 71));
		_centralPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		_centralPanel.setOpaque(false);
		_centralPanel.setBounds(40, 50, 260, 340);
		_centralPanel.setVisible(true);

		_panel.add(_centralPanel);
	}

	void setDescuento() {

	}

	void setDirection() {

	}

	void setPayMethod() {

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
