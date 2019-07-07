/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author pashak
 */
@NamedQueries({
    @NamedQuery(
            name = "list-articles",
            query = "SELECT p FROM Article AS p"
    ),
    @NamedQuery(
            name = "find-articles-by-user",
            query = "SELECT p FROM Article AS p WHERE p.author = :user "
    ),
   
    @NamedQuery(
            name = "find-article-by-id",
            query = "SELECT p FROM Article AS p WHERE p.id = :id "
    )
        
})
@Entity
public class Article implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "long varchar")
    private String content;
        
    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    protected Article() {
    }

    public Article(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.created = new Date();
        
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreated() {
        return created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
