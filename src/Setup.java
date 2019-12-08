import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;

    @BeforeSuite
    public void setupDriver() throws InterruptedException {
        Webdriver dr = Webdriver.getInstance();

        driver = dr.getDriver();
        driver.get("http://localhost:3000/index.html");

        Thread.sleep(1000);
        Reporter.log("Setted up a driver singleton");
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
