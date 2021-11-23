package ru.mail.nenado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestClickAll {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

    }

    @Test
    public void myFirstTest() {

        List <WebElement> leftMenu = driver.findElements(By.cssSelector("li#app-"));

        for (int i = 0; i < leftMenu.size(); i++) {
            leftMenu = driver.findElements(By.cssSelector("li#app-"));
            leftMenu.get(i).click();
            wait.until(presenceOfElementLocated(By.cssSelector("h1")));

            if (isElementPresent(driver, By.cssSelector("ul.docs [id*=doc-]"))) {
                List<WebElement> nestedElements = driver.findElements(By.cssSelector("ul.docs [id*=doc-]"));

                for (int j = 0; j < nestedElements.size(); j++) {
                    nestedElements = driver.findElements(By.cssSelector("ul.docs [id*=doc-]"));
                    nestedElements.get(j).click();
                    wait.until(presenceOfElementLocated(By.cssSelector("h1")));
                }
            }
        }
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
