package getpizza.control;

import java.util.*;
import java.util.List;

import getpizza.model.*;

public class TrolleyController {
	List<Producto> products;
	
	public TrolleyController() {
		this.products = new ArrayList<>();
	}
	
	public void addProducts(Producto product) {
		products.add(product);
	}
	
	public void tryToPay() {
		
	}
	
}
