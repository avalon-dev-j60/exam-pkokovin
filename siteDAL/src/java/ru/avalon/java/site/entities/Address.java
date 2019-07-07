/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author pashak
 */
@NamedQueries({
    @NamedQuery(
            name = "find-address-by-user",
            query = "SELECT p FROM Address AS p WHERE p.author = :user "
    )
}
)
@Entity
public class Address implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User author;
    private String address;
    private String city;
    private String zip;
    
    protected Address() {
    }

    public Address(String address, String city, String zip, User author) {
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
}
