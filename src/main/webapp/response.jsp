<%-- 
    Document   : response
    Created on : 29 Apr 2022, 2:28:51 am
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>s Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="com.dvd.model.DVDItem" />
        <jsp:setProperty name="mybean" property="title" />
    <h1>Hello, <jsp:getProperty name="mybean" property="title" />!</h1>
    </body>
</html>
