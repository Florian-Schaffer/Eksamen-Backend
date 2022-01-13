package facades;

import dto.Auction.AuctionsDTO;
import dto.Boat.BoatDTO;
import dto.Boat.BoatsDTO;
import entities.Auction;
import entities.Boat;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuctionFacade {

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
            TypedQuery<Boat> query = em.createQuery("SELECT b FROM Boat b JOIN b.users u WHERE u.name = :name", Boat.class);
            query.setParameter("name", user.getUserName());
            List<Boat> boatList = query.getResultList();
            return new BoatsDTO(boatList);
        }finally{
            em.close();
        }
    }




}
