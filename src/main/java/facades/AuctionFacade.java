package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Auction.AuctionDTO;
import dto.Auction.AuctionsDTO;
import dto.Boat.BoatDTO;
import dto.Boat.BoatsDTO;
import entities.Auction;
import entities.Boat;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class AuctionFacade implements IAuctionFacade {

    private static AuctionFacade instance;
    private static EntityManagerFactory emf;

    private AuctionFacade(){}


    public static AuctionFacade getInstance(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new AuctionFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager(){return emf.createEntityManager();}
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();






    public AuctionsDTO getAllAuctions(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Auction> query = em.createQuery("SELECT a FROM Auction a", Auction.class);
            List<Auction> auctions = query.getResultList();
            return new AuctionsDTO(auctions);
        }finally{
            em.close();
        }
    }


    /*public String stringifyAuctions(){
        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<Auction> query = em.createQuery("SELECT a FROM Auction a", Auction.class);
            List<Auction> qresult = query.getResultList();
            String result = GSON.toJson(qresult);
            return result;
        }finally{
            em.close();
        }


    }*/

    public long getBoatCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long boatCount = (long)em.createQuery("SELECT COUNT(b) FROM Boat b").getSingleResult();
            return boatCount;
        }finally {
            em.close();
        }
    }

    public BoatsDTO getBoatsByUser(User user){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Boat> query = em.createQuery("SELECT b FROM Boat b JOIN b.user_name u WHERE u.name = :user_name", Boat.class);
            query.setParameter("user_name", user.getUserName());
            List<Boat> boatList = query.getResultList();
            return new BoatsDTO(boatList);
        }finally{
            em.close();
        }
    }


    public AuctionDTO createAuction(AuctionDTO auctionDTO){
        EntityManager em = emf.createEntityManager();
        Auction auction = new Auction(auctionDTO.getAuctionName(),auctionDTO.getDate(),auctionDTO.getTime(),auctionDTO.getLocation());
        try{
            em.getTransaction().begin();
            em.persist(auction);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new AuctionDTO(auction);
    }


}
