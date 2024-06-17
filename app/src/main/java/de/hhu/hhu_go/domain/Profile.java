package de.hhu.hhu_go.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Profile implements Comparable<Profile>{
    private Integer id;

    private String userName;

    private String forename;

    private String surname;

    private Integer age;

    private String subject;

    private char degree;

    private Integer term;

    //private final List<Integer> friends = new ArrayList<>();
    private final List<Profile> friends = new ArrayList<>();


    public Profile(Integer id, String userName,
                  String forename, String surname,
                  Integer age, String subject,
                  Integer term, char degree){
        this.id = id;
        this.userName = userName;
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.subject = subject;
        this.term = term;
        this.degree = degree;
    }
    public Profile(String userName,
                   String forename, String surname,
                   Integer age, String subject,
                   Integer term, char degree){
        this(null, userName,
                forename, surname,
                age, subject,
                term, degree);
    }

    public List<Profile> getFriends(){
        return Collections.unmodifiableList(friends);
    }
    public void addFriend(Profile p){
        friends.add(p);
    }

    public boolean deleteFriend(Integer id){
        return friends.removeIf(f->f.getId().equals(id));
    }

    public Integer getId(){
        return id;
    }

    public String getForename(){
        return forename;
    }

    public void setForename(String forename){
        this.forename = forename;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String suname){
        this.surname = surname;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public char getDegree(){
        return degree;
    }

    public void setDegree(char degree){
        this.degree = degree;
    }

    public Integer getTerm(){
        return term;
    }

    public void setTerm(Integer term){
        this.term = term;
    }


    @Override
    public int compareTo(Profile other){
        return id.compareTo(other.id);
    }

    @Override
    public String toString(){
        return getUserName() + ", " + getForename() + " " + getSurname();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;

        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}
