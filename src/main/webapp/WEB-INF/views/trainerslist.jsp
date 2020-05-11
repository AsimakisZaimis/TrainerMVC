<%-- 
    Document   : trainerslist
    Created on : May 10, 2020, 6:22:00 PM
    Author     : Asimakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Trainer's List</title>
    </head>
    <body>
        <h1>Trainer's List</h1>
        <table>
            <tr>
                <td>ID</td><td>First Name</td><td>Last Name</td><td>Subject</td><td></td>
            </tr>
            <c:forEach items="${trainers}" var="trainer">
                <tr>
                    <!-- edit: http://localhost:8080/edit/{id} -->
                    <td><a href="<c:url value='${editurl}/${trainer.id}' />">${trainer.id}</a></td>
                    <td>${trainer.firstName}</td>
                    <td>${trainer.lastName}</td>
                    <td>${trainer.subject}</td>
                    <td><a href="<c:url value='${deleteurl}/${trainer.id}' />">delete</a></td>
                </tr>
            </c:forEach>
        </tr>
    </table>
    <div id="new"><a href="<c:url value='/new' />">Add a new Trainer</a></div>
    <div id="msg">${msg}</div>
</body>
</html>
