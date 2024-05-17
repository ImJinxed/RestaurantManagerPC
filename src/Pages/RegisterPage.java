package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel loginLink;
    private Map<String,String> clientData;
    private Map<String,String> employeeData;

    public RegisterPage() {
        clientData = new HashMap<>();
        employeeData = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurantmanager", "root",
                    "restaurantmanager123");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while (resultSet.next()) {
                if(resultSet.getString("type").equals("employee")){
                    employeeData.put(resultSet.getString("username"),resultSet.getString("password"));
                }else if(resultSet.getString("type").equals("client")){
                    clientData.put(resultSet.getString("username"),resultSet.getString("password"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

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
        loginLink = new JLabel("Do you have an account? Login!");
        loginLink.setForeground(Color.BLUE);
        loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel LoginLabel = new JLabel("Login");
        LoginLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel1.setFont(new Font("Palatino",Font.BOLD, 48));
        titleLabel2.setFont(new Font("Palatino",Font.BOLD, 48));

        usernameLabel.setBounds(60, 320, 80, 25);
        usernameField.setBounds(140, 320, 160, 25);
        emailLabel.setBounds(60, 350, 80, 25);
        emailField.setBounds(140, 350, 200, 25);
        passwordLabel.setBounds(60, 380, 80, 25);
        passwordField.setBounds(140, 380, 160, 25);
        registerButton.setBounds(140, 410, 120, 25);
        loginLink.setBounds(100, 450, 220, 25);
        LoginLabel.setBounds(140,300,200,40);
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
        add(loginLink);

        registerButton.addActionListener(this);
        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLoginPage();
            }
        });
    }

    private void openLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if(clientData.containsKey(username)){
            JOptionPane.showMessageDialog(this, "The username already exists, try to login!");
        }else if(email.matches(".*@gmail\\.com")){
            String insertSQL = "INSERT INTO USERS (username, password, email, type) VALUES (?, ?, ?, ?)";

                try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurantmanager", "root",
                        "restaurantmanager123");
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)){

                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, "client");

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("A new user was inserted successfully!");
                    }
                    openLoginPage();
            }catch (SQLException f){
                f.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Wrong email pattern!!");
        }
    }
}