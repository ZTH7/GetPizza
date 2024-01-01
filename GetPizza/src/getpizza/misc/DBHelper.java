package getpizza.misc;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import getpizza.model.*;
import redis.clients.jedis.Jedis;

public class DBHelper {
	static DBHelper instance = null;
	Jedis jedis = null;

	private DBHelper() {
		try {
			jedis = new Jedis("redis.database.url", 6379);
			jedis.auth("your password");
		} catch (Exception ex) {
			jedis = null;
			ex.printStackTrace();
		}
	}

	public static DBHelper getInstance() {
		if (instance == null)
			instance = new DBHelper();

		return instance;
	}

	public Jedis getConnection() {
		return jedis;
	}

	public void desconectar() {
		jedis.close();
	}

	public boolean exists(String username) {
		return jedis.exists(username);
	}

	public void setClient(Cliente cliente) {
		String data = new Gson().toJson(cliente);
		jedis.set(cliente.getId(), data);
	}

	public String get(String key) {
		return jedis.get(key);
	}

	public Cliente getClient(String username, String password) {
		if (jedis.exists(username)) {
			String data = jedis.get(username);
			try {
				Cliente cliente = new Gson().fromJson(data, Cliente.class);
				if (cliente.password.equals(password))
					return cliente;
				else
					Utils.showErrorMsg("Contraseña incorrecta");
			} catch (Exception e) {
				Utils.showErrorMsg("DB Error");
			}
		} else
			Utils.showErrorMsg("Usuario no existe");

		return null;
	}
	
	public List<DescuentoPorCodigo> getCodigo(){
		Gson gson = new Gson();
		JsonObject pizzajson = gson.fromJson(DBHelper.getInstance().get("descuentoPorCodigo"), JsonObject.class);
		List<DescuentoPorCodigo> codigo = new ArrayList<>();
		JsonArray codigos = pizzajson.getAsJsonArray("descuentoPorCodigo");
		for (JsonElement p : codigos) {
			codigo.add(gson.fromJson(p, DescuentoPorCodigo.class));
		}
		return codigo;
	}
	
	public List<Ingrediente> getIngrediente(){
		Gson gson = new Gson();
		JsonObject pizzajson = gson.fromJson(DBHelper.getInstance().get("ingredientes"), JsonObject.class);
		List<Ingrediente> ingrediente = new ArrayList<>();
		JsonArray ingredientes = pizzajson.getAsJsonArray("ingredientes");
		for (JsonElement p : ingredientes) {
			ingrediente.add(gson.fromJson(p, Ingrediente.class));
		}
		return ingrediente;
	}

	public static void main(String[] arg) {

		Jedis jedis = new Jedis("redis.database.url", 6379);
		jedis.auth("your password");

		jedis.set("ingredientes", "{\"ingredientes\":[{\"nombre\":\"Salsa de tomate\",\"precio\":0.5},{\"nombre\":\"Mozzarella fresca\",\"precio\":1.5},{\"nombre\":\"Albahaca fresca\",\"precio\":0.75},{\"nombre\":\"Queso mozzarella\",\"precio\":1.5},{\"nombre\":\"Pepperoni en rodajas\",\"precio\":2.0},{\"nombre\":\"Jamón\",\"precio\":2.0},{\"nombre\":\"Piña\",\"precio\":1.5},{\"nombre\":\"Anchoas\",\"precio\":2.5},{\"nombre\":\"Aceitunas negras\",\"precio\":1.0},{\"nombre\":\"Queso gorgonzola\",\"precio\":2.5},{\"nombre\":\"Queso parmesano\",\"precio\":1.0},{\"nombre\":\"Queso provolone\",\"precio\":1.0},{\"nombre\":\"Espinacas\",\"precio\":1.0},{\"nombre\":\"Tomate\",\"precio\":1.0},{\"nombre\":\"Cebolla\",\"precio\":0.5},{\"nombre\":\"Pimiento\",\"precio\":0.5},{\"nombre\":\"Aceitunas negras\",\"precio\":1.5}]}");
		System.out.println(jedis.ping());
		
		jedis.close();
	}
}
