package fidexio.pages;

import fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscussPage {

    public DiscussPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(css = ".fa.fa-inbox.mr8")
    public WebElement inboxLink;

}
