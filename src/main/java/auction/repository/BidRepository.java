package auction.repository;

import auction.domain.Bid;
import auction.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BidRepository {
    private static List<Bid> bids = new ArrayList();

    public List<Bid> getAll() {return bids;}

    public Bid save(Bid bid) {
        bids.add(bid);
        return bid;
    }

    private void edit(Bid bid) {
        Bid bidToBeEdited = getById(bid.getId());
        bidToBeEdited.setChoice(bid.getChoice());
        bidToBeEdited.setItemId(bid.getItemId());
        bidToBeEdited.setNome(bid.getNome());
        bidToBeEdited.setValue(bid.getValue());
    }

    public Bid getById(String id) {
        for (Bid bid : bids) {
            if (bid.getId().equals(id)) {
                return bid;
            }
        }

        return null;
    }

    public List<Bid> getListBidsOfItem(String itemId) {
        List<Bid> bidsOfItemList = new ArrayList();

        for (Bid bid : bids) {
            if (bid.getItemId().equals(itemId)) {
                bidsOfItemList.add(bid);
            }
        }

        return bidsOfItemList;
    }
}
