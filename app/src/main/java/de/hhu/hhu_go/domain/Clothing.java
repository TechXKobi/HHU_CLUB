package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Clothing extends Offer{

    public Clothing(Integer id, String clothingName,
                    String description, boolean state,
                    String category, Integer owner, LocalDateTime dateTime, Integer price){
        super(id, clothingName, description, state, category, owner, dateTime, price);
    }

    public Clothing(String clothingName,
                    String description, boolean state,
                    String category, Integer owner, LocalDateTime dateTime, Integer price){
        this(null, clothingName, description, state, category, owner, dateTime, price);
    }
}
