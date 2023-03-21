package getpizza.control;

import java.awt.event.*;
import getpizza.view.*;

public class RegistryController {
	Registry registry;

	public RegistryController() {
		this.registry = new Registry();
		setRegistryFunction();
	}
	
	public void setRegistryFunction() {
		registry.setRegistryListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
}
