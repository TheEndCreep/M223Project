package ch.zli.finalproject.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ch.zli.finalproject.Item.Item;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<Item> items = new ArrayList<Item>();

    public User(){
        super();
    }

    public User(String name, String passw){
        super();
        this.name = name;
        this.password = passw;
    }

    public List<Item> getItems(){
        return items;
    }

    public Item getItem(int id){
        Item rItem = items.get(id);
        return rItem;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String passw){
        this.password = passw;
    }

    @Override
    public String toString(){
        return "User [id=" + id + ", username=" + name + ", password=" + password + "]";
    }

}
