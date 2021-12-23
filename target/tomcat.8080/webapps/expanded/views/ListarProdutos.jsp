<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listagem de Produtos</title>
		<style>
			* {
				font-family: 'Verdana';
				font-size: 14px;
			}
			
			.container {
				width: 100%;
				height: 90vh;
				display: flex;
				flex-direction: column;
				align-items: center;
				justify-content: center;
			}
			
			table {
			    padding: 10px;
			    border-collapse: collapse;
			    box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
			}

			table tr td, table tr th {
			    padding: 15px 20px;
			    text-align: left;
			}
			
			tr {
			    border-bottom: 1px solid #d3d7da;
			}
			
			table tr {
			    transition: background 0.6s;
			    cursor: pointer;
			}
			
			table tr:hover {
			    background-color: #eaeef5;
			}
			
			table tr:nth-child(even) {
			    background-color: #eaeef5;
			}
			
			.container a, table tr th {
				color: #1976D2;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<table>
	            <tr>
	                <th>ID</th>
	                <th>Produto</th>
	                <th>Preço</th>
	                <th>Estoque</th>
	                <th>Detalhes</th>
	            </tr>
	            <c:forEach items="${produtos}" var="produto">
	                <tr>
	                	<td><c:out value="${produto.id}" /></td>
	                    <td><c:out value="${produto.nome}" /></td>
	                    <td><c:out value="${produto.preco}" /></td>
	                    <td><c:out value="${produto.estoque}" /></td>
	                    <td><c:out value="${produto.detalhes}" /></td>
	                    <td><a href="ProdutoController?app=excluir&produtoId=<c:out value="${produto.id}"/>">Excluir</a></td>
	                    <td><a href="ProdutoController?app=editar&produtoId=<c:out value="${produto.id}"/>">Editar</a></td>
	                </tr>
	            </c:forEach>
	       	</table>
	       	<br>
	       	<a href="CadastrarProduto">Cadastrar Produto</a>
		</div>
	</body>
</html>