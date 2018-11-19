<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4 col-md-6">
		<div class="card">
			<div class="card-header">Infos</div>
			<div class="card-body">
				<form method="post" action="Checkout">
					<div class="row">
						<div class="col">
							<input type="text" class="form-control" placeholder="First name" name="fname">
						</div>
						<div class="col">
							<input type="text" class="form-control" placeholder="Last name" name="lname">
						</div>
					</div>
					<div class="form-group mt-4"> 
						<input
							type="email" class="form-control" name="email"
							aria-describedby="emailHelp" placeholder="Enter email"> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password">
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>