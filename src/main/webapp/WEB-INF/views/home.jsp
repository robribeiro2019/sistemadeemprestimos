<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="generator" content="Jekyll v4.0.1">
<title>Sistema de empréstimos</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/checkout/">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.quicksearch/2.3.1/jquery.quicksearch.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/sisemprestimos/js/jquery-dateformat.min.js"></script>
<script type="text/javascript" src="/sisemprestimos/js/controller.js"></script>
</head>
<body class="bg-light">

	<div class="container">

		<div class="py-5 text-center">

			<h1 align="center">
				<i class="fa fa-handshake-o"> Sistema de empréstimos </i>
			</h1>

			<div class="d-flex justify-content-between">

				<h3 class="mt-2" align="left">Lista de empréstimos</h3>

				<div class="d-flex justify-content-between">
					<button class="mx-auto btn btn-primary" style="height:35px!important; width:100px!important" onclick="goToHome()">Listar</button>
					&nbsp;
					<button class="btn btn-primary" style="height:35px!important; width:100px!important" onclick="goToNew()">Criar</button>

				</div>
			</div>

		</div>

		<div class="form-group input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-search"></i></span> <input name="consulta"
				id="txt_consulta" placeholder="Localizar" type="text"
				class="form-control">
		</div>

		<table id="tabela" class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th>Nº contrato</th>
					<th>Cliente</th>
					<th>Coletor</th>
					<th>Data Inicio</th>
					<th>Data Fim</th>
					<th>Saldo devido</th>
					<th>Vencimento</th>
					<th>Status</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emprestimo}" var="emprestimo">
					<tr>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">${emprestimo.numeroDoContrato}</td>
						<td>${emprestimo.cliente.nomeDoCliente}</td>
						<td>${emprestimo.coletor.nomeDoColetor}</td>
						<td><script>formatDate('${emprestimo.dataInicioContrato}');</script></td>
						<td><script>formatDate('${emprestimo.dataFimContrato}');</script></td>
						<td>${emprestimo.montanteDoEmprestimoDevido}</td>
						<td><script>formatDate('${emprestimo.dataProximoVencimento}');</script></td>
						
						<c:set var="status" value="${emprestimo.status}" />
						<c:if test="${status =='Vencido'}">
							<td class="table-danger">${emprestimo.status}</td>
						</c:if>
						<c:if test="${status =='Regular'}">
							<td class="table-primary">${emprestimo.status}</td>
						</c:if>
						<c:if test="${status =='Quitado'}">
							<td class="table-success">${emprestimo.status}</td>
						</c:if>

						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1"><a
							title="Editar"
							href='<c:url value="/formedit/${emprestimo.numeroDoContrato}" />'><span
								class="glyphicon glyphicon-pencil"></span></a> <a title="Ecluir"
							href='<c:url value="/delete/${emprestimo.numeroDoContrato}" />'><span
								class="glyphicon glyphicon-remove"></span></a> <a title="Detalhar"
							href='<c:url value="/formpag/${emprestimo.numeroDoContrato}" />'><span
								class="glyphicon glyphicon-list"></span></a> <span
							class="glyphicon glyphicon-check"></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$('input#txt_consulta').quicksearch('table#tabela tbody tr');
	</script>
</body>
</html>