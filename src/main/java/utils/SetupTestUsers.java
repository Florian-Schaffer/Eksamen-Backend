package utils;


import entities.Role;
import entities.User;
import entities.Auction;
import entities.Boat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("user", "test1");
    User admin = new User("admin", "test2");
    User owner = new User("owner", "test3");

    Auction one = new Auction("Båden (2015)", "26022022", "Rungsted Havn", "1100");
    Auction two = new Auction("Den Hvide Kutter (1998)", "25022022","Nivå Havn", "1700");
    Auction three = new Auction("Hesten (2019)", "25022022", "Nivå Havn", "1230");

    Boat one1 = new Boat("Båden", "Båd", "Yacht", "2015", "admin", "Båden (2015)");
    Boat two2 = new Boat("Den Hvide Kutter", "Båd", "Sejlbåd", "1998", "user", "Den Hvide Kutter (1998)");
    Boat three3 = new Boat("Hesten", "Båd", "Motorbåd", "2019","owner", "Hesten (2019)");

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||owner.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    Role ownerRole = new Role("owner");
    user.addRole(userRole);
    admin.addRole(adminRole);
    owner.addRole(ownerRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(ownerRole);
    em.persist(user);
    em.persist(admin);
    em.persist(owner);
    em.persist(one);
    em.persist(two);
    em.persist(three);
    em.persist(one1);
    em.persist(two2);
    em.persist(three3);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}
