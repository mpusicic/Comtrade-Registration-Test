package comtradePage;

import comtradeBase.ComtradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComtradeSuccessfulRegistrationPage extends ComtradeBaseTest {

    public ComtradeSuccessfulRegistrationPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ub-emb-close")
    WebElement reklamaSuccessfulRegistration;
    public void reklamaSuccessfulRegistrationClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(reklamaSuccessfulRegistration)).click();

    }

    @FindBy(css = ".alert.alert-success")
    WebElement hvalaNaRegistraciji;
    public boolean hvalaNaRegistracijiIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(hvalaNaRegistraciji));
        return hvalaNaRegistraciji.isDisplayed();
    }
    public String hvalaNaRegistracijiGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(hvalaNaRegistraciji));
        return hvalaNaRegistraciji.getText();
    }
}
