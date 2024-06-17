package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clothing implements Comparable<Clothing>{

    private Integer id;

    private String clothingName;

    private String description;

    private boolean state;

    private String category;

    private Integer owner;

    public Clothing(Integer id, String clothingName,
                    String description, boolean state,
                    String category, Integer owner){
        this.id = id;
        this.clothingName = clothingName;
        this.description = description;
        this.state = state;
        this.category = category;
        this.owner = owner;
    }

    public Clothing(String clothingName,
                    String description, boolean state,
                    String category, Integer owner){
        this(null, clothingName, description, state, category, owner);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClothingName() {
        return clothingName;
    }

    public void setClothingName(String clothingName) {
        this.clothingName = clothingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    @Override
    public int compareTo(Clothing other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return clothingName +": " + description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;

        return Objects.equals(id, clothing.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
