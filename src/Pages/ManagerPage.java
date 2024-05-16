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

        welcomeText.setBounds(400,50,700,60);
        logoutButton.setBounds(5,5,80,20);

        setLayout(null);
        add(welcomeText);
        add(logoutButton);

        logoutButton.addActionListener(this);

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
}
