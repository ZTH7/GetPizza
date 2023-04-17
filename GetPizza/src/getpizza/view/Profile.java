package getpizza.view;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import getpizza.control.Controller;
import getpizza.misc.Utils;
import getpizza.model.Cliente;

public class Profile extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JButton save;
	Controller _ctrl;
	JPanel contentPanel;
	JTextField Nombre, Apellido, Correo, Tel, Direccion, Ciudad, Provincia, CodigoPostal, Password;

	int x = 75, y = 40;

	public Profile(Controller _ctrl) {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(255, 255, 255, 160));
		this._ctrl = _ctrl;

		InitGUI();
	}

	void InitGUI() {
		setViewportView(contentPanel);
		getVerticalScrollBar().setBackground(new Color(255, 255, 255, 160));
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setBounds(60, 50, 408, 390);
		setOpaque(false);
		
		setSaveButton();
		
		//Cliente cliente = _ctrl.getCliente();
		addTextField(Nombre = new JTextField(8), "Nombre:", x, y, 120, 20);
		//Nombre.setText(cliente.getId());
		Nombre.setEnabled(false);
		addTextField(Apellido = new JTextField(8), "Apellido:", x + 140, y, 120, 20);
		addTextField(Correo = new JTextField(8), "Correo:", x, y + 40, 160, 20);
		addTextField(Tel = new JTextField(8), "Tel.:", x + 180, y + 40, 80, 20);
		addTextField(Password = new JTextField(8), "Contraseña:", x, y + 80, 150, 20);
		addTextField(Direccion = new JTextField(8), "Direccion:", x, y + 120, 260, 20);
		addTextField(Ciudad = new JTextField(8), "Ciudad:", x, y + 160, 120, 20);
		addTextField(Provincia = new JTextField(8), "Provincia:", x + 140, y + 160, 120, 20);
		addTextField(CodigoPostal = new JTextField(8), "Codigo Postal:", x, y + 200, 100, 20);
	}
	
	void setSaveButton() {
		save = new JButton("Guardar");
		save.setForeground(new Color(96, 96, 96));
		save.setBounds(x + 50, y + 280, 160, 40);
		save.setBackground(new Color(0, 255, 176, 220));
		save.addActionListener(e -> {
			try {
				_ctrl.changeClient(getInfo());
			} catch (Exception ex) {
				Utils.showErrorMsg("Los datos no pueden ser vacio");
			}
		});
		add(save);
	}
	
	void addTextField(JTextField TextField, String name, int x, int y, int w, int l) {
		JLabel Text = new JLabel(name);
		Text.setForeground(new Color(255, 255, 255));
		Text.setBounds(x, y, w, 15);
		add(Text);

		TextField = new JTextField(8);
		TextField.setBounds(x, y + 15, w, l);
		TextField.setBackground(new Color(255, 255, 255, 220));
		add(TextField);
	}

	public Map<String, String> getInfo() {
		Map<String, String> res = new HashMap<>();
		res.put("Nombre", Nombre.getText());
		res.put("Apellido", Apellido.getText());
		res.put("Correo", Correo.getText());
		res.put("Tel", Tel.getText());
		res.put("Direccion", Direccion.getText());
		res.put("Ciudad", Ciudad.getText());
		res.put("Provincia", Provincia.getText());
		res.put("CodigoPostal", CodigoPostal.getText());
		res.put("Password", Password.getText());

		return res;
	}

}
