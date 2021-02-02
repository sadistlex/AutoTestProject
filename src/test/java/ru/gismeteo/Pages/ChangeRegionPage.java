package ru.gismeteo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeRegionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ChangeRegionPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }


    private By regionSearchPanel = By.className("currentgeo_search");
    private By searchInput = By.className("search_input");
    private By searchContainer = By.id("js-search-container");
    private By transparentInput = By.className("transparent-input");


    public void waitForLoad(){
        //Ждем загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(regionSearchPanel));
    }

    public void inputCityName(String city){
        //Кликаем на нужную строку, чтобы стал доступен ввод текста.
        driver.findElement(regionSearchPanel).findElement(transparentInput).click();
        //Вводим название города
        driver.findElement(regionSearchPanel).findElement(searchInput).sendKeys(city);
        //Ждем, пока появится всплывающий контейнер с результатами поиска
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchContainer));
        //Нажимаем Enter, чтобы выбрать первый по списку вариант
        driver.findElement(regionSearchPanel).findElement(searchInput).sendKeys(Keys.RETURN);
    }

}
