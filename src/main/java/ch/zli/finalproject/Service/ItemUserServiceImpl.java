package ch.zli.finalproject.Service;

import org.springframework.stereotype.Service;

import ch.zli.finalproject.Item.Item;
import ch.zli.finalproject.Item.ItemRepository;
import ch.zli.finalproject.User.AppUser;
import ch.zli.finalproject.User.UserRepository;

@Service
public class ItemUserServiceImpl implements ItemUserService{

    private ItemRepository itemRepository;
    private UserRepository userRepository;

    public ItemUserServiceImpl(ItemRepository itemRepository, UserRepository userRepository){
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addItem(AppUser user, Long itemId){
        Item item = itemRepository.getOne(itemId);
        user.addItem(item);
        userRepository.save(user);
        
    }
    
}
