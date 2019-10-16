package auction.repository;

import auction.domain.Bid;
import auction.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ItemRepository {
    private static List<Item> items = new ArrayList();



    public List<Item> getAll() {
        return filterList();
    }

    public List<Item> filterList(){
        List<Item> itemsOpened = new ArrayList();
        Date currentTime = new Date();
        for (Item item : items) {
            if (currentTime.before(item.getItemEnding())) {
                itemsOpened.add(item);
                // return itemsOpened;
            }
            // return itemsOpened;
        }
        return itemsOpened;
    }

    public Item save(Item item){
        items.add(item);
        return item;
    }

    public boolean getById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public Double getByHighest(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item.getHighestBid();
            }
        }
        return null;
    }

    public Date getByItemEnding(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item.getItemEnding();
            }
        }
        return null;
    }

    public void addHighest(Bid bid) {
        for (Item item : items) {
            if (item.getId().equals(bid.getItemId())) {
                item.setHighestBid(bid.getValue());
            }
        }
    }
}
