package getpizza.control;

import java.util.Map;

import javax.swing.*;

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
		mainPanel = new MainPanel(this);
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
		
	}

	public Object tryToPay(Carrito carrito) {
		// TODO Auto-generated method stub
		return null;
	}

}
