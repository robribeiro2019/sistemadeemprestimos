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
<body onload="init(${emprestimo.cliente.numeroDoCliente},${emprestimo.coletor.numeroDoColetor})">

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
		
			<div class="row col-12">
 
				<div class="form-group col-4" >
					<label for="dataInicio">Início de Emprestimo:</label>
					<input type="date" id="dataInicio" name="dataInicioContrato" value="${emprestimo.dataInicioContrato}">> 	   
				</div>
  
				<div class="form-group col-4" >
					<label for="dataFim">Fim do Emprestimo:</label>
					<input type="date" id="dataFim" name="dataFimContrato" value="${emprestimo.dataFimContrato}">   		
				</div>
  
				<div class="form-group col-4" >
					<label for="dataVencimento">Data do vencimento do pagamento:</label>
					<input type="date" id="dataVencimento" name="dataProximoVencimento" value="${emprestimo.dataProximoVencimento}">   		
				</div>
				
			</div>
			<div class="row col-12"> 
				<div class="form-group col-4" >
					<label  for="cliente">Cliente</label>
					<select name="cliente.numeroDoCliente" id="clienteId" class="form-control col-6">
					<option selected>Selecione uma Opção</option>
						<c:forEach items="${cliente}" var="cliente">
							<option value="${cliente.numeroDoCliente}">${cliente.nomeDoCliente}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group col-4" >	
					<label  for="banco">Banco</label>
					<select name="coletor.numeroDoColetor" id="coletorId" class="form-control col-6">
						<option selected>Selecione uma Opção</option>
						<c:forEach items="${coletor}" var="coletor">
							<option value="${coletor.numeroDoColetor}">${coletor.nomeDoColetor}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row col-12">   
				<div class="form-group col-4" >
			  	   <label  for="montanteEmprestimo">Montante do Emprestimo</label>
			  	   <input
			  	      type="text"
			  	      class="form-control"
			  	      name="montanteDoEmprestimo"
			  	      id="montanteEmprestimo"
			  	      value="${emprestimo.montanteDoEmprestimo}"
			  	   >		   
				</div>
			<div class="form-group col-4" >
				<label  for="montanteEmprestimoDevido">Montante Emprestimo Devido</label>
				<input
				   type="text"
				   class="form-control"
				   name="montanteDoEmprestimoDevido"
				   id="montanteEmprestimoDevido"
				   value="${emprestimo.montanteDoEmprestimoDevido}"
				>		   
			</div>
		</div>
		<div class="row col-12">   
			<div class="form-group col-6" >
				<label  for="parcelas">Parcelas</label>
				<input
					type="text"
					class="form-control"
					name="quantidadeDeParcelas"
					id="parcelas"
					value="${emprestimo.quantidadeDeParcelas}"
				>		   
			</div>
			<div class="form-group col-6" >
				<label  for="txJuros">Taxa de juros</label>
				<input
					type="text"
					class="form-control"
					name="taxaDeJuros"
					id="txJuros"
				>		   
			</div>
		</div>
		<button onclick="teste();"> alert</button>
		<input type="submit"  align="left" class="btn btn-primary" value="Salvar" >  
		</form>	
	</div>
	
	<script type="text/javascript" src="js/controller.js"></script>
		
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