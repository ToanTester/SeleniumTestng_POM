package anhtester.com.pages;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CustomersPage{
    //Các thuộc tính xác thực
    private String URL = "https://crm.anhtester.com/admin/clients";
    private  String PAGETEXT = "Customers Summary";
    //Object thuộc tính Customers Page
    String headerPageCustomer = "(//div[@class='panel-body']//h4)[1]";
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[normalize-space()='Contacts']");
    private By inputSeach = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By chucNangSearch = By.xpath("//input[@aria-controls='DataTables_Table_0']");
    private By tdCompany = By.xpath("//tbody/tr[1]/td[3]/a");
    //private By chucNangSearch = By.xpath("");


    //Hàm xây dựng
    private WebDriver driver;
    public CustomersPage (WebDriver _driver){

        driver = _driver;
        new WebUI(driver); //Khởi tạo class webUI để truyền giá trị driver bên ngoài vào WebUI
    }

    //Các hàm xử lý
    public void verifyCustomer(){
        Assert.assertEquals(driver.getCurrentUrl(),URL ,"URL chưa đúng với trang Darsboard");
        System.out.println("URL của Customer: " + driver.getCurrentUrl());
        Assert.assertTrue(WebUI.checkElementExist(headerPageCustomer),"Element không tồn tại");
        Assert.assertEquals(driver.findElement(By.xpath(headerPageCustomer)).getText(),PAGETEXT,"Tên headerPage của Customer Chưa đúng");

    }

    public AddCustomerPage clickbuttonNewCustomer(){
        WebUI.waitForElementVisible(5,buttonNewCustomer);
        driver.findElement(buttonNewCustomer).click();
        return new AddCustomerPage(driver);
    }

    public void seachDataCustomer(String company){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(5,chucNangSearch);
        driver.findElement(chucNangSearch).sendKeys(company, Keys.ENTER);
        WebUI.sleep(2);

    }

    public CustomerDetailPage clickTdCompany(){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(5,tdCompany);
        driver.findElement(tdCompany).click();
        return new CustomerDetailPage(driver);
    }

}
