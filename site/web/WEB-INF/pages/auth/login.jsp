<%-- 
    Document   : login
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core"%>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>

<core:layout title="Sign in">
    <div class="centered">
        <core:error/>
    </div>
    <div class="one third centered">
        <h2>Login</h2>
        <auth:login/>
    </div>
</core:layout>