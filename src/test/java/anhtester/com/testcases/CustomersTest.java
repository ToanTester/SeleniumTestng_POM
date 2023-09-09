package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.*;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    AddCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;

    @Test
    public void testAddNewCustomer()
    {
        String companyName ="Công ty FSoft";
        String websiteName ="FSoft.com";

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomer();
        customersPage.verifyCustomer();
        addCustomerPage = customersPage.clickbuttonNewCustomer();
        addCustomerPage.AddDataCustomer(companyName, websiteName);

    }
    @Test
    public void testSeachDataCustomer()
    {
        String companyName ="Công ty FSoft";

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomer();
        customersPage.verifyCustomer();
        customersPage.seachDataCustomer(companyName);
        customerDetailPage = customersPage.clickTdCompany(); //Click vào name của TdCompany
        customerDetailPage.checkCustomerDetail(companyName);
    }
}
