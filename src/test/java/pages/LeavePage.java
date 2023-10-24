package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LeavePage  extends CommonMethods {

@FindBy(xpath = "//span[text()='Leave']")
    public WebElement leaveTab;

@FindBy(xpath = "//div[@class='validation-form'][1]")
public WebElement leaveTable;

  public LeavePage(){
      PageFactory.initElements(driver, this);
  }
}
