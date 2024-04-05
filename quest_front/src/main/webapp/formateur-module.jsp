<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="output.css" rel="stylesheet">

<meta charset="utf-8">
</head>
<title>Fiche formateur ${formateur.id}</title>
<body class="bg-lime-50">
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
        <tbody>
	        <tr class="even:bg-green-100 odd:bg-green-50 text-green-950 hover:bg-green-200">
	            <td class="py-2">${formateur.id}</td>
	            <td class="py-2">${formateur.email}</td>
	            <td class="py-2">${formateur.password}</td>
	            <td class="py-2">${formateur.nom}</td>
	            <td class="py-2">${formateur.prenom}</td>
	            <td class="py-2">${formateur.tarif}</td>
	            <td class="py-2"><button type="button" onclick="location.href='formateur'" class="rounded shadow text-blue-900 bg-blue-200 hover:bg-blue-300 font-semibold py-4 px-4">Retour</button></td>
	        </tr>
	         <c:choose>
	        		<c:when test="${modules.isEmpty()}">
	        			   <tr class="even:bg-green-100 odd:bg-green-50 text-green-950 hover:bg-green-200">
	        			   		<td class="py-2" colspan=7>Aucun module trouvé</td>
	        			   </tr>
	        		</c:when>
	        		<c:otherwise>
	        				<c:forEach items="${modules}" var="module">
		        				<tr class="even:bg-green-100 odd:bg-green-50 text-green-950 hover:bg-green-200">
		        			   		<td class="py-2" colspan=7>${module.id} - ${module.matiere.libelle}</td>
		        			   </tr>
	        			   </c:forEach>
	        		</c:otherwise>
	         </c:choose>
	    </tbody>
    </table>
    </div>
</body>
</html>