import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class VoutingTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void VoutingTests() {
        wd.get("https://www.bizjournals.com/tampabay/pulse/survey/tbbjs-2017-best-in-the-biz-readers-choice-media-and-marketing/21116293");
        if (!wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[1]/div[2]/div[1]/div[22]/label/input")).isSelected()) {
            wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[1]/div[2]/div[1]/div[22]/label/input")).click();
        }
        wd.findElement(By.id("pulse-next-question-1")).click();
        if (!wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[2]/div[2]/div[1]/div[13]/label/input")).isSelected()) {
            wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[2]/div[2]/div[1]/div[13]/label/input")).click();
        }
        wd.findElement(By.id("pulse-next-question-2")).click();
        if (!wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[3]/div[2]/div[1]/div[10]/label/input")).isSelected()) {
            wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[3]/div[2]/div[1]/div[10]/label/input")).click();
        }
        wd.findElement(By.id("pulse-next-question-3")).click();
        if (!wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[4]/div[2]/div[1]/div[10]/label/input")).isSelected()) {
            wd.findElement(By.xpath("//form[@id='pulseForm']/fieldset/div[4]/div[2]/div[1]/div[10]/label/input")).click();
        }
        wd.findElement(By.xpath("//div[@id='formSubmit']/button")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
