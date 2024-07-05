package de.hhu.hhu_go.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact implements Comparable<Contact>{
        private Integer chatOwner;

        private Integer chatPartner;

        private LocalDateTime lastTimeChatted;

        private String lastMessage;

        private Integer profilePictureId;

        private Contact(Integer owner, Integer partner,
                        LocalDateTime lastTimeChatted,
                        String lastMessage,
                        Integer profilePictureId){
            this.chatOwner = owner;
            this.chatPartner = partner;
            this.lastTimeChatted = lastTimeChatted;
            this.lastMessage = lastMessage;
            this.profilePictureId = profilePictureId;
        }

        public Contact(LocalDateTime lastTimeChatted,
                       String lastMessage,
                       Integer profilePictureId){
            this(null, null, lastTimeChatted,
                    lastMessage, profilePictureId);
        }


    public Integer getChatOwner() {
        return chatOwner;
    }

    public void setChatOwner(Integer chatOwner) {
        this.chatOwner = chatOwner;
    }

    public Integer getChatPartner() {
        return chatPartner;
    }

    public void setChatPartner(Integer chatPartner) {
        this.chatPartner = chatPartner;
    }

    public LocalDateTime getLastTimeChatted() {
        return lastTimeChatted;
    }

    public void setLastTimeChatted(LocalDateTime lastTimeChatted) {
        this.lastTimeChatted = lastTimeChatted;
    }

    public Integer getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(Integer profilePictureId) {
        this.profilePictureId = profilePictureId;
    }

    @Override
    public int compareTo(Contact other){
        return chatOwner.compareTo(other.chatOwner);
    }

    @Override
    public String toString(){
        return lastMessage;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact c = (Contact) o;

        return Objects.equals(chatOwner, c.chatOwner);
    }

    @Override
    public int hashCode(){
        return Objects.hash(chatOwner);
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
