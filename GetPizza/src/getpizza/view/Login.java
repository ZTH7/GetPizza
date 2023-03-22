package getpizza.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	
	ActionListener loginListener, registryListener;
	JTextField username;
	JPasswordField password;
	JButton login, registry1, registry2;

	public Login() {
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
		login.addActionListener(loginListener);
		add(login);
	}

	void setRegistryButton() {
		registry1 = new JButton("¿No te has registrado?");
		registry1.setOpaque(false);
		registry1.setContentAreaFilled(false);
		registry1.setBorder(null);
		registry1.setForeground(new Color(2, 2, 250));
		registry1.setBounds(287, 345, 130, 20);
		registry1.addActionListener(registryListener);
		add(registry1);

		registry2 = new JButton("Registrate ahora");
		registry2.setOpaque(false);
		registry2.setContentAreaFilled(false);
		registry2.setBorder(null);
		registry2.setForeground(new Color(2, 2, 250));
		registry2.setBounds(292, 365, 120, 20);
		registry2.addActionListener(registryListener);
		add(registry2);
	}

	void setBackground() {
		JLabel bkg = new JLabel();
		bkg.setOpaque(true);
		bkg.setOpaque(true);
		bkg.setBackground(new Color(245, 242, 233, 160));
		bkg.setBounds(202, 65, 300, 350);
		add(bkg);
	}

	public void setLoginListener(ActionListener loginListener) {
		login.removeActionListener(this.loginListener);
		this.loginListener = loginListener;
		login.addActionListener(this.loginListener);
	}

	public void setRegistryListener(ActionListener registryListener) {
		registry1.removeActionListener(this.registryListener);
		registry2.removeActionListener(this.registryListener);
		this.registryListener = registryListener;
		registry1.addActionListener(this.registryListener);
		registry2.addActionListener(this.registryListener);
	}

	public String getUserName() {
		return username.getText();
	}

	public String getPassword() {
		return new String(password.getPassword());
	}
}
