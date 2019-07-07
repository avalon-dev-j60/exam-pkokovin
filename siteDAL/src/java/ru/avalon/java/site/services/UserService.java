/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import ru.avalon.java.site.entities.User;

/**
 *
 * @author pashak
 */
@Stateless
public class UserService {
    @PersistenceContext(unitName = "site-PU")
    EntityManager em;
    
    public void create(User user) {
        em.persist(user);
    }
    
    public User findByEmail(String email) {
        try {
            return em.createNamedQuery("find-user-by-email", User.class).setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
