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
				<h2 align='center'>Adicionar Veículo</h2>
				
				<form id="formulario" name="formulario" action="adicionaVeiculo" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="cliente_id" class="col-sm-2 control-label" >ID Cliente:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.cliente_id" cssStyle="color:red" />
							<input type="text" name="cliente_id" id = "cliente_id" class="form-control" value="${cliente_id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label" >Placa:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.placa" cssStyle="color:red" />
							<input type="text" name="placa" id="placa" class="form-control" ng-model="placaCount" onblur="validaPlaca(this.value)"/>
							<label class='small pull-right'> {{7 - placaCount.length}} caracteres restantes</label>
							<div id="avisoPlaca"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="ano_fabricacao" class="col-sm-2 control-label" >Ano Fabricação:</label>
						<div class="col-sm-10">
						    <form:errors path="veiculo.ano_fabricacao" cssStyle="color:red" />
							<input type="text" name="ano_fabricacao" class="form-control""/>
						</div>
					</div>
					<div class="form-group">
						<label for="ano_modelo" class="col-sm-2 control-label" >Ano Modelo:</label>
						<div class="col-sm-10">
						<form:errors path="veiculo.ano_modelo" cssStyle="color:red" />
							<input type="text" name="ano_modelo" class="form-control"/>
						</div>
					</div>
				
					<div align='center'>
						<input type="submit" id="bt_adicionar" value="Adicionar" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>
<script >
function validaPlaca(placa) {
		formato = /^[a-zA-Z]{3}\d{4}$/
			correto = formato.exec(placa);
			if (!correto){
				window.alert ("Informe a placa no formato correto.");
				return false;
			}
			
			$.post("checaPlaca",{'placa':placa},  function(resposta) {
				if(resposta == 'true'){
					$("#bt_adicionar").attr("disabled", true);
					$("#avisoPlaca").html("<span class='bg-danger'>A placa informada já existe no sistema</span>");
					return false;
				}else{
					$("#avisoPlaca").html("<span class='bg-success'>A placa informada está disponível</span>");
					$("#bt_adicionar").attr("disabled", false);
				}
				});
	
}



</script>
</body>
</html>