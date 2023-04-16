package getpizza.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import getpizza.misc.DBHelper;
import getpizza.misc.Utils;
import getpizza.model.Cliente;
import getpizza.view.Registry;

public class SARegistry {
	Controller _ctrl;
	Registry _reg;

	public SARegistry(Controller _ctrl, Registry _reg) {
		this._ctrl = _ctrl;
		this._reg = _reg;
		setRegistryAction();
	}

	void registry(Map<String, String> datos) {
		Cliente client = createClient(datos);
		if (client != null) {
			DBHelper.getInstance().createClient(datos);
			_ctrl.toMainPanel();
		} else {
			Utils.showErrorMsg("Datos incorrecta");
		}

	}

	Cliente createClient(Map<String, String> datos) {
		// TODO create client & check data

		Utils.showErrorMsg("Datos incorrecta");

		return null;
	}

	void setRegistryAction() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registry(_reg.getInfo());
			}
		};
		_reg.setRegistryAction(al);
	}

}
