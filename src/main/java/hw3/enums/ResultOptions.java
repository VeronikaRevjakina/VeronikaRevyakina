package hw3.enums;

public enum ResultOptions {
    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    final String option;

    ResultOptions(String option){
        this.option=option;
    }

    public String getOption(){
        return option;
    }
}
