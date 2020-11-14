package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;


public class ZadanieDodtkowe {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");


    }
    @Test
    public void testMyStore() {
        String[] products = {"mug", "t-shirt", "notebook", "cushion", "graphics"};

        Random random = new Random();
        int randomInteger = random.nextInt(products.length);
        //int randomInteger = random.nextInt(50);//  losuje liczby z przedziału 0 - 49
        //int wynik_dzielenia = randomInteger / products.length ;
        WebElement element = driver.findElement(By.name("s"));
        element.clear();
        //element.sendKeys(products[wynik_dzielenia]);
        element.sendKeys(products[randomInteger]);
        element.submit();
    }
    @After
    public void tearDown() throws Exception {
         //Zamknij przeglądarkę
        driver.quit();
    }
}
