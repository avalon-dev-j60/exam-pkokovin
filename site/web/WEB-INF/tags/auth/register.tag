<%-- 
    Document   : register
 
--%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources.labels"/>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="message"%>
<form action="${pageContext.servletContext.contextPath}/register" method="post">
  <fieldset>
    <legend>Register Here</legend>
    <div class="row">
      <div class="one half padded">
        <label for="name">Input Your name here</label>
        <input name="name" type="text" placeholder="First & Last Name">
      </div>
      <div class="one half padded">
        <label for="email">Write Your email here</label>
        <input name="email" type="email" value="${param.email}" placeholder="you@example.com">
      </div>
    </div>
    <div class="row">
      <div class="one whole padded">
        <label for="address">Address</label>
        <input name="address" type="text" placeholder="Street Address">
      </div>
    </div>
    <div class="row">
      <div class="two fourths padded">
        <input name="city" type="text" placeholder="City">
      </div>
      <div class="two fourth padded">
        <input name="zip" type="text" placeholder="Zip Code">
      </div>
    <div class="row">
      <div class="padded">
        <label for="password">Password</label>
        <input name="password" type="password" placeholder="Enter Your password here">
      </div>
      <div class="row">
      <div class="padded">
        <label for="confirmation">Confirm Your password</label>
        <input name="confirmation" type="password" placeholder="Confirm Your password">
      </div>
      </div>
        <div class="row">
            <div class="padded">
                <core:button>
                    <jsp:attribute name="title">
                        <fmt:message key="menu.register"/>
                    </jsp:attribute>
                 </core:button>
            </div>
        </div>
    </div>
   </fieldset>
</form>