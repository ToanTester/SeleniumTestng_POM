package anhtester.com.pages;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersPage{
    private String URL = "https://crm.anhtester.com/admin/clients";
    private  String PAGETEXT = "Customers";
    String headerPageCustomer = "//div[@class='panel-body']//h4[contains(.,'"+ PAGETEXT +"')]";
    //By headerPageCustomer = By.xpath("//div[@class='panel-body']//h4[contains(.,'"+ PAGETEXT +"')]");
    private WebDriver driver;
    public CustomersPage (WebDriver _driver){

        driver = _driver;
    }

    public  void verifyCustomer(){
        Assert.assertEquals(driver.getCurrentUrl(),URL,"URL chưa đúng với trang Darsboard");
        System.out.println("URL của Customer: " + driver.getCurrentUrl());
       // Assert.assertTrue(driver.findElement(headerPageCustomer).isDisplayed(),"Name headerPage không đúng");
        System.out.println("Trạng thái Name headerPage : " + driver.getCurrentUrl());
        Assert.assertTrue(WebUI.checkElementExist(driver, headerPageCustomer),"Element không tồn tại");
        Assert.assertEquals(driver.findElement(By.xpath(headerPageCustomer)).getText(),"Customers Summary","Tên headerPage của Customer Chưa đúng");

    }

}
