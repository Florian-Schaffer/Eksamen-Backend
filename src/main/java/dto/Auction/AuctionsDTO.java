package dto.Auction;

import dto.Boat.BoatDTO;
import entities.Auction;
import entities.Boat;

import java.util.ArrayList;
import java.util.List;

public class AuctionsDTO {

    List<AuctionDTO> all = new ArrayList<>();


    public AuctionsDTO(){}

    public AuctionsDTO(List<Auction> auctions){
        List<AuctionDTO> all = new ArrayList<>();
        auctions.forEach((a)->{
            all.add(new AuctionDTO(a));
        });
    }


    public int getSize(){
        int counter = 0;
        for(AuctionDTO a: all){
            counter++;
        }
        return counter;
    }


}
