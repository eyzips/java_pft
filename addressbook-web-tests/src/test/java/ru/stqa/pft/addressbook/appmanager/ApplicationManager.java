package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    if (browser == org.openqa.selenium.remote.BrowserType.FIREFOX) {
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (browser == org.openqa.selenium.remote.BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == org.openqa.selenium.remote.BrowserType.EDGE) {
      wd = new EdgeDriver();
    }

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
