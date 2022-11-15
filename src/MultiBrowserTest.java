import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "chrome";
    static String baseurl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {
        // Multidriver setup
        if (browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else{
            System.out.println("Wrong Browser name");
        }
        // Launch Url
        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Print the title of the page
        System.out.println("Title of the page is " + driver.getTitle());

        //Print the current url
        System.out.println("Current url is " + driver.getCurrentUrl());

        //print the page source
        System.out.println(" Page source is " + driver.getPageSource());

        // Find and enter email field
        WebElement email = driver.findElement(By.name("user[email]"));
        email.sendKeys("ajay@123");

        // enter password field
        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("ajay123");
        //Close
        driver.quit();

    }
}
