package PageList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BottomPanel {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"ext-gen1087\"]")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"ext-gen1322\"]")
    private WebElement bugNameField;

    public BottomPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BugsList clickOnAddButton() {
        addButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(bugNameField));
        return new BugsList(driver);
    }


}
