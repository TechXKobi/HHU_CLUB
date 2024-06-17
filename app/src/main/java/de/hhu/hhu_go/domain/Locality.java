package de.hhu.hhu_go.domain;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Locality implements Comparable<Locality>{

    private Integer id;

    private String locationName;

    private String description;

    private Integer postCode;

    private Integer googleStarsRating;

    private URL linkGoogle;

    private String locationCategory;

    public Locality(Integer id, String locationName,
                    String description, Integer postCode,
                    Integer googleStarsRating, URL link,
                    String locationCategory){
        this.id = id;
        this.locationName = locationName;
        this.description = description;
        this.postCode = postCode;
        this.googleStarsRating = googleStarsRating;
        this.linkGoogle = link;
        this.locationCategory = locationCategory;
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

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Integer getGoogleStarsRating() {
        return googleStarsRating;
    }

    public void setGoogleStarsRating(Integer googleStarsRating) {
        this.googleStarsRating = googleStarsRating;
    }

    public URL getLinkGoogle() {
        return linkGoogle;
    }

    public void setLinkGoogle(URL linkGoogle) {
        this.linkGoogle = linkGoogle;
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
}
