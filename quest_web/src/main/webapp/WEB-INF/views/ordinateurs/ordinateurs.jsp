<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<title>Ordinateurs</title>

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
		<h1>Liste des Ordinateurs</h1>
		<table id="tab" class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Ram</th>
					<th>Marque</th>
					<th>Stagiaire</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ordinateurs}" var="ordinateur">
					<tr>
						<td>${ordinateur.id}</td>
						<td>${ordinateur.ram}Go</td>
						<td>${ordinateur.marque}</td>
						<c:choose>
							<c:when test="${ordinateur.stagiaire==null}">
								<td>Pas de stagiaire</td>
							</c:when>
							
							<c:otherwise>
								<td>${ordinateur.stagiaire.id} - ${ordinateur.stagiaire.nom} ${ordinateur.stagiaire.prenom}</td>
							</c:otherwise>
						</c:choose>
		
						
						<td><a href="ordinateur?id=${ordinateur.id}"><button
									class="btn btn-success" type="submit">Modifier</button></a> <a
							href="ordinateur?id=${ordinateur.id}&delete"><button
									class="btn btn-danger" type="submit">Supprimer</button></a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="container">
		<form class="form-group row" action="ordinateur" id="inscription"
			method="POST">
			<fieldset>
				<table id="tab1" class="table table-active table-bordered">
					<h1>Ajouter un ordinateur</h1>
					<thead>
						<tr>
							<th><label>RAM</label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><select id="ram" name="ram" required>
									<option value="">Choisir une RAM</option>
									<option value="8">8G</option>
									<option value="16">16G</option>
									<option value="32">32G</option>
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
									<option>${marque}</option>
								</c:forEach>
						</select></td>
					</tr>
					
					
					<tr>
							<td><select name="stagiaire.id">
									<option value="">Pas de stagiaire</option>
									<c:forEach items="${stagiaires}" var="stagiaire">
										<option value="${stagiaire.id}">${stagiaire.id}-${stagiaire.nom} ${stagiaire.prenom}</option>
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
