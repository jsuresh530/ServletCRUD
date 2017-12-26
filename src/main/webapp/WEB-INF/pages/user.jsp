<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<%-- 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery-ui.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-ui.min.js"></script> --%>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>Add new user</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='UsersController' name="frmAddUser">
        
        First Name : <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /> <br /> 
        Last Name : <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /> <br /> 
        DOB : <input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br /> 
        Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /> <br /> 
        
        <input type="submit" value="Submit" />
        
    </form>
</body>
</html>