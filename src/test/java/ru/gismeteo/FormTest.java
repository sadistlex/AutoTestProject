package ru.gismeteo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FormTest extends DriverSettings{



    @Test
    public void FormTest() {
/*
Testing region change.
 */
        driver.get("https://www.gismeteo.ru");

        driver.manage().window().maximize();
        //Ждем загрузки нужного элемента
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/current-location/\"]")));
        //Проверяем текущее значение региона, чтобы изначальное отличалось от проверяемого
        String city = driver.findElement(By.className("weather_frame_title")).findElement(By.className("float_left")).getText();
        Assert.assertNotEquals("Санкт-Петербург",city);

        //Кликаем по кнопке "Изменить пункт", которая меняет регион.
        driver.findElement(By.cssSelector("[href=\"/current-location/\"]")).click();

        //Ждем, пока форма загрузится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("currentgeo_search")));
        //Кликаем на нужную строку, чтобы стал доступен ввод текста.
        driver.findElement(By.className("currentgeo_search")).findElement(By.className("transparent-input")).click();
        //Вводим название города
        driver.findElement(By.className("currentgeo_search")).findElement(By.className("search_input")).sendKeys("Санкт-Петербург");
        //Ждем, пока появится всплывающий контейнер с результатами поиска
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-search-container")));
        //Нажимаем Enter, чтобы выбрать первый по списку вариант
        driver.findElement(By.className("currentgeo_search")).findElement(By.className("search_input")).sendKeys(Keys.RETURN);

        //Снова проверяем текущее значение региона, проверяем с ожидаемым.
        city = driver.findElement(By.className("weather_frame_title")).findElement(By.className("float_left")).getText();
        Assert.assertEquals("Санкт-Петербург",city);


    }
}
