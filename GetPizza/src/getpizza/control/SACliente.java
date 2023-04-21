package getpizza.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import getpizza.misc.DBHelper;
import getpizza.misc.Utils;
import getpizza.model.Bebida;
import getpizza.model.Menu;
import getpizza.model.MenuPersonalizado;
import getpizza.model.MenuPredefinido;
import getpizza.model.Observable;
import getpizza.model.Observer;
import getpizza.model.Pedido;
import getpizza.model.Pizza;
import getpizza.model.Postre;
import getpizza.model.Producto;

public class SACliente implements Observable<Observer> {
	List<Observer> observadores;
	Menu carrito;
	JFrame mainWindow;
	// carta
	List<Pizza> pizza;
	List<Bebida> bebida;
	List<Postre> postre;

	public SACliente(JFrame mainWindow) {
		this.mainWindow = mainWindow;

		observadores = new ArrayList<>();
		importProductos();
	}

	public void selectMenu(boolean personalizado) {
		carrito = personalizado ? new MenuPersonalizado() : new MenuPredefinido();
	}

	@Override
	public void addObserver(Observer o) {
		if (observadores.contains(o))
			throw new IllegalArgumentException("El observador ya existe");

		observadores.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observadores.remove(o);
	}

	public void sendOrder(Pedido pedido) {
		for (Observer o : observadores) {
			o.onOrderSended(pedido);
		}
	}

	public void importProductos() {
		Gson gson = new Gson();

		JsonObject pizzajson = gson.fromJson(DBHelper.getInstance().get("pizzas"), JsonObject.class);
		pizza = new ArrayList<>();
		JsonArray AllPizza = pizzajson.getAsJsonArray("pizzas");
		for (JsonElement p : AllPizza) {
			pizza.add(gson.fromJson(p, Pizza.class));
		}

		JsonObject bebidajson = gson.fromJson(DBHelper.getInstance().get("bebidas"), JsonObject.class);
		bebida = new ArrayList<>();
		JsonArray AllBebida = bebidajson.getAsJsonArray("bebidas");
		for (JsonElement p : AllBebida) {
			bebida.add(gson.fromJson(p, Bebida.class));
		}

		JsonObject postrejson = gson.fromJson(DBHelper.getInstance().get("postres"), JsonObject.class);
		postre = new ArrayList<>();
		JsonArray AllPostre = postrejson.getAsJsonArray("postres");
		for (JsonElement p : AllPostre) {
			postre.add(gson.fromJson(p, Postre.class));
		}
	}

	public List<Pizza> getPizzas() {
		return this.pizza;
	}

	public List<Bebida> getBebidas() {
		return this.bebida;
	}

	public List<Postre> getPostres() {
		return this.postre;
	}

	public Menu getMenu() {
		return this.carrito;
	}

	public void addProduct(Producto p) {
		try {
			carrito.addProducto(p);
			for (Observer o : observadores)
				o.onProductAdded(p);
		} catch (IllegalArgumentException e) {
			Utils.showErrorMsg(e.getMessage());
		}
	}

	public void removeProducto(Producto p) {
		carrito.removeProducto(p);

		for (Observer o : observadores) {
			o.onProductRemoved(p);
		}
	}

}
