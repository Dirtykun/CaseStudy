package Tests;

import Pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InboxTest extends BaseTest {

    @Test
    @Parameters({"login", "password"})
    public void sendingMessageFlowVerification(String login, String password) {
        LoginPage loginPage = new LoginPage();

        loginPage.handleSignIn(login, password)
                .handleSendingMessage()
                .openEmail(1)
                .subjectVerification()
                .emailBodyVerification();
    }
}
