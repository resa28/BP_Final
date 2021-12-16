package Feature;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class featureLogin {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.cicle.app/signin");

//--board BC-2
        WebElement btnSignIn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/button[1]/div/span"));
        btnSignIn.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("zzxxahmad92@gmail.com");
        Thread.sleep(3000);
        WebElement btnNextemail = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        btnNextemail.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        password.sendKeys("resacantik");
        WebElement checkbox = driver.findElement(By.id("c3"));
        checkbox.click();
        WebElement btnNextpassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        btnNextpassword.click();
        Thread.sleep(3000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://staging.cicle.app/");
        WebElement teamB = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/p"));
        teamB.click();
    }
}
