import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {
    private static Webdriver ourInstance = new Webdriver();
    public static Webdriver getInstance() {
        return ourInstance;
    }

    static WebDriver driver;

    private Webdriver() {
        System.setProperty("webdriver.chrome.driver","/Users/Veronika-Kot/madp/web/NurseTesting/chromedriver");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
