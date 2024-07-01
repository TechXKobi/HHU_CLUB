package de.hhu.hhu_go.domain;

import java.net.URL;
import java.util.Objects;

public class Locality implements Comparable<Locality>{

    private Integer id;

    private String locationName;

    private String description;

    private String address;

    private String link;

    private String locationCategory;

    private Integer imageId;

    public Locality(Integer id, String locationName,
                    String description, String address, String link,
                    String locationCategory, Integer imageId){
        this.id = id;
        this.locationName = locationName;
        this.description = description;
        this.address = address;
        this.link = link;
        this.locationCategory = locationCategory;
        this.imageId = imageId;
    }

    public Locality(String locationName,
                    String description, String address,
                    String link, String locationCategory, Integer imageId){
        this(null, locationName, description, address,
                link, locationCategory, imageId);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocationCategory() {
        return locationCategory;
    }

    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

    @Override
    public int compareTo(Locality other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return locationName +": " + description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locality loc = (Locality) o;

        return Objects.equals(id, loc.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
