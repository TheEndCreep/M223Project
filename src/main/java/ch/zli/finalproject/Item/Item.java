package ch.zli.finalproject.Item;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    protected Item () {}

    public Item (String name, String desc){
        this.name = name;
        this.description = desc;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String desc){
        this.description = desc;
    }
}

