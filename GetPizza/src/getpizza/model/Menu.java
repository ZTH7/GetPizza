package getpizza.model;

import java.util.List;

public class Menu {
	
	List<Producto> productos;
	protected float precioTotal;
	
	public void addProducto(Producto p) {}
	public void removeProducto(Producto p) {};

	public float getPrecioTotal() {
		return precioTotal;
	}
}
