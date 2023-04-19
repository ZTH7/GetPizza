package getpizza.model;

import java.util.ArrayList;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("b556a3c3-5fa4-488f-be83-5625ff025654")
public class MenuPredefinido extends Menu {

	public MenuPredefinido() {
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
