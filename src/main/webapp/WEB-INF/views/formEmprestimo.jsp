<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de empréstimos</title>

<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

	<div class="table-responsive-xl">

			<h1 align="center">
				<i class="fa fa-handshake-o"> Sistema de empréstimos </i> 
			</h1>
		<div class="table-info">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href='<c:url value="/" />'>Lista de empréstimos</a></li>
			    <li class="breadcrumb-item"><a href='<c:url value="/novo" />'>Criar novo empréstimo</a></li>
			  </ol>
			</nav>
		</div>
	
		<h4>${tipoForm} empréstimo</h4>
	
		<form action='<c:url value="/salvar" />'  method="post">
		
		   <input  type="hidden" name="codigo" value="${emprestimo.numeroDoContrato}">
		
		   <div class="form-group" >
		   	   <label for="nome">Data início do Empréstimo</label>
		   	   <input
		   	      type="text"
		   	      class="form-control"
		   	      name="dataInicioContrato"
		   	      id="dataInicioContrato"
		   	      value="${emprestimo.dataInicioContrato}">		   
		   </div>
		   
		   <div class="form-group" >
		   	   <label  for="email">Email</label>
		   	   <input
		   	      type="text"
		   	      class="form-control"
		   	      name="email"
		   	      id="email"
		   	      value="${aluno.email}"
		   	   >		   
		   </div>
		   
		   <input type="submit"  class="btn btn-primary" value="Salvar" >  
		  
		    <a class="btn btn-secondary" href='<c:url value="/" />' ><i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Voltar para home </a>
		
		
		</form>	
	
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>	

</body>
</html>