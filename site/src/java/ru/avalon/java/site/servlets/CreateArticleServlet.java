/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.site.entities.Article;
import ru.avalon.java.site.entities.User;
import ru.avalon.java.site.exceptions.ValidationException;
import static ru.avalon.java.site.helpers.RedirectHelper.*;
import ru.avalon.java.site.service.AuthService;
import static ru.avalon.java.site.helpers.Validation.*;
import ru.avalon.java.site.services.ArticleService;

/**
 *
 * @author pashak
 */
@WebServlet("/create")
public class CreateArticleServlet extends HttpServlet{
    private static final String JSP = "/WEB-INF/pages/articles/create.jsp";
    
    @Inject AuthService authService;
    @EJB ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(authService.isSignedIn()){
        request .getRequestDispatcher(JSP)
                .forward(request, response);
        } else {
            localRedirect(request, response, "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        try {
            require(title, "Title is required!");
            require(content, "Content is required!");
            User user = authService.getUser();
            requireNotNull(
                user, 
                "You should be authorized to "
                + "create publications!"
            );
            Article article = new Article(
                title, 
                content, 
                user
            );
            articleService.create(article);
            localRedirect(request, response, "/");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
    
    
}
