<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produits</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value="/resource/images/nomOnglet.png"/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resource/js/productController.js"/>"></script>
</head>
<body>
	<div ng-app="myapp">
		<div class="container" style="width: 829px">
			<h2>Informations Produit</h2>
			<p>Détail du produit</p>
			<table class="table table-bordered" id="prod">
				<tbody>

					<tr>
						<td>Image Produit</td>
						<td><img
							src="<c:url value="/resource/images/produits/${produit.idProduit}.jpg"/>"
							width="40%" alt="${produit.nomProduit}" /></td>
					</tr>
					<tr>
						<td>Id Produit</td>
						<td>${produit.idProduit }</td>
					</tr>
					<tr>
						<td>Nom Produit</td>
						<td>${produit.nomProduit }</td>
					</tr>
					<tr>
						<td>Catégorie</td>
						<td>${produit.catégorieProduit}</td>
					</tr>
					<tr>
						<td>Description Produit</td>
						<td>${produit.descriptionProduit}</td>
					</tr>
					<tr>
						<td>Fabricant Produit</td>
						<td>${produit.fabricantProduit}</td>
					</tr>
					<tr>
						<td>Prix Produit</td>
						<td>${produit.prixProduit}</td>
					</tr>
					<tr>
						<td>Stock Disponible</td>
						<td>${produit.unitStock}</td>
					</tr>
					<tr>
						<td>Ajouter au panier:</td>
						<td><c:url value="/cart/add/${produit.idProduit}"
								var="addcart"></c:url>
							<div ng-controller="myController">
								<security:authorize access="hasRole('ROLE_USER')">
									<a href="#" ng-click="addToCart(${produit.idProduit})"
										class="btn btn-info"
										style="margin-top: 0px; width: 150px; float: left; margin-right: 31px;">
										<span class="glyphicon glyphicon-shopping-cart"></span>
									</a>
								</security:authorize>
								<a href="<c:url value="/getAllProducts" />" class="btn btn-info"
									style="margin-top: 0px; width: 150px; float: right; margin-right: 31px;">
									<span class="glyphicon glyphicon-arrow-left"></span>
								</a>
							</div></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>
