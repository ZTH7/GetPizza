package getpizza.model;

import java.util.ArrayList;

public class MenuPersonalizado extends Menu {

	public MenuPersonalizado() {
		productos = new ArrayList<>();
	}

	@Override
	public void addProducto(Producto p) {
		precioTotal += p.getPrecio();
		productos.add(p);
	}

	@Override
	public void removeProducto(Producto p) {
		precioTotal -= p.getPrecio();
		productos.remove(p);
	}

}
