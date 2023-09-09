package anhtester.com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage {

    //Không phải khai báo lai
    //Không bi dupplecase
    //tiết kiệm thời gian
    //Lỡ có sai chỉ sửa ở 1 nơi.


    private WebDriver driver;
    public CustomerDetailPage (WebDriver _driver){
        super(_driver);
        driver = _driver;
    }

    public void checkCustomerDetail(String expectedCompany){
        System.out.println( driver.findElement(inputCompany).getAttribute("value"));
        System.out.println( driver.findElement(inputVat).getAttribute("value"));
        System.out.println( driver.findElement(inputPhonenumber).getAttribute("value"));

//        Assert.assertEquals("","","");
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"),expectedCompany,"Get inputCompany chưa đúng");
        Assert.assertEquals(driver.findElement(inputVat).getAttribute("value"),"5%","Get inputVat chưa đúng");
        Assert.assertEquals(driver.findElement(inputPhonenumber).getAttribute("value"),"0901667000","Get inputPhonenumber chưa đúng");
    }
}
