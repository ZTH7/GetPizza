package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b556a3c3-5fa4-488f-be83-5625ff025654")
public class MenuPredefinido implements Menu {
	Pizza pizza;
	Bebida bebida;
	Postre postre;
	
	protected float precioTotal;
	
	public float getPrecioTotal() {
		return precioTotal;
	}

	@Override
	public void addPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void addBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	@Override
	public void addPostre(Postre postre) {
		this.postre = postre;
	}

	@Override
	public void removePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBebida(Bebida bebida) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePostre(Postre postre) {
		// TODO Auto-generated method stub
		
	}
}
