<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/bootstrap-theme.css" rel="stylesheet">

<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/angular.min.js"></script>

<script type="text/javascript">
function removeVeic(id) {
	$.post("removeVeiculo",{'id' : id},function(resposta) {
		$("#veiculo_"+id).remove();
		alert("Veículo removido.");
	} );
	}
	

</script>
<title>Insert title here</title>
</head>
<body>
	<div  ng-app="" class="container">
		<div class="row row-content">
			<div class="col-lg-6">
				<h2 align='center'>Mostrar/Alterar Cliente</h2>
				<br>
				<h4 align="center">Dados do cliente</h4>
				<form action="alteraCliente" method="post" class="form-horizontal">
				<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >Id:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.id" cssStyle="color:red" />
							<input type="text" name="id" class="form-control" value="${cliente.id}" />
						</div>
					</div>
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >Nome:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.nome" cssStyle="color:red" />
							<input type="text" name="nome" class="form-control" value="${cliente.nome}" />
							<label class='small pull-right'> {{80 - nomeCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="endereco" class="col-sm-2 control-label" >Endereço:</label>
						<div class="col-sm-10">
						    <form:errors path="cliente.endereco" cssStyle="color:red" />
							<input type="text" name="endereco" class="form-control" value="${cliente.endereco}"/>
							<label class='small pull-right'>{{80 - enderecoCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="bairro" class="col-sm-2 control-label" >Bairro:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.bairro" cssStyle="color:red" />
							<input type="text" name="bairro" class="form-control" value="${cliente.bairro}"/>
							<label class='small pull-right'>{{45 - bairroCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="cep" class="col-sm-2 control-label" >CEP:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.cep" cssStyle="color:red" />
							<input type="text" name="cep" class="form-control" value="${cliente.cep}"/>
							<label class='small pull-right'>{{8 - CEPCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div align='center'>
						<input type="submit" value="Alterar" class="btn btn-primary">
					</div>
				</form>
			</div>
			</div>
			<br>
			<div class="row row-content">
			<div class="col-lg-6">
			<h4 align="center">Veículos cadastrados para esse cliente</h4>
			<table class="table table-stripped table-hover">
			<th>ID</th>
			<th>Placa</th>
			<th>Ano Fabricação</th>
			<th>Ano Modelo</th>
			<th>Alterar</th>
			<th>Remover</th>
			<c:forEach items="${veiculos}" var="veiculo">
			<tr id="veiculo_${veiculo.id}">
				<td>${veiculo.id}</td>
				<td>${veiculo.placa}</td>
				<td>${veiculo.ano_fabricacao}</td>
				<td>${veiculo.ano_modelo}</td>
				<td align="center"><a href="<c:url value="/mostraVeiculo?id=${veiculo.id}"/>"><span class="glyphicon glyphicon-edit" aria-hidden="true" style="color:blue; cursor:pointer"></span></a></td>
				<td align="center"><a onClick="removeVeic(${veiculo.id})"><span class="glyphicon glyphicon-remove" style="color:red; cursor:pointer"></span></a></td>
			</tr>
		</c:forEach>
			</table>
			<div align='center'>
			
						<a href="<c:url value="/novoVeiculo?id=${cliente.id}" />" class="btn btn-primary btn-lg">Adicionar Veículo</a>
					</div>
			</div>
			</div>
		</div>

</body>
</html>