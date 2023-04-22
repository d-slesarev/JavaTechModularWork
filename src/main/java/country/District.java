package country;

import java.util.ArrayList;
import java.util.List;

// Район
public class District {

    private String name;
    public List<City> cities = new ArrayList<>();
    private Double square;

    public District(String name, Double square) {
        this.name = name;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }
}
