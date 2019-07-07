<%-- 
    Document   : edit
    Created on : 04.07.2019, 9:50:53
    Author     : pashak
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<%@attribute name="article" 
             type="ru.avalon.java.site.entities.Article"%>

<%@attribute name="action" required="true" %>

<core:error/>

<form action="${pageContext.servletContext.contextPath}${action}" 
      method="post">
    
    <c:if test="${not empty article}">
        <input type="hidden"
               name="id"
               value="${article.id}">
    </c:if>
    
    <div class="row gap-bottom">
        <input type="text"
               name="title"
               placeholder="Title"
               <c:if test="${not empty article}">
                    value="${article.title}"
               </c:if>
               required>
    </div>
    
    <div class="row gap-bottom">
        <textarea name="content"
                  placeholder="Content"
                  required><c:if test="${not empty publication}">${article.content}</c:if></textarea>
    </div>
    
    <div class="row gap-bottom">
        <button class="pull-right">
            Save
        </button>
    </div>
    
</form>