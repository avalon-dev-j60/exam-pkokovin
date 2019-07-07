<%-- 
    Document   : error
    Created on : 29.06.2019, 15:14:45
    Author     : pashak
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="exception"%>

<c:if test="${not empty exception}">
    <span class="box error gap-bottom gap-top">
        ${exception.message}
    </span>
</c:if>