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
		setButton();
		setOption();
		setResizable(false);
		setUndecorated(true);
		_panel.setBackground(new Color(248, 247, 240));

		setBounds(300, 200, 280, 220);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void setTitle() {
		JLabel title = new JLabel("<html><center>Seleccionar el tipo</center></html>");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 20));
		title.setBounds(0, 10, 280, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		_panel.add(title);
	}

	void setOption() {
		group = new ButtonGroup();

		predefinida = new JRadioButton("Menu predefinida");
		predefinida.setBounds(70, 60, 180, 30);
		predefinida.setOpaque(false);
		predefinida.setSelected(true);
		group.add(predefinida);
		_panel.add(predefinida);

		personalizada = new JRadioButton("Menu personalizada");
		personalizada.setBounds(70, 100, 180, 30);
		personalizada.setOpaque(false);
		group.add(personalizada);
		_panel.add(personalizada);

		// TODO format
	}

	public int getOption() {
		return group.getSelection() == personalizada.getModel() ? 1 : 0;
	}

	void setButton() {
		confirm = new JButton("Confirm");
		confirm.setForeground(new Color(21, 60, 70));
		confirm.setBounds(30, 170, 100, 30);
		confirm.setBackground(new Color(250, 192, 61));

		_panel.add(confirm);

		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(21, 60, 70));
		cancel.setBounds(150, 170, 100, 30);
		cancel.setBackground(new Color(134, 144, 138));
		cancel.addActionListener(e -> {
			this.dispose(); // TODO reset carrito
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

}
