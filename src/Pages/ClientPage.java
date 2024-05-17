package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPage extends JFrame {
    private static final int ROWS = 3;
    private static final int COLS = 4;
    private boolean[][] reservedTables;
    public ClientPage(boolean[][] reservedTables) {
        this.reservedTables = reservedTables;
        initUI();
    }
    private void initUI() {
        setTitle("Restaurant Table Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(ROWS, COLS, 5, 5));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                if (reservedTables[i][j]) {
                    button.setText("Reserved");
                    button.setEnabled(false);
                } else {
                    button.setText("Free");
                    button.addActionListener(new TableButtonListener(i, j)); // Add ActionListener
                }
                panel.add(button);
            }
        }

        add(panel);
        setLocationRelativeTo(null);  // Center the window
    }

    // ActionListener for table buttons
    private class TableButtonListener implements ActionListener {
        private int row;
        private int col;

        public TableButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform action when button is clicked (e.g., notify user)
            JOptionPane.showMessageDialog(null, "Table " + (row + 1) + "-" + (col + 1) + " reserved.");
            // Optionally, you can update the UI to reflect the reservation
            JButton button = (JButton) e.getSource();
            button.setText("Reserved");
            button.setEnabled(false);
            reservedTables[row][col] = true;
        }
    }
}
