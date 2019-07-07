/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.helpers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author pashak
 */
public class RedirectHelper {

    public RedirectHelper() {
    }
     public static void redirect (HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader(HttpHeaders.LOCATION, location);
    }
    public static void localRedirect (HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        location = request.getContextPath() + location;
        redirect(request, response, location);
    }
    public static void redirectBack (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        String currentLocation = request.getRequestURL().toString();
        if (referer == null || referer.equals(currentLocation)) {
            localRedirect(request, response, "/");
        } else {
            redirect(request, response, referer);
        }
    }
    
}
