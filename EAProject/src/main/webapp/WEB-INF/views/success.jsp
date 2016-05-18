<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success</title>
  </head>
  <body>

<center>
<h1>Successful Transaction</h1>
<img src="<spring:url value="/resource/images/success.jpg"  htmlEscape="true" />" alt="Successful transaction!!!"  />

 <p><button type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button></p>

</center> 
  </body>
</html>