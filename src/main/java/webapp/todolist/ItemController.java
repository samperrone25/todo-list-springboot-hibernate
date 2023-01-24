package webapp.todolist;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ItemController {
    
    private final ItemRepository repo;

    ItemController(ItemRepository jpa_repo) {
        this.repo = jpa_repo;
    }
    
    @PostMapping("/createitem")
    Item createItem(@RequestBody Item reqItem) {
        Item newItem = new Item(reqItem.getTitle(), reqItem.getDescription());
        return repo.save(newItem);
    }

    @PostMapping("/markitemasdone/{title}")
    Item markItemAsDone(@PathVariable String title) {
        
        return repo.findByTitle(title)
            .map(item -> {item.setDone(true);
                          return repo.save(item);
                         })
            .orElseGet(() -> null); 
    }
    // idea is to return newly 'done' item or 
    // null if none was found

    @PutMapping("/updateitemdescription/{title}")
    Item updateItemDescription(@PathVariable String title, @RequestBody Item newItem) {
        return repo.findByTitle(title)
            .map(item -> {item.setDescription(newItem.getDescription());
                          return repo.save(item);
                         })
            .orElseGet(() -> null); 
    }

    @GetMapping("/viewitem/{title}")
    Item viewItem(@PathVariable String title) {
        return repo.findByTitle(title).orElseGet(() -> null);
    }

    @GetMapping("/viewitems")
    List<Item> viewItems() {
        return (List<Item>) repo.findAll();
    }

    @DeleteMapping("/deleteitem/{title}")
    void deleteItem(@PathVariable String title) {
        repo.deleteByTitle(title);
    }

    @DeleteMapping("/deleteitems")
    void deleteItems() {
        repo.deleteAll();
    }
}
