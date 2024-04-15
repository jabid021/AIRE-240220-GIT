<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <form:form action="formateur/${formateur.id}" method="POST" modelAttribute="formateur">
	        <tr class="text-green-950 bg-blue-100">
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="number" path="id" readonly="true"/></td>
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="email" path="email"/></td>
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="password" path="password"/></td>
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="text"  path="nom"/></td>
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="text"  path="prenom"/></td>
	            <td class="py-2"><form:input class="py-1 w-11/12" required="required" type="number" path="tarif" step="0.01"/>
	            <form:errors path="tarif">Le tarif doit être compris entre 70 et 10000€</form:errors></td>
	            <td class="py-2"><button type="submit" class="rounded shadow text-orange-900 bg-orange-200 hover:bg-orange-300 font-semibold py-4 px-4">Modifier</button></td>
	        </tr>
        </form:form>
    </table>
    </div>
</body>
</html>