<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Items</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Items</h1>
				<p>All the available Items in our store</p>
			</div>
		</div>
	</section>

	<section>

		<form action="search" method="post">
		<sec:csrfInput />
			<div class="container">
				<div class="row">
				
				Minimum Price:<div class="input-group col-md-3">
						<input id="itemid" type="text" class="form-control input-lg"
							placeholder="Search by Item price" name="minPrice" />
					</div>
					
					Maximum Price:<div class="input-group col-md-3">
						<input id="itemid2" type="text" class="form-control input-lg"
							placeholder="Search by Item price" name="maxPrice" />
					</div>
					
					<div class="input-group col-md-3">
						<input id="itemname" type="text" class="form-control input-lg" 
							placeholder="Search by Item Name" name="itemName" />
					</div>
					<span class="input-group-btn">
						<input type="submit" id="btnSearch" class="btn btn-primary" value="Search" />
					</span>
					<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
				</div>
			</div>
		</form>

	</section>

	<hr>
	<section class="container">
		<div class="row">
			<c:forEach items="${items}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${item.name}</h3>
							<p>${item.description}</p>
							<p>${item.initialPrice}USD</p>
							<p>
								<a href=" <spring:url value="/items/item?id=${item.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<center>
		<p>
			<button type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button>
		</p>
	</center>
</body>
</html>
