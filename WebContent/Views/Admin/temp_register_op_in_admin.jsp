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

  <title>Infinity Admin Dashboard</title>
  <style type="text/css">


    .container {

      border: 1px solid grey;
      border-radius: 5px;

    }

  </style>
</head>
<body>
  <div class="container mt-5">
  <small>This content will auto populate with admin account info</small>
  <!-- HORIZONTAL NAV -->

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Admin Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link home" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link displayFormLink" href="#">Create Operator </a>
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
    </div>   <!-- col end --> 
    <!-- LAST NAME -->
    <div class="col">
      <div class="form-group input-group-sm mb-1">
        <label for="last-name" class="col-form-label">Last Name</label>
        <input type="text" class="form-control" id="last-name">
      </div>
     
    </div><!-- col end -->
  <!-- LAST NAME -->
  </div> <!-- END ROW -->
  <!-- EMAIL -->
  <div class="form-group input-group-sm mb-1">
    <label for="email" class="col-form-label">Email:</label>
    <input type="email" class="form-control" id="last-name">
  </div>
  <!-- EMAIL -->
  <!-- PHONE -->
  <div class="form-group input-group-sm mb-1">
    <label for="phone" class="col-form-label">Phone</label>
    <input type="number" class="form-control" name="phone" id="phone"></input>
  </div>
  <!-- PHONE END -->

  <div class="row">
  <!-- SHIFT START  -->  
<!--   <div class="col"> 
    <select onchange="myFunction()" onload="myFunction()" id="selectedOption">
<<<<<<< .mine
      <option value=7>7am to 3pm</option>
      <option value=8>8am to 4pm</option>
      <option value=9>9am to 5pm</option>      
||||||| .r193
      <option value=7>7:00 am to 3:00 pm</option>
      <option value=8>8:00 am to 4:00 pm</option>
      <option value=9>9:00 am to 5:00 pm</option>      
=======
      <option value=7>7:00 am</option>
      <option value=8>8:00 am</option>
      <option value=9>9:00 am</option>      
>>>>>>> .r201
    </select>
    </div> -->
    <div class="col">
    <select id = startTimeHour>
    <option selected="selected" value="">Select Hr (HH:MM)</option>
    <option value="0">0</option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  

</select>

 <select id="startTimeMin">
            <option selected="selected" value="">Select Minute</option>
            <option value="00">00</option>
            <option value="01">01</option>
            <option value="02">02</option>
            <option value="03">03</option>
            <option value="04">04</option>
            <option value="05">05</option>
            <option value="06">06</option>
            <option value="07">07</option>
            <option value="08">08</option>
            <option value="09">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option>
            <option value="32">32</option>
            <option value="33">33</option>
            <option value="34">34</option>
            <option value="35">35</option>
            <option value="36">36</option>
            <option value="37">37</option>
            <option value="38">38</option>
            <option value="39">39</option>
            <option value="40">40</option>
            <option value="41">41</option>
            <option value="42">42</option>
            <option value="43">43</option>
            <option value="44">44</option>
            <option value="45">45</option>
            <option value="46">46</option>
            <option value="47">47</option>
            <option value="48">48</option>
            <option value="49">49</option>
            <option value="50">50</option>
            <option value="51">51</option>
            <option value="52">52</option>
            <option value="53">53</option>
            <option value="54">54</option>
            <option value="55">55</option>
            <option value="56">56</option>
            <option value="57">57</option>
            <option value="58">58</option>
            <option value="59">59</option>
        </select>


 <!--  <label for="startTime" class="col-form-label">Start Time </label>
  <input type="text" id ="shiftStart" placeholder="H:MM" pattern="[0-9]:[0-9]{2}" required> -->
  </div>
  <div class="col">
  <label for="endTime" class="col-form-label">End Time</label> 
  <input type="text" id ="shiftEnd" disabled>
  </div>
  <!-- Shift END  -->
  </div>
  <!-- MAX NUMBER OF CUSTOMERS  -->
    <div class="form-group input-group-sm mb-1">
    <label for="count" class="col-form-label">Number of Customers </label>
    <input type="number" class="form-control" name="maxCount" id="count"></input>
  	</div>
  <!-- MAX NUMBER OF CUSTOMERS END -->
  <!-- PASSWORD  -->
     <div class="form-group input-group-sm mb-1">
        <label for="password" class="col-form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
      </div>
       
    <!-- Confirm Password -->
      <div class="form-group input-group-sm mb-1">
        <label for="confimPassword" class="col-form-label">Confirm Password</label>
        <input type="password" class="form-control" id="comfirmPassword">
      </div>
	<!--CONFIRM PASSWORD END  -->
  

</fieldset>

<div class="form-group">
  <button type="button" class="btn btn-secondary closeButton">Close</button>
  <button type="button" class="btn btn-primary">Submit</button>
</div>
</form>



</div>         

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<script type="text/javascript">
<<<<<<< .mine
||||||| .r193
document.querySelector("body").addEventListener("change", () => {
	  let shiftStart = document.querySelector('#shiftStart')
  let endInput = document.querySelector("#shiftEnd")
  console.log(shiftStart.value.split(":")[1])
  let minutes = shiftStart.value.split(":")[1]
  let hours = (parseInt(shiftStart.value))
    console.log(hours)
=======
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
<script>
function myFunction() {
	  var x = document.getElementById("selectedOption").value;
	  document.getElementById("shiftStart").value = x +":00 am";
	  
	  var a = parseInt(x)
	  document.getElementById("shiftEnd").value = (a-4) +":00 pm";
	}
</script>


<!-- <script type="text/javascript">
document.querySelector("body").addEventListener("change", () => {
	  let shiftStart = document.querySelector('#shiftStart')
  let endInput = document.querySelector("#shiftEnd")
  console.log(shiftStart.value.split(":")[1])
  let minutes = shiftStart.value.split(":")[1]
  let hours = (parseInt(shiftStart.value))
    console.log(hours)
>>>>>>> .r201


// document.querySelector("body").addEventListener("click", (e) => {
//  


	  document.querySelector("body").addEventListener("change", () => {
	 var startTimeHr = document.getElementById('startTimeHour').value;
   var startTimeMinute = document.getElementById('startTimeMin').value;
   var endTimeHr = (parseInt(startTimeHr) + 8)
   if (parseInt(endTimeHr) > 24) {
        endTimeHr = parseInt(endTimeHr) - 24
   }
   let endInput = document.querySelector("#shiftEnd")
   endInput.value = (endTimeHr + ':' + startTimeMinute)



       })
    // let shiftStartHr = document.querySelector('#shiftStartHour')
    // // shiftStartHr.options[shiftStartHr].value;
    // let shiftStartMin = document.querySelector('#shiftStartMin')
   
   //  let endInput = document.querySelector("#shiftEnd")
   //  console.log(shiftStart.value.split(":")[1])
   //  let minutes = shiftStart.value.split(":")[1]
   //  let hours = (parseInt(shiftStart.value))
   //    console.log(hours)


   //  let endTime = ((parseInt(shiftStart.value) + 8 + ':' + shiftStart.value.split(":")[1]))
   //  console.log(endTime)
   // endInput.value = endTime
  
   //  if(minutes >= 60 || minutes < 0){
   //    alert('Wrong input for minutes')
   //    shiftStart.value = ''
   //  }


   //  if(hours > 12 || hours <= 0){
   //    alert('Wrong input for hours')
   //    shiftStart.value = ''
   //  }

    
    
	  // document.getElementById("shiftEnd").value = (a-4) +" pm";

</script> -->

</body>
</html>