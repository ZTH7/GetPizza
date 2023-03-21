package getpizza.control;

import java.awt.event.*;

import javax.swing.JPanel;

import getpizza.misc.DBHelper;
import getpizza.model.Cliente;
import getpizza.view.*;
import getpizza.misc.*;

public class LoginController {
	Login login;
	DBHelper dbhelper;
	Controller controller;
	
	public LoginController(DBHelper dbhelper, Controller controller) {
		this.dbhelper = dbhelper;
		this.controller = controller;

		this.login = new Login();
		setLoginFunction();
		setRegistryFunction();
	}

	public void setLoginFunction() {
		login.setLoginListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = login.getUserName();
				String password = login.getPassword();
				Cliente client = DBHelper.getClient(username, password);
				if(client != null) {
					//..change to MainPage panel
				}
				else {
					Utils.showErrorMsg("El usuario o contraseña incorrecta");
				}
			}

		});
	}

	public void setRegistryFunction() {
		login.setRegistryListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
	
	public JPanel getLoginPanel() {
		return login;
	}
}
