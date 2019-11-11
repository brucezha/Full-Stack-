<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Welcome Admin</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">



</style>
<!-- Custom styles for this template -->
<link href="floating-labels.css" rel="stylesheet">
</head>
<body>

	<div class="container-fluid mt-5">
		<!-- HORIZONTAL NAV -->

		<div class="container">
		<jsp:include page="../../partials/menu.jsp" />
			<table class="table text-left table-sm table-striped">
			
			
			<div class="form-inline float-left input-group-sm">
			<input type="text" id="myInput" class="form-control mr-2" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
			
							<button type="button" class="btn btn-sm btn-secondary"
					data-toggle="modal" data-target="#exampleModalCenter">New
					Customer</button>
			</div>		
					<div class="dropdown form-inline float-right">
<form  action="${pageContext.request.contextPath}/admin/customer" method = "post">
  <button type="submit" name="action" value="getAll" class="btn btn-primary mb-2" >All Customers</button>
  <button type="submit" name="action" value="filter" class="btn btn-secondary ml-2 mb-2" >Delete Requests</button>
  </form>

</div>
				<thead>
					<tr>
					
						<th scope="col">#</th>
						<th scope="col">First</th>
						<th scope="col">Last</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
						<th scope="col">Phone</th>
						<th scope="col">Address 1</th>
						<th scope="col">Address 2</th>
						<th scope="col">City</th>
						<th scope="col">State</th>
						<th scope="col">Zip</th>
						<th scope="col">Creation Date</th>
						<th scope="col">Operator ID</th>
						<th scope="col">Retailer ID</th>
						<th scope="col"></th>


					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td><c:out value="${customer.customerId}" /></td>
							<td><c:out value="${customer.firstName}" /></td>
							<td><c:out value="${customer.lastName}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td><c:out value="${customer.password}" /></td>
							<td><c:out value="${customer.phone}" /></td>
							<td><c:out value="${customer.address1}" /></td>
							<td><c:out value="${customer.address2}" /></td>
							<td><c:out value="${customer.city}" /></td>
							<td><c:out value="${customer.state}" /></td>
							<td><c:out value="${customer.zip}" /></td>
							<td><c:out value="${customer.creationDate}" /></td>
							<td><c:out value="${customer.operatorId}" /></td>
							<td><c:out value="${customer.retailerId}" /></td>
							<td scope="col">
								<div class="btn-group  dropright">
									<button class="btn btn-secondary btn-sm dropdown-togglee"
										type="button" id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Action</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<!-- 		<a name="action" value="delete" class="dropdown-item"
											href="${pageContext.request.contextPath}/admin/edit/customer?id=${customer.customerId}">Delete</a>
								 	-->
										<a name="action" value="edit" class="dropdown-item" class="edit"
											href="${pageContext.request.contextPath}/admin/edit/customer?id=${customer.customerId}">Edit</a>
							
								
									<form action="${pageContext.request.contextPath}/admin/edit/customer?id=${customer.customerId}" method = "post">
  										<button type="submit" name="action" value="delete" class="btn delete btn-light mb-1" >Delete</button>
  								<!--  	<button type="submit" name="action" value="edit" class="btn btn-light " >Edit</button>
 								-->		 </form>
 								
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
							<h5 class="modal-title" id="exampleModalCenterTitle">Customer
								Registration</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>

						<div class="modal-body">
							<form class="editUserForm" action="${pageContext.request.contextPath}/admin/customer/register" method="post">
								<div class="row">
									<div class="col">
										<!-- FIRST NAME  -->
										<div class="form-group input-group-sm mb-1">
											<label for="firstName" class="col-form-label">First
												Name</label> <input type="text" class="form-control" id="firstName"
												name="firstName">
										</div>
										<!-- FIRST NAME  -->
									</div>
									<!-- LAST NAME -->
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="lastname" class="col-form-label">Last
												Name</label> <input type="text" class="form-control" id="lastname"
												name="lastName">
										</div>
										<!-- LAST NAME -->
									</div>
								</div>
								<!-- EMAIL -->
								<div class="form-group input-group-sm mb-1">
									<label for="email" class="col-form-label">Email</label> <input
										type="text" class="form-control" id="email" name="email">
									<!-- EMAIL -->
								</div>
								<!-- Phone Number -->
								<div class="form-group input-group-sm mb-1">
									<label for="phone" class="col-form-label">Phone Number</label>
									<input type="tel" class="form-control checkValid1" name="phone"
										id="phone"></input>
								</div>
								<div class="row">
									<div class="col">
										<!-- ADDRESS -->
										<fieldset>
											<legend>Address</legend>
											<!-- STREET ADDRESS 1 -->
											<div class="form-group input-group-sm mb-1">
												<label for="streetAddress1" class="col-form-label">Street
													Address</label> <input type="text" class="form-control"
													id="streetAddress1" name="streetAddress1">
											</div>
											<!-- STREET ADDRESS 1 -->
											<!-- BEGIN STREET ADDRESS 2 -->
											<div class="form-group input-group-sm mb-1">
												<label for="streetAddress2" class="col-form-label">Street
													Address 2</label> <input type="text" class="form-control"
													id="streetAddress2" name="streetAddress2">
											</div>
											<!-- END STREET ADDRESS 2 -->
											<div class="row">
												<!-- BEGIN CITY -->
												<div class="col">
													<div class="form-group input-group-sm mb-1">
														<label for="city" class="col-form-label">City</label> <input
															type="text" class="form-control" id="city" name="city">
													</div>
												</div>
												<!-- END CITY -->
												<!-- BEGIN STATE -->
												<div class="col">
													<div class="form-group input-group-sm mb-1">
														<label for="state" class="col-form-label">State</label> <input
															type="text" class="form-control" id="state" name="state">
													</div>
												</div>
												<!-- END STATE -->
												<div class="col">
													<div class="form-group input-group-sm mb-1">
														<label for="zip" class="col-form-label">Zip Code:</label>
														<input type="number" class="form-control" id="zip"
															name="zip">
													</div>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="example-date-input" class="col-form-label">Customer
												Creation Date</label> <input class="form-control" type="date"
												value="2019-10-15" id="example-date-input" name="example-date-input">
										</div>
										<!-- OPERATOR NAME -->
									</div>
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="exampleSelect1">Operator Name</label> <select
												class="form-control" id="exampleSelect1" name="operators">
												<option>Operator 1</option>
												<option>Operator 2</option>
												<option>Operator 3</option>
												<option>Operator 4</option>
												<option>Operator 5</option>
											</select>
										</div>
									</div>
								</div>
								<!-- RETAILER NAME -->
								<div class="row">
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="exampleSelect1">Retailer Name</label> <select
												class="form-control" id="exampleSelect1" name="retailers">
												<option>Retailer 1</option>
												<option>Retailer 2</option>
												<option>Retailer 3</option>
												<option>Retailer 4</option>
												<option>Retailer 5</option>
											</select>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button name="action" value="submit" type="submit" class="btn btn-primary">Submit</button>
<!-- 									<form action="mypage.jsp" method="post"> -->
								</div>
<!-- 							</form> -->
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

<!--  SEARCH USING JAVASCRIPT -->
<script type="text/javascript">
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