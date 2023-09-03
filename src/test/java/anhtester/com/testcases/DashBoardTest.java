package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.CustomersPage;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenMenuDashboard (){
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboard();

        //Kiểm tra mở trang customer khi Click vào menu customer
        dashboardPage.openCustomer();
        customersPage = new CustomersPage(driver);
        customersPage.verifyCustomer();
    }
    @Test
    public void testFilterWidgeOnDashboard (){
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboard();
        //Check filter Widgets on DashBoarh
        //dashboardPage.checkboxQuickStatistics();
        dashboardPage.verifyFilterQuickStatistics();


    }

}
