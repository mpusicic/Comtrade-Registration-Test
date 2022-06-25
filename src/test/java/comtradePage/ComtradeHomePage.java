package comtradePage;

import comtradeBase.ComtradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComtradeHomePage extends ComtradeBaseTest {

    public ComtradeHomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ub-emb-close")
    WebElement reklamaClose;
    public ComtradeHomePage reklamaCloseClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(reklamaClose)).click();
        return this;
    }

    @FindBy(linkText = "Otvori nalog")
    WebElement otvoriNalogLink;
    public ComtradeHomePage otvoriNalogLinkClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(otvoriNalogLink)).click();
        return this;
    }
}
