package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Data trong nội bộ trang
    private String URL ="https://crm.anhtester.com/admin/";
    private String PAGETEXT = " Dashboard Options ";

    //Các Object
    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    String buttonDashboarh = "//div[@class='screen-options-btn']";

    By widgetQuickStatistics = By.xpath("//div[@id='widget-top_stats']");
    By checkboxQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");

    //Hàm xây dựng
    private WebDriver driver;
    public DashboardPage (WebDriver _driver){
        driver = _driver;

    }
    //Hàm xử lý
    public  void verifyDashboard(){
        //Kiểm tra URL chứa phần thuộc trang
        Assert.assertEquals(driver.getCurrentUrl(),URL,"URL chưa đúng với trang Darsboard");
        System.out.println("URL của DashBoarh: " + driver.getCurrentUrl());
        Assert.assertTrue(WebUI.checkElementExist(driver, buttonDashboarh),"Dashboard không tồn tại");
    }
    public void openCustomer(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();
    }
    public void checkboxQuickStatistics(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath(buttonDashboarh)).click();
        WebUI.waitForElementVisible(driver, 5,checkboxQuickStatistics);
        driver.findElement(checkboxQuickStatistics).click();
    }
    public void verifyFilterQuickStatistics(){
        //Kiểm tra hiển thi mặc định: checked
        Assert.assertTrue(WebUI.verifyElementVisible(driver,widgetQuickStatistics,5),"Widget QuickStatistics Không hiển thị mặc định checked ");
        //Kiểm tra khi Click vào: unchecked
        checkboxQuickStatistics();
        //Kiểm tra Widget trên đã bị ẩn (not visible)
        Assert.assertTrue(WebUI.verifyElementNOTVisible(driver,widgetQuickStatistics,5),"Widget QuickStatistics hiện tại chưa ẩn ");


    }
}
