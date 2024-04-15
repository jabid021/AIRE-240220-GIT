<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Stagiaires</title>

</head>

<style>
body {
	background-color: rgb(243, 243, 243);
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 30px;
}

.table_border th, .table_border td {
	border: 2px solid black;
	padding: 8px;
}

th.actions {
	width: 100px;
}

.btn-group {
	display: flex;
	justify-content: space-between;
}

.btn {
	flex: 1;
	margin: 0 5px;
}

form table {
	width: 100%;
}

form th, form td {
	text-align: left;
	margin: 30px;
}

.btn-success {
	width: 100%;
	margin-top: 20px;
}

legend {
	color: yellowgreen;
}

dd {
	text-transform: uppercase;
	font-size: 40px;
	text-align: center;
	margin-top: 30px;
}
</style>

<body>

	<dd>
		<b>Table Stagiaires</b>
	</dd>


	<div class="table_border">
		<table align="center" border width="80%">
			<thead>
				<tr>
					<th>id</th>
					<th>email</th>
					<th>password</th>
					<th>nom</th>
					<th>prenom</th>
					<th>numero</th>
					<th>voie</th>
					<th>ville</th>
					<th>cp</th>
					<th>filiere</th>
					<th class="actions" colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${stagiaires}" var="stagiaire">
						<td>${stagiaire.id}</td>
						<td>${stagiaire.email}</td>
						
						<td><c:if test="${compte.getClass().getSimpleName()=='Formateur'}"> ${stagiaire.password}</c:if></td>
						<td>${stagiaire.nom}</td>
						<td>${stagiaire.prenom}</td>
						<td>${stagiaire.adresse.numero}</td>
						<td>${stagiaire.adresse.voie}</td>
						<td>${stagiaire.adresse.ville}</td>
						<td>${stagiaire.adresse.cp}</td>
						<td>${stagiaire.filiere.id}-${stagiaire.filiere.libelle}</td>

						<td colspan="2"><a href="stagiaire/${stagiaire.id}">
								<div class="btn-group">
									<button type="button" class="btn btn-outline-warning">Modifier</button>
						</a> <a href="stagiaire/delete/${stagiaire.id}">
								<button type="button" class="btn btn-outline-danger">Supprimer</button>
								</div>
						</a></td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	</br>
	<main>
		<form:form  action="stagiaire" method="POST" modelAttribute="stagiaire">
			<fieldset>
				<legend>
					<<b>Ajouter un stagiaire</b>
				</legend>
				<table>
					<tbody>

						<tr>
							<td>Mail :</td>
						</tr>
						<tr>
							<td>
							<form:label path="email"></form:label>
							
							<form:input style="width: 80%" required="required" path="email"
								placeholder="Saisir votre email" type="email"/>
							<form:errors path="email" style= "color: red" ></form:errors>
								</td>
						</tr>


						<tr>
							<td>Password :</td>
						</tr>
						<tr>
							<td>
							<form:label path="password"></form:label>
							<form:input style="width: 80%" required="required" path="password"
								placeholder="Saisir votre password" type="password"/>
								<form:errors path="password" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Nom :</td>
						</tr>
						<tr>
							<td>
							<form:label path="nom"></form:label>
							<form:input style="width: 80%" required="required" path="nom"
								placeholder="Saisir votre nom" type="text"/>
								<form:errors path="nom" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Prenom :</td>
						</tr>
						<tr>
							<td>
							<form:label path="prenom"></form:label>
							<form:input style="width: 80%"
								placeholder="Saisir votre prenom" required="required" path="prenom" type="text"/>
								<form:errors path="prenom" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Numero :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.numero"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.numero"
								placeholder="Saisir votre numero d'adresse" type="text"/>
								<form:errors path="adresse.numero" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Voie :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.voie"></form:label>
							<form:input style="width: 80%"
								placeholder="Saisir votre voie d'adresse" required="required" path="adresse.voie"
								type="text"/>
								<form:errors path="adresse.voie" style= "color: red" ></form:errors>
								</td>
						</tr>


						<tr>
							<td>Ville :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.ville"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.ville"
								placeholder="Saisir votre ville" type="text"/>
								<form:errors path="adresse.ville" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Cp:</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.cp"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.cp"
								placeholder="Saisir votre code postal" type="text"/>
								<form:errors path="adresse.cp" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Filiere :</td>
						</tr>
						<tr>
							<td>
							<form:label path="filiere.id"></form:label>
							<form:select path="filiere.id" required="required">
									<form:option value="">Choisir une filière</form:option>
									<form:options items="${filieres}" itemValue="id" itemLabel="infos"/>
									<form:errors path="filiere.id" style= "color: red" ></form:errors>
										
							</form:select></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<input class ="btn btn-success" type="submit" value="Ajouter">
		</form:form>
	</main>



</body>
</html>
