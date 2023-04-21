package getpizza.model;

import java.util.ArrayList;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("b556a3c3-5fa4-488f-be83-5625ff025654")
public class MenuPredefinido extends Menu {
	boolean pizza = false, bebida = false, postre = false;

	public MenuPredefinido() {
		productos = new ArrayList<>();
	}

	@Override
	public void addProducto(Producto p) {
		if (p.getClass() == Pizza.class) {
			if (pizza)
				throw new IllegalArgumentException("Ya tiene un producto de tipo pizza");
			pizza = true;
		} else if (p.getClass() == Bebida.class) {
			if (bebida)
				throw new IllegalArgumentException("Ya tiene un producto de tipo bebida");
			bebida = true;
		} else if (p.getClass() == Postre.class) {
			if (postre)
				throw new IllegalArgumentException("Ya tiene un producto de tipo postre");
			postre = true;
		}
		
		precioTotal += p.getPrecio();
		productos.add(p);
	}

	@Override
	public void removeProducto(Producto p) {
		if (p.getClass() == Pizza.class)
			pizza = false;
		else if (p.getClass() == Bebida.class)
			bebida = false;
		else if (p.getClass() == Postre.class)
			postre = false;

		precioTotal -= p.getPrecio();
		productos.remove(p);
	}
}
