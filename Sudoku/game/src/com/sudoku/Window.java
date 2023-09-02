package com.sudoku;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JLabel;

public class Window extends JFrame {

	private JPanel contentPane;
	 int[][] initialGrid={{0,8,0,0,0,0,1,0,3},
	          {0,0,0,0,3,0,2,7,0},
	          {0,0,2,9,0,0,0,0,0},
	          {0,6,7,4,8,0,0,0,0},
	          {2,9,0,3,0,0,0,4,0},
	          {0,0,0,0,7,0,0,0,1},
	          {0,0,0,0,9,6,0,0,8},
	          {9,5,8,0,4,3,7,6,0},
	          {0,7,3,0,5,2,4,1,9}};


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Window(String output) {
		
		setVisible(true);
		final String output1="Hello "+output;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		 GraphicsEnvironment env2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice device = env2.getDefaultScreenDevice();
	        device.setFullScreenWindow(null);
	
        // Set the JFrame to full screen mode
       
		ImageIcon icon=new ImageIcon("C:\\Users\\srkrit\\Desktop\\sudoku.jpg");
       setIconImage(icon.getImage());
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(0, 255, 0));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingUtilities.invokeLater(() -> new SudokuGameGUI(initialGrid));
			}
			
			
		});
		btnNewButton.setBounds(729, 333, 139, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HELP");
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(729, 413, 139, 34);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 255, 0));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBackground(new Color(0, 0, 0));
		 Timer timer = new Timer(100, new ActionListener() {
             String text = output1;
             int index = 0;

             @Override
             public void actionPerformed(ActionEvent e) {
                 if (index < text.length()) {
                     textArea.append(String.valueOf(text.charAt(index)));
                     index++;
                 } else {
                     ((Timer) e.getSource()).stop();
                 }
             }
         });

         timer.start();
		textArea.setBounds(735, 230, 375, 63);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ajay dattu\\Documents\\sl_031420_28950_10.jpg"));
		lblNewLabel.setBounds(10, 2, 1589, 912);
		contentPane.add(lblNewLabel);
	
		
	}
}