<%-- 
    Document   : list
    Created on : 06.07.2019, 23:47:24
    Author     : pashak
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<%@tag import="java.util.*" %>
<%@tag import="ru.avalon.java.site.entities.*" %>
<%@attribute name="articles"
             type="List<Article>"
             required="true"%>


 <div class="centered">
        <c:choose>
            <c:when test="${not empty articles}">
                <table class="responsive" data-max="15">
                     <thead>
                         <tr>
                             <th><fmt:message key="article.title"/></th>
                             <th><fmt:message key="article.article"/></th>
                             <th><fmt:message key="article.created"/></th>
                             <th><fmt:message key="article.author"/></th>
                         </tr>
                     </thead>
                <c:forEach items="${articles}" var="item">
                    <div class="row">
                            <tbody>
                                <tr>
                                    <td>
                                        <p class="box round info">
                                            <core:link  location="/article?id=${item.id}"
                                                        title="${item.title}"/>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="box">
                                            <c:if test="${not empty item.content}">
                                                <c:choose>
                                                    <c:when test="${item.content.length() > 128}">
                                                        ${item.content.substring(0,128)}...
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${item.content}
                                                    </c:otherwise>
                                                </c:choose>
                                        </c:if>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="box">
                                            ${item.created}
                                        </p>
                                    </td>
                                    <td>
                                        <p class="box">
                                            ${item.author.email}
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        <br>
                    </div>
                </c:forEach>
                    </table>
            </c:when>
            <c:otherwise>
                <p>
                    There is no articles currently published....
                </p>
            </c:otherwise>
        </c:choose>
    </div>
    
    