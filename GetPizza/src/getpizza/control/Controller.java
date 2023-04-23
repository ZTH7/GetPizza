package getpizza.control;

import java.util.List;
import java.util.Map;

import javax.swing.*;

import getpizza.misc.DBHelper;
import getpizza.model.Bebida;
import getpizza.model.Cliente;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Pizza;
import getpizza.model.Postre;
import getpizza.model.Producto;
import getpizza.view.*;

public class Controller {
	JFrame mainWindow;
	JPanel login, registry, mainPanel, currentPanel = null;
	Cliente cliente;
	SALogin salogin;
	SARegistry sareg;
	SACliente sacliente;

	/*
	 * El controller debe de tener todos los metodos de los SA, ya que es el
	 * que controla sus acciones
	 */

	public Controller() {
		login = new Login();
		salogin = new SALogin(this, (Login) login);

		registry = new Registry();
		sareg = new SARegistry(this, (Registry) registry);

		mainWindow = new MainWindow();
		sacliente = new SACliente(mainWindow);
	}

	public void run() {
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

	public void tryToPay() {
		new PayConfirm(mainWindow, this, sacliente.getMenu());
	}

	public void sendOrder(Pedido pedido) {
		cliente.addHistoria(pedido);
		cliente.getMembresia().addPunto((int) pedido.getPrecioFinal());
		sacliente.sendOrder(pedido);
		cliente.addPuntos((int)pedido.getPrecioFinal());
		DBHelper.getInstance().setClient(cliente);
	}

	public void selectMenu(boolean personalizado) {
		sacliente.selectMenu(personalizado);
	}

	public List<Pizza> getPizzas() {
		return this.sacliente.getPizzas();
	}

	public List<Bebida> getBebidas() {
		return this.sacliente.getBebidas();
	}

	public List<Postre> getPostres() {
		return this.sacliente.getPostres();
	}

	public void addProducto(Producto p) {
		sacliente.addProduct(p);
	}

	public void removeProducto(Producto p) {
		sacliente.removeProducto(p);
	}

}
