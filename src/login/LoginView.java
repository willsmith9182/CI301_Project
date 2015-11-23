package login;

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
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	protected JTextField T_username;
	protected JPasswordField T_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try
		{
			LoginView frame = new LoginView();
			frame.setVisible(true);
		} 
		catch (Exception e)
		{
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
		
		JLabel lblNfcBackEnd = new JLabel("NFC BACK END V.01");
		lblNfcBackEnd.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 18));
		lblNfcBackEnd.setBounds(103, 11, 254, 26);
		contentPane.add(lblNfcBackEnd);
		
		T_password = new JPasswordField();
		T_password.setBounds(103, 160, 128, 20);
		contentPane.add(T_password);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String username =  T_username.getText();
				String password =  T_password.getText();
				LoginCheck.Login(username , password);
			}
		});
		button.setBounds(327, 162, 70, 22);
		contentPane.add(button);
	}
}
