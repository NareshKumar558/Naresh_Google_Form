package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public WebDriver driver;
    public WebDriverWait wait;

    public Wrappers(WebDriver driver){
        this.driver=driver;
    }

    public String getUrl(){
        return this.driver.getCurrentUrl();

    }
    public WebElement elementSearch(String x){
        return this.driver.findElement(By.xpath(x));
    }
    public void inputText(WebElement input,String x){
        input.sendKeys(x);
    }
    public void select(WebElement input){
        input.click();
    }
    public void inputTextDate(WebElement input, String x){
        input.sendKeys(x);
    }
    public String getMessage(WebElement input){
        return input.getText();
    }
    
}
