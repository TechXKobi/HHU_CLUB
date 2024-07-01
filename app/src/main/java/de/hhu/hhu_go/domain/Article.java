package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Article implements Comparable<Article>{
    private Integer id;

    private String title;

    private String content;

    private final List<Integer> images = new ArrayList<>(); // drawable ids

    private Integer creatorId;

    private LocalDateTime dateTime;

    private String category;

    public Article(Integer id, String title, String content, Integer creatorId, LocalDateTime dateTime, String category){
        this.id = id;
        this.title = title;
        this.content = content;
        this.creatorId = creatorId;
        this.dateTime = dateTime;
        this.category = category;
    }

    public Article(String title, String content, Integer creatorId,
                   LocalDateTime dateTime, String category){
        this(null, title, content, creatorId, dateTime, category);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getImageIds() {
        return Collections.unmodifiableList(images);
    }

    public void addImage(Integer id){
        images.add(id);
    }

    public boolean deleteImage(Integer imageId){
        return images.removeIf(i->i.equals(imageId));
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(Article other){
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
        Article article = (Article) o;

        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
