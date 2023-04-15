package getpizza.control;

import javax.swing.*;

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

	public Controller() {
		login = new Login();
		salogin = new SALogin(this, (Login) login);

		registry = new Registry();
		sareg = new SARegistry(this, (Registry) registry);

		mainPanel = new MainPanel(this);
		mainWindow = new MainWindow();

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

}
