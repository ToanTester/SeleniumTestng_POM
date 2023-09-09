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

    private By tabCustomerDetails = By.xpath("//a[@aria-controls='contact_info']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVat = By.xpath("//input[@id='vat']");
    private By inputPhonenumber = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputSearchGroups = By.xpath("//input[@aria-controls='bs-select-1']");
    private By clickGroups = By.xpath("//label[normalize-space()='Groups']/following-sibling::div");
    private By buttonSave = By.xpath("(//button[normalize-space()='Save'])[2]");
    private By chucNangSearch = By.xpath("//input[@aria-controls='DataTables_Table_0']");
    //By buttonSaveandcreatecontact = By.xpath(" //button[normalize-space()='Save and create contact']");


    private WebDriver driver;
    public AddCustomerPage(WebDriver _driver){
        super(_driver); //Tuân theo cấu trúc hàm xây dựng của thằng cha(CustomerPage)
        driver = _driver; //Khởi tạo driver của thằng con(AddCustomerPage)
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
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(buttonSave)).perform();
        WebUI.sleep(1);
        driver.findElement(buttonSave).click();

    }

    public void seachDataCustomer(String company){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(chucNangSearch).sendKeys(company, Keys.ENTER);
        WebUI.sleep(2);
    }

}
