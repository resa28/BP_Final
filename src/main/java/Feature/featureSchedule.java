package Feature;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class featureSchedule {

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

//--schedule BC-10
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        WebElement scheduleMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[3]/a/div/div/div[1]")));
        scheduleMenu.click();
        Thread.sleep(3000);
        String URL1 = driver.getCurrentUrl();
        Assert.assertEquals(URL1, "https://staging.cicle.app/schedules/615e9f8ed3cd8545cd3ca508");
        Thread.sleep(3000);
        WebElement createEvent = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button"));
        createEvent.click();
        String URL2 = driver.getCurrentUrl();
        Assert.assertEquals(URL2, "https://staging.cicle.app/schedules/615e9f8ed3cd8545cd3ca508/create");
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input"));
        title.sendKeys("event");
        WebElement starts = driver.findElement(By.id("date-picker-dialog-start"));
        WebElement timeStarts = driver.findElement(By.id("time-picker"));
        WebElement ends = driver.findElement(By.id("date-picker-dialog-end"));
        WebElement timeEnds = driver.findElement(By.id("time-picker"));
        Thread.sleep(3000);
        WebElement repeat = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div"));
        repeat.click();
        WebElement repeat2 = driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[2]"));
        Thread.sleep(3000);
        repeat2.click();
        Thread.sleep(3000);
        WebElement with = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[3]/div[1]/div[2]"));
        with.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Add/Remove Subscribers";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        Thread.sleep(3000);
        WebElement members = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div[3]/div[3]/div[3]/div[3]"));
        members.click();
        Thread.sleep(3000);
        WebElement closeIcon = driver.findElement(By.cssSelector("div.ManageSubscribersContainer_ManageSubscribersContainer__Header__1jlWK > svg.MuiSvgIcon-root > path"));
        closeIcon.click();
        Thread.sleep(3000);
        WebElement notes = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[5]/div/div[3]/div"));
        notes.sendKeys("notes");
        Thread.sleep(3000);
        WebElement btnPostEvent = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[2]/button[1]"));
        btnPostEvent.click();
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Schedule";
        if(actualTitle1.equalsIgnoreCase(expectedTitle1))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
    }


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
        Thread.sleep(3000);

//--schedule fail BC-11
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        WebElement scheduleMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[3]/a/div/div/div[1]")));
        scheduleMenu.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Schedule";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        Thread.sleep(3000);
        WebElement createEvent = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button"));
        createEvent.click();
        String URL2 = driver.getCurrentUrl();
        Assert.assertEquals(URL2, "https://staging.cicle.app/schedules/615e9f8ed3cd8545cd3ca508/create");
        Thread.sleep(3000);
        WebElement btnPostEvent = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[2]/button[1]"));
        btnPostEvent.click();
        Thread.sleep(3000);
        String exp = "Event title cannot be empty";
        WebElement m1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("notistack-snackbar")));
        m1.isDisplayed();
        String act = m1.getText();
        System.out.println("Message is: Event title cannot be empty "+ act);
        //verify message with Assertion
        Assert.assertEquals(exp, act);
    }
}

