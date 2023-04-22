package country;

import java.util.ArrayList;
import java.util.List;

// Область
public class Region {

    private String name;
    private String mainCity;
    public List<District> districts = new ArrayList<>();
    private Double square;

    public Region(String name) {
        this.name = name;
    }

    public String getMainCity() {
        return districts.get(3).cities.get(5).getName();
    }

    public String getName() {
        return name;
    }

    public Double getSquare() {
        return districts.stream().
                mapToDouble(District::getSquare).
                sum();
    }

}
