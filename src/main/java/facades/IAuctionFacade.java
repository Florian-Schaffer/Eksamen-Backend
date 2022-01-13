package facades;

import dto.*;
import dto.Auction.AuctionDTO;
import dto.Auction.AuctionsDTO;

public interface IAuctionFacade {

    AuctionsDTO getAllAuctions();

    AuctionDTO createAuction(AuctionDTO auctionDTO);



}
