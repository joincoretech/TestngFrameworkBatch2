package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LeaveTest  extends CommonMethods {

    @Test(groups = "regression")
    public void validateLeaveTable(){
        LoginPage loginPage=new LoginPage();
        loginPage.userNameBox.sendKeys(ConfigReader.getPropertiesValue("userName"));
        loginPage.passwordBox.sendKeys(ConfigReader.getPropertiesValue("password"));
        loginPage.submitBtn.click();

        LeavePage leavePage=new LeavePage();
        leavePage.leaveTab.click();
        Assert.assertTrue(leavePage.leaveTable.isDisplayed());
    }

}
