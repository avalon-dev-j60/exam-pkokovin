<%-- 
    Document   : view
    Created on : 07.07.2019, 16:26:42
    Author     : pashak
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@tag import="ru.avalon.java.site.entities.Article" %>
<%@attribute name="article" type="Article" required="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="resources.labels"/>

<h2>${article.title}</h2>

${article.content}

<c:set var="var1" value="${user}"/>
<c:set var="var2" value="${article.author.email}"/>
<c:choose>
    <c:when test = "${var1 == var2}">
        <form action="/edit" method="GET">
            <input type="hidden" name="id" value="${article.id}"/>
            <core:button>
                <jsp:attribute name="title">
                    <fmt:message key="menu.change"/>
                </jsp:attribute>
            </core:button>
        </form>
    </c:when>
</c:choose>