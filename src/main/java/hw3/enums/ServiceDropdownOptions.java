package hw3.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ServiceDropdownOptions {

    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMPLEX_TEBLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String serviceDropdownElement;

    ServiceDropdownOptions(String serviceOption) {
        serviceDropdownElement = serviceOption;
    }

    public String getServiceDropdownElement() {
        return serviceDropdownElement;
    }

    public static List<String> getListStringServiceDropdown(){
        return Stream.of(ServiceDropdownOptions.values()).
                map(v->v.getServiceDropdownElement()).
                collect(Collectors.toList());
    }
}
