package WarsztatoweDwa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ZadanieDrugie {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");

    }

    @Test
    public void Login() {

// logowanie
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signIn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("Miceannot1990@einrot.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("miceannot");

        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();

// wybiera sweter
        WebElement clothesButton = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        clothesButton.click();

        WebElement HummingbirdSweater = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img"));
        HummingbirdSweater.click();

// wybiera rozmiar i ilosc
        WebElement size = driver.findElement(By.id("group_1"));
        size.sendKeys("L");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.clear();
        quantity.sendKeys("5");

//  dodaje do  koszyka
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCart.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// przechodzi do  kasy
        WebElement proceed = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceed.click();

        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        checkout.click();

//zaznacza adres,  metode dostawy i platnosci
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        continueButton.click();

        WebElement pickInStore = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span"));
        pickInStore.click();

        WebElement continueDelivery = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        continueDelivery.click();

        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        payByCheck.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//akceptuje regulaminn
        WebElement conditionsToapprove = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        conditionsToapprove.click();

// zamawia
        WebElement order = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        order.click();

    }

    @After
    public void screenShot() {

    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         try {
        FileUtils.copyFile(scrFile, new File("/Users/martasajewicz/Desktop/screen/screenshot.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
         driver.close();
    }

}






