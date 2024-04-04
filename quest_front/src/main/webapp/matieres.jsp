<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="fr">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Matieres</title>

<!-- Banniere navbar par bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

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

	<!-- Bannière de ma page-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
		<a class="navbar-brand" href="#">Quest</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="accueil.html">Accueil</a></li>
				<!-- <li class="nav-item">
          <a class="nav-link" href="#">Ajouter une matière</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Supprimer une matière</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Modifier une matière</a>
        </li> -->
				<li class="nav-item search-bar">
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Rechercher" aria-label="Search">
						<button class="btn btn-outline-secondary my-2 my-sm-0"
							type="submit">Rechercher</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>

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
						<td class="action-buttons"><a
							href="matiere?id=${matiere.id}"><button>Modifier</button></a>
							<a href="matiere?id=${matiere.id}&delete"><button>Supprimer</button></a>
						</td>
					</tr>
				</c:forEach>


			</table>
		</div>

		<!-- Affichage de la saisie de matière-->
		<form action="matiere" method="POST">
			<div class="form-container">
				<h3>Ajouter une nouvelle Matière</h3>
				<div class="form-group">
					<label for="libelle">Libellé de la Matière :</label> <input
						type="text" id="libelle" name="libelle"> <input
						type="submit" value="Ajouter">
				</div>
			</div>
		</form>

	</div>

	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
