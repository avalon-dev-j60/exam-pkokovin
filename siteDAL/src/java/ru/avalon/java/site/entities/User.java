/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.entities;

import java.io.Serializable;
import javax.persistence.*;
import static ru.avalon.java.site.services.CryptWithMD5.*;

/**
 *
 * @author pashak
 */
@Entity(name = "Users")
@NamedQueries({
    @NamedQuery(
            name = "find-user-by-email",
            query = "SELECT user FROM Users AS user WHERE user.email = :email "
    )
})
public class User implements Serializable{
    @Id
    private String email;
    private String name;
    private String password;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = cryptWithMD5(password);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
}
