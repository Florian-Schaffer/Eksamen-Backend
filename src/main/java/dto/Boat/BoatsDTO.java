package dto.Boat;

import dto.Auction.AuctionDTO;
import dto.UserDTO;
import entities.Boat;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class BoatsDTO {

    List<BoatDTO> all = new ArrayList<>();


    public BoatsDTO(){}

    public BoatsDTO(List<Boat> boats){
        List<BoatDTO> all = new ArrayList<>();
        boats.forEach((b)->{
            all.add(new BoatDTO(b));
        });
    }

    public int getSize(){
        int counter = 0;
        for(BoatDTO b: all){
            counter++;
        }
        return counter;
    }

}
