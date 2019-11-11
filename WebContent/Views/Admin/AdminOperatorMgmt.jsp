<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid mt-5">
		
		<div class="container">
		<jsp:include page="../../partials/menu.jsp" />
		<div class="panel panel-default">
  <div class="panel-body">
  		<table
			
				class="table text-left table-sm table-striped table-hover table-responsive">
			<div class="form-inline float-left input-group-sm">
			<input type="text" id="myInput" class="form-control mr-2" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
				<button type="button" class="btn btn-sm btn-secondary mt-2 mb-2"
					data-toggle="modal" data-target="#exampleModalCenter">New
					Operator</button>
					</div>
				<thead>
					<tr>
						<th scope="col">#</th>

						<th scope="col">First</th>
						<th scope="col">Last</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
						<th scope="col">Phone</th>
						<th scope="col">Shift Start</th>
						<th scope="col">Shift End</th>
						<th scope="col"># Max Customers</th>

						<th scope="col">Creation Date</th>
						<th scope="col"># Active Customers</th>


					</tr>
				</thead>

				<tbody>
					<c:forEach var="operator" items="${operators}">
						<tr>
							<td><c:out value="${operator.operatorId}" /></td>
							<td><c:out value="${operator.firstName}" /></td>
							<td><c:out value="${operator.lastName}" /></td>
							<td><c:out value="${operator.email}" /></td>
							<td><c:out value="${operator.password}" /></td>
							<td><c:out value="${operator.phone}" /></td>
							<td><c:out value="${operator.shiftStart}" /></td>
							<td><c:out value="${operator.shiftEnd}" /></td>
							<td><c:out value="${operator.managedCustomers}" /></td>
							<td><c:out value="${operator.creationDate}" /></td>
							<td><c:out value="${operator.activeCustomers}" /></td>
							<td>
								<div class="btn-group  dropright">
									<button class="btn btn-secondary btn-sm dropdown-togglee"
										type="button" id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Action</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" name="action" value="delete" class="delete"
											href="${pageContext.request.contextPath}/admin/edit/operator?action=delete&id=${operator.operatorId}">Delete</a>
										<a name="action" value="update" class="dropdown-item" class="edit"
											href="${pageContext.request.contextPath}/admin/edit/operator?id=${operator.operatorId}">Edit</a>

									</div>
								</div>
							</td>
						</tr>
					</c:forEach>



				</tbody>
			</table>



			<!-- Modal FOR THE REGISTRATION -->
			<div class="modal fade" id="exampleModalCenter" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg"
					role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Operator
								Registration</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>

						<!-- MODAL OPERATOR REGISTRATION -->
						<div class="modal-body">
							<form class="displayForm" action="${pageContext.request.contextPath}/operator/registration" method="POST">
								<div class="row">
									<div class="col">

										<!-- FIRST NAME  -->
										<div class="form-group input-group-sm mb-1">
											<label for="firstName" class="col-form-label">First
												Name</label> <input type="text" class="form-control" id="firstName"
												name="firstName">
										</div>
									</div>
									<!-- col end -->
									<!-- LAST NAME -->
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="last-name" class="col-form-label">Last
												Name</label> <input type="text" class="form-control" id="last-name"
												name="lastName">
										</div>

									</div>
									<!-- col end -->
									<!-- LAST NAME -->
								</div>
								<!-- END ROW -->
								<!-- EMAIL -->
								<div class="form-group input-group-sm mb-1">
									<label for="email" class="col-form-label">Email:</label> <input
										type="email" class="form-control" id="email" name="email">
								</div>
								<!-- EMAIL -->
								<!-- PHONE -->
								<div class="form-group input-group-sm mb-1">
									<label for="phone" class="col-form-label">Phone</label> <input
										type="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control" name="phone" id="phone"></input>
								</div>
								<!-- PHONE END -->

								<div class="form-group input-group-sm mt-4 mb-1">
									<div class="row">

										<div class="col-12">
											<div class="input-group">
												<label for="startTimeHour"> Start & End Time</label> <select
													id=startTimeHour class="form-control ml-2 mr-2">
													<option selected="selected" value=" ">Select Hr
														(HH:MM)</option>
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


												</select> <select id="startTimeMin" class="form-control">
													<option selected="selected" value=" ">Select Minute</option>
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
												<label for="endTime" class="col-form-label"></label> <input
													type="text" id="shiftStart" name="shiftStart"
													class="form-control">

											</div>
										</div>
										<div class="col-12">
											<div class="form-group input-group mb-1 mt-2">
												<label for="endTime" class="col-form-label mr-2">Shift
													End</label> <input type="text" id="shiftEnd" name="shiftEnd"
													class="form-control">

											</div>

										</div>
									</div>

									<!-- Shift END  -->
								</div>
								<!-- MAX NUMBER OF CUSTOMERS  -->
								<div class="form-group input-group-sm mb-1">
									<label for="count" class="col-form-label">Number of
										Customers </label> <input type="number" class="form-control"
										name="maxCount" id="count"></input>
								</div>
								<!-- MAX NUMBER OF CUSTOMERS END -->
								<!-- PASSWORD  -->
								<div class="row">

									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="password" class="col-form-label">Password
												(Auto-Generated as 1234)</label> <input type="text"
												class="form-control" id="password" name="password"
												value="1234" disabled>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-6">
										<div class="form-group input-group-sm mb-1">

											<label for="creationDate" class="col-form-label">Creation
												Date</label> <input type="text" class="form-control"
												id="creationDate" name="creationDate" disabled>
										</div>
										<div class="col-6"></div>

									</div>

								</div>


								<!--CONFIRM PASSWORD END  -->


								</fieldset>

							

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>


  </div>
</div>

		
	</div>

	<!-- </div> -->
	<!-- END MODAL REGISTRATION -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

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

const myFunction = ()=> {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput"); //get input
  filter = input.value.toUpperCase(); // get filter
  table = document.querySelector("table"); // get table
  tr = table.getElementsByTagName("tr"); //get tr

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }


}


</script>


</body>
</html>