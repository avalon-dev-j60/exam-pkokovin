<%-- 
    Document   : articles

--%>

<%@ page import="java.util.List" %>
<%@ page import="ru.avalon.java.site.entities.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core"%>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
<%@taglib prefix="articles" tagdir="/WEB-INF/tags/articles/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<core:layout title="Articles">
    <articles:list articles="${articles}"/> 
    <div class="two thirds row gap-bottom">
        <p class="row gap-bottom">
        <core:link location="/create">
                <jsp:attribute name="title">
                    <fmt:message key="menu.edit"/>
                </jsp:attribute>
        </core:link>
        </p>
    </div>
</core:layout>
