package getpizza.view;

import java.util.List;

import javax.swing.JScrollPane;

import getpizza.model.Codigo;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Producto;

public class SelectionPanel extends JScrollPane implements Observer {

	
	@Override
	public void onProductAdded(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProductRemoved(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCodeUsed(Codigo codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOrderSended(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

}
