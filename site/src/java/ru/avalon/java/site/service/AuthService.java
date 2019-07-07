/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.service;

import ru.avalon.java.site.entities.User;
import ru.avalon.java.site.services.UserService;
import ru.avalon.java.site.entities.Address;
import ru.avalon.java.site.services.AddressService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.avalon.java.site.exceptions.ValidationException;
import static ru.avalon.java.site.helpers.Validation.*;
import ru.avalon.java.site.services.CryptWithMD5;

/**
 *
 * @author pashak
 */
@Stateless
public class AuthService {
    @EJB UserService userService;
    @EJB AddressService addressService;
    
    @Inject HttpSession session;
    
    public void signIn(String email, String password) throws ValidationException{
        require(email, "Email is required");
        require(password, "password is required");
        User user = userService.findByEmail(email);
        requireNotNull(user, "user does not exist");
        requireEquals(user.getPassword(), CryptWithMD5.cryptWithMD5(password), "Invalid password");
        session.setAttribute("user", email);
    }
    
    public boolean isSignedIn() {
       return session.getAttribute("user") != null;
    }
    
    public void register(String email, String name, String password, String passwordConfirmation) throws ValidationException {
        require(email, "Email is required");
        require(password, "password is required");
        require(name, "Name is required");
        require(passwordConfirmation, "Password confirmation is required");
        requireEquals(password, passwordConfirmation, "passwords does not match confirmation");
        User user = userService.findByEmail(email);
        requireNull(user, "User already registred");
        user = new User(email, name, password);
        userService.create(user);
    }
    
    public void register(String email, String name, String address, String city, String zip, String password, String passwordConfirmation) throws ValidationException {
        require(email, "Email is required");
        require(password, "password is required");
        require(name, "Name is required");
        require(address, "Adress is required");
        require(city, "City is required");
        require(zip, "Zip is required");
        require(passwordConfirmation, "Password confirmation is required");
        requireEquals(password, passwordConfirmation, "passwords does not match confirmation");
        User user = userService.findByEmail(email);
        requireNull(user, "User already registred");
        user = new User(email, name, password);
        Address addr = new Address(address, city, zip, user);
        userService.create(user);
        addressService.create(addr);
    }
    
    public void signOut() {
         session.invalidate();
    }
    public User getUser() {
        String email = (String) session.getAttribute("user");
        if (email != null) {
            return userService.findByEmail(email);
        }
        return null;
    }
}
