package de.hhu.hhu_go.domain;

import android.provider.MediaStore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Message implements Comparable<Message>{
    private Integer id;

    private String content;

    private final List<Integer> images = new ArrayList<>(); // drawable ids

    private Integer userId;

    private LocalDateTime dateTime;

    public Message(Integer id, String content, Integer userId, LocalDateTime dateTime){
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public Message(String content, Integer userId, LocalDateTime dateTime){
        this(null, content, userId, dateTime);
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(){
        this.content = content;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public void addImage(Integer id){
        images.add(id);

    }

    public List<Integer> getImageIds(){
        return Collections.unmodifiableList(images);
    }

    public boolean deleteImage(Integer imageId){
        return images.removeIf(i->i.equals(imageId));
    }

    @Override
    public int compareTo(Message other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return content;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message msg = (Message) o;

        return Objects.equals(id, msg.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


}
