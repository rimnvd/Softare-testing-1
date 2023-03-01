package task3;

public class City {
    private String name;
    private Country country;
    private boolean exist = true;
    private int countPositiveEvent = 0;
    private int countNegativeEvent = 0;


    public City(String name, Country country) {
        this.name = name;
        this.country = country;
        addToCitiesList();
    }

    public City() {}

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public int getCountNegativeEvent() {
        return countNegativeEvent;
    }

    public int getCountPositiveEvent() {
        return countPositiveEvent;
    }

    public void setCountNegativeEvent(int countNegativeEvent) {
        this.countNegativeEvent = countNegativeEvent;
    }

    public void setCountPositiveEvent(int countPositiveEvent) {
        this.countPositiveEvent = countPositiveEvent;
    }

    public void addToCitiesList() {
        country.addNewCity(this);
    }
}
