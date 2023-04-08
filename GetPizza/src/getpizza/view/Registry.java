package getpizza.view;

import javax.swing.*;

import getpizza.control.Controller;
import getpizza.model.Observer;
import getpizza.model.Producto;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registry extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	JTextField Nombre, Apellido, Correo, Tel, Direccion, Ciudad, Provincia, CodigoPostal;
	JPasswordField Password;
	JButton registry;

	public Registry(Controller _ctrl) {
		super(null);
		this._ctrl = _ctrl;

		InitGUI();
	}

	void InitGUI() {
		setBounds(0, 0, 600, 450);
		setOpaque(false);

		setTitle();
		setRegistryButton();
		addTextField(Nombre, "Nombre:", 222, 85, 120, 20);
		addTextField(Apellido, "Apellido:", 362, 85, 120, 20);
		addTextField(Correo, "Correo:", 222, 125, 160, 20);
		addTextField(Tel, "Tel.:", 402, 125, 80, 20);
		addPasswordField(Password, "Contrase�a:", 222, 165, 150, 20);
		addTextField(Direccion, "Direccion:", 222, 205, 260, 20);
		addTextField(Ciudad, "Ciudad:", 222, 245, 120, 20);
		addTextField(Provincia, "Provincia:", 362, 245, 120, 20);
		addTextField(CodigoPostal, "Codigo Postal:", 222, 285, 100, 20);

		setBackground();
	}

	void setTitle() {
		JLabel title = new JLabel("Registrar");
		title.setForeground(new Color(0xE0FAAB00, true));
		title.setFont(new Font(null, 1, 30));
		title.setBounds(222, 45, 260, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
	}

	void setRegistryButton() {
		registry = new JButton("Registry");
		registry.setForeground(new Color(96, 96, 96));
		registry.setBounds(272, 385, 160, 40);
		registry.setBackground(new Color(0, 255, 176, 220));
		registry.addActionListener(e -> _ctrl.registry(getInfo()));
		add(registry);
	}

	void setBackground() {
		JLabel bkg = new JLabel();
		bkg.setOpaque(true);
		bkg.setOpaque(true);
		bkg.setBackground(new Color(255, 255, 255, 100));
		bkg.setBounds(202, 40, 300, 400);
		add(bkg);
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

	void addPasswordField(JPasswordField PasswordField, String name, int x, int y, int w, int l) {
		JLabel Text = new JLabel(name);
		Text.setForeground(new Color(255, 255, 255));
		Text.setBounds(x, y, w, 15);
		add(Text);

		PasswordField = new JPasswordField(8);
		PasswordField.setBounds(x, y + 15, w, l);
		PasswordField.setBackground(new Color(255, 255, 255, 220));
		add(PasswordField);
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
		res.put("Password", new String(Password.getPassword()));

		return res;
	}

	@Override
	public void onProductAdded(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProductRemoved(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}

}
