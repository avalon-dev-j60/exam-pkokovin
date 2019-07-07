<%-- 
    Document   : link
    Created on : 29.06.2019, 14:28:24
    Author     : pashak
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="location" required="true"%>
<%@attribute name="title" required="true"%>

<a href="${pageContext.servletContext.contextPath}${location}">
    ${title}
</a>
