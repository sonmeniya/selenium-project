package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_AND_PLATFORM;
import static constans.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM){
            case "CHROME_WINDOWS" :
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
//            case "CHROME_MAC" :
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/googlechrome.dmg");
//                driver = new ChromeDriver();
//                break;
//            case "MOZILLA_MAC" :
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//                driver = new FirefoxDriver();
//                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME" + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return  driver;
    }
}
