package getpizza.model;

public interface Menu {
	
	void addPizza(Pizza pizza);
	void addBebida(Bebida bebida);
	void addPostre(Postre postre);
	void removePizza(Pizza pizza);
	void removeBebida(Bebida bebida);
	void removePostre(Postre postre);
	
}
