<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="output.css" rel="stylesheet">

<meta charset="utf-8">
</head>
<title>Formateurs</title>
<body class="bg-lime-50">

<!-- 	<!-- NavBar Hedieh--> 
<!-- 	<nav class="bg-blue-500"> -->
<!--   <a class="" href="#">Quest</a> -->
<!--   <button class="" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--     <span class=""></span> -->
<!--   </button> -->
<!--   <div class="" id="navbarNav"> -->
<!--     <ul class="flex justify-end"> -->
<!--       <li class=""> -->
<!--         <a class="" href="accueil">Accueil</a> -->
<!--       </li> -->
<!--       <li class=""> -->
<!--         <a class="" href="stagiaires">Stagiaires</a> -->
<!--       </li> -->
<!--       <li class=""> -->
<!--         <a class="" href="matieres">Formateurs</a> -->
<!--       </li> -->
<!--       <li class=""> -->
<!--         <a class="" href="formateurs">Matière</a> -->
<!--       </li>  -->
<!--       <li class=""> -->
<!--         <a class="" href="filiere">Filieres</a> -->
<!--       </li>  -->
<!--       <li class=""> -->
<!--         <a class="" href="ordinateurs">Ordinateurs</a> -->
<!--       </li>  -->
<!--       <li class=""> -->
<!--         <form class=""> -->
<!--           <input class="" type="search" placeholder="Rechercher" aria-label="Search"> -->
<!--           <button class="" type="submit">Rechercher</button> -->
<!--         </form> -->
<!--       </li> -->
<!--     </ul> -->
<!--   </div> -->
<!-- </nav>  -->

    <div class="container mx-auto shadow-md w-11/12 my-8">
    <table class="table-fixed w-full align-middle justify-start text-left font-light border-collapse divide-y-2 rounded">
        <thead class="bg-green-100 text-green-950 font-semibold">
            <tr>
            <th class="py-4 px-4 w-1/12">Id</th>
            <th class="py-4 w-2/12">Email</th>
            <th class="py-4 w-2/12">Password</th>
            <th class="py-4 w-1/12">Nom</th>
            <th class="py-4 w-1/12">Prénom</th>
            <th class="py-4 w-1/12">Tarif</th>
            <th class="py-4 w-4/12">Actions</th>
            </tr>
        </thead>
        
        <c:forEach items="${formateurs}" var="formateur">
	        <tr class="even:bg-green-100 odd:bg-green-50 text-green-950 hover:bg-green-200">
	            <td class="py-2 px-4">${formateur.id}</td>
	            <td class="py-2">${formateur.email}</td>
	            <td class="py-2">${formateur.password}</td>
	            <td class="py-2">${formateur.nom}</td>
	            <td class="py-2">${formateur.prenom}</td>
	            <td class="py-2">${formateur.tarif}€</td>
	            <td class="py-2">
	                <button onclick="location.href='formateur?id=${formateur.id}'" type="button" class="rounded shadow text-orange-900 bg-orange-200 hover:bg-orange-300 font-semibold py-4 px-4">Modifier</button>
	                <button onclick="location.href='formateur?id=${formateur.id}&delete'" type="button" class="rounded shadow text-red-900 bg-red-200 hover:bg-red-300 font-semibold py-4 px-4">Supprimer</button>
	                <button onclick="location.href='formateur?id=${formateur.id}&jumeau'" type="button" class="rounded shadow text-red-600 bg-zinc-900 hover:bg-zinc-950 font-semibold py-4 px-4">Remplacer</button>        
	            </td>
	        </tr>
		</c:forEach>
		
        <form action="formateur" method="POST">
        <tr class="text-green-950 bg-blue-100">
            <td class="py-2"></td>
            <td class="py-2"><input class="py-1 w-11/12" type="email" name="email" id="email" placeholder="jardonibad@gmail.com"></td>
            <td class="py-2"><input class="py-1 w-11/12" type="password" name="password" id="password" placeholder="drowssap"></td>
            <td class="py-2"><input class="py-1 w-11/12" type="text" name="nom" id="nom" placeholder="Ibad"></td>
            <td class="py-2"><input class="py-1 w-11/12" type="text" name="prenom" id="prenom" placeholder="Jardon"></td>
            <td class="py-2"><input class="py-1 w-11/12" type="number" name="tarif" id="tarif" placeholder="530.00€" step="0.01"></td>
            <td class="py-2"><button type="submit" class="rounded justify-self-center shadow text-blue-900 bg-blue-200 hover:bg-blue-300 font-semibold py-4 px-4">Ajouter</button></td>
        </tr>
        </form>
    </table>
    </div>
</body>
</html>