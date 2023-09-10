package anhtester.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        setupDriver(browser);
    }

    public static WebDriver setupDriver(String browserName) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver != null) {
            driver.quit();
        }
    }
//    public WebDriver driver;
//
//    @BeforeMethod
//    public void createDriver() {
//        //WebDriverManager.chromedriver().setup();
//        System.out.println("Start Chrome browser");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //pageLoadTimeout: Chờ đợi Page load xong khoảng thời gian 30s
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//    }
//
//    @AfterMethod
//    public void closeDriver() {
//        System.out.println("Close Chrome browser");
//        driver.quit();
//    }
}
