package ru.mail.nenado;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Stickers {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart");
        wait.until(titleIs("Online Store | My Store"));

    }

    @Test
    public void myFirstTest() {

        List<WebElement> stickers = driver.findElements(By.cssSelector("li.product"));
        int count = 0;
        for (int i = 0; i < stickers.size(); i++) {
            int pool = stickers.get(i).findElements(By.cssSelector(".sticker")).size();
            Assert.assertEquals(1, pool);
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
