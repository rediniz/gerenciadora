<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body>
	<div  ng-app="" class="container">
		<div class="row row-content">
			<div class="col-lg-6">
				<h2 align='center'>Adicionar Cliente</h2>
				
				<form action="adicionaCliente" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >Nome:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.nome" cssStyle="color:red" />
							<input type="text" name="nome" class="form-control" ng-model="nomeCount"/>
							<label class='small pull-right'> {{80 - nomeCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="endereco" class="col-sm-2 control-label" >Endereço:</label>
						<div class="col-sm-10">
						    <form:errors path="cliente.endereco" cssStyle="color:red" />
							<input type="text" name="endereco" class="form-control" ng-model="enderecoCount"/>
							<label class='small pull-right'>{{80 - enderecoCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="bairro" class="col-sm-2 control-label" >Bairro:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.bairro" cssStyle="color:red" />
							<input type="text" name="bairro" class="form-control" ng-model="bairroCount"/>
							<label class='small pull-right'>{{45 - bairroCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div class="form-group">
						<label for="cep" class="col-sm-2 control-label" ng-model="CEPCount">CEP:</label>
						<div class="col-sm-10">
						<form:errors path="cliente.cep" cssStyle="color:red" />
							<input type="text" name="cep" class="form-control" ng-model="CEPCount"/>
							<label class='small pull-right'>{{8 - CEPCount.length}} caracteres restantes</label>
						</div>
					</div>
					<div align='center'>
						<input type="submit" value="Adicionar" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>