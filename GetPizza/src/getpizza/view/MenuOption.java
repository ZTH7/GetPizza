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

public class MenuOption extends JDialog {

	private static final long serialVersionUID = 1L;

	int x, y;
	JFrame _parent;
	JPanel _panel;
	ButtonGroup group;
	JButton confirm;
	JRadioButton predefinida, personalizada;

	public MenuOption(JFrame parent) {
		super(parent);
		this._parent = parent;
		InitGUI();
	}

	void InitGUI() {
		setContentPanel();
		setupMouse();
		setTitle();
		_panel.setBackground(new Color(248, 247, 240));
		setResizable(false);
		setUndecorated(true);

		setBounds(300, 200, 340, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void setTitle() {
		JLabel title = new JLabel("Seleccionar el tipo");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(100, 10, 140, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		_panel.add(title);
	}

	void setOption() {
		predefinida = new JRadioButton("Menu predefinida");
		predefinida.setSelected(true);
		personalizada = new JRadioButton("Menu personalizada");
		group = new ButtonGroup();
		// TODO format
	}

	public int getOption() {
		return group.getSelection() == personalizada.getModel() ? 1 : 0;
	}

	public void setConfirmButton() {
		confirm = new JButton("Confirmar");
		// TODO format
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

}
