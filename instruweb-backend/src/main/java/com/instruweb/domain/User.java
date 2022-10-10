package com.instruweb.domain;

import javax.persistence.*;
import io.quarkus.resteasy.reactive.jackson.SecureField;

@Entity
public class User {
    public enum Role {
        User,
        Admin
    }

    // @SecureField(rolesAllowed = "admin")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailaddress;
    private String password;
    private boolean verified;
    private Integer role;
    private String address;
    private String postalcode;
    private String phonenumber;

    public User() {}

    public User(Integer id, String firstname, String lastname, String emailaddress, String password, boolean verified, Integer role, String address, String postalcode, String phonenumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.password = password;
        this.verified = verified;
        this.role = role;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
    }

    public Integer getId() {
        return id;
    }

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

    public Integer getRole() { return role; }

    public void setRole(Integer role) {this.role = role;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {this.password = password;}

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
