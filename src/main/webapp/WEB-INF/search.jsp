<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
    <!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
</head>

<body>
    <a href="/new">Add New</a>  <a href="/top10">Top Songs</a>
    <form action="/search" method="get">
        <input type="text" name="artist">
        <input type="submit" value="Search">
    </form>

    <table>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>actions</th>
        </tr>
        <c:forEach items="${songs.song}" var="song">
            <tr>
                <td>${song.title}</td>
                <td>${song.rating}</td>
                <td><a href="/delete/${song.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>