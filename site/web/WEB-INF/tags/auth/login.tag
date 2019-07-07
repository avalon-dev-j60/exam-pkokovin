<%-- 
    Document   : login
  
--%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<form action="${pageContext.servletContext.contextPath}/login"
      method="POST">
    <p class="row gap-bottom">
        <input type="text" 
               name="email"
               value="${param.email}"
               placeholder="Email address" 
               required>
        <input type="password" 
               name="password" 
               placeholder="Password" 
               required>
    </p>
    
    <p class="row gap-bottom">
        <core:link location="/register">
                <jsp:attribute name="title">
                    <fmt:message key="menu.register"/>
                </jsp:attribute>
        </core:link>
        
        <core:button>
                <jsp:attribute name="title">
                    <fmt:message key="menu.login"/>
                </jsp:attribute>
        </core:button>
    </p>

</form>