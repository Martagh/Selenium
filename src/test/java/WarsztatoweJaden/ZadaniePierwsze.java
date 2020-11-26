package WarsztatoweJaden;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ZadaniePierwsze {
    private WebDriver driver;

    @Given("an open PrestaShop page")
    public void openPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
    }
    @When("log in")
    public void logIn() {
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
    }
    @Then("add first address")
    public void addAddress() {
        WebElement firstAddress = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        //WebElement firstAddress = driver.findElement(By.xpath("//*[@id=\"address-link\"]/span"));
        firstAddress.click();

        WebElement createNew =driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/i"));
        createNew.click();

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys("John");

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys("Royal St");

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys("London");

        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        postalCodeInput.sendKeys("01-001");

        WebElement countryInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryInput.click();
        countryInput.sendKeys("United Kingdom");

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys("111-222-333");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();
    }
    @And("check if address is correct")

            public void checkifcorrect(){
        List<WebElement> addresses = driver.findElements(By.tagName("article"));
        String addressText = addresses.get(addresses.size()-1).getText();
        Assert.assertTrue(addressText.contains("Royal St"));
        Assert.assertTrue(addressText.contains("London"));
        Assert.assertTrue(addressText.contains("01-001"));
        Assert.assertTrue(addressText.contains("United Kingdom"));
        Assert.assertTrue(addressText.contains("111-222-333"));

//delete address
        List<WebElement> addressesDel = driver.findElements(By.tagName("article"));
        WebElement lastAddress = addressesDel.get(addressesDel.size() - 1);
        WebElement deleteFromLastAddress = lastAddress.findElement(By.cssSelector("[data-link-action='delete-address']"));
        deleteFromLastAddress.click();
    }
}
