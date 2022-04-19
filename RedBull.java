package SereniumApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBull {

    public static  void  main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pavel\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://bulletins-pu.thomasmurray.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("test_password");
        driver.findElement(By.className("button1")).click();
        driver.quit();
    }

}
