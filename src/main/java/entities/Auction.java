package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name ="auctions")
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name= "auction_name", length = 40)
    private String auctionName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date", length = 15)
    private String date;

    @Basic(optional = false)
    @NotNull
    @Column(name = "time", length = 30)
    private String time;

    @Basic(optional = false)
    @NotNull
    @Column(name = "location", length = 75)
    private String location;

    @JoinTable(name = "boats", joinColumns = {
            @JoinColumn(name = "auction_name", referencedColumnName = "boat_name")}, inverseJoinColumns = {
            @JoinColumn(name = "boat_name", referencedColumnName = "boat_name")})
    @OneToOne
    private Boat boat;


    public Auction() {}

    public Auction(String auctionName, String date, String location, String time) {
            this.auctionName = auctionName;
            this.date = date;
            this.location = location;
            this.time = time;
    }


    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boat getBoat(){return boat;}

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionName='" + auctionName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", boat=" + boat +
                '}';
    }
}
