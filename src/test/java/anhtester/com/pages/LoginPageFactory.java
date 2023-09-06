package anhtester.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";
    //Khai báo object
    @FindBy(xpath = "//h1")
    private WebElement headerPage ;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPass;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    //Khai báo ham xây dựng
    private WebDriver driver;
    public LoginPageFactory(WebDriver _driver){
        driver = _driver;
        //Goi hàm initElement của class PageFactory để khởi tao các WebElement bên trên.
        PageFactory.initElements(_driver,this);
    }
    public void Login(String email, String pass){
        driver.get(URL);
        inputEmail.sendKeys(email);
        inputPass.sendKeys(pass);
        buttonLogin.click();
    }

}
