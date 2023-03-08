package fidexio.step_definitions;

import fidexio.pages.DiscussPage;
import fidexio.pages.LoginPage;
import fidexio.utilities.ConfigurationReader;
import fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Step_Definition {

    LoginPage loginPage=new LoginPage();
    DiscussPage discussPage=new DiscussPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));

    }
    @When("{string} enter username {string} and password {string}")
    public void enter_username_and_password(String string, String userName, String password) {
        loginPage.inputEmail.sendKeys(userName);
        loginPage.inputPassword.sendKeys(password);
        
    }
    @When("user click on login button")
    public void user_click_on_login_button() {

        String value=loginPage.inputEmail.getAttribute("required");
        loginPage.loginButton.click();

        
    }

    @Then("user should see discuss page {string}")
    public void user_should_see_discuss_page(String url) throws InterruptedException {

       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),8);
       wait.until(ExpectedConditions.visibilityOf(discussPage.inboxLink));

        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(url,actualTitle);

    }

    @Then("user should display {string} error message")
    public void user_should_display_error_message(String errorMessage) {

       Assert.assertEquals(errorMessage,loginPage.error.getText());

    }

//    @Then("input weblements {string} attribute values should be {string}")
//    public void input_weblements_attribute_values_should_be(String attribute, String expectedAttributeValue) {
//
//        String actualUsernameInputAttributeValue=loginPage.inputEmail.getAttribute(attribute);
//        String actualPasswordInputAttributeValue=loginPage.inputPassword.getAttribute(attribute);
//
//        Assert.assertEquals(expectedAttributeValue,actualUsernameInputAttributeValue);
//        Assert.assertEquals(expectedAttributeValue,actualPasswordInputAttributeValue);
//    }
    @Then("user should see the {string} message")
    public void user_should_see_the_message(String expectedFieldMessage) {
        System.out.println(loginPage.inputEmail.getAttribute("validationMessage"));
        Assert.assertEquals(expectedFieldMessage,loginPage.inputEmail.getAttribute("validationMessage"));
        Assert.assertEquals(expectedFieldMessage,loginPage.inputPassword.getAttribute("validationMessage"));

    }

//    @Then("password input weblement {string} attribute values should be {string}")
//    public void password_input_weblement_attribute_values_should_be(String attribute, String expectedValue) {
//
//        String actualPasswordInputAttributeValue=loginPage.inputPassword.getAttribute(attribute);
//        Assert.assertEquals(expectedValue,actualPasswordInputAttributeValue);
//    }

    @Then("User should see the password in bullet signs")
    public void user_should_see_the_password_in_bullet_signs() {
        String actualPasswordInputAttributeValue=loginPage.inputPassword.getAttribute("type");
        Assert.assertEquals("password",actualPasswordInputAttributeValue);
    }

    @When("user press enter on keyboard")
    public void user_press_enter_on_keyboard() {
        loginPage.loginButton.sendKeys(Keys.ENTER);

    }




}
