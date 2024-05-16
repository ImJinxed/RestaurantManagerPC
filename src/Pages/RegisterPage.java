package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel loginLink;

    public RegisterPage() {
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

        // In a real application, you would perform registration logic here
        // For simplicity, let's just display the entered information
        JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password + "\nEmail: " + email);
    }
}