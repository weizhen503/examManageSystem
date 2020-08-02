package hg.wzz.main.gui;

import javax.swing.*;


public class Login extends JFrame {

	private JLabel account ;
	private JLabel password;
	private JTextField userAccount;
	private JPasswordField userPassword;
	private JButton button;

	public JLabel getAccount() {
		return account;
	}

	public void setAccount(JLabel account) {
		this.account = account;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JTextField getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(JTextField userAccount) {
		this.userAccount = userAccount;
	}

	public JPasswordField getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(JPasswordField userPassword) {
		this.userPassword = userPassword;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public Login() {
		setBounds(100,100,550,400);
		setTitle("用户登录");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		account = new JLabel("账号");
		account.setBounds(90,30,100,100);
		password = new JLabel("密码");
		password.setBounds(90,90,100,200);
		
		userAccount = new JTextField();
		userAccount.setBounds(140,60,300,50);
		userPassword = new  JPasswordField();
		userPassword.setBounds(140, 155, 300, 50);
		
		button = new JButton("登录");
		button.setBounds(240, 230, 90, 40);// x,y ,long , width
		
		add(account);
		add(password);
		add(userAccount);
		add(userPassword);
		add(button);
	}


}
