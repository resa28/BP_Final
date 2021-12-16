package Feature;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class featureGrupChat {

    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.cicle.app/signin");

//--Login Cicle
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
        password.sendKeys("your password");
        WebElement checkbox = driver.findElement(By.id("c3"));
        checkbox.click();
        WebElement btnNextpassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        btnNextpassword.click();
        Thread.sleep(3000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://staging.cicle.app/");
        WebElement teamB = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/p"));
        teamB.click();
        Thread.sleep(3000);

//--group chat BC-8
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        WebElement groupchat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")));
        groupchat.click();
        Thread.sleep(3000);
        String URL1 = driver.getCurrentUrl();
        Assert.assertEquals(URL1, "https://staging.cicle.app/group-chats/615e9f8ed3cd859f6f3ca502");
        WebElement fillMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[4]/div/div[1]/div/div/div/p"));
        fillMessage.sendKeys("testing1");
        Thread.sleep(3000);
        WebElement btnSend = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[4]/div/div[2]/button"));
        btnSend.click();
        Thread.sleep(5000);

        driver.navigate().refresh();
        String URL2 = driver.getCurrentUrl();
        Assert.assertEquals(URL2, "https://staging.cicle.app/group-chats/615e9f8ed3cd859f6f3ca502");
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Group Chat Soal B";
        if (actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
    }

//--perfomance testing group chats
    @Test
    public void Test0() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.cicle.app/signin");

//--Login Cicle
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
        password.sendKeys("your password");
        WebElement checkbox = driver.findElement(By.id("c3"));
        checkbox.click();
        WebElement btnNextpassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        btnNextpassword.click();
        Thread.sleep(3000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://staging.cicle.app/");
        WebElement teamB = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/p"));
        teamB.click();
        Thread.sleep(3000);

        long start = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        WebElement webElement;
        try {
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")));
            System.out.println("The page load is too long!");
        } catch (TimeoutException ex) {
            long timeToLoad= (System.currentTimeMillis()-start);
            System.out.println("The page loaded in " +timeToLoad+ " seconds.");
            // Close loading window
            return;
        }
        webElement.click();
    }
}
