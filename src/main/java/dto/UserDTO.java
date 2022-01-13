package dto;

import dto.Boat.BoatDTO;
import dto.Boat.BoatsDTO;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    public String user_name;
    public BoatsDTO boats;

    public UserDTO(User user){
        this.user_name = user.getUserName();
        this.boats = new BoatsDTO(user.getBoatList());
    }






    public static List<UserDTO> getUsersDTO(List<User> users){
        List<UserDTO> all = new ArrayList<>();
        users.forEach((p)->{
            all.add(new UserDTO(p));
        });
        return all;
    }

}
