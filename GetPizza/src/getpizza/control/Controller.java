package getpizza.control;

import javax.swing.*;

import getpizza.model.Cliente;

public class Controller {
	JFrame BottomFrame;
	JPanel login, registry, mainPage;
	Cliente cliente;
	LoginController loginctrl;
	RegistryController registryctrl;
	PayController payctrl;
	TrolleyController trolleyctrl;
	MenuController menuctrl;
	
	public Controller() {
		
	}
	
	public void loginSuccessful() {
		//TODO change login to mainpage
	}
	
	public void registrySuccessful() {
		//TODO change login to registry
	}
	
	public void registry() {
		//TODO change registry to mainpage
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
		// set mainpage cliente
	}
}
