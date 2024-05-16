package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel registerLink;

    public LoginPage() {
        setTitle("RestaurantManager");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel1 = new JLabel("Restaurant");
        JLabel titleLabel2 = new JLabel("Manager");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        registerLink = new JLabel("Don't have an account? Register here");
        registerLink.setForeground(Color.BLUE);
        registerLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel LoginLabel = new JLabel("Login");
        LoginLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel1.setFont(new Font("Palatino",Font.BOLD, 48));
        titleLabel2.setFont(new Font("Palatino",Font.BOLD, 48));

        usernameLabel.setBounds(60, 350, 80, 25);
        usernameField.setBounds(140, 350, 160, 25);
        passwordLabel.setBounds(60, 380, 80, 25);
        passwordField.setBounds(140, 380, 160, 25);
        loginButton.setBounds(140, 410, 80, 25);
        registerLink.setBounds(80, 450, 220, 25);
        LoginLabel.setBounds(140,300,200,40);
        titleLabel1.setBounds(60,150,320,100);
        titleLabel2.setBounds(90,190,320,100);

        setLayout(null);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerLink);
        add(LoginLabel);
        add(titleLabel1);
        add(titleLabel2);

        loginButton.addActionListener(this);
        registerLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openRegisterPage();
            }
        });
    }

    private void openRegisterPage() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setVisible(true);
        dispose();
    }
    private void openManagerPage(){
        ManagerPage managerPage = new ManagerPage();
        managerPage.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
                openManagerPage();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }

    }
}