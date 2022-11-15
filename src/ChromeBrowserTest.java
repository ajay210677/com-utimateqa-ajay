import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args) {


        String url = "https://courses.ultimateqa.com/users/sign_in";


        //Set chrome driver path
        System.setProperty("Webdriver.chrom.driver", "drivers/chromedriver.exe");

        //Start Chrome browser
        WebDriver driver = new ChromeDriver();

        //Open Url
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get title of loaded page
        System.out.println("Page Title is" + driver.getTitle());

        //Get current URL
        System.out.println("Current URL IS: " + driver.getCurrentUrl());

        //Get web elements or page source
        System.out.println("Page Source is; " + driver.getPageSource());

        //fine and enter email in username field element
        WebElement usernameField = driver.findElement(By.name("user[email]"));
        usernameField.sendKeys("Admin");

        //Find and enter password in password field element
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("admin123");
        //Close browser
        driver.quit();
    }
}
