package auction.service;

import auction.domain.Bid;
import auction.domain.Choice;
import auction.repository.BidRepository;
import auction.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BidService {

    public BidService(ItemRepository repositoryItem, BidRepository repositoryBid){
        this.repositoryItem = repositoryItem;
        this.repositoryBid = repositoryBid;
    }

    private final ItemRepository repositoryItem;
    private final BidRepository repositoryBid;


    public List<Bid> getAll() {return repositoryBid.getAll();}

    public Bid addBid(Bid bid){
        bidExist(bid.getItemId());
        isTheHighest(bid);
        isTimeEnd(bid);
        bid.setChoice(Choice.WAITING);

        repositoryItem.addHighest(bid);
        return repositoryBid.save(bid);
    }

    public void bidExist(String id){
        if(!repositoryItem.getById(id)){
            throw new RuntimeException("Item Inexistente");
        }
    }

    public void isTheHighest(Bid bid){
        if (repositoryItem.getByHighest(bid.getItemId()) >= bid.getValue()) {
            throw new RuntimeException("Lance precisa ser o maior até então");
        }
    }

    public boolean isTimeEnd(Bid bid){
        Date currentTime = new Date();


        if (currentTime.after(repositoryItem.getByItemEnding(bid.getItemId()))) {
            throw new RuntimeException("Tempo Esgotado. Leilão fechado");
        }else {
            return true;
        }
    }


    public Bid accept(String bidId) {
        Bid bid = repositoryBid.getById(bidId);

        AuctionInProgress(bid);

        if (bid != null) {
            bid.setChoice(Choice.ACCEPT);
        } else {
            throw new RuntimeException("Erro. Item não aceito");
        }

        return bid;
    }


    public boolean AuctionInProgress(Bid bid){
        Date currentTime = new Date();

        if (currentTime.after(repositoryItem.getByItemEnding(bid.getItemId()))) {
            return true;
        }else {
            throw new RuntimeException("Leilão ainda em andamento");
        }
    }

    public List<Bid> bidsOfItemList(String itemId) {
        return repositoryBid.getListBidsOfItem(itemId);
    }
}
