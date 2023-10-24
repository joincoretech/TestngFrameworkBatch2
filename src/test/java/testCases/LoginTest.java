package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTest extends CommonMethods {
@Test(groups = "regression")
 public void loginTest(){
   LoginPage loginPage=new LoginPage();
   loginPage.userNameBox.sendKeys(ConfigReader.getPropertiesValue("userName"));
   loginPage.passwordBox.sendKeys(ConfigReader.getPropertiesValue("password"));
   loginPage.submitBtn.click();

    DashboardPage dashboardPage=new DashboardPage();
    Assert.assertTrue(dashboardPage.hrmText.isDisplayed(),
            "Dashboard page is not displayed");
 }

 @DataProvider
 public Object[][] inValidData(){
     Object[][] data={
             {"admin@gmail.com",    "admin123", "Username and Password is Wrong!"},
             {"admin@yahoo.com",    "admin#123", "Username and Password is Wrong!"},
             {"admin@gmail.com",    "", "UserName and Password is required"},
             {"admin@gmail.com",    "", "UserName and Password is required"}
     };
    return data;
 }

 @Test(dataProvider = "inValidData", groups = "smoke")
 public void inValidLoginMessageValidation(String username, String password, String errorMessage){
    LoginPage loginPage=new LoginPage();
    loginPage.userNameBox.sendKeys(username);
    loginPage.passwordBox.sendKeys(password);
    loginPage.submitBtn.click();

    Assert.assertEquals(loginPage.errorMessage.getText(), errorMessage);

 }


}
