<%-- 
    Document   : read
    Created on : 06.07.2019, 23:44:05
    Author     : pashak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core"%>
<%@taglib prefix="articles" tagdir="/WEB-INF/tags/articles/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<core:layout title="${article.title}">
    <articles:view article="${article}"/>   
</core:layout>
