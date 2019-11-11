
<!--  THIS MENU IS FOR ADMINS ONLY -->
<nav class="navbar navbar-expand-lg navbar-light bg-light ">
	<a class="navbar-brand" href="#">Admin Dashboard</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link home"
				href="${pageContext.request.contextPath}/Views/Admin/admin.jsp">Home</a>
			</li>


			<!-- CUSTOMER MGMT (DROP DOWN) -->
			<li class="nav-item "><a
				class="nav-link customerManagementPortalLink"
				href="${pageContext.request.contextPath}/admin/customer">Customer
					Management</a></li>
			<!-- RETAILER MGMT (DROP DOWN) -->
			<li class="nav-item"><a class="nav-link retailMgmtFormLink"
				href="${pageContext.request.contextPath}/admin/retailer">Retailer
					Management</a></li>
			<!-- OPERATOR MGMT (DROP DOWN) -->
			<li class="nav-item"><a class="nav-link retailMgmtFormLink"
				href="${pageContext.request.contextPath}/admin/operator">Operator
					Management</a></li>
					<li class="nav-item"><a class="nav-link retailMgmtFormLink"
				href="${pageContext.request.contextPath}/Views/Admin/AdminStats.jsp">Analytics
					</a></li>
				
			<li class="nav-item "><a class="nav-link retailMgmtFormLink btn btn-primary"
				href="${pageContext.request.contextPath}/Views/login.jsp">Logout</a></li>
		</ul>

	</div>

<script>
document.querySelector(".nav-link.retailMgmtFormLink.btn.btn-primary").addEventListener("click", (e)=>{
	var r = confirm("Are you sure you want to proceed?")
	if (r == true) {
	    return;
	}
	else {
		e.preventDefault();
	    alert("Canceled!");
		
	}

	})

</script>


</nav>