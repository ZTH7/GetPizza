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

	public void tryToPay() {
		// TODO show payConfirm panel
	}

	public void sendOrder() {
		// TODO enviar los products a base de dato
	}

	public void addObserver(Observer o) {
		// TODO
	}

	public void removeObserver(Observer o) {
		// TODO
	}

}
