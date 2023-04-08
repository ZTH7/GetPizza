package getpizza.model;

import java.util.List;

public interface Observer {

	public void onProductAdded(List<Producto> products, Producto p);

	public void onProductRemoved(List<Producto> products, Producto p);
}
