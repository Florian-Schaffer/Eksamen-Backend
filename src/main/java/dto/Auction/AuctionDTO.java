package dto.Auction;

import dto.Boat.BoatDTO;
import entities.Auction;

public class AuctionDTO {

    public String auctionName;
    public String date;
    public String time;
    public String location;
    public BoatDTO boat;

    public AuctionDTO(){

    }

    public AuctionDTO(Auction auction){
        this.auctionName = auction.getAuctionName();
        this.date = auction.getDate();
        this.time = auction.getTime();
        this.location = auction.getLocation();
        this.boat = new BoatDTO(auction.getBoat());
    }

    public AuctionDTO(String auctionName, String date, String time, String location, BoatDTO boat){
        this.auctionName = auctionName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.boat = boat;
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

    public BoatDTO getBoat() {
        return boat;
    }

    public void setBoat(BoatDTO boat) {
        this.boat = boat;
    }
}
