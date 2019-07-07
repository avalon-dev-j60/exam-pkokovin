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
import static ru.avalon.java.site.helpers.Validation.*;
import static ru.avalon.java.site.helpers.RedirectHelper.*;
import ru.avalon.java.site.service.AuthService;
import ru.avalon.java.site.services.ArticleService;
import ru.avalon.java.site.services.UserService;

/**
 *
 * @author pashak
 */
@WebServlet("/article")
public class ViewArticleServlet extends HttpServlet{
    private static final String JSP = "/WEB-INF/pages/articles/read.jsp";
    @Inject AuthService authService;
    @EJB ArticleService articleService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null){
            try {
                long lid = Long.parseLong(id);
                Article article = articleService.findById(lid);
                if(authService.isSignedIn()){
                User user = authService.getUser();
                    requireNotNull(user, "Only authorized users can edit articles");
                request.setAttribute("user", user.getEmail());
                }
                requireNotNull(article, "");
                request.setAttribute("article", article);
                
                request.getRequestDispatcher(JSP).forward(request, response);
            } catch (ValidationException | NumberFormatException ex) {
                response.sendError(
                    HttpServletResponse.SC_NOT_FOUND);
            }
        
    } else {
            localRedirect(request, response, "/articles");
        }
    }
     
}
