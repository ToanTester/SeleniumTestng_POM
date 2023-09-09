package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.AddCustomerPage;
import anhtester.com.pages.CustomersPage;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    AddCustomerPage addCustomerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomer();

        customersPage.verifyCustomer();
        addCustomerPage = customersPage.clickbuttonNewCustomer();
        addCustomerPage.AddDataCustomer("Công ty FPT","FPT.com");

    }
    @Test
    public void testseachDataCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomer();
        customersPage.verifyCustomer();

        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.seachDataCustomer("Công ty FPT");
    }
}
