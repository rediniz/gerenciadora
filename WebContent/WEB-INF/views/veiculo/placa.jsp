<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${resposta eq true}">
					<span class="bg-danger">A placa informada já existe no sistema</span>
				</c:if>