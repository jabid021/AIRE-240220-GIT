<!-- <base href="/quest_front/"> -->




<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">




<nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
	<a class="navbar-brand" href="index.html">Quest</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
		
		<li class="nav-item active"><a class="nav-link" href="">Bonjour ${compte.prenom} ${compte.nom}</a>
			</li>
			
			<li class="nav-item active"><a class="nav-link" href="index.html">Accueil</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="stagiaire">Stagiaires</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="formateur">Formateurs</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="matiere">Matières</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="filiere">Filieres</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="ordinateur">Ordinateurs</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="home?deconnecter">Se deconnecter</a>
			</li>
			
		</ul>
	</div>
</nav>


<base href="${pageContext.request.contextPath}/"> 
