package task3;

import java.util.ArrayList;

public class Country {
    private String name;
    private boolean exist = true;
    private City capital;
    private Currency currency;
    private final ArrayList<City> cities = new ArrayList<>();

    public Country(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    public Country() {}

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isExist() {
        return exist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getCurrencyValue() {
        return currency.getValue();
    }

    public void setCurrencyValue(int value) {
        currency.setValue(value);
    }

    public String getCurrencyName() {
        return currency.getName();
    }

    public void reduceCurrencyValue(int delta) {
        currency.setValue(currency.getValue() - delta);
    }

    public void increaseCurrencyValue(int delta) {
        currency.setValue(currency.getValue() + delta);
    }

    public int getCitiesCount() {
        return cities.size();
    }

    public void addNewCity(City city) {
        cities.add(city);
    }

    public boolean findCityInCities(City city) {
        return cities.contains(city);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void removeCity(City city) {
        cities.remove(city);
    }

}
