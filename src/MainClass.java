import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupDriver() {
        driver = Webdriver.getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test(priority = 1)
    public void testTitle() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "Super Nurse | Login");
    }

    @Test (priority = 2)
    public void testWrongEmail() {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("wrong+email@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("123");

        driver.findElement(By.id("sign-in-button"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("invalid-feedback")));

        String errorMessage = driver.findElements(By.className("invalid-feedback")).get(0).getText();

        Assert.assertEquals(errorMessage, "Authentication failed");
    }

    @Test (priority = 3)
    public void testWrongPassword() {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("user1@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("1235");

        driver.findElement(By.id("sign-in-button"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("invalid-feedback")));

        String errorMessage = driver.findElements(By.className("invalid-feedback")).get(0).getText();

        Assert.assertEquals(errorMessage, "Authentication failed");
    }

    @Test (priority = 4)
    public void testLogin() {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("user1@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("123");

        driver.findElement(By.id("sign-in-button"))
                .click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test(priority = 5)
    public void testTitleList() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Super Nurse | Patients List");
    }
}
