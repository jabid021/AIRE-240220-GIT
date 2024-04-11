<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="eshop.model.Produit"%>
<%@page import="eshop.context.Singleton"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche du produit</title>
</head>
<body>

<% 
Integer id = Integer.parseInt(request.getParameter("id"));
Produit p = Singleton.getInstance().getDaoProduit().findById(id);
%>
<table>


<tr><th>ID</th><th>Libelle</th><th>Prix</th></tr>
<% 
out.println("<tr><td>"+p.getId()+"</td><td>"+p.getLibelle()+"</td><td>"+p.getPrix()+"</td></tr>");
%>

</body>
</html>