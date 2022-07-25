package com.example.splitit;

public class User {
    private String name, uid, phonenumber, profileimage;

    public User() {

    }

    public User(String name, String uid, String phonenumber, String profileimage) {
        this.name = name;
        this.uid = uid;
        this.phonenumber = phonenumber;
        this.profileimage = profileimage;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getuid() {
        return uid;
    }

    public String getProfileimage() {
        return profileimage;
    }
}

