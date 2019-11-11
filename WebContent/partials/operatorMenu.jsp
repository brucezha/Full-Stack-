		<!--  THIS MENU IS FOR OPERATORS ONLY -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light "> <a
			class="navbar-brand" href="#">Operator Dashboard</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link home"
					href="${pageContext.request.contextPath}/Views/Operator/operatorDashboard.jsp">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link displayFormLink"
					href="${pageContext.request.contextPath}/Views/Operator/OperatorSelfSettings.jsp">My Operator Settings</a></li>
				<!-- CUSTOMER MGMT (DROP DOWN) -->
				<li class="nav-item "><a
					class="nav-link customerManagementPortalLink"
					href="${pageContext.request.contextPath}/operator/customer">Manage Customers
						</a></li>
						
				<!-- RETAILER MGMT (DROP DOWN)
				<li class="nav-item"><a class="nav-link retailMgmtFormLink"
					href="${pageContext.request.contextPath}/admin/retailer">Retailer Management</a></li> 
					-->
				<!-- OPERATOR MGMT (DROP DOWN)
				<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Operator Management
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/operator">Admin>Manage Operators</a>
          <a class="dropdown-item" href="#">Analytics</a>
          <div class="dropdown-divider"></div>
          
        </div>
      </li>
      -->
      <li class="nav-item "><a class="nav-link retailMgmtFormLink btn btn-danger"
				href="${pageContext.request.contextPath}/Views/login.jsp">Logout</a></li>
			</ul>
			
		</div>
<!-- 
		<form class="form-inline">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit"
				name="logout">Logout</button>
		</form>
		 -->
		</nav>