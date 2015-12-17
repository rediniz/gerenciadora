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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row row-content">
			<div class="col-lg-6">
				<h2 align='center'>Lista de Clientes</h2>
				<label class="text-center">Clique no nome do cliente para ver ou alterar informações</label>

				<table class="table table-bordered table-stripped table-hover">
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Remover</th>
					</tr>
					<c:forEach items="${clientes}" var="cliente">
						<tr id="cliente_${cliente.id}">
							<td>${cliente.id}</td>
							<td><a href="mostraCliente?id=${cliente.id}">${cliente.nome}</a></td>
				<td align="center"><a onClick="removeCliente(${cliente.id})"><span class="glyphicon glyphicon-remove" style="color:red; cursor:pointer"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		</div>
			<p align="left">
						<a class="btn btn-primary btn-lg" href="novoCliente" role="button">Cadastrar Cliente</a>
					</p>
	</div>
<script type="text/javascript">
function removeCliente(id) {
	$.post("removeCliente",{'id' : id},function(resposta) {
		$("#cliente_"+id).remove();
		alert("Cliente removido.");
	} );
	}
	

</script>
</body>
</html>