package com.instruweb.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String emailaddress;
    private boolean verified;
    private String role;
    private String address;
    private String postalcode;
    private String phonenumber;

    public User() {}

    public User(Integer id, String username, String firstname, String lastname, String emailaddress, boolean verified, String role, String address, String postalcode, String phonenumber) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.verified = verified;
        this.role = role;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {this.emailaddress = emailaddress;}

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {this.verified = verified;}

    public String getRole() { return role; }

    public void setRole(String role) {this.role = role;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {this.address = address;}

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {this.postalcode = postalcode;}

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;}
}
