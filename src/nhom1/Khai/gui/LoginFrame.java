package nhom1.Khai.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import nhom1.Khai.db.DBConnector;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel, centerPanel;
	private JLabel idLabel, passwordLabel;
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton loginButton, exitButton;
	private DBConnector dbConnector;

	public LoginFrame(DBConnector dbConnector) {
		super("Login");
		this.dbConnector = dbConnector;
		initUI();
	}

	public void initUI() {
		this.setSize(300, 130);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		idLabel = new JLabel("ID");
		passwordLabel = new JLabel("Password");
		idField = new JTextField(20);
		passwordField = new JPasswordField(20);
		loginButton = new JButton("Login");
		exitButton = new JButton("Exit");
		buttonPanel.add(loginButton);
		buttonPanel.add(exitButton);
		this.setLayout(new BorderLayout());
		centerPanel.add(idLabel);
		centerPanel.add(idField);
		centerPanel.add(passwordLabel);
		centerPanel.add(passwordField);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public static void main(String[] args) {
		LoginFrame a = new LoginFrame(new DBConnector());
	}
}
