<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Shipment</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Shipment</h1>
				<p>Our shipping policies establish that the items will be delivered within the next ${newShipment.maxmaxShippingDays} business days</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newShipment" action="/store/ship" class="form-horizontal">
			<fieldset>
				<legend>Settings for the shipment</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message
							code="shipment.form.user.label" /></label>
					<div class="col-lg-10">
						<span id="name">${newShipment.user.firstName} ${newShipment.user.lastName}</span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="item"><spring:message
							code="shipment.form.item.label" /></label>
					<div class="col-lg-10">
						<span id="name">ID:#${newShipment.item.id} ${newShipment.item.name}</span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="street"><spring:message
							code="shipment.form.street.label" /></label>
					<div class="col-lg-10">
						<form:input id="street" path="address.street" type="text"
							class="form:input-large" value="${newShipment.user.address.street}" />
						<form:errors path="address.street" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipcode"><spring:message
							code="shipment.form.zipcode.label" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="zipcode" path="address.zipcode" type="text"
								class="form:input-large" value="${newShipment.user.address.zipcode}" />
							<form:errors path="address.zipcode" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="city"><spring:message
							code="shipment.form.city.label" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="city" path="address.city" type="text"
								class="form:input-large" value="${newShipment.user.address.city}" />
							<form:errors path="address.city" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Send" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
