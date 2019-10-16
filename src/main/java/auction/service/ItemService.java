package auction.service;


import auction.domain.Item;
import auction.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository){
        this.repository = repository;
    }

    public List<Item> getAll() {return repository.filterList();}

    public Item addItem(Item item){
        Date endTime = generateEndingDate();
        item.setItemEnding(endTime);
        return repository.save(item);
    }

    private Date generateEndingDate() {
        Calendar endTime = Calendar.getInstance();
        endTime.getTime();
        endTime.add(Calendar.MINUTE, 5);
        return endTime.getTime();
    }


}
