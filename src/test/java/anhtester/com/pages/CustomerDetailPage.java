package anhtester.com.pages;

import anhtester.com.keywords.WebUI;

import static anhtester.com.keywords.WebUI.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage {

    //Không phải khai báo lai
    //Không bi dupplecase
    //tiết kiệm thời gian
    //Lỡ có sai chỉ sửa ở 1 nơi.


    private WebDriver driver;

    public CustomerDetailPage(WebDriver _driver) {
        super(_driver);
        driver = _driver;
        new WebUI(driver);
    }

    public void checkCustomerDetail(String expectedCompany) {
        //Kết hợp thêm key static và * trong import để gọi tất cả cac hàm trong class mà không cần gọi tên class
        System.out.println(getAttributeElement(inputCompany, "value"));
//        System.out.println( WebUI.getAttributeElement(inputCompany,"value"));

        System.out.println(driver.findElement(inputVat).getAttribute("value"));
        System.out.println(driver.findElement(inputPhonenumber).getAttribute("value"));

        //Kết hợp thêm key static và * trong import để gọi tất cả cac hàm trong class mà không cần gọi tên class
        Assert.assertEquals(getAttributeElement(inputCompany, "value"), expectedCompany, "Get inputCompany chưa đúng");
//        Assert.assertEquals(WebUI.getAttributeElement(inputCompany,"value"),expectedCompany,"Get inputCompany chưa đúng");
        Assert.assertEquals(driver.findElement(inputVat).getAttribute("value"), "5%", "Get inputVat chưa đúng");
        Assert.assertEquals(driver.findElement(inputPhonenumber).getAttribute("value"), "0901667000", "Get inputPhonenumber chưa đúng");
    }
}
