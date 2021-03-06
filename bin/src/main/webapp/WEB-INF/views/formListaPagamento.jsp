<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="generator" content="Jekyll v4.0.1">
	<title>Sistema de empr�stimos</title>
	
	<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/checkout/">

	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	
	<script type="text/javascript" src="js/controller.js"></script>
	
</head>
<body class="bg-light" onload="init(${emprestimo.cliente.numeroDoCliente},${emprestimo.coletor.numeroDoColetor})">

	<div class="container">
	
	<div class="py-5 text-center">

		<h1 align="center">
			<i class="fa fa-handshake-o"> Sistema de empr�stimos </i> 
		</h1>
			
		<div class="table-info">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href='<c:url value="/" />'>Lista de empr�stimos</a></li>
			    <li class="breadcrumb-item"><a href='<c:url value="/novo" />'>Criar novo empr�stimo</a></li>
			  </ol>
			</nav>
		</div>
		
		<h3 align="left">Detalhes do empr�stimo</h3>		
		
	</div>
	
		<form action='<c:url value="/salvar" />'  method="post">
		
			<input  type="hidden" name="codigo" value="${emprestimo.numeroDoContrato}">
			<input  type="hidden" name="codigoCliente" value="${emprestimo.cliente.numeroDoCliente}">
			<input  type="hidden" name="codigoColetor" value="${emprestimo.coletor.numeroDoColetor}">
		
			<div class="row col-12">
 
				<div class="form-group col-4" >
					<label for="dataInicio">In�cio de Emprestimo:</label>
					<input disabled class="form-control" type="date" id="dataInicio" name="dataInicioContrato" value="${emprestimo.dataInicioContrato}"> 	   
				</div>
  
				<div class="form-group col-4" >
					<label for="dataFim">Fim do Emprestimo:</label>
					<input disabled class="form-control" type="date" id="dataFim" name="dataFimContrato" value="${emprestimo.dataFimContrato}">   		
				</div>
  
				<div class="form-group col-4" >
					<label for="dataVencimento">Data do vencimento do pagamento:</label>
					<input disabled class="form-control" type="date" id="dataVencimento" name="dataProximoVencimento" value="${emprestimo.dataProximoVencimento}">   		
				</div>
				
			</div>
			<div class="row col-12"> 
				<div class="form-group col-4" >
					<label  for="cliente">Cliente</label>
					  	    <input disabled
					   	       type="text"
					   	       disabled
					  	       class="form-control"
					  	       name="nomeDoCliente"
					  	       id="nomeDoCliente"
					  	       value="${emprestimo.cliente.nomeDoCliente}">
				</div>
				
				<div class="form-group col-4" >	
					<label  for="banco">Banco</label>
					  	    <input
					   	       type="text"
					   	       disabled
					  	       class="form-control"
					  	       name="nomeDoColetor"
					  	       id="nomeDoColetor"
					  	       value="${emprestimo.coletor.nomeDoColetor}">
				</div>
				<div class="form-group col-4" >
			  	   <label  for="montanteEmprestimo">Montante do Emprestimo</label>
			  	   <input disabled
			  	      type="text"
			  	      class="form-control"
			  	      name="montanteDoEmprestimo"
			  	      id="montanteEmprestimo"
			  	      value="${emprestimo.montanteDoEmprestimo}">		   
				</div>				
			</div>
			<div class="row col-12">   

			<div class="form-group col-4" >
				<label  for="montanteEmprestimoDevido">Montante Emprestimo Devido</label>
				<input disabled
				   type="text"
				   class="form-control"
				   name="montanteDoEmprestimoDevido"
				   id="montanteEmprestimoDevido"
				   value="${emprestimo.montanteDoEmprestimoDevido}">		   
			</div>
			<div class="form-group col-4"" >
				<label  for="parcelas">Parcelas</label>
				<input disabled
					type="text"
					onkeypress="return event.charCode >= 48 && event.charCode <= 57"
					class="form-control"
					name="quantidadeDeParcelas"
					id="parcelas"
					value="${emprestimo.quantidadeDeParcelas}">		   
			</div>	
				<div class="form-group col-4"" >
				<label  for="txJuros">Taxa de juros</label>
				<input disabled
					type="text"
					class="form-control"
					name="taxaDeJuros"
					id="txJuros"
					value="${emprestimo.coletor.taxaDeJuros}">		   
			</div>
			</div>
		<hr class="mb-4">
		</form>	
		
		<h3 align="left">${tipoForm} empr�stimo</h3>	
			
		<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>N� pagamento</th>
					<th>Data pagamento</th>
					<th>Valor pagamento</th>
					<th>Taxa de Juros</th>
					<th>Observacoes</th>
<!-- 					<th>Status</th> -->
					<th>A��o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emprestimo.pagamentos}" var="pagamento">
					<tr>
						<td>${pagamento.numeroDoPagamento}</td>
						<td>${pagamento.dataDoPagamento}</td>						
						<td>${pagamento.pagamentoDoMontante}</td>
						<td>${pagamento.pagamentoTaxaDeJuros}</td>
						<td>${pagamento.observacoes}</td>
						
<%-- 						<c:set var="status" value="${emprestimo.status}"/>
						<c:if test="${status =='Vencido'}">
							 <td class="table-danger">${emprestimo.status}</td>
						</c:if>
						<c:if test="${status =='Regular'}">
							 <td class="table-primary">${emprestimo.status}</td>
						</c:if>						
						<c:if test="${status =='Quitado'}">
							 <td class="table-success">${emprestimo.status}</td>
						</c:if>	 --%>						
						
						<td  class="col-xs-2 col-sm-2 col-md-2 col-lg-1">
							<a title="Editar" href='<c:url value="/formedit/${emprestimo.numeroDoContrato}" />'><span class="glyphicon glyphicon-pencil"></span></a>
							<a title="Ecluir" href='<c:url value="/delete/${emprestimo.numeroDoContrato}" />'><span class="glyphicon glyphicon-remove"></span></a>
							<span class="glyphicon glyphicon-list"></span>	
							<span class="glyphicon glyphicon-plus"></span>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>

</body>
</html>