package getpizza.control;

import java.util.Map;

import javax.swing.*;

import getpizza.misc.DBHelper;
import getpizza.model.Carrito;
import getpizza.model.Cliente;
import getpizza.model.Observer;
import getpizza.view.*;

public class Controller {
	JFrame mainWindow;
	JPanel login, registry, mainPanel, currentPanel = null;
	Cliente cliente;
	SALogin salogin;
	SARegistry sareg;
	SACliente sacliente;
	
	/*TODO:
	 * El controller debe de tener todos los metodos de los SA, ya que es el que controla sus acciones
	 * Hay que hacer anyadir Observer de cada tipo*/

	public Controller() {
		login = new Login();
		salogin = new SALogin(this, (Login) login);

		registry = new Registry();
		sareg = new SARegistry(this, (Registry) registry);

		mainWindow = new MainWindow();
		sacliente = new SACliente(mainWindow);
	}

	public void run() throws Exception {
		setMainWindowPanel(login);
	}

	void setMainWindowPanel(JPanel panel) {
		if (currentPanel != null)
			mainWindow.getContentPane().remove(currentPanel);

		mainWindow.getContentPane().add(panel);
		mainWindow.revalidate();
		mainWindow.repaint();

		currentPanel = panel;
	}

	public void toMainPanel() {
		mainPanel = new MainPanel(this);
		setMainWindowPanel(mainPanel);
	}

	public void toRegistry() {
		setMainWindowPanel(registry);
	}

	public void addClientObserver(Observer o) {
		sacliente.addObserver(o);
	}

	public void removeClientObserver(Observer o) {
		sacliente.removeObserver(o);
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void changeClient(Map<String, String> datos) {
		cliente.setNombre(datos.get("Nombre"));
		cliente.setApellido(datos.get("Apellido"));
		cliente.setCorreo(datos.get("Correo"));
		cliente.setTelefono(datos.get("Tel"));
		cliente.setDireccion(datos.get("Direccion"));
		cliente.setCiudad(datos.get("Ciudad"));
		cliente.setProvincia(datos.get("Provincia"));
		cliente.setCodigoPostal(datos.get("CodigoPostal"));
		cliente.setPassword(datos.get("Password"));
		DBHelper.getInstance().setClient(cliente);
	}

	public Object tryToPay() {
		// TODO Auto-generated method stub
		return null;
	}

}
