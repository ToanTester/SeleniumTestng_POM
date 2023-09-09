package anhtester.com.pages;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddCustomerPage extends CustomersPage {

    //Các thuộc tính xác thực
    private String URL = "https://crm.anhtester.com/admin/clients/client";
    private  String PAGETEXT = "Customer Details";

    public By tabCustomerDetails = By.xpath("//a[@aria-controls='contact_info']");
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVat = By.xpath("//input[@id='vat']");
    public By inputPhonenumber = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    private By clickGroups = By.xpath("//label[normalize-space()='Groups']/following-sibling::div");
    public By inputSearchGroups = By.xpath("//input[@aria-controls='bs-select-1']");
    private By buttonSave = By.xpath("(//button[normalize-space()='Save'])[2]");

    //By buttonSaveandcreatecontact = By.xpath(" //button[normalize-space()='Save and create contact']");


    private WebDriver driver;
    public AddCustomerPage(WebDriver _driver){
        super(_driver); //Tuân theo cấu trúc hàm xây dựng của thằng cha(CustomerPage)
        driver = _driver; //Khởi tạo driver của thằng con(AddCustomerPage)
        new WebUI(driver);
    }


    public void AddDataCustomer(String company, String website ){
        WebUI.sleep(1);
        driver.findElement(inputCompany).sendKeys(company);
        driver.findElement(inputVat).sendKeys("5%");
        driver.findElement(inputPhonenumber).sendKeys("0901667000");
        driver.findElement(inputWebsite).sendKeys(website);
        driver.findElement(clickGroups).click();
        WebUI.sleep(1);
        driver.findElement(inputSearchGroups).sendKeys("Gold", Keys.ENTER);
        WebUI.sleep(1);
        WebUI.srollToElement(buttonSave);
        WebUI.sleep(1);
        driver.findElement(buttonSave).click();
    }


}
