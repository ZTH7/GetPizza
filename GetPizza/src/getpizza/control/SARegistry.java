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
		Cliente client;
		try {
			client = new Cliente(datos);
			if (client != null) {
				if (!DBHelper.getInstance().exists(datos.get("Nombre"))) {
					DBHelper.getInstance().setClient(client);
					_ctrl.setCliente(client);
					_ctrl.toMainPanel();
				} else
					Utils.showErrorMsg("Usuario ya existe");
			}
		} catch (Exception e) {
			Utils.showErrorMsg("Datos incorrecta");
		}
	}

	void setRegistryAction() {
		ActionListener reg = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Map<String, String> datos = _reg.getInfo();
					for(String str : datos.values()) {
						if(str.equals(""))
							throw new IllegalArgumentException();
					}
					registry(datos);
				} catch (Exception ex) {
					Utils.showErrorMsg("Los datos no pueden ser vacio");
				}
			}
		};
		_reg.setRegistryAction(reg);
		
		ActionListener volver = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_ctrl.run();
			}
		};
		_reg.setCancelAction(volver);
	}

}
