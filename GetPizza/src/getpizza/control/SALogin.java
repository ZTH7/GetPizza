package getpizza.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import getpizza.view.Login;

public class SALogin {
	Controller _ctrl;
	Login login;

	public SALogin(Controller _ctrl, Login login) {
		this._ctrl = _ctrl;
		this.login = login;
		setLoginAction();
		setRegistryAction();
	}

	void login(String username, String password) {
		_ctrl.toMainPanel();
//		Cliente cliente = DBHelper.getInstance().getClient(username, password);
//		if (cliente != null) {
//			this.cliente = cliente;
//			setMainWindowPanel(mainPanel, login);
//		} else {
//			Utils.showErrorMsg("El usuario o contraseña incorrecta");
//		}
	}

	void setLoginAction() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login(login.getUsername(), login.getPassword());
			}
		};
		login.setLoginAction(al);
	}

	void setRegistryAction() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_ctrl.toRegistry();
			}
		};
		login.setRegistryAction(al);
	}
}
