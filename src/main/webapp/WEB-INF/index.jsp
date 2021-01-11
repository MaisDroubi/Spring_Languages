<%--
  Created by IntelliJ IDEA.
  User: pccorner
  Date: ١٠/٠١/٢٠٢١
  Time: ١١:٢٣ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>languages</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Welcome to languages Dot Com!</h1>
    <a href="/new">Add a language</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ languages }" var="language">
            <tr>
                <td><a href="/${ language.id }">${ language.name }</a></td>
                <td>${ language.creator }</td>
                <td>${ language.currentVersion }</td>
                <td>
                    <a class="btn btn-primary" href="/${ language.id }/edit">Edit</a>
                    <form id="delete-form" action="/${language.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input class="btn btn-danger" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
