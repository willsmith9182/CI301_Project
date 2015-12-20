package ui.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	protected JTextField T_username;
	protected JPasswordField T_password;
	String charPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginView frame = new LoginView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel L_username = new JLabel("Username :");
		L_username.setBounds(33, 112, 71, 20);
		contentPane.add(L_username);

		JLabel L_password = new JLabel("Password : ");
		L_password.setBounds(33, 162, 61, 17);
		contentPane.add(L_password);

		T_username = new JTextField();
		T_username.setBounds(103, 112, 128, 20);
		contentPane.add(T_username);
		T_username.setColumns(10);

		JLabel L_logo = new JLabel("NFC BACK END V.01");
		L_logo.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 18));
		L_logo.setBounds(103, 11, 254, 26);
		contentPane.add(L_logo);

		T_password = new JPasswordField();
		T_password.setBounds(103, 160, 128, 20);
		contentPane.add(T_password);

		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				// very basic login
				// no hash implemented
				charPassword = String.copyValueOf(T_password.getPassword());
				/*
				 * try { System.out.println("char array to password : " +
				 * charPassword); //DBConnect.basicLogin(T_username.getText() ,
				 * charPassword); } catch (SQLException e) {
				 * e.printStackTrace(); }
				 */
			}
		});
		button.setBounds(327, 162, 70, 22);
		contentPane.add(button);
	}
}
