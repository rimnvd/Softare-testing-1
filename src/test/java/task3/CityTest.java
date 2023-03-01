package task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    Country country = new Country("Россия", Currency.RUBLE);
    City city = new City("Москва", country);

    @Test
    void cityTest() {
        assertEquals("Москва", city.getName());
        assertEquals(country, city.getCountry());
        assertTrue(city.isExist());
        assertEquals(0, city.getCountNegativeEvent());
        assertEquals(0, city.getCountPositiveEvent());
    }

    @Test
    void newCityTest() {
        City city1 = new City();
        city1.setName("Санкт-Петербург");
        assertEquals("Санкт-Петербург", city1.getName());
        city1.setCountry(country);
        assertEquals(country, city1.getCountry());
        Country country1 = new Country("США", Currency.DOLLAR);
        city1.setCountry(country1);
        assertEquals(country1, city1.getCountry());
        city1.addToCitiesList();
        assertTrue(city1.getCountry().findCityInCities(city1));
        city1.setExist(false);
        assertFalse(city1.isExist());
        city1.setCountPositiveEvent(3);
        assertEquals(3, city1.getCountPositiveEvent());
        city1.setCountNegativeEvent(10);
        assertEquals(10, city1.getCountNegativeEvent());
    }

}
