package anhtester.com.testcases.learnParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Paralleltest {

    @Test
    public void ChromeDriver1() throws InterruptedException {
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }

    @Test
    public void EdgeTest2() throws InterruptedException {
        //WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }
    @Test
    public void ChromeDriver3() throws InterruptedException {
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }
    @Test
    public void ChromeDriver4() throws InterruptedException {
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }
    @Test
    public void EdgeTest5() throws InterruptedException {
        //WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }
}
