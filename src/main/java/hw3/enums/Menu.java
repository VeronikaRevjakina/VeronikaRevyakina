package hw3.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getListStringMenuHeaders(){
        return Stream.of(Menu.values()).
                map(v->v.getName()).
                collect(Collectors.toList());
    }

}
