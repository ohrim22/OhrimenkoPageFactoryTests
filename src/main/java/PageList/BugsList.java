package PageList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BugsList {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"gridview-1028\"]/table/tbody/tr[2]/td[3]")
    private WebElement firstBug;

    @FindBy(className = "x-form-field x-form-text")
    private WebElement bugNameField;

    @FindBy(xpath = "//*[@id=\"ext-gen1533\"]")
    private WebElement newBugName;


    public BugsList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BugsList findFirstBug() {
        firstBug.click();
        return this;
    }

    public  String getFirstBugName() {
        return firstBug.getText();
    }


    public BugsList openPage(String url) {
        driver.get(url);
        return this;
    }

    public BugsList populateBugName(String name) {
        bugNameField.sendKeys(name);
        return this;
    }

    public String getNewBugName() {
        return newBugName.getText();
    }

    public List<BugsList> getBugs() {
        List<BugsList> actualBugs = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.className(" x-grid-cell x-grid-cell-gridcolumn-1020"));

        for(WebElement el: elements) {
            if(el.isDisplayed()){
                actualBugs.add((BugsList) el);

            }
        }
        return actualBugs;
    }

}
