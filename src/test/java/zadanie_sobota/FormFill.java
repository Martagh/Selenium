package zadanie_sobota;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormFill {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void FillFormTest() {
        // przygotowanie danych
        String firstNameText = "Karol";

        // znajdź i wypełnij First Name
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        if (firstNameInput.isDisplayed()) {
            firstNameInput.sendKeys(firstNameText);
            WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='first-name']"));
            System.out.println(firstNameLabel.getText() + ":" + firstNameText);
        } else {
            Assert.fail("firstNameInput is not displayed.");
        }
        // znajdź i wypełnij pole Last Name
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Kowalski");

        //wybierz male
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id='infoForm']/div[3]/div/div/label[1]/input"));
        maleRadioButton.click();

        //znajdż i wypełnij date of birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dob"));
        dateOfBirthInput.sendKeys("05/22/2019");

        //znajdź i wypełnij address
        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("Prosta 51");

        // znajdź i wypełnij email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("karol.kowalski@mailinator.com");

        //znajdź i wypełnij password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Pass123");

        //znajdź i wypełnij company
        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys("Coders Lab");

        //znajdź i wypełnij comment

        WebElement commentInput = driver.findElement(By.id("comment"));
        commentInput.sendKeys("To jest mój pierwszy automat testowy");

    }

    @After
    public void tearDown() throws Exception {
       // Zamknij przeglądarkę
        driver.quit();
    }
}



