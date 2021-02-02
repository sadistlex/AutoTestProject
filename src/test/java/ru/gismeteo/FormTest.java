package ru.gismeteo;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.gismeteo.Settings.DriverSettings;
import ru.gismeteo.Pages.ChangeRegionPage;
import ru.gismeteo.Pages.MainPage;


public class FormTest extends DriverSettings {



    @Test
    public void ChangeRegionTest() {
        /*
        Тестируем смену региона.
        */

        //Название города, которое будем вводить
        String city="Санкт-Петербург";
        //Инициализируем главную страницу
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        //Открываем сайт
        mainPage.openURL();

        //Проверяем текущее значение региона, чтобы изначальное отличалось от проверяемого
        mainPage.checkCityNameNotEquals(city);

        //Кликаем по кнопке "Изменить пункт", которая меняет регион.
        mainPage.clickChangeRegion();

        //Инициализируем страницу смены региона
        ChangeRegionPage changeRegionPage = PageFactory.initElements(driver,ChangeRegionPage.class);
        //Ждем, пока форма загрузится
        changeRegionPage.waitForLoad();
        //Вводим и применяем название города
        changeRegionPage.inputCityName(city);

        //Снова проверяем текущее значение региона, проверяем с ожидаемым.
        mainPage.checkCityNameEquals(city);


    }
}
