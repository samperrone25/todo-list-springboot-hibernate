package webapp.todolist;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer>{
    
    Optional<Item> findByTitle(String title);
    void deleteByTitle(String title);

}

