<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<jsp:include page="../../partials/menu.jsp" />
	<div class="container mt-5">
		


		<form action="${pageContext.request.contextPath}/admin/edit/operator?id="${operatorId}" method="POST">
			<div class="form-group">

				<label for="operatorId">Operator ID</label> <input type="text"
					class="form-control" name="operatorId" id="operatorId"
					value="${operator.operatorId}" disabled>
			</div>
			<div class="row">
				<div class="col">
					<!-- FIRST NAME  -->
					<div class="form-group input-group-sm mb-1">
						<label for="firstName" class="col-form-label">First Name</label> <input
							type="text" class="form-control" id="firstName" name="firstName"
							value="${operator.firstName }" required>
					</div>
					<!-- FIRST NAME  -->
				</div>
				<!-- LAST NAME -->
				<div class="col">
					<div class="form-group input-group-sm mb-1">
						<label for="last-name" class="col-form-label">Last Name</label> <input
							type="text" class="form-control" id="last-name" name="lastName"
							value="${operator.lastName }" required>
					</div>
					<!-- LAST NAME -->
				</div>
			</div>
			<!-- EMAIL -->
			<div class="form-group input-group-sm mb-1">
				<label for="email" class="col-form-label">Email</label> <input
					type="text" class="form-control" id="email" name="email"
					value="${operator.email}" required>
				<!-- EMAIL -->
			</div>
			<!-- PASSWORD -->
			<div class="form-group input-group-sm mb-1">
				<label for="password" class="col-form-label">Password</label> <input
					type="password" class="form-control" id="password" name="password"
					value="${operator.password}" required>
				<!-- END PASSWORD -->
			</div>
			<!-- Phone Number -->
			<div class="form-group input-group-sm mb-1">
				<label for="phone" class="col-form-label">Phone</label> <input
					type="tel" class="form-control checkValid1"
					pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" name="phone" id="phone"
					value="${operator.phone}" required>
			</div>

			<div class="form-group input-group-sm mt-4 mb-1">
      <div class="row">

  <div class="col-12">
  <div class="input-group">
  <label for="startTimeHour"> Start & End Time</label>
    <select id = startTimeHour  class="form-control ml-2 mr-2">
      <!-- <option selected="selected" value="">Select Hr (HH:MM)</option> -->
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

    <select id="startTimeMin" class="form-control">
      <!-- <option selected="selected" value="">Select Minute</option> -->
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

  </div>

 <!--  <label for="startTime" class="col-form-label">Start Time </label>
 <input type="text" id ="shiftStart" placeholder="H:MM" pattern="[0-9]:[0-9]{2}" required> -->
</div>
</div>
<div class="row"> 
    <div class="col-6"> 
<div class="form-group input-group mb-1 mt-2">
  <label for="endTime" class="col-form-label">Shift Start</label> 
  <input type="text" id ="shiftStart" name="shiftStart" value="" class="form-control" >

</div>
    </div>
    <div class="col-12"> 
<div class="form-group input-group mb-1 mt-2">
  <label for="endTime" class="col-form-label mr-2">Shift End</label> 
  <input type="text" id ="shiftEnd" name="shiftEnd" class="form-control" >

</div>

    </div>
</div>  

<!-- Shift END  -->
</div>
					<div class="form-group input-group-sm mb-1">
						<label for="managedCustomers" class="col-form-label">Managed
							Customer </label> <input type="text" class="form-control"
							id="managedCustomer" name="managedCustomers"
							value="${operator.managedCustomers}" required>
					</div>

					<div class="row">

						<div class="col">
						
							<div class="form-group input-group-sm mb-1">
								<label for="creationDate" class="col-form-label">
									Creation Date</label> <input type="text" class="form-control"
									id="creationDate" value="${operator.creationDate}" disabled>
							</div>
							 

							<div class="col">
								<div class="form-group input-group-sm mb-1">
									<label for="activeCustomers" class="col-form-label">Active
										Customers</label> <input type="text" class="form-control"
										id="activeCustomers" name="activeCustomers"
										value="${operator.activeCustomers}" required>
								</div>
							</div>

						</div>

					</div>
				</div>

	<input type="hidden" name="action" value="update">
			
			
			<div class="container">
			  <div class="row">
			    <div class="col text-center">
			      <button type="submit" value="Update" class="btn btn-primary mt-3 mx-auto">Update Operator</button>
			    </div>
			  </div>
			</div>
			
			
<!-- 			<button type="submit" value="Update" class="btn btn-primary mt-3">Update -->
<!-- 				Operator</button> -->
			<input type="hidden" name="operatorId" value="${operator.operatorId}">
		</form>
	
	
	
	
	<script type="text/javascript">
//Dynamically get today's Date when registering Customer
var today = new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
var yyyy = today.getFullYear();

today = mm + '/' + dd + '/' + yyyy;
today = String(today)
document.querySelector("#creationDate").value = today;



 document.querySelector("body").addEventListener("change", ()=> {
  var startTimeHr = document.getElementById('startTimeHour').value;
  var startTimeMinute = document.getElementById('startTimeMin').value;
  var endTimeHr = (parseInt(startTimeHr) + 8)
  if (parseInt(endTimeHr) > 24) {
    endTimeHr = parseInt(endTimeHr) - 24
  }
  let endInput = document.querySelector("#shiftEnd")
  endInput.value = (endTimeHr + ':' + startTimeMinute)

let startInput = document.querySelector("#shiftStart")
startInput.value = startTimeHr + ':' + startTimeMinute

})

</script>
</body>
</html>