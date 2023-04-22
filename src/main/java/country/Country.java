package country;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    public List<Region> regions = new ArrayList<>();
    private Double square;

    public String getName() {
        return name;
    }

    public int getNumRegions() {
        return regions.size();
    }

    public String getCapital() {
        String capital = "Київ";
        return capital;
    }

    public String getMainCitiesInRegions(){
        StringBuilder str = new StringBuilder();
        int index = 1;
        for(Region region : regions){
            str.append(index).append(". ").append(region.getMainCity()).append("\n");
            index++;
        }
        return str.toString();
    }

    public Double getSquare() {
        return regions.stream().
                mapToDouble(Region::getSquare).
                sum();
    }
}
