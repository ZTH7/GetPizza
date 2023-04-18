package getpizza.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import getpizza.control.Controller;
import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class MakeOrderView extends JDialog implements Observer {

	private static final long serialVersionUID = 1L;

	int x, y;
	JFrame _parent;
	JPanel _panel;
	JButton confirm;
	JScrollPane _centralPanel;
	TrolleyPanel trolley;
	Controller _ctrl;
	SelectionPanel _selection;
	
	/*TODO: RESET, resetear el carrito en caso de cancelar el pedido*/

	public MakeOrderView(JFrame parent, Controller ctrl) {
		super(parent);
		this._parent = parent;
		this._ctrl = ctrl;

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
		setTrolleyPanel();

		setBounds(300, 200, 854, 480);
		
	}

	void setTitle() {
		JLabel title = new JLabel("<html><center>Seleccione los productos que quiera</center></html>");
		title.setForeground(new Color(238, 120, 31));
		title.setFont(new Font(null, 1, 30));
		title.setBounds(0, 10, 854, 30);
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
		confirm.setForeground(new Color(21, 60, 70));
		confirm.setBounds(600, 420, 100, 30);
		confirm.setBackground(new Color(250, 192, 61));
		confirm.addActionListener(e -> _ctrl.tryToPay());
		
		_panel.add(confirm);

		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(21, 60, 70));
		cancel.setBounds(720, 420, 100, 30);
		cancel.setBackground(new Color(134, 144, 138));
		cancel.addActionListener(e -> {
			this.dispose(); // TODO reset carrito
		});

		_panel.add(cancel);
	}

	void setCentralPanel() {
		_selection = new SelectionPanel(_ctrl);

		_centralPanel = new JScrollPane();
		_centralPanel.setViewportView(_selection);
		_centralPanel.getVerticalScrollBar().setBackground(new Color(255, 204, 153));
		_centralPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		_centralPanel.setOpaque(false);
		_centralPanel.setBounds(40, 60, 520, 390);
		_centralPanel.setVisible(true);

		_panel.add(_centralPanel);
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
	
	public void open() {
		// Establecer la posición de la ventana de diálogo de tal manera que se abra en el centro de la ventana principal
		setLocationRelativeTo(this.getParent());
		setVisible(true);
	}
	
	public void close() {
		dispose();
	}

	void setContentPanel() {
		_panel = new JPanel();
		_panel.setLayout(null);
		this.setContentPane(_panel);
	}

	void setTrolleyPanel() {
		trolley = new TrolleyPanel(_ctrl);
		_panel.add(trolley);
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
