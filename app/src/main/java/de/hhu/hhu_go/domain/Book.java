package de.hhu.hhu_go.domain;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private Integer id;

    private String bookName;

    private String description;

    private boolean state;

    private String category;

    private Integer owner;

    public Book(Integer id, String bookName,
                    String description, boolean state,
                    String category, Integer owner){
        this.id = id;
        this.bookName = bookName;
        this.description = description;
        this.state = state;
        this.category = category;
        this.owner = owner;
    }

    public Book(String bookName,
                String description, boolean state,
                String category, Integer owner){
        this(null, bookName, description, state, category, owner);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
    public int compareTo(Book other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return bookName +": " + description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
