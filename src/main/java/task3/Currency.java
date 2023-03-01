package task3;

public enum Currency {
    DOLLAR("Доллар", 1500),
    EURO("Евро", 1590),
    RUBLE("Рубль", 20),
    STANDARD("Эталон", 1);

    private int value;
    private final String name;

    Currency(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }
}
