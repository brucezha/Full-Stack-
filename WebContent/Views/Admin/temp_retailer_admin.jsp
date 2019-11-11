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
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Welcome Admin</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</style>
<!-- Custom styles for this template -->
<link href="floating-labels.css" rel="stylesheet">
</head>
<body>

	<div class="container-fluid mt-5">
		<div class="container">
			<!-- HORIZONTAL NAV -->
			<jsp:include page="../../partials/menu.jsp" />
<div class="panel panel-default">
  <div class="panel-body">
  <table class="table table-sm table-striped">
				<button type="button" class="btn btn-sm btn-secondary mt-2 mb-2"
					data-toggle="modal" data-target="#exampleModalCenter">New
					Retailer</button>
				<thead>
					<tr>
						<th scope="col">RetailerId</th>
						<th scope="col">Name</th>
						<th scope="col">Contact1</th>
						<th scope="col">contact2</th>
						<th scope="col">BoxLimit</th>
						<th scope="col">CreditLimit</th>
						<th scope="col">Commission</th>
						<th scope="col">ServiceCharge</th>
						<th scope="col">InventoryId</th>
						<th scope="col">Creation Date</th>
						<th scope="col">InventoryCost</th>
						<th scope="col">Address1</th>
						<th scope="col">Address2</th>
						<th scope="col">City</th>
						<th scope="col">State</th>
						<th scope="col">ZipCode</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="retailer" items="${retailers}">
						<tr>
							<td><c:out value="${retailer.retailerId}" /></td>
							<td><c:out value="${retailer.retailName}" /></td>
							<td><c:out value="${retailer.retailContact1}" /></td>
							<td><c:out value="${retailer.retailContact2}" /></td>
							<td><c:out value="${retailer.boxLimit}" /></td>
							<td><c:out value="${retailer.creditLimit}" /></td>
							<td><c:out value="${retailer.retailCommission}" /></td>
							<td><c:out value="${retailer.retailServiceCharge}" /></td>
							<td><c:out value="${retailer.retailInventId}" /></td>
							<td><c:out value="${retailer.retailCreationDate}" /></td>
							<td><c:out value="${retailer.inventCost}" /></td>
							<%-- 								<td><c:out value="${retailer.retailCreationDate}" /></td> --%>
							<td><c:out value="${retailer.retailAddress1}" /></td>
							<td><c:out value="${retailer.retailAddress2}" /></td>
							<td><c:out value="${retailer.retailCity}" /></td>
							<td><c:out value="${retailer.retailState}" /></td>
							<td><c:out value="${retailer.retailZip}" /></td>
							<td>
								<div class="btn-group  dropright">
									<button class="btn btn-secondary btn-sm dropdown-togglee"
										type="button" id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Action</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" name="action" value="delete" class="delete"
											href="${pageContext.request.contextPath}/admin/edit/retailer?action=delete&id=${retailer.retailerId}">Delete</a>
										<a name="action" value="update" class="dropdown-item edit"
											href="${pageContext.request.contextPath}/admin/edit/retailer?id=${retailer.retailerId}">Edit</a>

									</div>
								</div>
							</td>
							
							
							
							<!-- 										<td scope="col"> -->
							<!-- 						<div class="btn-group  dropright"> -->
							<!-- 							<button class="btn btn-secondary btn-sm dropdown-togglee" -->
							<!-- 								type="button" id="dropdownMenuButton" data-toggle="dropdown" -->
							<!-- 								aria-haspopup="true" aria-expanded="false">Action</button> -->
							<!-- 							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"> -->
							<!-- 								<a class="dropdown-item" href="#">Delete</a> <a -->
							<!-- 									class="dropdown-item" href="#">Edit</a> -->
							<!-- 								 -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 					</td> -->

						</tr>
					</c:forEach>

				</tbody>
			</table>
  
  </div>
  </div>
			
			<!-- 		<button type="button" class="btn btn-secondary closeButton mb-2">Close</button> -->


			<!-- Modal FOR THE REGISTRATION -->
			<div class="modal fade" id="exampleModalCenter" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg"
					role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Retailer
								Registration</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>

						<!-- MODAL LOGIN -->
						<div class="modal-body">
							<form class="editUserForm"
								action="${pageContext.request.contextPath}/admin/retailer"
								method="post">
								<div class="row">
									<div class="col">
										<!-- FIRST NAME  -->
										<div class="form-group input-group-sm mb-1">
											<label for="Name" class="col-form-label">Name</label> <input
												type="text" class="form-control" id="Name" name="Name">
										</div>
										<!-- FIRST NAME  -->
									</div>
									<!-- LAST NAME -->
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<label for="Contact1" class="col-form-label">Contact1</label>
											<input type="tel" class="form-control" id="Contact1"
												name="Contact1" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
										</div>
										<!-- LAST NAME -->
									</div>
								</div>
								<!-- EMAIL -->
								<div class="form-group input-group-sm mb-1">
									<label for="Contact2" class="col-form-label">Contact2</label> <input
										type="tel" class="form-control" id="Contact2"
										name="Contact2" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
								</div>
								<!-- Phone Number -->
								<div class="form-group input-group-sm mb-1">
									<label for="SetTopBoxLimit" class="col-form-label">SetTop
										Box Limit</label> <input type="number" class="form-control"
										name="SetTopBoxLimit" id="SetTopBoxLimit"></input>
								</div>
								<div class="form-group input-group-sm mb-1">
									<label for="CreditLimit" class="col-form-label">Credit
										Limit</label> <input type="number" class="form-control"
										name="CreditLimit" id="CreditLimit"></input>
								</div>
								<div class="form-group input-group-sm mb-1">
									<label for="Commission%onSale" class="col-form-label">Commission
										% on Sale</label> <input type="number" class="form-control"
										name="Commission%onSale" id="Commission%onSale"></input>
								</div>
								<div class="form-group input-group-sm mb-1">
									<label for="ServiceCharge" class="col-form-label">Service
										Charge</label> <input type="number" class="form-control"
										name="ServiceCharge" id="ServiceCharge"></input>
								</div>
								<div class="form-group input-group-sm mb-1">
									<label for="InventoryCost" class="col-form-label">Inventory
										Cost</label> <input type="number" class="form-control"
										name="InventoryCost" id="InventoryCost"></input>
								</div>

								<div class="row">
									<div class="col">
										<!-- ADDRESS -->
										<fieldset>
											<legend>Address</legend>
											<!-- STREET ADDRESS 1 -->
											<div class="form-group input-group-sm mb-1">
												<label for="Address1" class="col-form-label">Address1</label>
												<input type="text" class="form-control" id="Address1"
													name="Address1">
											</div>
											<!-- STREET ADDRESS 1 -->
											<!-- BEGIN STREET ADDRESS 2 -->
											<div class="form-group input-group-sm mb-1">
												<label for="Address2" class="col-form-label">Address2</label>
												<input type="text" class="form-control" id="Address2"
													name="Address2">
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
														<label for="Pincode/Zipcode" class="col-form-label">Pincode/Zipcode</label>
														<input type="number" class="form-control"
															id="Pincode/Zipcode" name="Pincode/Zipcode">
													</div>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group input-group-sm mb-1">
											<%@ page import="java.text.SimpleDateFormat"%>
											<%@ page import="java.util.Date"%>
											<label for="example-date-input" class="col-form-label">Retailer
												Creation Date</label> <input class="form-control" type="text"
												value="<%=new SimpleDateFormat("MM/dd/yyyy").format(new Date())%>"
												id="example-date-input" disabled>
										</div>
										<!-- OPERATOR NAME -->
									</div>
								</div>
								<div class="form-group input-group-sm mb-1">
									<label for="Name" class="col-form-label">Admin Name</label> <input
										type="text" class="form-control" id="AdminName" value="Admin"
										Disabled>
								</div>


								<!-- 								<button type="button" class="btn btn-secondary" -->
								<!-- 									>Close</button> -->
								<button type="submit" class="btn btn-primary" name="action"
									value="Register Retailer">Register</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



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
</body>
</html>