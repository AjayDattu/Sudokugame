package com.sudoku;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
import javax.swing.SwingConstants;

public class Maincode extends JFrame implements ActionListener{

	/**
	 * 
	
	 * 
	 */
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maincode frame = new Maincode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Maincode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); // Remove title bar, buttons, etc.

		GraphicsEnvironment env1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env1.getDefaultScreenDevice();
        device.setFullScreenWindow(null);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
				setResizable(false);
		ImageIcon icon=new ImageIcon("C:\\Users\\srkrit\\Desktop\\sudoku.jpg");
        setIconImage(icon.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dispose();
					Name obj=new Name();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				
			}
				
			}
		});
		btnNewButton_1.setBounds(783, 491, 138, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("SUDOKU");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 64));
		lblNewLabel.setBounds(743, 386, 271, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ajay dattu\\Downloads\\game.jpeg"));
		lblNewLabel_1.setBounds(-175, -227, 1766, 1231);
		contentPane.add(lblNewLabel_1);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}