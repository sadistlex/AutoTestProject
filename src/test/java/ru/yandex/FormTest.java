package ru.yandex;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {
    @Test
    public void FormTest(){
        System.setProperty("webdriver.chrome.driver","D:\\All Files\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru");
        driver.quit();
    }
}
