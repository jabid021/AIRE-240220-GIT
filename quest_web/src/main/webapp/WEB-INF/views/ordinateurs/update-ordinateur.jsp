<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<title>Fiche Ordinateur</title>

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
		<form:form class="form-group row" action="ordinateur/${ordinateur.id}" 
			method="POST" modelAttribute="ordinateur">
			<fieldset>
				<table id="tab1" class="table table-active table-bordered">
					<h1>Modifier un ordinateur</h1>
					<form:hidden path="id"/>
					<thead>
						<tr>
							<th><label>RAM</label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
							<form:select path="ram" requied="required">
									<option value="">Choisir une RAM</option>
									<form:option value="8">8G</form:option>
									<form:option value="16">16G</form:option>
									<form:option value="32">32G</form:option>
							</form:select>
							</td>
						</tr>
					<thead>
						<tr>
							<th><label>MARQUE</label></th>
						</tr>
					</thead>
					<tr>
						<td>
						<form:select class="custom-select" path="marque" requied="required">
								<form:option value="">Choisir une MARQUE Ordinateur</form:option>
								<form:options items="${marques}"/>
						</form:select>
						</td>
					</tr>


					<tr>
						<td>
						<form:select path="stagiaire.id">
								<form:option value="">Pas de stagiaire</form:option>		
									
								<form:options items="${stagiaires}" itemValue="id" itemLabel="infos"/>
						</form:select>
						</td>
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
		</form:form>
	</div>
</body>
</html>
