package anhtester.com.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

    public static WebDriver driver;

    public WebUI(WebDriver _driver) {
        driver = _driver;
    }

    public static void openURL(String URL) {
        driver.get(URL);
        waitForPageLoaded();
    }

    public static WebElement getElement(By by) {
        return driver.findElement(by);
    }
    public static void clickElement(By by) {
       getElement(by).click();
    }

    public static void setText(By by, String value){
        getElement(by).sendKeys(value);
    }
    public static String getTextElement(By by){
        return getElement(by).getText();
    }
    public static String getAttributeElement(By by, String attributeName){
        return getElement(by).getAttribute(attributeName);
    }
    public static void srollToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(by)).build().perform();
    }
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(int second, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));
        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + "exiting.");
            return true;
        } else {
            System.out.println("Element" + xpath + "NOT exits.");
            return false;
        }
    }

    public static boolean verifyElementVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean verifyElementNOTVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }

    }

    //     * Wait for Page loaded
//     * Chờ đợi trang tải xong (Javascript tải xong)
//     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
}
