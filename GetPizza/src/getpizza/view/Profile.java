package getpizza.view;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import getpizza.control.Controller;
import getpizza.misc.Utils;
import getpizza.model.Cliente;

public class Profile extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton save;
	Controller _ctrl;
	JTextField Nombre, Apellido, Correo, Tel, Direccion, Ciudad, Provincia, CodigoPostal, Password;

	int x = 75, y = 40;

	public Profile(Controller _ctrl) {
		this._ctrl = _ctrl;

		InitGUI();
	}

	void InitGUI() {
		setLayout(null);
		setBackground(new Color(255, 255, 255, 160));
		setBounds(60, 50, 408, 390);
		
		setSaveButton();
		addTextField(Nombre = new JTextField(8), "Nombre:", x, y, 120, 20);
		addTextField(Apellido = new JTextField(8), "Apellido:", x + 140, y, 120, 20);
		addTextField(Correo = new JTextField(8), "Correo:", x, y + 40, 160, 20);
		addTextField(Tel = new JTextField(8), "Tel.:", x + 180, y + 40, 80, 20);
		addTextField(Password = new JTextField(8), "Contraseña:", x, y + 80, 150, 20);
		addTextField(Direccion = new JTextField(8), "Dirección:", x, y + 120, 260, 20);
		addTextField(Ciudad = new JTextField(8), "Ciudad:", x, y + 160, 120, 20);
		addTextField(Provincia = new JTextField(8), "Provincia:", x + 140, y + 160, 120, 20);
		addTextField(CodigoPostal = new JTextField(8), "Codigo Postal:", x, y + 200, 100, 20);
	}
	
	void setData() {
		Cliente cliente = _ctrl.getCliente();
		Nombre.setText(cliente.getNombre());
		Apellido.setText(cliente.getApellido());
		Correo.setText(cliente.getCorreo());
		Tel.setText(cliente.getTelefono());
		Password.setText(cliente.getPassword());
		Direccion.setText(cliente.getDireccion());
		Ciudad.setText(cliente.getCiudad());
		Provincia.setText(cliente.getProvincia());
		CodigoPostal.setText(cliente.getCodigoPostal());
	}
	
	void setSaveButton() {
		save = new JButton("Guardar");
		save.setForeground(new Color(0, 0, 0));
		save.setBounds(x + 50, y + 280, 160, 40);
		save.setBackground(new Color(255, 204, 153));
		save.addActionListener(e -> {
			try {
				Map<String, String> datos = getInfo();
				for(String str : datos.values()) {
					if(str.equals(""))
						throw new IllegalArgumentException();
				}
				_ctrl.changeClient(getInfo());
			} catch (Exception ex) {
				Utils.showErrorMsg("Los datos no pueden ser vacio");
			}
		});
		add(save);
	}
	
	void addTextField(JTextField TextField, String name, int x, int y, int w, int l) {
		JLabel Text = new JLabel(name);
		Text.setForeground(new Color(0, 0, 0));
		Text.setBounds(x, y, w, 15);
		add(Text);

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
