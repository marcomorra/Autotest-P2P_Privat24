import Screen.P2PTopUpScreen;
import Screen.TransferPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P2PTopUpTest {
    private WebDriver driver;
    private P2PTopUpScreen p2pTopUpScreen;
    private TransferPage transferPage;

    String senderCard = "5168742720441819";
    String monthYear = "1124";
    String cvvNumber = "123";
    String receiverCard = "5354321098131429";
    String minAmount = "1";
    String maxAmount = "29999";
    String expectedFromCardValue = "5168 7427 2044 1819";
    String expectedToCardValue = "5354 3210 9813 1429";
    String expectedMinAmount = "1";
    String expectedMaxAmount = "29 999";


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        p2pTopUpScreen = new P2PTopUpScreen(driver);
        transferPage = new TransferPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        p2pTopUpScreen.navigate();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTopUpMinSum() throws InterruptedException {
        p2pTopUpScreen.fillForm(senderCard, monthYear, cvvNumber, receiverCard, minAmount);
        transferPage.checkCartScreen(expectedFromCardValue, expectedToCardValue, expectedMinAmount);
    }
    @Test
    public void checkTopUpMaxSum() throws InterruptedException {
        p2pTopUpScreen.fillForm(senderCard, monthYear, cvvNumber, receiverCard, maxAmount);
        transferPage.checkCartScreen(expectedFromCardValue, expectedToCardValue, expectedMaxAmount);
    }
}
