import Pages.LoginPage;
import Pages.RegisterPage;

import java.sql.*;

public class AppController {
    public static void main(String[] args) {
        // Create and display the login page
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
