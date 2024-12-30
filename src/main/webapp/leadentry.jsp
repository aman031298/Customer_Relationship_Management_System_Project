<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lead Entry Form</title>
<link rel="stylesheet" type="text/css" href="leadentry.css">

<style>
body {
	background-image: url('scheduleEntry.jpg');
	background-color: #000;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	color: #fff;
}

h2 {
	text-align: center;
	margin-top: 20px;
	color: #fff;
}

form {
	max-width: 600px;
	margin: 20px auto;
	padding: 30px;
	background-color: #000;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

label {
	display: inline-block;
	width: 150px;
	margin-right: 10px;
}

input[type="text"], input[type="email"], input[type="number"], select,
	textarea, input[type="submit"] {
	width: 240px;
	padding: 12px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #fff;
	color: #000;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	margin: 0 auto; /* Center the button */
	display: block; /* Make it a block element to center */
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

select {
	width: 260px;
}

textarea {
	width: 240px; /* Adjust width of the Address field */
	max-width: 100%; /* Ensure it doesn't overflow */
	height: 80px; /* Reduce height to make it smaller */
}

/* Styles for the left panel */
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 15%;
	background-color: silver; /* Change the background color to silver */
	height: calc(100vh - 40px);
	overflow: auto;
	float: left;
	transition: width 0.5s;
	/* Add a transition effect for smoother animation */
	position: relative; /* Set position to relative */
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
	font-weight: bold;
	transition: background-color 0.3s;
	/* Add a transition effect for smoother color change */
}

li a:hover {
	background-color: #c0c0c0; /* Change the background color on hover */
	color: white;
}

li {
	margin: 20px 0;
}

.container {
	margin-left: 15%;
	padding: 20px;
	height: calc(100vh - 20px);
	display: flex;
	flex-wrap: wrap;
	transition: margin-left 0.5s;
	/* Add transition for smoother animation */
}

.card {
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 20px;
	margin: 10px;
	width: calc(50% - 20px);
	height: calc(50% - 20px);
	background-color: #f9f9f9;
	box-sizing: border-box;
	display: flex;
	flex-direction: column;
	background-size: contain;
	background-position: center;
	background-repeat: no-repeat;
}

.card:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.card h3 {
	margin-top: 0;
}

.card-content {
	flex-grow: 1;
	color: black; /* Set the text color to black */
}

/* Styles for the welcome message */
.welcome-message {
	font-size: 24px; /* Adjust the font size as needed */
	font-weight: bold;
	margin-bottom: 10px;
}

/* Styles for the toggle button */
.toggle-button {
	position: absolute;
	top: 20px;
	left: 20px; /* Adjust left position for the button */
	background-color: #333;
	color: #fff;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
	transition: left 0.5s; /* Add transition for smoother animation */
	z-index: 1; /* Ensure the button is above other elements */
}

.toggle-button:hover {
	background-color: #555;
}

/* Styles for the container when the left panel is closed */
.container-closed {
	margin-left: 0;
}

/* Styles for the ul when the left panel is closed */
.ul-closed {
	width: 0;
	overflow: hidden;
}

/* Align Address label and input box */
.address-container {
	display: flex;
	align-items: center;
}

.address-container label {
	margin-right: 20px;
}
</style>

</head>
<body>
	<%
	// Retrieve error message attribute
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<!-- Display error message in JavaScript alert -->
	<script>
        alert("<%=errorMessage%>
		");
	</script>
	<%
	}
	%>
	<div class="top-header">
		<button class="toggle-button" onclick="togglePanel()">&#9776;</button>
	</div>

	<ul id="left-panel" class="ul-closed">
		<li><a href="schedule_add.jsp">Add Schedule</a></li>
		<li><a href="leadentry.jsp">Add Lead</a></li>
		<li><a href="leads_show.jsp">Lead</a></li>
		<li><a href="team_show.jsp">Team</a></li>
		<li><a href="product_show.jsp">Product</a></li>
		<li><a href="company_show.jsp">Company</a></li>
		<li><a href="employee_show.jsp">Employees</a></li>
		<li><a href="schedule_show.jsp">Schedule</a></li>
		<li><a href="logs_show.jsp">Logs</a></li>
		<li><a href="customer_show.jsp">Customers</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>

	<form action="LeadEntry" method="post" onsubmit="return validateForm()">
		<h2>Company Details</h2>
		<!-- Company details fields -->
		<label for="companyName">Name:</label> <input type="text"
			id="companyName" name="companyName" required><br>
		<br> <label for="companyEmail">Email:</label> <input type="email"
			id="companyEmail" name="companyEmail" required><br>
		<br>

		<div class="address-container">
			<label for="companyAddress">Address:</label>
			<textarea id="companyAddress" name="companyAddress" rows="4"
				cols="50" required></textarea>
			<br>
			<br>
		</div>

		<h2>Deal Details</h2>
		<label for="industryType">Industry Type:</label> <input type="text"
			id="industryType" name="industryType" required><br>
		<br> <label for="source">Source:</label> <input type="text"
			id="source" name="source" required><br>
		<br> <label for="interestLevel">Interest Level:</label> <input
			type="number" id="interestLevel" name="interestLevel" required
			min="1" max="10"><br>
		<br> <label for="dealSize">Deal Size:</label> <input
			type="number" id="dealSize" name="dealSize" required><br>
		<br>

		<!-- Product ID dropdown -->
		<label for="productId">Product ID:</label> <select id="productId"
			name="productId" required>
			<option value="">Select Product ID</option>
			<option value="206">206</option>
			<option value="207">207</option>
			<option value="208">208</option>
			<option value="209">209</option>
		</select><br>
		<br>

		<!-- Product field will be dynamically filled based on the selected Product ID -->
		<label for="product">Product:</label> <input type="text" id="product"
			name="product" readonly required><br>
		<br>

		<h2>Representative Details</h2>
		<!-- Representative details fields -->
		<label for="repName">Name:</label> <input type="text" id="repName"
			name="repName" required><br>
		<br> <label for="repEmail">Email:</label> <input type="email"
			id="repEmail" name="repEmail" required><br>
		<br> <label for="mobileNo">Mobile No.:</label> <input type="text"
			id="mobileNo" name="mobileNo" required><br>
		<br> <label for="jobRole">Job Role:</label> <input type="text"
			id="jobRole" name="jobRole" required><br>
		<br> <input type="submit" value="Submit">
	</form>

	<script>
		// Map Product IDs to Products
		const products = {
			"206" : "HCM",
			"207" : "Tech CX",
			"208" : "ERP",
			"209" : "SCM"
		};

		// Function to update Product field based on selected Product ID
		document
				.getElementById('productId')
				.addEventListener(
						'change',
						function() {
							const selectedProductId = this.value;
							document.getElementById('product').value = products[selectedProductId];
						});

		// Function to validate mobile number for Indian region
		function validateForm() {
			const mobileNo = document.getElementById('mobileNo').value;
			const indianMobileRegex = /^[6-9]\d{9}$/; // Indian mobile number regex

			if (!indianMobileRegex.test(mobileNo)) {
				alert("Please enter a valid Indian mobile number.");
				return false;
			}
			return true;
		}

		function togglePanel() {
			var leftPanel = document.getElementById("left-panel");
			leftPanel.classList.toggle("ul-closed");
			var container = document.querySelector(".container");
			container.classList.toggle("container-closed");
			var toggleButton = document.querySelector(".toggle-button");
			toggleButton.classList.toggle("toggle-button-closed");
		}
	</script>
</body>
</html>
