package hw3.enums.TableWithPages;

public enum ShowEntries {
    FIVE("5"),
    TEN("10"),
    FIFTEEN("15"),
    TWENTY("20");

    final String name;

    ShowEntries(String name) {
        this.name = name;
    }

    public String getEntry() {
        return name;
    }

}
