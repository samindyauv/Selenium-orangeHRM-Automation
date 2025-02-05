package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Properties;
import static dataProviders.repositoryFileReader.constructElement;
import static dataProviders.repositoryFileReader.findElementRepo;

public class webSteps {

    protected static WebDriver driver;
    private final String username;
    private final String password;

    public webSteps(WebDriver driver) {
        webSteps.driver = driver;

        // Load email and password from properties file
        Properties properties = propertyLoader.loadProperties("src/main/resources/dataset.properties");
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
    }

    // Method to wait 5000ms
    public void waiting() throws InterruptedException {
        Thread.sleep(500);
    }

    // Common method to click an element
    public void click(String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement button =  driver.findElement(xpath);
        button.click();
        waiting();
    }

    // Common method to type text into an input field
    public void type(String text, String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement inputField = driver.findElement(xpath);
        inputField.clear();
        inputField.sendKeys(text);
        waiting();
    }

    public void loginSystem() throws InterruptedException {
        waiting();
        type(username, "username");
        type(password, "password");
        click("loginButton");
        waiting();
    }

    // Common method to get text from an element
    public String getText(String locator) {
        By xpath = constructElement(findElementRepo(locator));
        return driver.findElement(xpath).getText();
    }
}
