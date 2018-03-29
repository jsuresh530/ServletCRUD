<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="header.jsp" %>
<%-- 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery-ui.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-ui.min.js"></script> --%>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>Add new user</title>
<style>
body {
    margin: 0 0 100px;
    padding: 25px;
}
</style>
<body >
<div class="container" style="margin-top:200px;">
    <form method="POST" action='usersController.do' name="frmAddUser" class="form-horizontal" enctype="multipart/form-data">
    <input type ="hidden" value ="${userId}" name ="userId">
    <input type ="hidden" value ="${action}" id ="action">
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">First Name *</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="firstName" placeholder="Enter firstName" name="firstName" value="${user.firstName}" required="required">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastName">Last Name</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="lastName" placeholder="Enter lastName" name="lastName" value="${user.lastName}">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="dob">Date of Birth *</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="dob" required="required" placeholder="Enter Date of birth" name="dob" value="${user.dob}">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">Email *</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${user.email}" required="required">
      </div>
      
    </div>
  
    <c:if test="${action != 'edit'}">
    
	    <div class="form-group">
	    	<label class="control-label col-sm-2" for="exampleInputFile">File input</label>
	    	 <div class="col-sm-8">
	    		<input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" name="fileName" value="${user.fileName}">
	    		<small id="fileHelp" class="form-text text-muted">Max Size is 20 MB.</small>
	    	</div>
	  	</div>
  
	    <div class="form-group">
		      <label class="control-label col-sm-2" for="password">Password *</label>
		      <div class="col-sm-8">
		        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password"  required="required">
		      </div>
	    </div>
     </c:if>
        
        <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary">Submit</button>
		      </div>
    	</div>
        
    </form>
    </div>
    
    <c:if test="${action == 'edit'}">
    	<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <a href="usersController.do?action=listUser" class="btn btn-primary pull-right" role="button">Back</a>
		      </div>
    	</div>
    </c:if>
    
    <c:if test="${addUser == '1'}">
    	<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <a href="login.do" class="btn btn-primary pull-right" role="button">Back to login</a>
		      </div>
    	</div>
    </c:if>
    
    ${login}
</body>

	<script>
        $(function() {
            $('input[name=dob]').datepicker({ dateFormat: 'yy-M-dd' });
            // $('input[name=dob]').datepicker({ dateFormat: 'yy-mm-dd' });
        });
    </script>
    
<%@include file="footer.jsp" %>