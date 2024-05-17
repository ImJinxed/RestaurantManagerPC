package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPage extends JFrame implements ActionListener {

    public ManagerPage(){
        setTitle("RestaurantManager");
        setSize(1280, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeText = new JLabel("Welcome, Manager!");
        welcomeText.setFont(new Font("Arial",Font.BOLD,48));
        JButton logoutButton = new JButton("Logout");
        JButton addButton = new JButton("Add Empployee");

        addButton.setBounds(120,400,160,30);
        welcomeText.setBounds(400,50,700,60);
        logoutButton.setBounds(5,5,80,20);

        setLayout(null);
        add(welcomeText);
        add(logoutButton);
        add(addButton);

        logoutButton.addActionListener(this);
        addButton.addActionListener(new AddButtonListener());
    }
    private void openLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openLoginPage();
    }
    private class AddButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            AddEmployeePage addEmployeePage = new AddEmployeePage();
            addEmployeePage.setVisible(true);
            dispose();
        }
    }
}
