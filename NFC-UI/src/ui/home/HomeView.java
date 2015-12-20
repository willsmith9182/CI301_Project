package ui.home;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class HomeView extends JFrame
{
	public HomeView() {
		setTitle("BACKEND V0.1");
		setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnNew = new JButton("New ");
		btnNew.setBounds(10, 108, 89, 23);
		getContentPane().add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(10, 142, 89, 23);
		getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 176, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnCustom = new JButton("Weekly log");
		btnCustom.setBounds(10, 427, 89, 23);
		getContentPane().add(btnCustom);
		
		JButton btnNewButton = new JButton("All Users");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 325, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("All Doors");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 359, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Daily log");
		btnNewButton_2.setBounds(10, 393, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Custom log");
		btnNewButton_3.setBounds(10, 461, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnUserLookup = new JButton("Lookup");
		btnUserLookup.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUserLookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserLookup.setBounds(10, 210, 89, 23);
		getContentPane().add(btnUserLookup);
		
		JTextArea T_bigText = new JTextArea();
		T_bigText.setText("Welcome to V0.1 NFC/Android door automation");
		T_bigText.setBounds(109, 11, 498, 735);
		getContentPane().add(T_bigText);
	}
}
