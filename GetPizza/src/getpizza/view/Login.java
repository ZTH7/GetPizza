package getpizza.view;

import javax.swing.*;

import getpizza.control.Controller;
import getpizza.model.Observer;
import getpizza.model.Producto;

import java.awt.*;
import java.util.List;

public class Login extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	JTextField username;
	JPasswordField password;
	JButton login, registry1, registry2;

	public Login(Controller ctrl) {
		this._ctrl = ctrl;
		InitGUI();
	}

	void InitGUI() {
		setLayout(null);
		setBounds(0, 0, 600, 450);
		setOpaque(false);

		setTitle();
		setUserField();
		setPasswordField();
		setLoginButton();
		setRegistryButton();

		setBackground();
	}

	void setTitle() {
		JLabel title = new JLabel("Get Pizza");
		title.setForeground(new Color(250, 192, 61));
		title.setFont(new Font(null, 1, 55));
		title.setBounds(222, 85, 260, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
	}

	void setUserField() {
		JLabel userText = new JLabel("Username:");
		userText.setForeground(new Color(250, 192, 61));
		userText.setBounds(272, 155, 100, 20);
		add(userText);

		username = new JTextField(8);
		username.setBounds(272, 175, 160, 40);
		username.setBackground(new Color(255, 255, 255, 220));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		add(username);
	}

	void setPasswordField() {
		JLabel pwdText = new JLabel("Password:");
		pwdText.setForeground(new Color(250, 192, 61));
		pwdText.setBounds(272, 220, 100, 20);
		add(pwdText);

		password = new JPasswordField(8);
		password.setBounds(272, 240, 160, 40);
		password.setBackground(new Color(255, 255, 255, 220));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		add(password);
	}

	void setLoginButton() {
		login = new JButton("Log in");
		login.setForeground(new Color(96, 96, 96));
		login.setBounds(272, 305, 160, 40);
		login.setBackground(new Color(250, 192, 61));
		login.addActionListener(e -> _ctrl.login(username.getText(), new String(password.getPassword())));
		add(login);
	}

	void setRegistryButton() {
		registry1 = new JButton("<html><p>¿No te has registrado?</p></html>");
		registry1.setOpaque(false);
		registry1.setContentAreaFilled(false);
		registry1.setBorder(null);
		registry1.setForeground(new Color(2, 2, 250));
		registry1.setBounds(287, 345, 130, 20);
		registry1.addActionListener(e -> _ctrl.changeToRegistry());
		add(registry1);

		registry2 = new JButton("<html><p>Registrate ahora</p></html>");
		registry2.setOpaque(false);
		registry2.setContentAreaFilled(false);
		registry2.setBorder(null);
		registry2.setForeground(new Color(2, 2, 250));
		registry2.setBounds(292, 365, 120, 20);
		registry2.addActionListener(e -> _ctrl.changeToRegistry());
		add(registry2);
	}

	void setBackground() {
		JLabel bkg = new JLabel();
		bkg.setOpaque(true);
		bkg.setBackground(new Color(245, 242, 233, 160));
		bkg.setBounds(202, 65, 300, 350);
		add(bkg);
	}

	@Override
	public void onProductAdded(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProductRemoved(List<Producto> products, Producto p) {
		// TODO Auto-generated method stub

	}
}
