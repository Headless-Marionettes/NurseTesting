import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreatePatient {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupDriver() {
        driver = Webdriver.getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test(priority = 1)
    public void testTitle() {
        Assert.assertEquals(driver.getTitle(), "Super Nurse | Patients List");
    }

    @Test(priority = 2)
    public void MoveToCreatePatient() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[1]/a"))
                .click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Super Nurse | Create Patient");
    }

    @Test(priority = 3)
    public void FilledTheForm() throws InterruptedException {

        driver.findElement(By.id("patientFirstName"))
                .sendKeys("AutoTestF");

        driver.findElement(By.id("patientLastName"))
                .sendKeys("AutoTestL");

        driver.findElement(By.id("patientSex"))
                .sendKeys("M");

        driver.findElement(By.id("patientRoom"))
                .sendKeys("1000");

        driver.findElement(By.id("patientHeight"))
                .sendKeys("100");

        driver.findElement(By.id("patientWeight"))
                .sendKeys("100");

        driver.findElement(By.id("patientBloodType"))
                .sendKeys("AB+");

        driver.findElement(By.id("patientDateOfBirth"))
                .sendKeys("12/12/1920");

        driver.findElement(By.id("patientAlergies"))
                .sendKeys("100");

        driver.findElement(By.id("submit-button"))
                .click();

        Thread.sleep(1);

    }

    @Test(priority = 4)
    public void CHeckNewPat() throws InterruptedException {
        Thread.sleep(1);

        List<WebElement> patients = driver.findElements(By.xpath("//*[@id=\"patients\"]/div/a/div[2]/*[@id=\"FullNameID\"]"));

        List<String> names = new ArrayList<>();

        for (WebElement patient : patients) {
            names.add(patient.getText());
        }

        Assert.assertEquals(names.contains("AutoTestF AutoTestL"), true);
    }


}
