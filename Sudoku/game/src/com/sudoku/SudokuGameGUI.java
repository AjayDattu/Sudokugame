package com.sudoku;




import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SudokuGameGUI extends JFrame implements ActionListener {
    private static final int SIZE = 9;
    private static final int CELL_SIZE = 50;
    private static final int BOARD_SIZE = CELL_SIZE * SIZE;
    private JPanel contentPane;

    private JTextField[][] cells;
    private int[][] initialGrid;

    public SudokuGameGUI(int[][] initialGrid) {
    	setUndecorated(true); // Remove title bar, buttons, etc.

        // Set the JFrame to full screen mode
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        device.setFullScreenWindow(null);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);

    	

    	 setTitle("Sudoku Game");

        ImageIcon icon=new ImageIcon("C:\\Users\\srkrit\\Desktop\\sudoku.jpg");
       setIconImage(icon.getImage());
        contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        this.initialGrid = copyGrid(initialGrid); 
        cells = new JTextField[SIZE][SIZE];

        int startX = 626;
        int startY = 192;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setText(initialGrid[i][j] == 0 ? "" : String.valueOf(initialGrid[i][j]));
                cells[i][j].setForeground(new Color(0, 255, 64));
                cells[i][j].setBackground(new Color(0, 0, 0));
                int x = startX + j * CELL_SIZE;
                int y = startY + i * CELL_SIZE;
                
                cells[i][j].setBounds(x, y, CELL_SIZE, CELL_SIZE);
                cells[i][j].addFocusListener(new SudokuFocusListener(i, j));

                getContentPane().add(cells[i][j]);
            }
        }

        JButton SubmitButton = new JButton("Submit");
        SubmitButton.setBackground(new Color(0, 0, 0));
        SubmitButton.setForeground(new Color(0, 255, 0));
        SubmitButton.addActionListener(this);
        SubmitButton.setBounds(945, 814, 100, 30);
        getContentPane().add(SubmitButton);
        
        JButton btnNewButton = new JButton("exit\r\n");
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(0, 255, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(805, 814, 100, 30);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ajay dattu\\Documents\\sl_031420_28950_10.jpg"));
        lblNewLabel.setBounds(-41, -40, 1620, 1224);
        contentPane.add(lblNewLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            SubmitSudoku();
        }
    }

    private class SudokuFocusListener implements FocusListener {
        private int row;
        private int col;

        public SudokuFocusListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            String text = cells[row][col].getText();
            try {
                int value = Integer.parseInt(text);
                if (value >= 1 && value <= 9) {
                    if (isValueValid(value, row, col)) {
                        initialGrid[row][col] = value;
                    } else {
                        JOptionPane.showMessageDialog(SudokuGameGUI.this,
                                "Invalid move! The entered value violates Sudoku rules.",
                                "Invalid Move", JOptionPane.ERROR_MESSAGE);
                        cells[row][col].setText(""); 
                        initialGrid[row][col] = 0; 
                    }
                } else {
                    initialGrid[row][col] = 0;
                    cells[row][col].setText(""); 
                }
            } catch (NumberFormatException ex) {
                initialGrid[row][col] = 0; 
                cells[row][col].setText(""); 
            }
        }
    }

    private void SubmitSudoku() {
        boolean Submitd = Submit(0, 0);
        if (Submitd) {
            updateGrid();
            JOptionPane.showMessageDialog(this, "Puzzle Solved!!!");
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists for the given puzzle!");
        }
    }

    private boolean Submit(int row, int col) {
        if (row == SIZE) {
            return true;
        }

        int nextRow = col == SIZE - 1 ? row + 1 : row;
        int nextCol = (col + 1) % SIZE;

        if (initialGrid[row][col] != 0) {
            return Submit(nextRow, nextCol);
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValueValid(num, row, col)) {
                initialGrid[row][col] = num;

                if (Submit(nextRow, nextCol)) {
                    return true; 
                }

             
                initialGrid[row][col] = 0;
            }
        }

        return false;     }

    private void updateGrid() {
                for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setText(String.valueOf(initialGrid[i][j]));
            }
        }
    }

    private int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }

    private boolean isValueValid(int value, int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            if (initialGrid[row][i] == value || initialGrid[i][col] == value) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (initialGrid[startRow + i][startCol + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}