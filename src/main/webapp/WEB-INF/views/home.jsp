<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de empréstimos</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

	<div class="container">

		<div class="jumbotron">
			<h1>
				<i class="fa fa-handshake-o" aria-hidden="true"></i> Sistema de
				empréstimos financeiros
			</h1>
			<h3>Com spring boot</h3>
		</div>

		<div class="d-flex justify-content-between">
			<h4>Listagem de empréstimos</h4>
			<h3>
				<a class="btn btn-primary" href='<c:url value="/criarEmprestimo" />'>
					Criar novo empréstimo </a>
			</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Número do contrato</th>
					<th>Nome do cliente</th>
					<th>Nome do coletor</th>
					<th>Inicio do contrato</th>
					<th>Fim do contrato</th>
					<th>Saldo montante devido</th>
					<th>Próximo vencimento</th>
					<th>Status</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emprestimo}" var="emprestimo">
					<tr>
						<td>${emprestimo.numeroDoContrato}</td>
						<td>${emprestimo.cliente.nomeDoCliente}</td>
						<td>${emprestimo.coletor.nomeDoColetor}</td>
						<td>${emprestimo.dataInicioContrato}</td>
						<td>${emprestimo.dataFimContrato}</td>
						<td>${emprestimo.montanteDoEmprestimoDevido}</td>
						<td>${emprestimo.dataProximoVencimento}</td>
						<td>${emprestimo.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>