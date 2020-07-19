<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="generator" content="Jekyll v4.0.1">
	<title>Sistema de empréstimos</title>
	
	<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/checkout/">

	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	
	<script type="text/javascript" src="/sisemprestimos/js/controller.js"></script>
	
</head>
<body class="bg-light" onload="init(${emprestimo.cliente.numeroDoCliente},${emprestimo.coletor.numeroDoColetor})">

	<div class="container">
	
	<div class="py-5 text-center">

		<h1 align="center">
			<i class="fa fa-handshake-o"> Sistema de empréstimos </i> 
		</h1>
			
		<div class="d-flex justify-content-between">
			
			<h3 class="mt-2" align="left">${tipoForm} empréstimo</h3>	
			
			<div class="d-flex justify-content-between">
				<button class="mx-auto btn btn-primary" style="height:35px!important; width:100px!important" onclick="goToHome()">Listar</button>
				
			</div>
		</div>
		
	</div>
	
		<form action='<c:url value="/salvar" />'  method="post">
		
			<c:set var="tipo" value="${tipoForm}"/>
			
			<input  type="hidden" name="numeroDoContrato" value="${emprestimo.numeroDoContrato}">
			<input  type="hidden" name="tipoForm" value="${tipoForm}">
			
			<c:if test="${tipo == 'Editar'}">
				<input  type="hidden" name="cliente.numeroDoCliente" value="${emprestimo.cliente.numeroDoCliente}">
				<input  type="hidden" name="coletor.numeroDoColetor" value="${emprestimo.coletor.numeroDoColetor}">
			</c:if>
			
			<div class="row col-12">
 
				<div class="form-group col-4" >
					<label for="dataInicio">Início do Emprestimo:</label>
					<c:if test="${tipo =='Editar'}">
					<input disabled class="form-control" type="date" id="dataInicio1" name="dataInicioContrato" value="${emprestimo.dataInicioContrato}"> 
					</c:if>	
					<c:if test="${tipo =='Novo'}">
					<input class="form-control" type="date" id="dataInicio1" name="dataInicioContrato" value="${emprestimo.dataInicioContrato}"> 
					</c:if>   
				</div>
  
				<div class="form-group col-4" >
					<label for="text">Fim do Emprestimo:</label>
					<input disabled class="form-control" type="date" id="dataFim" name="dataFimContrato" value="${emprestimo.dataFimContrato}">   		
				</div>
  
				<div class="form-group col-4" >
					<label for="dataVencimento">Data do próximo vencimento:</label>
					<input disabled class="form-control" type="date" id="dataVencimento1" name="dataProximoVencimento" value="${emprestimo.dataProximoVencimento}">   		
				</div>
				
			</div>
			<div class="row col-12"> 
				<div class="form-group col-4" >
					<label  for="cliente">Cliente</label>
						<c:if test="${tipo =='Editar'}">
					  	    <input
					   	       type="text"
					   	       disabled
					  	       class="form-control"
					  	       name="nomeDoCliente"
					  	       id="nomeDoCliente"
					  	       value="${emprestimo.cliente.nomeDoCliente}">
						</c:if>
						<c:if test="${tipo =='Novo'}">
								<select class="form-control form-control-lg" name="cliente.numeroDoCliente" id="clienteId" required>
								<option selected>Selecione uma Opção</option>
									<c:forEach items="${cliente}" var="cliente">
										<option value="${cliente.numeroDoCliente}">${cliente.nomeDoCliente}</option>
									</c:forEach>
								</select>
						</c:if>	
											
				</div>
				
				<div class="form-group col-4" >	
					<label  for="banco">Banco</label>
					
						<c:if test="${tipo =='Editar'}">
					  	    <input
					   	       type="text"
					   	       disabled
					  	       class="form-control"
					  	       name="nomeDoColetor"
					  	       id="nomeDoColetor"
					  	       value="${emprestimo.coletor.nomeDoColetor}">
						</c:if>
						<c:if test="${tipo =='Novo'}">
							<select class="form-control form-control-lg" name="coletor.numeroDoColetor" id="coletorId" required>
								<option selected>Selecione uma Opção</option>
								<c:forEach items="${coletor}" var="coletor">
									<option value="${coletor.numeroDoColetor}">${coletor.nomeDoColetor}</option>
								</c:forEach>
							</select>
						</c:if>					
		
				</div>
				<div class="form-group col-4" >
			  	   <label  for="montanteEmprestimo">Montante do Emprestimo</label>
			  	   <c:if test="${tipo =='Editar'}">
			  	   <input
			  	   	  disabled
			  	      type="text"
			  	      class="form-control"
			  	      name="montanteDoEmprestimo"
			  	      id="montanteEmprestimo"
			  	      value="${emprestimo.montanteDoEmprestimo}">
			  	    </c:if>  
			  	   <c:if test="${tipo =='Novo'}">
			  	   <input
			  	      type="text"
			  	      class="form-control"
			  	      name="montanteDoEmprestimo"
			  	      id="montanteEmprestimo"
			  	      value="${emprestimo.montanteDoEmprestimo}">
			  	    </c:if> 
				</div>				
			</div>
			<div class="row col-12">   

			<div class="form-group col-4" >
				<label  for="montanteEmprestimoDevido">Montante Emprestimo Devido</label>
				<input
				   disabled
				   type="text"
				   class="form-control"
				   name="montanteDoEmprestimoDevido"
				   id="montanteEmprestimoDevido"
				   value="${emprestimo.montanteDoEmprestimoDevido}">		   
			</div>
			<div class="form-group col-4" >
				<label  for="parcelas">Parcelas</label>
				<c:if test="${tipo =='Editar'}">
				<input
				    disabled
					type="text"
					onkeypress="return event.charCode >= 48 && event.charCode <= 57"
					class="form-control"
					name="quantidadeDeParcelas"
					id="parcelas"
					value="${emprestimo.quantidadeDeParcelas}">
				</c:if>	
				<c:if test="${tipo =='Novo'}">
				<input
					type="text"
					onkeypress="return event.charCode >= 48 && event.charCode <= 57"
					class="form-control"
					name="quantidadeDeParcelas"
					id="parcelas"
					value="${emprestimo.quantidadeDeParcelas}">
				</c:if>						   
			</div>	
			<div class="form-group col-4" >
				<label  for="txJuros">Taxa de juros</label>
				<input
				    disabled
					type="text"
					class="form-control"
					name="taxaDeJuros"
					id="txJuros"
					value="${emprestimo.coletor.taxaDeJuros}">		   
			</div>
			</div>
		<hr class="mb-4">
		<div class="container">
			<input class="btn btn-primary btn-lg" style="margin-left: 45%!important" type="submit" value="Salvar" >  
		</div>
		
		</form>	
	</div>

</body>
</html>