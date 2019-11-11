<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>Welcome Admin</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">

.jumbotron, .container, .jumbotron-fluid {
height: 400px;
}
</style>
<!-- Custom styles for this template -->
<link href="floating-labels.css" rel="stylesheet">
</head>
<body>

	<div class="container-fluid mt-5">
	<div class="container">
		<!-- HORIZONTAL NAV -->
	<jsp:include page="../../partials/menu.jsp" />
	
	<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">INFINITY DTH Systems+</h1>
    <p class="lead">A Direct-broadcast satellite system used to send signals to
television for broadcasting programs to over 1 billion people. </p>
  </div>
</div>
	
		<!--
		<form class="retailMgmtForm">
			
			<div>
				<h1 class="text-center">Add SetTop Box</h1>
				<p>All fields are mandatory. Amount is in U.S. dollars</p>
			</div>

			
			<div class="row">
				<div class="col d-inline">
				
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Set Top Box Type</label>
					</div>
				</div>
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<select class="custom-select">
							<option value="standard">Standard</option>
							<option value="hd">High Definition - HD</option>
							<option value="hdr">High Definition Recorder - HDR</option>
							<option value="iptv">IPTV</option>
						</select>
					</div>
				</div>
			</div>
			<br>
			
			<div class="row">
				<div class="col d-inline">
					
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Set Top Box Features</label>
					</div>
				</div>
				<div></div>
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="checkbox-inline"><input type="checkbox"
							value="live-recording" checked>Live recording</label> <label
							class="checkbox-inline"><input type="checkbox"
							value="scheduled-recording">Scheduled recording</label>

					</div>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapse"
						aria-expanded="false" aria-controls="collapse">More
						Features</button>
					<div class="collapse" id="collapse">
						<label class="checkbox-inline"><input type="checkbox"
							value="pause-and-play">Pause and play</label> <label
							class="checkbox-inline"><input type="checkbox">Option
							1</label> <label class="checkbox-inline"><input type="checkbox">Option
							2</label> <label class="checkbox-inline"><input type="checkbox">Option
							3</label>
					</div>
				</div>
			</div>
			<br>


			
			<div class="row">
				<div class="col d-inline">
					<div class="d-inline">
						<label class="col-form-label">Dimensions in inches</label>
					</div>
				</div>
				<div class="col">
					<div class="form-inline form-group input-group-sm mb-1">
						<label for="height" class="form-inline  mr-3 mb-2">Height</label>

						<input type="text"
							class="form-inline form-group input-group-sm mb-1" name="height"></input>
					</div>


					<div class="form-inline form-group input-group-sm mb-1">
						<label for="length" class="form-inline mr-3 mb-2">&nbspWidth</label>

						<input type="text"
							class="form-inline form-group input-group-sm mb-1" name="length"></input>
					</div>

					<div class="form-inline form-group input-group-sm mb-1">
						<label for="length" class="form-inline mr-3 mb-2">Length</label> <input
							type="text" class="form-inline form-group input-group-sm mb-1"
							name="length"></input>
					</div>

				</div>


			</div>
			<br>


			
			<div class="row">
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Price</label>
					</div>
				</div>
				<div class="col">
					<input type="text" class="form-control input-group-sm" name="price"></input>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Installation Charge</label>
					</div>
				</div>
				<div class="col">
					<input type="text" class="form-control "
						name="installation-charge input-group-sm"></input>
				</div>
			</div>
			
			<br>
			
			<div class="row">
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Upgradation Charge</label>
					</div>
				</div>
				<div class="col">
					<input type="text" class="form-control input-group-sm"
						name="upgradation-charge"></input>
				</div>
			</div>
			<br>
		
			<div class="row">
				<div class="col d-inline input-group-sm mb-1">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Discount %</label>
					</div>
				</div>
				<div class="col">
					<input type="text" class="form-control input-group-sm"
						name="discount-percentage"></input>
				</div>
			</div>
			<br>
			
			<div class="row">
				<div class="col d-inline input-group-sm mb-1">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Billing Type</label>
					</div>
				</div>
				<div class="col">
					<label class="radio-inline"><input type="radio"
						name="optradio" value="prepaid" checked>Prepaid</label> &nbsp <label
						class="radio-inline"><input type="radio" name="optradio"
						value="postpaid">Postpaid</label>
				</div>
			</div>
			<br>

			
			<div class="row">
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label input-group-sm">Refundable
							Deposit Amount</label>
					</div>
				</div>
				<div class="col input-group-sm mb-1">
					<input type="text" class="form-control input-group-sm"
						name="refundable-deposit-amount"></input>
				</div>
			</div>
			<br>

			
			<div class="row">
				<div class="col d-inline">
					<div class="form-group input-group-sm mb-1 d-inline">
						<label class="col-form-label">Set Top Box Inventory
							details</label>
					</div>
				</div>
				<div class="col">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text input-group-sm"
								id="inputGroupFileAddon01">Upload</span>
						</div>
						<div class="custom-file">
							<input type="file" class="custom-file-input input-group-sm"
								id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
							<label class="custom-file-label" for="inputGroupFile01">Choose
								file</label>
						</div>
					</div>
				</div>
			</div>
			<br>
			</fieldset>
		
			<button type="button" class="btn btn-secondary closeButton mb-2">Close</button>
			<button type="button" class="btn btn-primary mb-2">Add</button>
		</form>
		-->
</div>
	</div> <!--  END CONTAINER -->



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