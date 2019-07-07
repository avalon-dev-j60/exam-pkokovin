/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.servlets;

import ru.avalon.java.site.service.AuthService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.site.exceptions.ValidationException;
import static ru.avalon.java.site.helpers.RedirectHelper.*;

/**
 *
 * @author pashak
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
 
    private static final String JSP = "/WEB-INF/pages/auth/login.jsp";
    @Inject AuthService authService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isSignedIn()){
            redirectBack(request, response);
        } else {
            request.getRequestDispatcher(JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        try {
            authService.signIn(email, password);
            localRedirect(request, response, "/");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
        
    }


}
