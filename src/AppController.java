import Pages.LoginPage;
import Pages.RegisterPage;

public class AppController {
    public static void main(String[] args) {
        // Create and display the login page
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
