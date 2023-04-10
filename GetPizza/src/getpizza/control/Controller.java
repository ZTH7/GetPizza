package getpizza.control;

import java.util.List;
import java.util.Map;

import javax.swing.*;

import getpizza.misc.DBHelper;
import getpizza.misc.Utils;
import getpizza.model.Cliente;
import getpizza.model.Producto;
import getpizza.view.*;

public class Controller {
	JFrame mainWindow;
	JPanel login, registry, mainPanel, payConfirm, trolley;
	Cliente cliente;
	List<Producto> products;

	public Controller() {

	}

	public void run() throws Exception {
		mainWindow = new MainWindow();
		login = new Login(this);
		mainPanel = new MainPanel(this);
		setMainWindowPanel(login, null);
	}

	void setMainWindowPanel(JPanel panel, JPanel anterior) {
		if (anterior != null)
			mainWindow.getContentPane().remove(anterior);

		mainWindow.getContentPane().add(panel);

		mainWindow.revalidate();
		mainWindow.repaint();
	}

	public void login(String username, String password) {
		Cliente cliente = DBHelper.getInstance().getClient(username, password);
		if (cliente != null) {
			this.cliente = cliente;
			setMainWindowPanel(mainPanel, login);
		} else {
			Utils.showErrorMsg("El usuario o contraseña incorrecta");
		}
	}

	public void changeToRegistry() {// change login to registry
		registry = new Registry(this);
		setMainWindowPanel(registry, login);
	}

	public void registry(Map<String, String> datos) {
		Cliente client = createClient(datos);
		if (client != null) {
			DBHelper.getInstance().createClient(datos);
			setMainWindowPanel(mainPanel, registry);
		}

	}

	public Cliente createClient(Map<String, String> datos) {
		// TODO create client & check data

		Utils.showErrorMsg("Datos incorrecta");

		return null;
	}

	public void addProduct(Producto product) {
		products.add(product);
	}

	public void removeProduct(Producto product) {
		if (products.contains(product))
			products.remove(product);
	}

	public void tryToPay() {
		// TODO show payConfirm panel
	}

	public void sendOrder() {
		// TODO enviar los products a base de dato
	}

}
