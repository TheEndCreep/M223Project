package ch.zli.finalproject.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public void editItem(@PathVariable Long id, @RequestBody Item item){
        Item existingItem = itemRepository.findById(id).get();
        Assert.notNull(existingItem, "Item not found!");
        existingItem.setDescription(item.getDescription());
        existingItem.setName(item.getName());
        itemRepository.save(existingItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        Item itemToDelete = itemRepository.findById(id).get();
        itemRepository.delete(itemToDelete);
    }

}
