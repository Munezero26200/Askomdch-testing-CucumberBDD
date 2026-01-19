package objects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Country {

    private String name;
    private List<String> states;

    public Country(String countryName, List<String> states){
        this.name = countryName;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public List<String> getStates() {
        return states;
    }
    public boolean hasStates(){
        return states != null && !states.isEmpty();
    }
    public static Country fromString(String countryName){
        switch (countryName){
            case "United States (US)":
                return new Country("United States (US)",
                        Arrays.asList("Texas","California", "New York"));

            case "Canada":
                return new Country("Canada",
                        Arrays.asList("Ontario", "Quebec", "British Columbia"));
            default:
                return new Country(countryName, Collections.emptyList());


        }
    }
}

