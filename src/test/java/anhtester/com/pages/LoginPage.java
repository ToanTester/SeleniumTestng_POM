package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {


    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";
    //Lưu object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo object cùng giá trị Locator tương ứng
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPass = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");


    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public LoginPage (WebDriver _driver){
        driver = _driver;
    }

    //Viết các hàm xử lý cho trang Login
    public void verifyheaderPage(){
        Assert.assertEquals(driver.findElement(headerPage).getText(),"Login","Tên headerPage chưa đúng");

    }
    public void verifyErrorMessageDisplay(){
        Assert.assertTrue(driver.findElement(messageErrorEmail).isDisplayed(),"Fail. message Không hiển thị");
        Assert.assertEquals(driver.findElement(messageErrorEmail).getText(),"Invalid email or password","Fail. Nội dung message Email chưa đúng");

    }
    public void  enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void  enterPass(String pass){
        driver.findElement(inputPass).sendKeys(pass);
    }
    public void  clickOnLoginButton(){
        driver.findElement(buttonLogin).click();

    }
    //Liên kết Page bài 19
    public DashboardPage login (String email, String pass){
        driver.get(URL);
        verifyheaderPage();
        enterEmail(email);
        enterPass(pass);
        clickOnLoginButton();

        return  new DashboardPage(driver);
    }


//    public void login (String email, String pass){
//        driver.get(URL);
//        verifyheaderPage();
//        enterEmail(email);
//        enterPass(pass);
//        clickOnLoginButton();
//    }

    public void loginInvalidEmail (String email, String pass){
        driver.get(URL);
        verifyheaderPage();
        enterEmail(email);
        enterPass(pass);
        clickOnLoginButton();
        //Kiểm tra message thông báo lỗi khi nhập sai email
        verifyErrorMessageDisplay();
    }

}//Đóng class
