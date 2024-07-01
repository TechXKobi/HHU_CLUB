package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;

public class Book extends Offer{

    public Book(Integer id, String bookName,
                String description, boolean state,
                String category, Integer owner, LocalDateTime dateTime, Integer price){
        super(id, bookName, description, state, category, owner, dateTime, price);
    }

    public Book(String bookName,
                String description, boolean state,
                String category, Integer owner, LocalDateTime dateTime, Integer price){
        this(null, bookName, description, state, category, owner, dateTime, price);
    }
}
