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
<title>Welcome Operator</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5" >
	
	<jsp:include page="../../partials/operatorMenu.jsp" />
	

		<form class="editUserForm"
			action="${pageContext.request.contextPath}/operator/edit/customer?id="${customerId}
			method="POST">
			<div class="form-group">

				<label for="customerId">Customer ID</label> <input type="text"
					class="form-control" name="customerId" id="customerId"
					value="${customer.customerId}" disabled>
			</div>
			<div class="row">
				<div class="col">
					<!-- FIRST NAME  -->
					<div class="form-group input-group-sm mb-1">
						<label for="firstName" class="col-form-label">First Name</label> <input
							type="text" class="form-control" id="firstName" name="firstName"
							value="${customer.firstName }" required>
					</div>
					<!-- FIRST NAME  -->
				</div>
				<!-- LAST NAME -->
				<div class="col">
					<div class="form-group input-group-sm mb-1">
						<label for="last-name" class="col-form-label">Last Name</label> <input
							type="text" class="form-control" id="last-name" name="lastName"
							value="${customer.lastName }" required>
					</div>
					<!-- LAST NAME -->
				</div>
			</div>
			<!-- EMAIL -->
			<div class="form-group input-group-sm mb-1">
				<label for="email" class="col-form-label">Email</label> <input
					type="text" class="form-control" id="email" name="email"
					value="${customer.email}" required>
				<!-- EMAIL -->
			</div>
			<!-- PASSWORD -->
			<div class="form-group input-group-sm mb-1">
				<label for="password" class="col-form-label">Password</label> <input
					type="text" class="form-control" id="password" name="password"
					value="${customer.password}" required>
				<!-- END PASSWORD -->
			</div>
			<!-- Phone Number -->
			<div class="form-group input-group-sm mb-1">
				<label for="phone" class="col-form-label">Phone Number</label> <input
					type="tel" class="form-control checkValid1" name="phone" id="phone"
					value="${customer.phone}" required>
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
								id="streetAddress1" name="streetAddress1"
								value="${customer.address1}" required>
						</div>
						<!-- STREET ADDRESS 1 -->
						<!-- BEGIN STREET ADDRESS 2 -->
						<div class="form-group input-group-sm mb-1">
							<label for="streetAddress2" class="col-form-label">Street
								Address 2</label> <input type="text" class="form-control"
								id="streetAddress2" name="streetAddress2"
								value="${customer.address2}" required>
						</div>
						<!-- END STREET ADDRESS 2 -->
						<div class="row">
							<!-- BEGIN CITY -->
							<div class="col">
								<div class="form-group input-group-sm mb-1">
									<label for="city" class="col-form-label">City</label> <input
										type="text" class="form-control" id="city" name="city"
										value="${customer.city}" required>
								</div>
							</div>
							<!-- END CITY -->
							<!-- BEGIN STATE -->
							<div class="col">
								<div class="form-group input-group-sm mb-1">
									<label for="state" class="col-form-label">State</label> <input
										type="text" class="form-control" id="state" name="state"
										value="${customer.state}" required>
								</div>
							</div>
							<!-- END STATE -->
							<div class="col">
								<div class="form-group input-group-sm mb-1">
									<label for="zip" class="col-form-label">Zip Code:</label> <input
										type="text" pattern="[0-9]{5}" class="form-control" id="zip"
										name="zip" title="5 digit zip code" value="${customer.zip}"
										required>
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
							value="2019-10-15" id="example-date-input"
							value="${customer.creationDate}" disabled>
					</div>
					<!-- OPERATOR NAME -->
				</div>
<!-- 
				<div class="col">
					<div class="form-group input-group-sm mb-1">
						<label for="exampleSelect1">Operator Name</label> <select
							class="form-control" id="exampleSelect1">
							<option>Operator 1</option>
							<option>Operator 2</option>
							<option>Operator 3</option>
							<option>Operator 4</option>
							<option>Operator 5</option>
						</select>
					</div>
				</div>
			
			
	
				<div class="col">
					<div class="form-group input-group-sm mb-1">
						<label for="exampleSelect1">Retailer Name</label> <select
							class="form-control" id="exampleSelect1">
							<option>Retailer 1</option>
							<option>Retailer 2</option>
							<option>Retailer 3</option>
							<option>Retailer 4</option>
							<option>Retailer 5</option>
						</select>
					</div>
				</div>
				 -->
				 <input type="hidden" name="operatorId" value="">
			</div>
		
			<input type="hidden" name="action" value="update">


			<button type="submit" value="Update" class="btn btn-primary mt-3">Update
				Customer</button>
			<input type="hidden" name="customerId" value="${customer.customerId}">
		</form>
	</div>
</body>
</html>