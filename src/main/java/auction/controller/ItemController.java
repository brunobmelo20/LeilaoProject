package auction.controller;

import auction.domain.Item;
import auction.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("api/v1/Items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping
    public List<Item> get() {
        return service.getAll();
    }

    @PostMapping
    public Item post(@RequestBody Item item) {
        return service.addItem(item);
    }

}
