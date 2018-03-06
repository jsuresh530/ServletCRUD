<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
        <div class="row">

            <div class="col-md-8 col-md-offset-2">
                <form role="form" method="POST" action="ServletCRUD/login.do">

                    <legend class="text-center">Register</legend>

                    <fieldset>
                        <legend>Account Details</legend>

                        <div class="form-group col-md-6">
                            <label for="first_name">First name</label>
                            <input type="text" class="form-control" name="" id="first_name" placeholder="First Name">
                        </div>

                        <div class="form-group col-md-6">
                            <label for="last_name">Last name</label>
                            <input type="text" class="form-control" name="last_name" id="" placeholder="Last Name">
                        </div>

                        <div class="form-group col-md-12">
                            <label for="">Email</label>
                            <input type="email" class="form-control" name="" id="" placeholder="Email">
                        </div>

                        <div class="form-group col-md-6">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="" id="password" placeholder="Password">
                        </div>

                        <div class="form-group col-md-6">
                            <label for="confirm_password">Confirm Password</label>
                            <input type="password" class="form-control" name="" id="confirm_password" placeholder="Confirm Password">
                        </div>


                    </fieldset>

                    <fieldset>
                        <legend>Optional Details</legend>

                        <div class="form-group col-md-6">
                            <label for="country">Country of Residence</label>
                            <select class="form-control" name="" id="country">
                                <option>Country 1</option>
                                <option>Country 2</option>
                                <option>Country 3</option>
                            </select>
                        </div>

                        <div class="form-group col-md-12">
                            <label for="found_site">How did you find out about the site?</label>
                            <select class="form-control" name="" id="found_site">
                                <option>Company</option>
                                <option>Friend</option>
                                <option>Colleague</option>
                                <option>Advertisement</option>
                                <option>Google Search</option>
                                <option>Online Article</option>
                                <option value="other" >Other</option>
                            </select>
                        </div>

                        <div class="form-group col-md-12 hidden">
                            <label for="specify">Please Specify</label>
                            <textarea class="form-control" id="specify" name=""></textarea>
                        </div>

                    </fieldset>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" id="">
                                    I accept the <a href="#">terms and conditions</a>.
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                        
                        <a href="usersController.do?action=insert" class="btn btn-primary" role="button">Register</a>
                            <!-- <button type="submit" class="btn btn-primary">
                                Register
                            </button>
                            <a href="#">Already have an account?</a> -->
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#found_site').on('change', function() {
       $(this).val() == "other" ? $('#specify').closest('.form-group').show() : $('#specify').closest('.form-group').hide();
    })
})
</script>
<jsp:include page="footer.jsp"></jsp:include>