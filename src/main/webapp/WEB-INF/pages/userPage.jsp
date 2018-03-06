<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="header.jsp" %>
<title>User Page</title>

<body>
<h1 style="color: red; margin-top: 150px; margin-right: 75px;"> Welcome , ${user}  <a href="logout.do" class="btn btn-primary pull-right" role="button">Logout</a> </h1> 

 <h1 style="color: black"> USER INFO WILL UPDATE SOON ..... </h1>
</body>
<%@include file="footer.jsp" %>