package hw4.data;

import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import hw3.enums.DifferentElements.Vegetables;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class MetalsAndColorsData {
    private List<String> summary;
    private List<CheckboxForces> elements;
    private List<DropdownColors> colors;
    private List<RadioMetals> metals;
    private List<Vegetables> vegetables;
}
