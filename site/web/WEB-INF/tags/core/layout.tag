<%-- 
    Document   : layout
 
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core" %>

<%@attribute name="title"%>

<html>
    <head>
        <title>${title}</title>
        <meta charset="UTF-8">
        <link href="${pageContext.servletContext.contextPath}/css/groundwork-setup.css"
              type="text/css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/css/layout.css"
              type="text/css" rel="stylesheet">
    </head>
    <body>
        <header>
            <core:menu/>
        </header>
        <article class="justify">
            <section class="two thirds centered padded">
                <jsp:doBody/>
            </section>
        </article>
        <footer>
            <section class="two thirds centered padded">
                <span class="pull-right">
                SimpleSite 2019 &#169;
                </span>
            </section>
        </footer>
    </body>
</html>