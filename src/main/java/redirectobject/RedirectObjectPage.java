package redirectobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class RedirectObjectPage {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    public void scrollDownToElementLink(){
        wait.until(ExpectedConditions.
                presenceOfElementLocated(
                        By.cssSelector("a[href='http://elementalselenium.com/']")));
        WebElement redirectLink = driver.findElement(By.cssSelector("a[href='http://elementalselenium.com/']"));
        js.executeScript("arguments[0].scrollIntoView(true)", redirectLink);
        redirectLink.click();

    }

    public void changeTab(){
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> count = tabs.iterator();
        if (count.hasNext()){
            String mainTab = count.next();
            String nextTab = count.next();
            driver.switchTo().window(nextTab);
        }
    }

    public void insertText(String textField, String text){
        wait.until(ExpectedConditions.
                presenceOfElementLocated(
                        By.cssSelector(textField)));
        driver.findElement(By.cssSelector(textField)).sendKeys(text);
    }

    public void joinMailingList(){
        wait.until(ExpectedConditions.
                presenceOfElementLocated(
                        By.cssSelector(Selectors.joinEmailButton)));
        driver.findElement(By.cssSelector(Selectors.joinEmailButton)).click();
    }

    public void selectJava(){
        Select select = new Select(driver.findElement(By.cssSelector(Selectors.selectLang)));
        select.selectByValue(Selectors.selectOptions);
    }
    public void tearDown(){
        driver.quit();
    }

}
