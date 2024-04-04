<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<title>Fiche Ordinateur</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
#container-bootstrap {
	background-color: lightgreen;
}

/* CSS mobile*/
@media ( max-width : 768px) {
	#navPc {
		display: none;
	}
	#navTel {
		text-align: center;
	}
	#container-bootstrap {
		background-color: lightblue;
	}
}

/*CSS Tablette */
@media ( min-width : 768px) and (max-width: 992px) {
	#navTel {
		display: none;
	}
	#container-bootstrap {
		background-color: orange;
	}
}

/*CSS PC */
@media ( min-width : 992px) {
	#navTel {
		display: none;
	}
	#container-bootstrap {
		background-color: salmon;
	}
}
</style>
</head>
<body>
	<div class="container">
		<h1>Fiche de l'Ordinateur ${ordinateur.id}</h1>
	</div>
	<div class="container">
		<form class="form-group row" action="ordinateur" id="inscription"
			method="POST">
			<fieldset>
				<table id="tab1" class="table table-active table-bordered">
					<h1>Modifier un ordinateur</h1>
					<input type="hidden" value="${ordinateur.id}" name="id">
					<thead>
						<tr>
							<th><label>RAM</label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><select id="ram" name="ram" required>
									<option value="">Choisir une RAM</option>
									<option <c:if test="${ordinateur.ram==8}"> selected </c:if> value="8">8G</option>
									<option <c:if test="${ordinateur.ram==16}"> selected </c:if> value="16">16G</option>
									<option <c:if test="${ordinateur.ram==32}"> selected </c:if> value="32">32G</option>
							</select></td>
						</tr>
					<thead>
						<tr>
							<th><label>MARQUE</label></th>
						</tr>
					</thead>
					<tr>
						<td><select class="custom-select" id="marque" name="marque"
							required>
								<option value="">Choisir une MARQUE Ordinateur</option>
								<c:forEach items="${marques}" var="marque">

									<c:choose>
										<c:when test="${marque== ordinateur.marque}">
											<option selected>${marque}</option>
										</c:when>

										<c:otherwise>
											<option>${marque}</option>
										</c:otherwise>
									</c:choose>
 
								</c:forEach>
						</select></td>
					</tr>


					<tr>
						<td><select name="stagiaire.id">
								<option value="">Pas de stagiaire</option>
								<c:forEach items="${stagiaires}" var="stagiaire">
								
								<c:choose>
										<c:when test="${stagiaire.id== ordinateur.stagiaire.id}">
											<option selected value="${stagiaire.id}">${stagiaire.id}-${stagiaire.nom}
										${stagiaire.prenom}</option>
										</c:when>

										<c:otherwise>
											<option value="${stagiaire.id}">${stagiaire.id}-${stagiaire.nom}
										${stagiaire.prenom}</option>
										</c:otherwise>
									</c:choose>
									
								</c:forEach>
						</select></td>
					</tr>
					</tbody>
					<tr>
						<td>
							<button class="btn btn-primary" type="submit" value="inscription">
								Envoyer</button>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
