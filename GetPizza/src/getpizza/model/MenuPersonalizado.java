package getpizza.model;

import java.util.ArrayList;
import java.util.List;

public class MenuPersonalizado extends Menu {

	public MenuPersonalizado() {
		productos = new ArrayList<>();
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	@Override
	public void addProducto(Producto p) {
		productos.add(p);
	}

	@Override
	public void removeProducto(Producto p) {
		productos.remove(p);
	}

}
