package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddEmployeePage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;

    public AddEmployeePage(){
        setTitle("RestaurantManager");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel1 = new JLabel("Restaurant");
        JLabel titleLabel2 = new JLabel("Manager");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        JButton registerButton = new JButton("Register");

        titleLabel1.setFont(new Font("Palatino",Font.BOLD, 48));
        titleLabel2.setFont(new Font("Palatino",Font.BOLD, 48));

        usernameLabel.setBounds(60, 320, 80, 25);
        usernameField.setBounds(140, 320, 160, 25);
        emailLabel.setBounds(60, 350, 80, 25);
        emailField.setBounds(140, 350, 200, 25);
        passwordLabel.setBounds(60, 380, 80, 25);
        passwordField.setBounds(140, 380, 160, 25);
        registerButton.setBounds(140, 410, 120, 25);
        titleLabel1.setBounds(60,150,320,100);
        titleLabel2.setBounds(90,190,320,100);

        setLayout(null);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(emailLabel);
        add(emailField);
        add(registerButton);
        add(titleLabel2);
        add(titleLabel1);

        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
            String insertSQL = "INSERT INTO USERS (username, password, email, type) VALUES (?, ?, ?, ?)";

            try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurantmanager", "root",
                    "restaurantmanager123");
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)){

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, "employee");

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
                openManagerPage();
            }catch (SQLException f){
                f.printStackTrace();
            }

    }
    private void openManagerPage(){
        ManagerPage managerPage = new ManagerPage();
        managerPage.setVisible(true);
        dispose();
    }
}
