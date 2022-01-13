package dto.Boat;

import dto.UserDTO;
import entities.Boat;


import java.util.ArrayList;
import java.util.List;

public class BoatDTO {

    public String boatName;
    public String brand;
    public String make;
    public String year;


    public BoatDTO(){}

    public BoatDTO(Boat boat){
        this.boatName = boat.getBoatName();
        this.brand = boat.getBrand();
        this.make = boat.getMake();
        this.year = boat.getYear();
    }



    public static List<BoatDTO> getBoatDtos(List<Boat> boats){
        List<BoatDTO> all = new ArrayList<>();
        boats.forEach((p)->{
            all.add(new BoatDTO(p));
        });
        return all;
    }


    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
