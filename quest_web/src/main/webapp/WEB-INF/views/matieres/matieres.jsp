<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="fr">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Matieres</title>

<style>
body {
	padding-top: 70px;
	/* Pour éviter que la barre de navigation ne chevauche le contenu */
	background-image: url('assets/image/code.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

/* Style pour centrer le contenu */
.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 20px;
	margin-top: 80px;
	/* Ajout de marge pour éviter le chevauchement avec la barre de navigation */
	background-color: rgba(255, 255, 255, 0.8);
	/* Couleur blanche avec 80% d'opacité */
}

table {
	width: 100%;
	margin-bottom: 30px; /* Ajout de marge en bas du tableau */
}

.my-table th, .my-table td {
	border: 2px solid grey;
	padding: 8px;
	text-align: center;
}

th {
	font-weight: bold;
}

.action-buttons {
	display: flex;
	justify-content: space-around;
}

/* Style pour centrer le titre */
#titreMaTable {
	text-align: center;
	margin-bottom: 20px; /* Ajout de marge en bas des titres */
}

/* CSS pour le formulaire */
.form-container {
	margin-top: 20px;
	text-align: left;
}

.form-container h3 {
	margin-bottom: 10px;
}

.form-container .form-group {
	display: flex;
	align-items: center;
	gap: 10px;
}

.form-container .form-group label {
	flex: 1;
}

.form-container .form-group input {
	flex: 2;
}

.form-container .form-group button {
	flex: 1;
	background-color: #17a2b8;
	color: white;
	border: none;
	padding: 10px 20px;
}

@media ( max-width : 991.98px) {
	.navbar-nav {
		flex-direction: column;
		/* Afficher les éléments de la barre de navigation en colonne */
	}
}
</style>
</head>
<body>


	<!-- Tableau d'affichage des matières-->
	<div class="container">
		<h3 id="titreMaTable">Liste des matières</h3>
		<div class="table-responsive">
			<table class="my-table">
				<tr>
					<th>id</th>
					<th>libelle</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${matieres}" var="matiere">
					<tr>
						<td>${matiere.id}</td>
						<td>${matiere.libelle}</td>
						<td class="action-buttons"><a href="matiere/${matiere.id}"><button>Modifier</button></a>
							<a href="matiere/delete/${matiere.id}"><button>Supprimer</button></a>
						</td>
					</tr>
				</c:forEach>


			</table>
		</div>

		<!-- Affichage de la saisie de matière-->
		<form:form action="matiere" method="POST"
			modelAttribute="matiere">
			<div class="form-container">
				<h3>Ajouter une Matière</h3>
				<!--  <input type="hidden" value="${matiere.id}" name="id">-->
				<div class="form-group">
					<!--  <label for="libelle">Libellé de la Matière :</label>
         <input type="text" id="libelle" value="${matiere.libelle}" name="libelle">
       -->
					<form:label path="libelle">Libellé de la Matière :</form:label>
					<form:input path="libelle" />
					<form:errors path="libelle" style="color:red"/>
					<form:errors path="libelle"><span style="color:red">Ceci est autre message d'error</span></form:errors>
					<input type="submit" value="Ajouter">
				</div>
			</div>
		</form:form>

	</div>

</body>
</html>
