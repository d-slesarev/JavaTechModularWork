package org.example;

import country.City;
import country.Country;
import country.District;
import country.Region;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> strCities = new ArrayList<>();
    private static List<String> strDistricts = new ArrayList<>();
    private static List<Double> distrSquare = new ArrayList<>();
    private static List<String> strRegions = new ArrayList<>();
    private static Country ukraine = new Country();
    private static int index = 0;

    public static void main(String[] args) throws IOException {

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("Cities.txt")) {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null) {
                strCities.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("Districts.txt")) {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null) {
                strDistricts.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("Districts_square.txt")) {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null) {
                distrSquare.add(Double.parseDouble(line));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("Regions.txt")) {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null) {
                strRegions.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 24; i++) {
            ukraine.regions.add(new Region(strRegions.get(index)));
            index++;
        }
        index = 0;
        for(Region region : ukraine.regions){
            for (int i = 0; i < 5; i++) {
                region.districts.add(new District(strDistricts.get(index), distrSquare.get(index)));
                index++;
            }
        }
        index = 0;
        for(Region region : ukraine.regions){
            for(District district : region.districts){
                for (int i = 0; i < 7; i++) {
                    district.cities.add(new City(strCities.get(index)));
                    index++;
                }
            }
        }

        System.out.println(
                "Столиця: " + ukraine.getCapital() + "\n" +
                "Кількість областей: " + ukraine.getNumRegions() + "\n" +
                "Площа: " + ukraine.getSquare() + " км²"+ "\n" +
                "Обласні центри: \n" + ukraine.getMainCitiesInRegions()
        );
    }
}