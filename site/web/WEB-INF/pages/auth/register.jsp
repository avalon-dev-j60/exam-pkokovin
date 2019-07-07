<%-- 
    Document   : register
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core"%>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>

<core:layout title="Register">
    <div class="centered">
        <core:error/>
    </div>
    <div class="one half centered">
        <auth:register/>
    </div>
</core:layout>
