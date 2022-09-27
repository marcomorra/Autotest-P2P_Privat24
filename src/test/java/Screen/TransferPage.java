package Screen;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {
    By fromCard = By.xpath("//span[@data-qa-node='payer-card']");
    By toCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By amount = By.xpath("//div[@data-qa-node='payer-amount']");

    private static WebDriver driver;

    public TransferPage(WebDriver driver){
        this.driver = driver;
    }
    public String getFromCardValue(){
        return driver.findElement(fromCard).getText();
    }
    public String getToCardValue(){
        return driver.findElement(toCard).getText();
    }
    public String getAmount(){
        return driver.findElement(amount).getText();
    }
    public void checkFromCardValue(String fromCardValue){
        Assert.assertEquals(fromCardValue, getFromCardValue());
    }
    public void checkToCardValue(String toCardValue){
        Assert.assertEquals(toCardValue, getToCardValue());
    }
    public void checkAmount(String amount){
        Assert.assertEquals(amount, getAmount());
    }
    public void checkCartScreen(String fromCard, String toCard, String amount){
        checkToCardValue(toCard);
        checkFromCardValue(fromCard);
        checkAmount(amount + " UAH");
    }
}
