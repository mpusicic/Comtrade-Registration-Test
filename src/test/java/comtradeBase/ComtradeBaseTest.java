package comtradeBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComtradeBaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);

        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/");
    }

    @After
    public void ternDown(){
        //TODO odkomentarisati na kraju
        //driver.quit();
    }
}
