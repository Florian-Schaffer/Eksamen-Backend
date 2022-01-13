package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name ="boats")
public class Boat implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name="boat_name", length = 50)
    private String boatName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "brand", length = 50)
    private String brand;

    @Basic(optional = false)
    @NotNull
    @Column(name = "make", length = 50)
    private String make;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Year", length = 10)
    private String year;


    public Boat(){}


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
