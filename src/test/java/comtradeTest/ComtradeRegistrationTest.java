package comtradeTest;

import comtradeBase.ComtradeBaseTest;
import comtradePage.ComtradeHomePage;
import comtradePage.ComtradeRegistrationPage;
import comtradePage.ComtradeSuccessfulRegistrationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class ComtradeRegistrationTest extends ComtradeBaseTest {

    ComtradeHomePage comtradeHomePage;
    ComtradeRegistrationPage comtradeRegistrationPage;
    ComtradeSuccessfulRegistrationPage comtradeSuccessfulRegistrationPage;

    Random random = new Random();
    String ime = "comtradenekoime" + random.nextInt(999999);
    String prezime = ime;
    String email = ime +"@mailinator.com";
    //String pib = "123456"+ random.nextInt(999);
    //String wrongPib = "123456";
    String lozinka = "123456789";

    @Before
    public void setUpTest(){

        comtradeHomePage = new ComtradeHomePage();
        comtradeRegistrationPage = new ComtradeRegistrationPage();
        comtradeSuccessfulRegistrationPage = new ComtradeSuccessfulRegistrationPage();
    }


    @Test
    public void successfulRegistrationTest(){

        comtradeHomePage
                .reklamaCloseClick()
                .otvoriNalogLinkClick();
        comtradeRegistrationPage
                .reeklamaRegistrationClick()
                .imeInputFieldSendKeys(ime)
                .prezimeInputFieldSedKeys(prezime)
                .emailInputFieldSendKeys(email)
                .checkBoxclick()
                .lozinkaInputFieldSendKeys(lozinka)
                .potvrdaLozinkeInputFieldSendKeys(lozinka)
                .posaljiButtonClick();
        comtradeSuccessfulRegistrationPage.reklamaSuccessfulRegistrationClick();
        Assert.assertTrue(comtradeSuccessfulRegistrationPage.hvalaNaRegistracijiIsDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.", comtradeSuccessfulRegistrationPage.hvalaNaRegistracijiGetText());

    }


    @Test
    public void sameEmailUnsuccessfulRegistrationTest(){

        comtradeHomePage
                .reklamaCloseClick()
                .otvoriNalogLinkClick();
        comtradeRegistrationPage
                .reeklamaRegistrationClick()
                .imeInputFieldSendKeys(ime)
                .prezimeInputFieldSedKeys(prezime)
                .emailInputFieldSendKeys("comtradenekimail@mailinator.com")
                .checkBoxclick()
                .lozinkaInputFieldSendKeys(lozinka)
                .potvrdaLozinkeInputFieldSendKeys(lozinka)
                .posaljiButtonClick();
        comtradeRegistrationPage.reeklamaRegistrationClick();
        Assert.assertTrue(comtradeRegistrationPage.postojiNalogMessageIsDisplayed());
        Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!", comtradeRegistrationPage.postojiNalogMessageGetText());

    }


    @Test
    public void passwordsAreNotTheSameTest(){

        comtradeHomePage
                .reklamaCloseClick()
                .otvoriNalogLinkClick();
        comtradeRegistrationPage
                .reeklamaRegistrationClick()
                .imeInputFieldSendKeys(ime)
                .prezimeInputFieldSedKeys(prezime)
                .emailInputFieldSendKeys(email)
                .checkBoxclick()
                .lozinkaInputFieldSendKeys(lozinka)
                .potvrdaLozinkeInputFieldSendKeys("12345")
                .posaljiButtonClick();
        comtradeRegistrationPage.reeklamaRegistrationClick();
        Assert.assertTrue(comtradeRegistrationPage.postojiNalogMessageIsDisplayed());
        Assert.assertEquals("Razlikuju se lozinka i potvrda lozinke!", comtradeRegistrationPage.postojiNalogMessageGetText());

    }

    @Test
    public void wrongEmail(){
        comtradeHomePage
                .reklamaCloseClick()
                .otvoriNalogLinkClick();
        comtradeRegistrationPage
                .reeklamaRegistrationClick()
                .imeInputFieldSendKeys(ime)
                .prezimeInputFieldSedKeys(prezime)
                .emailInputFieldSendKeys("wrongEmail")
                .checkBoxclick()
                .lozinkaInputFieldSendKeys(lozinka)
                .potvrdaLozinkeInputFieldSendKeys(lozinka)
                .posaljiButtonClick();
        Assert.assertTrue(comtradeRegistrationPage.invalidMailMessageIsDisplayed());
        Assert.assertEquals("The email must be a valid email address.", comtradeRegistrationPage.invalidMailMessageGetText());
    }

}
