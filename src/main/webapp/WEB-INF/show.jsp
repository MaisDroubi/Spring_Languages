<%--
  Created by IntelliJ IDEA.
  User: pccorner
  Date: ١٠/٠١/٢٠٢١
  Time: ١١:٢٣ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Details for Language #${ language.id }</h1>
    <hr />
    <h1><c:out value="${language.name}"/></h1>
    <p>Creator: <c:out value="${language.creator}"/></p>
    <p>Current Version: <c:out value="${language.currentVersion}"/></p>
    <a class="btn btn-primary" href="/${language.id}/edit">Edit Language</a>
    <form id="delete-form" action="/${language.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-danger" type="submit" value="Delete">
    </form>
</div>
</body>
</html>
