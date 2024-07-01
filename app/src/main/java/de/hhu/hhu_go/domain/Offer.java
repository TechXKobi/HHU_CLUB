package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Offer implements Comparable<Offer>{
    private Integer id;

    private String name;

    private Integer price;

    private String description;

    private boolean state;

    private LocalDateTime dateTime;

    private String category;

    private Integer owner;

    public Offer(Integer id, String name, String description, boolean state, String category, Integer owner, LocalDateTime dateTime,Integer price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.state = state;
        this.dateTime = dateTime;
        this.category = category;
        this.owner = owner;
    }

    public Offer (String name, String description, boolean state, String category, Integer owner, LocalDateTime dateTime, Integer price){
        this(null, name, description, state, category, owner, dateTime, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public int compareTo(Offer other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return name +": " + description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;

        return Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
