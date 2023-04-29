package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class InboxTest extends BaseTest {

    @Test
    public void sendingMessageFlowVerification() {
        LoginPage loginPage = new LoginPage();

        loginPage.handleSignIn()
                .handleSendingMessage()
                .openEmail(1);
    }
}
