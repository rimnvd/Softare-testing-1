package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {
    Event event = new Event("Открытие музея", EventType.POSITIVE);
    Event event1 = new Event("Пандемия", EventType.NEGATIVE);

    @BeforeEach
    void init() {
        Currency.DOLLAR.setValue(1500);
    }

    @Test
    void eventTest() {
        assertEquals("Открытие музея", event.getDescription());
        assertEquals(EventType.POSITIVE, event.getType());
    }

    @Test
    void positivelyAffectTest() {
        Country country = new Country("США", Currency.DOLLAR);
        City cityCalifornia = new City("Калифорния", country);
        event.affect(cityCalifornia);
        assertEquals(1, cityCalifornia.getCountPositiveEvent());
        event.affect(cityCalifornia);
        event.affect(cityCalifornia);
        assertEquals(0, cityCalifornia.getCountPositiveEvent());
        assertEquals(0, cityCalifornia.getCountNegativeEvent());
        assertEquals(1504, cityCalifornia.getCountry().getCurrencyValue());
        cityCalifornia.setExist(false);
        ByteArrayOutputStream output = setUpStream();
        event.affect(cityCalifornia);
        assertEquals("Город не существует, никакие события уже не могут на него повлиять\r\n", output.toString());
        System.setOut(System.out);
    }

    @Test
    void negativelyAffectTest() {
        Country country = new Country("США", Currency.DOLLAR);
        City cityCalifornia = new City("Калифорния", country);
        City cityNY = new City("Нью-Йорк", country);
        City cityChicago = new City("Чикаго", country);
        event1.affect(cityCalifornia);
        assertEquals(1, cityCalifornia.getCountNegativeEvent());
        event1.affect(cityCalifornia);
        event1.affect(cityCalifornia);
        assertFalse(cityCalifornia.isExist());
        assertEquals(0, cityCalifornia.getCountPositiveEvent());
        assertEquals(0, cityCalifornia.getCountNegativeEvent());
        assertEquals(1496, cityCalifornia.getCountry().getCurrencyValue());
        assertFalse(cityCalifornia.getCountry().findCityInCities(cityCalifornia));
        ByteArrayOutputStream output = setUpStream();
        event1.affect(cityCalifornia);
        assertEquals("Город не существует, никакие события уже не могут на него повлиять\r\n", output.toString());
        System.setOut(System.out);
    }

    @Test
    void negativelyAffectCountryTest() {
        Country country = new Country("США", Currency.DOLLAR);
        City cityNY = new City("Нью-Йорк", country);
        City cityCalifornia = new City("Калифорния", country);
        event1.affect(cityCalifornia);
        event1.affect(cityCalifornia);
        event1.affect(cityCalifornia);
        assertFalse(country.isExist());
        assertFalse(cityNY.isExist());
        assertEquals(0, country.getCitiesCount());
        assertEquals(0, country.getCurrencyValue());
    }

    ByteArrayOutputStream setUpStream() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }
}