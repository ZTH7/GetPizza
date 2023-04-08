package getpizza.control;

import java.util.Map;

import getpizza.misc.DBHelper;
import getpizza.misc.Utils;
import getpizza.model.Cliente;

public class RegistryController {
	Controller _ctrl;

	public RegistryController(Controller _ctrl) {
		this._ctrl = _ctrl;
	}

	public void registry(Map<String, String> datos) {
		_ctrl.setCliente(createClient(datos));
		DBHelper.getInstance().createClient(datos);
	}
	
	public Cliente createClient(Map<String, String> datos) {
		// TODO create client & check data
		
		Utils.showErrorMsg("Datos incorrecta");
		
		return null;
	}
	
	
}
