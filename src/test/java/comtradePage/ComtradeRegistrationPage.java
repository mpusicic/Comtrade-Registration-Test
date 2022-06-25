package comtradePage;

import comtradeBase.ComtradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ComtradeRegistrationPage extends ComtradeBaseTest {

    public ComtradeRegistrationPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ub-emb-close")
    WebElement reeklamaRegistration;
    public ComtradeRegistrationPage reeklamaRegistrationClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(reeklamaRegistration)).click();
        return this;
    }

    @FindBy(id = "firstname")
    WebElement imeInputField;
    public ComtradeRegistrationPage imeInputFieldSendKeys(String ime){
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime);
        return this;
    }

    @FindBy(id = "lastname")
    WebElement prezimeInputField;
    public ComtradeRegistrationPage prezimeInputFieldSedKeys(String prezime){
        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
        return this;
    }

    @FindBy(id = "email_address")
    WebElement emailInputField;
    public ComtradeRegistrationPage emailInputFieldSendKeys(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
        return this;
    }

    @FindBy(name = "is_subscribed")
    WebElement checkBox;
    public ComtradeRegistrationPage checkBoxclick(){
        wdWait.until(ExpectedConditions.visibilityOf(checkBox));
        if (checkBox.isSelected())
            checkBox.click();
        return this;
    }

    @FindBy(id = "pravnolice")
    WebElement pravnoLiceField;

    public ComtradeRegistrationPage pravnoLiceFieldSelect(){
        wdWait.until(ExpectedConditions.elementToBeClickable(pravnoLiceField));
        Select pravnoLice = new Select(pravnoLiceField);
        pravnoLice.selectByValue("1");
        return this;
    }

    @FindBy(id = "firma")
    WebElement firmaInputField;
    public ComtradeRegistrationPage firmaInputFieldSendKeys(String firma){
        wdWait.until(ExpectedConditions.visibilityOf(firmaInputField)).clear();
        firmaInputField.sendKeys(firma);
        return this;
    }

    @FindBy(id = "pib")
    WebElement pibInputField;
    public ComtradeRegistrationPage pibInputFieldSendKeys(String pib){
        wdWait.until(ExpectedConditions.visibilityOf(pibInputField)).clear();
        pibInputField.sendKeys(pib);
        return this;
    }

    @FindBy(id = "password")
    WebElement lozinkaInputField;
    public ComtradeRegistrationPage lozinkaInputFieldSendKeys(String lozinka){
        wdWait.until(ExpectedConditions.visibilityOf(lozinkaInputField)).clear();
        lozinkaInputField.sendKeys(lozinka);
        return this;
    }

    @FindBy(id = "confirmation")
    WebElement potvrdaLozinkeInputField;
    public ComtradeRegistrationPage potvrdaLozinkeInputFieldSendKeys(String potvrdaLozinke){
        wdWait.until(ExpectedConditions.visibilityOf(potvrdaLozinkeInputField)).clear();
        potvrdaLozinkeInputField.sendKeys(potvrdaLozinke);
        return this;
    }

    @FindBy(css = ".button.btn.btn-primary")
    WebElement posaljiButton;
    public void posaljiButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(posaljiButton)).click();
    }

    @FindBy(css = ".alert.alert-warning")
    WebElement postojiNalogMessage;
    public boolean postojiNalogMessageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(postojiNalogMessage));
        return postojiNalogMessage.isDisplayed();
    }

    public String postojiNalogMessageGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(postojiNalogMessage));
        return postojiNalogMessage.getText();
    }

    @FindBy(css = ".alert.alert-warning")
    WebElement invalidMailMessage;
    public boolean invalidMailMessageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(invalidMailMessage));
        return invalidMailMessage.isDisplayed();
    }

    public String invalidMailMessageGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(invalidMailMessage));
        return invalidMailMessage.getText();
    }

}
