package com.example.individalassigment;

public class signupinf {
    private String fullname;
    private String username;
    private String email;
    private String gender;
    private String pass;
    public signupinf(String username,String pass){
        this.username = username;
        this.pass = pass;
    }

    public signupinf(String fullname, String username, String email, String gender, String pass) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
