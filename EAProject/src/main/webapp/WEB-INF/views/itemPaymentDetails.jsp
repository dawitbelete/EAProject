<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Items</title>
</head>
<body>

    
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Billing Section </h1>
				<p> You can pay for this item using your debit or credit card.Please provide authentic information.</p>
				<p><a href="<spring:url value="/billing" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> CheckOut
					</a></p>
			</div>
 		</div>
	</section>
	

	
</body>
</html>
