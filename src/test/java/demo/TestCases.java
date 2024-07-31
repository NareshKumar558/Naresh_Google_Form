package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    private Wrappers wrappers;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    @Test
    public void testCase01() {
        try {
            System.out.println("Start Test case: testCase01");
            // hit url
            driver.get(
                    "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
            Thread.sleep(2000);
            // String CurrentURL=driver.getCurrentUrl();
            String x = this.wrappers.getUrl();
            String y = "forms";
            if (x.contains(y)) {
                System.out.println("URL is correct");
            } else {
                System.out.println("URL is not correct");
            }

            //name
            WebElement name = wrappers.elementSearch("//input[@aria-describedby='i2 i3']");
            //send name
            wrappers.inputText(name, "Crio Learner");

            //practicing Automation?
            WebElement pauto = wrappers.elementSearch("//textarea[@aria-describedby='i6 i7']");
            //send practicing Automation?
            wrappers.inputText(pauto, "I want to be the best QA Engineer! 1710572021");

            //experience
            WebElement experience= wrappers.elementSearch("//div[@id='i13']");
            //click option
            wrappers.select(experience);

            //java
            WebElement java= wrappers.elementSearch("//div[@id='i30']");
            //click option
            wrappers.select(java);

            //selenium
            WebElement selenium= wrappers.elementSearch("//div[@id='i33']");
            //click option
            wrappers.select(selenium);

            //testNG
            WebElement testNG= wrappers.elementSearch("//div[@id='i39']");
            //click option
            wrappers.select(testNG);

            //dropdown
            WebElement dropdown= wrappers.elementSearch("(//div[@jsname='wQNmvb'])[1]");
            //click option
            wrappers.select(dropdown);

            Thread.sleep(1000);

            //select Mr  
            WebElement mr= wrappers.elementSearch("(//div[@data-value='Mr'])[2]");
            //click option
            wrappers.select(mr);

            //date  
            WebElement date= wrappers.elementSearch("//input[@type='date']");
            //send date
            wrappers.inputTextDate(date,"24-07-2024");

            //hr time
            WebElement hr= wrappers.elementSearch("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input");
            //send time
            wrappers.inputTextDate(hr,"07");

            //min time
            WebElement min= wrappers.elementSearch("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input");
            //send time
            wrappers.inputTextDate(min,"30");

            //submit
            WebElement submit= wrappers.elementSearch("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div");
            //send time
            wrappers.select(submit);


            Thread.sleep(5000);

            //get success message
            WebElement message= wrappers.elementSearch("//div[@class='vHW8K']");
            //send time
            String mess=wrappers.getMessage(message);
            if(mess.contains("Thanks for your response, Automation Wizard!")){
                System.out.println("Correct message");
            }
            else{
                System.out.println("Incorrect message");
            }

            System.out.println("end Test case: testCase01");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("TestCase01 Failed!");
        }

    }

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        // might have to change
        wrappers = new Wrappers(driver);

        //driver.manage().timeouts().PageLoadTimeOut(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}