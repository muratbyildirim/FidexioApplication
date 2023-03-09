package fidexio.step_definitions;


import fidexio.pages.DiscussPage;
import fidexio.pages.LoginPage;
import fidexio.pages.SessionExpiredPage;
import fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Logout_Step_Definiton {

    LoginPage loginPage=new LoginPage();
    DiscussPage discussPage=new DiscussPage();
    SessionExpiredPage sessionExpiredPage=new SessionExpiredPage();

    @Then("user enters credentials and click the login button")
    public void user_enters_credentials_and_click_the_login_button(Map<String,String> credentials) {

        loginPage.inputEmail.sendKeys(credentials.get("email"));
        loginPage.inputPassword.sendKeys(credentials.get("password"));
        loginPage.loginButton.click();

    }
    @When("user click the profile dropdown located top right corner")
    public void user_click_the_profile_dropdown_located_top_right_corner() {
        discussPage.userProfileDropdown.click();

    }
    @When("user click the log out link")
    public void user_click_the_log_out_link() {
        discussPage.logoutLink.click();

    }
    @Then("user end up on login page")
    public void user_end_up_on_login_page(Map<String,String> loginTitle) {
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(loginTitle.get("title")));
    }

    @When("user click the step back button")
    public void user_click_the_step_back_button() {

        Driver.getDriver().navigate().back();

    }

    @Then("user should display Session expired alert")
    public void user_should_display_session_expired_alert() {
       Assert.assertTrue(sessionExpiredPage.sessionExpiredAlert.isDisplayed());
    }

}
