package ru.mail.nenado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestingCode {

    private WebDriver driver;
    private WebDriverWait wait;

//    WebDriver chromeDriver = new ChromeDriver();
//    WebDriver ieDriver = new InternetExplorerDriver();
//    WebDriver firefoxDriver = new FirefoxDriver();
    @Before
    public void start() {
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://www.yandex.ru/");
//        WebElement q = driver.findElement(By.name("q"));
//        driver.navigate().refresh();
//        q.sendKeys("webdriver");
        driver.findElement(By.name("text")).sendKeys("webdriver");
        driver.findElement(By.className("search2__button")).click();
//        wait.until(titleIs("webdriver — Яндекс: нашлось 714 тыс. результатов"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
