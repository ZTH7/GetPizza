package getpizza.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import getpizza.control.Controller;

public class MenuOption extends JDialog {

	private static final long serialVersionUID = 1L;

	int x, y;
	JFrame _parent;
	JPanel _panel;
	ButtonGroup group;
	JButton confirm;
	Controller _ctrl;
	JRadioButton predefinida, personalizada;

	public MenuOption(JFrame parent, Controller ctrl) {
		super(parent);
		this._parent = parent;
		_ctrl = ctrl;
		InitGUI();
	}

	void InitGUI() {
		setContentPanel();
		setupMouse();
		setTitle();
		setButton();
		setOption();
		setResizable(false);
		setUndecorated(true);
		_panel.setBackground(new Color(248, 247, 240));

		setBounds(300, 200, 280, 220);
	}

	void setTitle() {
		JLabel title = new JLabel("<html><center>¿Qué tipo de menú desea?</center></html>");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(0, 10, 280, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		_panel.add(title);
	}

	void setOption() {
		group = new ButtonGroup();

		predefinida = new JRadioButton("Menú predefinido");
		predefinida.setBounds(70, 60, 180, 30);
		predefinida.setOpaque(false);
		predefinida.setSelected(true);
		group.add(predefinida);
		_panel.add(predefinida);

		personalizada = new JRadioButton("Menú personalizado");
		personalizada.setBounds(70, 100, 180, 30);
		personalizada.setOpaque(false);
		group.add(personalizada);
		_panel.add(personalizada);
	}

	public boolean getOption() {
		return group.getSelection() == personalizada.getModel() ? true : false;
	}

	void setButton() {
		confirm = new JButton("Confirm");
		confirm.setForeground(new Color(21, 60, 70));
		confirm.setBounds(30, 170, 100, 30);
		confirm.setBackground(new Color(250, 192, 61));
		
		confirm.addActionListener((e) -> {
			// TODO how to close MakeOrderView
			MakeOrderView MakeOrderView = new MakeOrderView(_parent, _ctrl);
			MakeOrderView.open();
			_ctrl.selectMenu(getOption());
			this.close();
		});

		_panel.add(confirm);

		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(21, 60, 70));
		cancel.setBounds(150, 170, 100, 30);
		cancel.setBackground(new Color(134, 144, 138));
		cancel.addActionListener(e -> {
			this.dispose(); 
		});

		_panel.add(cancel);
	}

	public void setConfirmAction(ActionListener al) {
		confirm.addActionListener(al);
	}

	void setContentPanel() {
		_panel = new JPanel();
		_panel.setLayout(null);
		this.setContentPane(_panel);
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
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void close() {
		setVisible(false);
	}
  
}
