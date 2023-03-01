package task3;

public class Event {
    private final String description;
    private final EventType type;

    public Event(String description, EventType type) {
        this.description = description;
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void affect(City city) {
        if (type == EventType.POSITIVE)
            positivelyAffect(city);
        else negativelyAffect(city);

    }

    private void positivelyAffect(City city) {
        if (city.isExist()) {
            city.setCountPositiveEvent(city.getCountPositiveEvent() + 1);
            if (city.getCountPositiveEvent() == 3) {
                city.setCountPositiveEvent(0);
                city.setCountNegativeEvent(0);
                city.getCountry().increaseCurrencyValue(4);
            }
        } else {
            System.out.println("Город не существует, никакие события уже не могут на него повлиять");
        }
    }

    private void negativelyAffect(City city) {
        if (!city.isExist()) {
            System.out.println("Город не существует, никакие события уже не могут на него повлиять");
        } else {
            city.setCountNegativeEvent(city.getCountNegativeEvent() + 1);
            if (city.getCountNegativeEvent() == 3) {
                System.out.println("Город " + city.getName() + " больше не существует");
                city.setExist(false);
                city.getCountry().removeCity(city);
                city.setCountNegativeEvent(0);
                city.setCountPositiveEvent(0);
                city.getCountry().reduceCurrencyValue(4);
                if (city.getCountry().getCitiesCount() == 1) {
                    Country country = city.getCountry();
                    country.setExist(false);
                    country.getCities().get(0).setExist(false);
                    country.getCities().clear();
                    country.setCurrencyValue(0);
                    System.out.println("Страна " + country.getName() + " больше не существует");
                }
            }
        }
    }

}
