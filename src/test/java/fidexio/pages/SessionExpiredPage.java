package fidexio.pages;

import fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionExpiredPage {

    public SessionExpiredPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".o_dialog_warning.modal-body")
    public WebElement sessionExpiredAlert;

}
