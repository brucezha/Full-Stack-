<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Infinity Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <style>
    html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 420px;
  padding: 15px;
  margin: auto;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group > input,
.form-label-group > label {
  height: 3.125rem;
  padding: .75rem;
}

.form-label-group > label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0; /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  pointer-events: none;
  cursor: text; /* Match the input under the label */
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: 1.25rem;
  padding-bottom: .25rem;
}

.form-label-group input:not(:placeholder-shown) ~ label {
  padding-top: .25rem;
  padding-bottom: .25rem;
  font-size: 12px;
  color: #777;
}
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="floating-labels.css" rel="stylesheet">
  </head>
  <body>
  <!-- NAV -->

  <!-- END NAV -->
  



  <form class="form-signin" action="${pageContext.request.contextPath}/LoginServlet" method="post" name="myForm">
    <div class="text-center mb-4">
      <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Infinity Login</h1>
      <p>Welcome to Infinity Customer Portal </p>
    </div>

    <div class="form-label-group">
      <input type="text"  name="email"id="email" class="form-control" placeholder="email" required autofocus>
      <label for="email">Email</label>
    </div>

    <div class="form-label-group">
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
      <label for="inputPassword">Password</label>
    </div>

    <!-- <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div> -->

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    
    <!-- Button trigger REGISTER modal -->
    <button type="button" class="btn btn-lg btn-secondary btn-block" data-toggle="modal" data-target="#exampleModalCenter">
      Customer Registration
    </button>
    <p class="mt-5 mb-3 text-muted text-center">&copy;2019</p>
  </form>

  <!-- Modal -->
  <div class="modal fade" id="exampleModalCenter" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenterTitle">Customer Registration</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>

        <!-- MODAL REGISTRATION -->
        <div class="modal-body">
          <form action="${pageContext.request.contextPath}/register/customer" method="POST" name="register" id="register">
            <div class="row">
              <div class="col">

               <!-- FIRST NAME  -->
                  <div class="form-group input-group-sm mb-1">
                    <label for="firstName" class="col-form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                  </div>
                  <!-- FIRST NAME  -->
              </div>    
                  <!-- LAST NAME -->
                  <div class="col">
                    <div class="form-group input-group-sm mb-1">
                      <label for="lastName" class="col-form-label">Last Name</label>
                      <input type="text" class="form-control" name="lastName" id="lastName">
                    </div>
                  <!-- LAST NAME --> 
                </div>
              </div>
              
               <!-- EMAIL -->
                <div class="form-group input-group-sm mb-1">
                  <label for="email" class="col-form-label">Email: </label>
                  <input type="email" name="email" class="form-control" id="email">
                </div>
                <!-- EMAIL -->
                <!-- PASSWORD -->
                <div class="form-group input-group-sm mb-1">
                  <label for="password" class="col-form-label">Password</label>
                  <input type="password" class="form-control checkValid1" name="password" id="password"></input>
                </div>
                <!-- PASSWORD -->
                <!-- SECOND PASSWORD -->
                <div class="form-group input-group-sm mb-1">
                  <label for="password2" class="col-form-label">Confirm Password</label>
                  <input type="password" class="form-control checkValid2" name="password2" id="password2"></input>
                </div>
                <!-- SECOND PASSWORD -->
               <!-- PHONE -->
                <div class="form-group input-group-sm mb-1">
                  <label for="number" class="col-form-label">Phone Number: </label>
                 <input class="form-control" type="tel" id="phone" name="phone"
       pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
       required>
                </div>
                <!-- EMAIL -->

            <div class="row">
              <div class="col">
               <!-- ADDRESS -->
               <fieldset>
                <legend>Address</legend>
                <!-- STREET ADDRESS 1 -->
                <div class="form-group input-group-sm mb-1">
                  <label for="streetAddress1" class="col-form-label">Street Address</label>
                  <input type="text" class="form-control" id="streetAddress1" name="streetAddress1">
                </div>
                <!-- STREET ADDRESS 1 -->
                <!-- BEGIN STREET ADDRESS 2 -->
                <div class="form-group input-group-sm mb-1">
                  <label for="streetAddress2" class="col-form-label">Street Address 2</label>
                  <input type="text" class="form-control" id="streetAddress2" name="streetAddress2">
                </div>
                <!-- END STREET ADDRESS 2 -->
                <div class="row">
                  <!-- BEGIN CITY -->
                  <div class="col">
                   <div class="form-group input-group-sm mb-1">
                     <label for="city" class="col-form-label">City</label>
                     <input type="text" class="form-control" id="city" name="city">
                   </div>
                 </div>
                 <!-- END CITY -->
                 <!-- BEGIN STATE -->
                 <div class="col">
                   <div class="form-group input-group-sm mb-1">
                    <label for="state" class="col-form-label">State</label>
                    <input type="text" class="form-control" id="state" name="state">
                  </div>
                </div>
              </div>
              <!-- END STATE -->

              <div class="row"> <!-- NEW ROW -->
                <!-- BEGIN ZIP -->
                <div class="col">
                 <div class="form-group input-group-sm mb-1">
                  <label for="zip" class="col-form-label">Zip Code:</label>
                  <input type="number" class="form-control" id="zip" name="zip">
                </div>
              </div>
              <!-- END ZIP -->
             
          </div> <!-- END ROW -->
        </div>         
      </div>
    </fieldset>
    <!-- ADDRESS  -->
    <div class="modal-footer">
      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</div>
</div>
<!-- END MODAL REGISTRATION -->
</div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
