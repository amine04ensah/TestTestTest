<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A Propos De Nous</title>
<link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/proposNous.css"/>">
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/nomOnglet.png"/>" />
</head>

<body>


<%@ include file="navbar.jsp"%>


	<div class="row" style="margin-top:4px; margin-right:0px; margin-left:0px;margin-bottom:19px ">
		<div class="col-sm-4" style="margin-top:0px">
			<div class="container-fluid bg-1 text-center">
				<h3>Qui sommes-nous?</h3>
				<img src="<c:url value="/resource/images/aboutImage.png"/>" class="img-circle" alt="AboutUs" width="350"
					height="350">
				<h3>SmartPhonesBoutique est un site e-commerce international</h3>
			</div>

		</div>

		<div class="container-fluid bg-2 text-center">
			<h3>Que somme-nous?</h3>
			<div id="para"><p>SmartPhonesBoutique est une application web qui permet l'achat en-ligne 
			des smart phones</p>
			</div>
			<div id="para"><p>Cette application est développée en utilisant les frameworks Spring MVC, 
			et Hibernate, plus deux modules de Spring qui sont Spring Security et Spring WebFlow</p>
		</div></div>
	</div>
	

<%@ include file="footer.jsp"%> 

</body>
</html>