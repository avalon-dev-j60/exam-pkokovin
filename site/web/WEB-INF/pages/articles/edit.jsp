<%-- 
    Document   : editsinglearticle
    Created on : 05.07.2019, 15:04:17
    Author     : pashak
--%>

<%@ page import="ru.avalon.java.site.entities.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>
<%@taglib prefix="articles" tagdir="/WEB-INF/tags/articles/"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<core:layout title="Edit your article">
    <h2>Article edit</h2>
    
    <articles:edit article="${article}"
                       action="/edit"/>
</core:layout>
