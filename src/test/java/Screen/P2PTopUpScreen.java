package Screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P2PTopUpScreen {
    By senderCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By receiverCard = By.xpath("//input[@data-qa-node='numberreceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By submitButton = By.xpath("//button[@type='submit']");

    String p2pTopUpUrl = "https://next.privat24.ua/money-transfer/card";

    private static WebDriver driver;

    public P2PTopUpScreen(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get(p2pTopUpUrl);
    }
    public void fillSenderCard(String senderCard){
        driver.findElement(this.senderCard).sendKeys(senderCard);
    }
    public void fillExpiredDate(String expiredDate){
        driver.findElement(this.expiredDate).sendKeys(expiredDate);
    }
    public void fillCvv(String cvv){
        driver.findElement(this.cvv).sendKeys(cvv);
    }
    public void fillReceiverCard(String receiverCard){
        driver.findElement(this.receiverCard).sendKeys(receiverCard);
    }
    public void fillAmount(String amount){
        driver.findElement(this.amount).click();

        while (!driver.findElement(this.amount).getAttribute("value").equals("")){
            driver.findElement(this.amount).sendKeys(Keys.BACK_SPACE);
        }

        driver.findElement(this.amount).sendKeys(amount);
    }
    public void submitButtonClick(){
        driver.findElement(this.submitButton).submit();
    }

    public void fillForm(String senderCard, String monthYear, String cvv, String receiverCard, String amount) throws InterruptedException {
        fillSenderCard(senderCard);
        fillExpiredDate(monthYear);
        fillCvv(cvv);
        fillReceiverCard(receiverCard);
        fillAmount(amount);
        submitButtonClick();
        Thread.sleep(4000); // Just for visualisation
    }
}
