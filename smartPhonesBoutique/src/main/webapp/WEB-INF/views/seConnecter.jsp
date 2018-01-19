<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>seConnecter</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/nomOnglet.png"/>" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="js/jquery-3.1.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/header.css">
<style type="text/css">
@media ( min-width : 1200px) .container {
	width
	:
		
	1300
	px
		
	;
}

@media ( min-width : 992px) .col-md-4 {
	margin-left
		
	:
	330px
		
	;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container" style="margin-top: 30px; margin-bottom: 180px;">
		<div class="col-md-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" align="center">Se connecter</h3>
				</div>
				<div class="panel-body">

				
					<c:if test="${!empty querySuccess}">
						<div class="error" style="color: #ff0000;">${querySuccess}</div>
					</c:if>

					
					<c:if test="${not empty inscriptionRéussite}">
						<div class="error" style="color: #ff0000;">${inscriptionRéussite}</div>
					</c:if>
					
					<c:if test="${not empty logout}">
						<div class="error" style="color: #ff0000;">${logout}</div>
					</c:if>

					<form name="loginForm"
						action="<c:url value="/j_spring_security_check"/>" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail"
									name="j_username" type="email">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Mot de passe"
									name="j_password" type="password">
							</div>
							<div class="checkbox">
								<c:if test="${not empty error}">
									<div class="error" style="color: #ff0000">${error}</div>
								</c:if>
							</div>
							
							<div id="button">
								<button type="submit" class="btn btn-sm btn-success"
									style="margin-right: 79px; margin-left: 60px">Se connecter</button>
								<a href="<c:url value="/register"/>"
									class="btn btn-sm btn-success">S'inscrire</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>