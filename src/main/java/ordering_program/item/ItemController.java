package ordering_program.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @GetMapping(value = "/")
    public List<Item> getItemLists() {
        return itemRepo.findItemSortById();
    }
}
