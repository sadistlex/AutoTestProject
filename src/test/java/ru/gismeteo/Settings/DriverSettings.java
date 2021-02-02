package ru.gismeteo.Settings;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverSettings {
    public WebDriver driver;
    public WebDriverWait wait;
    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","D:\\All Files\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
         wait = new WebDriverWait(driver,5);
    }

    @After
    public void Quit(){

       driver.quit();
    }
}
