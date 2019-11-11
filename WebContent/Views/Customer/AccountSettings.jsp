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

  <title>Infinity Customer Account Settings</title>
  <style type="text/css">
    .displayForm {
      transition: 5s;

    }

    .container {

      border: 1px solid grey;
      border-radius: 5px;

    }

  </style>
</head>
<body>
<form class="form-signin" action="${pageContext.request.contextPath}/AdminServlet" method="post" name="myForm">
  <div class="container mt-5">
  <small>This content will auto populate with customer account info</small>
  

  <div class="row">
    <div class="col">
    
<div class="form-group">
 
  <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Discontinue">Discontinue Services</button>
  
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