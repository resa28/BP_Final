package Feature;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class featureBoard {

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

//--board BC-1
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        WebElement boardMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")));
        boardMenu.click();
        Thread.sleep(3000);
        WebElement cardA = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"listcard_content-1\"]/div/div/div/a")));
        cardA.click();
        WebElement comment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[1]/div[2]/form/input")));
        comment.click();
        WebElement fillComment = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[1]/div[2]/form/div[1]/div/div[2]/div/p"));
        fillComment.sendKeys("testtt");
        WebElement btnSave = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[1]/div[2]/form/div[2]/div/button/div"));
        btnSave.click();
        Thread.sleep(3000);
        String exp = "Request failed with status code 500";
        WebElement m = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("notistack-snackbar")));
        m.isDisplayed();
        String act = m.getText();
        System.out.println("Message is: Request failed with status code 500 "+ act);
        //verify message with Assertion
        Assert.assertEquals(exp, act);

//--board BC-4
        String actualTitle = driver.getTitle();
        String expectedTitle = "A";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        WebElement btnEdit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[4]/div[1]/p")));
        btnEdit.click();
        WebElement editText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/p")));
        editText.sendKeys("neww");
        WebElement btnSaveedit = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[2]/div/form/div[2]/div/button/div"));
        btnSaveedit.click();

// harus direfresh supaya tidak menjadi blocking scenario bc-6 (error 401 ketika klik button delete)
        driver.navigate().refresh();

//--board BC-6
        String URL2 = driver.getCurrentUrl();
        Assert.assertEquals(URL2, "https://staging.cicle.app/cards/61724cdabc729e69d874ff84");
        WebElement btnDelete = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[4]/div[3]/p")));
        btnDelete.click();
        String exp1 = "Deleting a comment is forever. There is no undo.";
        WebElement m1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[4]/div[4]/div[3]")));
        m1.isDisplayed();
        String act1 = m1.getText();
        System.out.println("Message is: Deleting a comment is forever. There is no undo "+ act1);
        //verify message with Assertion
        Assert.assertEquals(exp1, act1);
        Thread.sleep(3000);
        WebElement btnDelete2 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[7]/div/div[1]/div[3]/div/div[2]/div[4]/div[4]/div[4]/button/div"));
        btnDelete2.click();
        Thread.sleep(3000);
        String exp2 = "delete comment is success";
        WebElement m2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("notistack-snackbar")));
        m2.isDisplayed();
        String act2 = m2.getText();
        System.out.println("Message is: delete comment is success "+ act2);
        //verify message with Assertion
        Assert.assertEquals(exp2, act2);
        Thread.sleep(3000);
        WebElement test = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[2]/div[1]/p"));
        Actions actions = new Actions(driver);
        actions.moveToElement(test);
        actions.perform();
        Thread.sleep(3000);
        WebElement closeCards1 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button/span[1]"));
        closeCards1.click();
        Thread.sleep(3000);

//--board BC-5
        String URL3 = driver.getCurrentUrl();
        Assert.assertEquals(URL3, "https://staging.cicle.app/boards/615e9f8ed3cd857e473ca500");
        Thread.sleep(3000);
        WebElement cardA1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"listcard_content-1\"]/div/div/div/a")));
        cardA1.click();
        Thread.sleep(3000);
        WebElement iconPlus = driver.findElement(By.cssSelector("div.Members_plusButton__26WlU > svg.MuiSvgIcon-root > path"));
        iconPlus.click();
        Thread.sleep(3000);
//        WebElement searchMembers = driver.findElement(By.cssSelector("input.form-control"));
//        searchMembers.sendKeys("Resa Nirmaya Sari");
//        Thread.sleep(3000);
//        searchMembers.click();
        WebElement members = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[4]/div[3]"));
        Thread.sleep(3000);
        members.click();
        Thread.sleep(3000);
        WebElement iconClose = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button/span[1]"));
        iconClose.click();
        Thread.sleep(3000);

//--board BC-12
        String URL4 = driver.getCurrentUrl();
        Assert.assertEquals(URL4, "https://staging.cicle.app/boards/615e9f8ed3cd857e473ca500");
        Thread.sleep(3000);
        WebElement from = driver.findElement(By.xpath("//*[@id=\"listcard_content-0\"]/div[1]/div/div"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(from,252, 95).clickAndHold().build().perform();
        Thread.sleep(3000);
        driver.navigate().refresh();

//--board BC-7
        Thread.sleep(3000);
        WebElement iconNotif = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/div[1]/div[2]"));
        iconNotif.click();
        Thread.sleep(3000);
        WebElement viewAllnotif = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/div[1]/div[3]/div[3]/div[2]/button"));
        viewAllnotif.click();
        Thread.sleep(3000);
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Notifications";
        if(actualTitle1.equalsIgnoreCase(expectedTitle1))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        Thread.sleep(3000);
        WebElement notifGroupchats = driver.findElement(By.xpath("//*[@id=\"notification-page\"]/div/div[2]/div/div/div[1]/div/a[2]/div/div[2]/div[1]/div[1]/h1"));
        notifGroupchats.click();
        Thread.sleep(3000);
        String URL5 = driver.getCurrentUrl();
        Assert.assertEquals(URL5, "https://staging.cicle.app/group-chats/615e9f8ed3cd859f6f3ca502");
    }
}