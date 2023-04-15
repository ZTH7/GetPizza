package getpizza.control;

import java.util.List;

import getpizza.model.Observable;
import getpizza.model.Observer;

public class SACliente implements Observable<Observer> {
	List<Observer> observadores;
	Controller _ctrl;

	public SACliente(Controller _ctrl) {
		this._ctrl = _ctrl;
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
		// TODO show payConfirm panel
	}

	public void sendOrder() {
		// TODO enviar los products a base de dato
	}

}
