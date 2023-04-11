package getpizza.control;

import java.util.List;

import getpizza.model.Observable;
import getpizza.model.Observer;

public class SACliente implements Observable<Observer> {
	List<Observer> observadores;

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

}
