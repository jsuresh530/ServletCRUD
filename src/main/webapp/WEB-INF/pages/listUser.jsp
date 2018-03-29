<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="header.jsp" %>
<title>Show All Users</title>
<style>
body .container-fluid.body-content {
  position: absolute;
  top: 90px;
  bottom: 30px;
  right: 0;
  left: 0;
  overflow-y: auto;
}
</style>
<body>
<div class="container-fluid body-content">

<h1 style="color: red;"> Welcome , ${admin}  <a href="logout.do" class="btn btn-primary pull-right" role="button" style="background-color: #337ab7">Logout</a> </h1> 
    <table border=1 class="table table-bordered">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th>File</th>
                <th colspan=2 style="text-align:center">Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${fn:length(users) > 0}">
            
            <c:forEach items="${users}" var="user">
	                <tr>
	                    <td><c:out value="${user.firstName}" /></td>
	                    <td><c:out value="${user.lastName}" /></td> 
	                    <td><c:out value="${user.dob}" /></td>
	                    <td><c:out value="${user.email}" /></td>
	                    <td title="Click here to download"><a href="downloadFile.do?fileName=<c:out value="${user.fileName}"/>" style="background-color: #337ab7"> <c:out value="${user.fileName}" /> </a></td>
	                    <td title="Click here to edit user details"><a href="usersController.do?action=edit&userId=<c:out value="${user.userid}"/>" style="background-color: #337ab7">Edit</a></td>
	                    <td title="Click here to delete user"><a href="usersController.do?action=delete&userId=<c:out value="${user.userid}"/>" style="background-color: #337ab7">Delete</a></td>
	                </tr>
            </c:forEach>
            </c:if>
            
             <c:if test="${fn:length(users) == 0}">
             	<tr> <td colspan="5" style="text-align:center"> <h2> No records to display. </h2> </td> </tr>
             </c:if>
        </tbody>
    </table>
    
    </div>
</body>

<script type="text/javascript">

function downloadFile(filename)
{
	var action = "downloadFile.do";
	//var url = action + "?fileName="+method+"&documentId=" +filename;
    var url = action + "?fileName="+filename;
    alert(url)
    $.ajax({
          url: url,
          dataType: "text", // Change dataType to "text"
          type: 'GET',
          success: function(data){
              if (data == "FAIL") {
                  alert("File not found!");
              } else {
                  window.location.href = data; // Download the file
              }
          },
          error: function (request, status, error) {
              alert("The request failed: " + request.responseText);
          }
    });
	
}

</script>
<%@include file="footer.jsp" %>