/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.services;

import javax.ejb.Stateless;
import javax.persistence.*;
import ru.avalon.java.site.entities.Address;
import ru.avalon.java.site.entities.User;

/**
 *
 * @author pashak
 */
@Stateless
public class AddressService {
    @PersistenceContext(unitName = "site-PU")
    EntityManager em;
    
    public void create(Address address){
        em.persist(address);
    }
    
    public Address findByUser(User user) {
        try {
            return em.createNamedQuery("find-address-by-user", Address.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
