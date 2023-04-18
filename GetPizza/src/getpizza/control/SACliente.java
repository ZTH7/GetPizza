package getpizza.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import getpizza.model.Menu;
import getpizza.model.MenuPersonalizado;
import getpizza.model.MenuPredefinido;
import getpizza.model.Observable;
import getpizza.model.Observer;

public class SACliente implements Observable<Observer> {
	List<Observer> observadores;
	Menu carrito;
	JFrame mainWindow;

	public SACliente(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		
		observadores = new ArrayList<>();
	}
	
	public void selectMenu(int option) {
		if (option == 1) {
			carrito = new MenuPersonalizado();
		}
		else {
			carrito = new MenuPredefinido();
		}
	}

	@Override
	public void addObserver(Observer o) {
		if (observadores.contains(o))
			throw new IllegalArgumentException("El observador ya existe");

		observadores.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observadores.remove(o);
	}

	public void tryToPay() {
		//JDialog payConfirm = new PayConfirm(mainWindow, this);
		// TODO show payConfirm panel
	}

}
