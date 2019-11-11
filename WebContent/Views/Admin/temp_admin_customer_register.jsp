<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>Infinity Customer Dashboard</title>
  <style type="text/css">

    .container {

      border: 1px solid grey;
      border-radius: 5px;

    }

  </style>
</head>
<body>
  <div class="container mt-5">
  <small>This content will auto populate with customer account info</small>
  <!-- HORIZONTAL NAV -->

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Customer Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link home" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link displayFormLink" href="#">Account Settings</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
    </div>
  </nav>
<!-- HORIZONTAL NAV -->

  <!-- UPDATE CUSTOMER DETAILS -->
  <form class="displayForm">
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
        <label for="last-name" class="col-form-label">Last Name</label>
        <input type="text" class="form-control" id="last-name">
      </div>
      <!-- LAST NAME --> 
    </div>
  </div>
  <!-- EMAIL -->
  <div class="form-group input-group-sm mb-1">
    <label for="email" class="col-form-label">Email:</label>
    <input type="email" class="form-control" id="last-name">
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
    <!-- BEGIN COUNTRY  -->
    <div class="col">
     <div class="form-group input-group-sm mb-3">
      <label for="country" class="col-form-label">Country</label>
      <input type="text" class="form-control" id="country" name="country">
    </div>
  </div>
  <!-- END COUNTRY  -->
</div> <!-- END ROW -->
</div>         
</div>


</fieldset>
<!-- ADDRESS  -->
<div class="form-group">
  <button type="button" class="btn btn-secondary closeButton">Close</button>
  <button type="button" class="btn btn-primary">Submit</button>
</div>
</form>


<!-- CUSTOMER CAN DELETE ON REQUEST - UNSUBSCRIBE FROM SERVICES -> POPUP TO NOTIFY -->




</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<script type="text/javascript">
let myForm = document.querySelector(".displayForm")
myForm.style.display = "none"
document.querySelector("body").addEventListener("click", (e) => {
  console.log(e.target.className)
  if(e.target.className == "nav-link displayFormLink"){
    if(myForm.style.display == "none") {
      myForm.style.display = "block"
    } 
  } else if(e.target.className == "nav-link home")  {
    myForm.style.display = "none"
  } else if(e.target.className == "btn btn-secondary closeButton"){
    if(myForm.style.display == "block") {
      myForm.style.display = "none"
    } 
  }
  
})

</script>

</body>
</html>