package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Events implements Comparable<Events>{
    private Integer id;

    private String eventName;

    private LocalDateTime dateTime;

    private String place;

    private String description;

    private String category;

    private final List<Profile> participants = new ArrayList<>(); // drawable ids

    private Integer creatorId;

    public Events(Integer id, String eventName, LocalDateTime dateTime, String place,
                  String description, String category,
                  Integer creatorId){
        this.id = id;
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.place = place;
        this.description = description;
        this.category = category;
        this.creatorId = creatorId;
    }

    public Events(String eventName, LocalDateTime dateTime, String description,
                  String category, Integer creatorId, String place){
        this(null, eventName, dateTime, place, description, category, creatorId);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public List<Profile> getParticipants(){
        return Collections.unmodifiableList(participants);
    }

    public void addParticipant(Profile p){
        participants.add(p);
    }

    public void deleteParticipant(Integer pId){
        participants.removeIf(p->p.getId().equals(pId));
    }

    @Override
    public int compareTo(Events other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events event = (Events) o;

        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
