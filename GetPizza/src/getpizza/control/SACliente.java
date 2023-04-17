package getpizza.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import getpizza.model.Carrito;
import getpizza.model.Observable;
import getpizza.model.Observer;
import getpizza.view.PayConfirm;

public class SACliente implements Observable<Observer> {
	List<Observer> observadores;
	JFrame mainWindow;

	public SACliente(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		
		observadores = new ArrayList<>();
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

	public void tryToPay(Carrito carrito) {
		JDialog payConfirm = new PayConfirm(mainWindow, this, carrito);
		// TODO show payConfirm panel
	}

	public void sendOrder() {
		// TODO enviar los products a base de dato
	}

}
