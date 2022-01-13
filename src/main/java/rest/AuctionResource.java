package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Auction.AuctionDTO;
import dto.Auction.AuctionsDTO;
import entities.Auction;
import facades.AuctionFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

@Path("/auction")
public class AuctionResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final AuctionFacade auctionFACADE = AuctionFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();



    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String allAuctions(){
        AuctionsDTO auctions = auctionFACADE.getAllAuctions();
        return GSON.toJson(auctions);
            }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String addAuction(String auction){
        AuctionDTO a = GSON.fromJson(auction, AuctionDTO.class);
        AuctionDTO aNew = auctionFACADE.createAuction(a);
        return GSON.toJson(aNew);
    }


    @Path("/status")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String status() {return "{\"msg\"API is up and running.\"}";}




}
