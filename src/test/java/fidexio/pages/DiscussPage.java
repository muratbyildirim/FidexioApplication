package fidexio.pages;

import fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscussPage {

    public DiscussPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".fa.fa-inbox.mr8")
    public WebElement inboxLink;


    @FindBy(css = "li[class='o_user_menu']")
    public WebElement userProfileDropdown;

    @FindBy(css = "a[data-menu='logout']")
    public WebElement logoutLink;


}
