<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<spring:url value="/resource/js/controllers.js"/>"></script>


<title>Insert title here</title>
</head>
<body>







	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Card Details</h1>
		</div>
	</div>
	</section>


	<section class="container">

	<div class="row">

		<div class="col-md-5">

			

			<h3>Please Carefully Enter your valid  card Details</h3>

			<form:form method="post" action="checkBillingInfo"
				commandName="creditcard">

				<table>
					<tr>
						<td>Card Number:(16 characters)</td>
						<td><form:input path="number" type="text" /><br />
						<form:errors path="number" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<td>Expiry Month:</td>
						<td><form:input path="expMonth" type="text" /></td>
					</tr>
					<tr>
						<td>Expiry Year:</td>
						<td><form:input path="expYear" type="text" /></td>
					</tr>
					
					<tr>
					<td>                    </td>
					<tr>
						<td></td>
						<td><input   value="CheckOut" class="btn btn-lg btn-success btn-mini" class="row top-buffer" type="submit" /></td>
					</tr>
				</table>

			</form:form>

			

			</p>

		</div>
	</div>

	</section>











</body>
</html>