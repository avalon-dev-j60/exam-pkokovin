<%-- 
    Document   : menu
  
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<fmt:setBundle basename="resources.labels"/>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="menu"%>
<!-- Nav -->
<nav id="nav">
    <ul class="container">
        <li>
            <core:link location="/">
                <jsp:attribute name="title">
                    <fmt:message key="menu.home"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li>
            <core:link location="/articles">
                <jsp:attribute name="title">
                    <fmt:message key="menu.articles"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li>
            <core:link location="/about">
                <jsp:attribute name="title">
                    <fmt:message key="menu.about"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li>
            <core:link location="/contacts">
                <jsp:attribute name="title">
                    <fmt:message key="menu.contacts"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <core:link location="/logout">
                        <jsp:attribute name="title">
                    <fmt:message key="menu.logout"/>
                </jsp:attribute>
                    </core:link>
                </c:when>
                <c:otherwise>
                    <core:link location="/login">
                        <jsp:attribute name="title">
                    <fmt:message key="menu.login"/>
                </jsp:attribute>
                    </core:link>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</nav>
