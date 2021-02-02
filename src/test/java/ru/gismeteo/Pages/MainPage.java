package ru.gismeteo.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }


    private By changeRegionBtn = By.cssSelector("[href=\"/current-location/\"]");
    private By weatherFrame = By.className("weather_frame_title");
    private By cityValue = By.className("float_left");



    public void openURL(){
        driver.get("https://www.gismeteo.ru");
        driver.manage().window().maximize();
    }


    public void checkCityNameEquals(String city, boolean equals){
        //Ждем загрузки нужного элемента
        wait.until(ExpectedConditions.visibilityOfElementLocated(weatherFrame));
        //Проверяем текущее значение региона, чтобы изначальное отличалось от проверяемого
        String pageCity = driver.findElement(weatherFrame).findElement(cityValue).getText();
        //Проверяем, положительное или отрицательное сравнение нам нужно.
        if (equals){
            Assert.assertEquals(city,pageCity);
        }
        else {
            Assert.assertNotEquals(city, pageCity);
        }

    }



    public void clickChangeRegion(){
        driver.findElement(changeRegionBtn).click();
    }

}
