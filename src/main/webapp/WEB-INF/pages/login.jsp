<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp" %>


<title>Login Page</title>
<style>

#msg {
    text-align: center;
    width: 324px;
    margin-left: 188px;
    margin-bottom: 10px;
    };
</style>

<body>
  
 <div class="container" style="margin-top:200px;">
 
    <div class="row">
        <div class="col-md-8 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Login</strong>

                </div>
                <div class="panel-body">
				
				<div  id="msg" >
				    
			  </div>
                
                    <form class="form-horizontal" role="form" method="post" id="myForm" action="login.do">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9">
                                <input class="form-control" id="email" placeholder="Email" type="email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <input class="form-control" id="password" placeholder="Password" type="password" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label class="">
                                       <input class="" type="checkbox">Remember me</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group last">
                            <div class="col-sm-offset-3 col-sm-9">
                                <input type="submit"  id="login" class="btn btn-primary" role="button" >
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">Not User ? <a href="usersController.do?action=insert" class="btn btn-primary" role="button">Create account here.</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- <div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> This alert box could indicate a successful or positive action.
  </div>
  <div class="alert alert-info alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Info!</strong> This alert box could indicate a neutral informative change or action.
  </div>
  <div class="alert alert-warning alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Warning!</strong> This alert box could indicate a warning that might need attention.
  </div>
  <div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
  </div> -->
  
<script type="text/javascript">

$(document).ready(function(){
	//$('#msg').hide();
});

	$("#login").on('click', function(){
		
		
		var email = $("#email").val();
		var password = $("#password").val();
		
		if(email == ""){
			//alert(1)
			$("#msg").css("border","2px solid green");
			$("#msg").text('email is required..');
            return false;
        }
        if(password == ""){
            $("#msg").text('password is required..');
            //$("#password").addClass('error');
            //alert("Password is required");
            return false;
        }
        return true;
        
        /* $.ajax({
            url : "login.do",
            method : get,
            data : {
            	email : email,
                password : password
            },
            success : function(results){
                if(results != null && results != ""){
                    showMessage(results);
                    $('#messageDiv').css("display","block");
                }else{
                    $('#messageDiv').css("display","none");
                    $('#messageDiv').html("");
                    alert("Some exception occurred! Please try again.");
                }
            }
        }); */
        
	});
	
	function showMessage(results){
        if(results == 'SUCCESS'){
            $('#messageDiv').html("<font color='green'>You are successfully logged in. </font>")
        }else if(results == 'FAILURE'){
            $('#messageDiv').html("<font color='red'>Username or password incorrect </font>")
        }
    }
	
</script>

</body>
</html>