/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.services;

import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import ru.avalon.java.site.entities.Article;
import ru.avalon.java.site.entities.User;

/**
 *
 * @author pashak
 */
@Stateless
public class ArticleService {

    @PersistenceContext(unitName = "site-PU")
    EntityManager em;

    public void create(Article article) {
        em.persist(article);
    }

    public List<Article> listAll() {
        try {
            return em.createNamedQuery("list-articles", Article.class).getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    public List<Article> findByUser(User user) {
        try {
            return em.createNamedQuery("find-articles-by-user", Article.class).setParameter("user", user).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Article findById(Long id) {
        try {
            return em.createNamedQuery("find-article-by-id", Article.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void save(Article article) {
        em.merge(article);
    }
}
