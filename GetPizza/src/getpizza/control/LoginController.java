package getpizza.control;

import getpizza.misc.DBHelper;
import getpizza.model.Cliente;
import getpizza.misc.*;

public class LoginController {
	Controller _ctrl;

	public LoginController(Controller ctrl) {
		this._ctrl = ctrl;

	}

	public void login(String username, String password) {
		Cliente cliente = DBHelper.getInstance().getClient(username, password);
		if (cliente != null) {
			_ctrl.setCliente(cliente);
			_ctrl.loginSuccessful();
		} else {
			Utils.showErrorMsg("El usuario o contraseña incorrecta");
		}
	}

	public void registry() {
		_ctrl.registry();
	}
}
