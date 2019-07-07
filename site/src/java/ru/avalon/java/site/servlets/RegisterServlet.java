/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.servlets;

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
import ru.avalon.java.site.helpers.RedirectHelper;
import ru.avalon.java.site.service.AuthService;

/**
 *
 * @author pashak
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private static final String JSP = "/WEB-INF/pages/auth/register.jsp";

    @Inject AuthService authService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isSignedIn()){
            RedirectHelper.redirectBack(request, response);
        } else {
        request.getRequestDispatcher(JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String confirmation = request.getParameter("confirmation");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String address = request.getParameter("address");
        if (address.trim().isEmpty() && city.trim().isEmpty() && zip.trim().isEmpty()) {
            try {
            authService.register(email, name, password, confirmation);
            RedirectHelper.localRedirect(request, response, "/login");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
        } else {
            try {
            authService.register(email, name, address, city, zip, password, confirmation);
            RedirectHelper.localRedirect(request, response, "/login");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
        }
    }

    
}
