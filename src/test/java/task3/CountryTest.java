package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {
    Country country = new Country("Россия", Currency.RUBLE);
    City cityMoscow = new City("Москва", country);

    @BeforeEach
    void init() {
        country.setCapital(cityMoscow);
        country.setCurrencyValue(20);
    }

    @Test
    void countryTest() {
        assertEquals("Россия", country.getName());
        assertEquals(cityMoscow, country.getCapital());
        assertEquals(Currency.RUBLE, country.getCurrency());
        assertTrue(country.isExist());
        assertEquals("Рубль", country.getCurrencyName());
        assertEquals(20, country.getCurrencyValue());
    }

    @Test
    void newCountryTest() {
        Country country1 = new Country();
        City city1 = new City();
        country1.setName("США");
        country1.setCapital(city1);
        country1.setExist(false);
        country1.setCurrency(Currency.DOLLAR);
        assertEquals("США", country1.getName());
        assertEquals(city1, country1.getCapital());
        assertEquals(Currency.DOLLAR, country1.getCurrency());
        assertFalse(country1.isExist());
    }

    @Test
    void citiesListTest() {
        assertEquals(1, country.getCitiesCount());
        City city1 = new City();
        City city2 = new City();
        country.addNewCity(city1);
        country.addNewCity(city2);
        assertEquals(3, country.getCitiesCount());
        assertTrue(country.findCityInCities(city1));
        assertTrue(country.findCityInCities(city2));
        country.removeCity(city1);
        assertEquals(2, country.getCitiesCount());
    }

    @Test
    void currencyValueTest() {
        country.increaseCurrencyValue(5);
        assertEquals(25, country.getCurrencyValue());
        country.reduceCurrencyValue(10);
        assertEquals(15, country.getCurrencyValue());
        country.setCurrencyValue(28);
        assertEquals(28, country.getCurrencyValue());
    }
}
