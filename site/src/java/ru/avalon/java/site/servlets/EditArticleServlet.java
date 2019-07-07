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
import javax.servlet.http.HttpServletResponse;;
import ru.avalon.java.site.entities.Article;
import ru.avalon.java.site.exceptions.ValidationException;
import static ru.avalon.java.site.helpers.RedirectHelper.*;
import static ru.avalon.java.site.helpers.Validation.*;
import ru.avalon.java.site.service.AuthService;
import ru.avalon.java.site.services.ArticleService;

/**
 *
 * @author pashak
 */
@WebServlet("/edit")
public class EditArticleServlet extends HttpServlet{
    private static final String JSP = "/WEB-INF/pages/articles/edit.jsp";
    @Inject AuthService authService;
    @EJB ArticleService articleService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isSignedIn()) {
            String id = request.getParameter("id");
            if (id != null) {
                try {
                    long lid = Long.parseLong(id);
                    Article article = articleService.findById(lid);
                    requireNotNull(article, "");
                    request.setAttribute("article", article);
                } catch (ValidationException | NumberFormatException ex) {
                    response.sendError(
                            HttpServletResponse.SC_NOT_FOUND);
                }
            }
            request.getRequestDispatcher(JSP).forward(request, response);
        } else {
            localRedirect(request, response, "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        try {
            long lid = Long.parseLong(id);
            Article article = articleService.findById(lid);
            article.setTitle(title);
            article.setContent(content);
            articleService.save(article);
            localRedirect(request, response, "/articles");
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

}
