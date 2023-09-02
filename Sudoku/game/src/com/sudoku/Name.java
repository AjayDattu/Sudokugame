package com.sudoku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Name {

	private JFrame frame;
	private JTextField textField;
	public String str;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Name() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
	   frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	   GraphicsEnvironment env3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
       GraphicsDevice device = env3.getDefaultScreenDevice();
       device.setFullScreenWindow(null);

		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel();

        Timer timer = new Timer(100, new ActionListener() {
            String text = "Enter your Name";
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < text.length()) {
                	 lblNewLabel.setText(text.substring(0, index + 1));
                	 index++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 255, 64));
		lblNewLabel.setBounds(657, 255, 340, 47);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 255, 64));
		textField.setBackground(new Color(0, 0, 0));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(657, 342, 229, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Next\r\n");
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str=textField.getText();
				frame.dispose();
				Window obj=new Window(str);
				
			}
		});

		btnNewButton.setBounds(738, 443, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ajay dattu\\Documents\\sl_031420_28950_10.jpg"));
		lblNewLabel_1.setBounds(-401, 10, 1919, 1271);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
