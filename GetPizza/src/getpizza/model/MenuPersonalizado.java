package getpizza.model;

import java.util.ArrayList;
import java.util.List;

public class MenuPersonalizado implements Menu{
	List<Pizza> pizza;
	List<Bebida> bebida;
	List<Postre> postre;
	
	protected float precioTotal;
	
	public MenuPersonalizado() {
		pizza = new ArrayList<>();
		bebida = new ArrayList<>();
		postre = new ArrayList<>();
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void addPizza(Pizza pizza) {
		this.pizza.add(pizza);
	}
	
	public void addBebida(Bebida bebida) {
		this.bebida.add(bebida);
	}
	
	public void addPostre(Postre postre) {
		this.postre.add(postre);
	}
	
	public void removePizza(Pizza pizza) {
		this.pizza.remove(pizza);
	}
	
	public void removeBebida(Bebida bebida) {
		this.bebida.remove(bebida);
	}
	
	public void removePostre(Postre postre) {
		this.postre.remove(postre);
	}
}
