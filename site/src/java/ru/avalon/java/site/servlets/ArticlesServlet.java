/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.site.entities.Article;
import ru.avalon.java.site.services.ArticleService;

/**
 *
 * @author pashak
 */
@WebServlet(name = "ArticlesServlet", urlPatterns = {"/articles"})
public class ArticlesServlet extends HttpServlet {
    private static final String JSP = "/WEB-INF/pages/articles/articles.jsp";
    @EJB ArticleService articleService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Article> articles = articleService.listAll();
        request.setAttribute("articles", articles);
        request.getRequestDispatcher(JSP).forward(request, response);
    }

}
