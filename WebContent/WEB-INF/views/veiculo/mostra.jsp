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
<title>Gerenciadora de Risco</title>
</head>
<body>
	<div   class="container">
		<div class="row row-content">
			<div class="col-lg-6">
				<h2 align='center'>Mostrar/Alterar Veículo</h2>
				<br>
				<h4 align="center">Dados do veículo</h4>
				<form action="alteraVeiculo" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="cliente_id" class="col-sm-2 control-label" >ID Cliente:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.cliente_id" cssStyle="color:red" />
							<input type="text" name="cliente_id" class="form-control" value="${veiculo.cliente_id}" readonly="readonly"/>
						</div>
					</div>
						<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >ID Veículo</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.id" cssStyle="color:red" />
							<input type="text" name="id" class="form-control"readonly="readonly" value="${veiculo.id}" />
						</div>
					</div>
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >Placa:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.placa" cssStyle="color:red" />
							<input type="text" name="placa" class="form-control"readonly="readonly" value="${veiculo.placa}" />
						</div>
					</div>
					<div class="form-group">
						<label for="ano_fabricacao" class="col-sm-2 control-label" >Ano Fabricação:</label>
						<div class="col-sm-10">
						    <form:errors path="veiculo.ano_fabricacao" cssStyle="color:red" />
							<input type="text" name="ano_fabricacao" class="form-control"" value="${veiculo.ano_fabricacao}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="ano_modelo" class="col-sm-2 control-label" >Ano Modelo:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.ano_modelo" cssStyle="color:red" />
							<input type="text" name="ano_modelo" class="form-control" value="${veiculo.ano_modelo}"/>
						</div>
					</div>
					<div align='center'>
						<input type="submit" value="Alterar" class="btn btn-primary">
					</div>
				</form>
			</div>
			</div>
			<br>
			
		</div>

</body>
</html>