<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Carrinho de compras</title>
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
			<h1>Seu carrinho</h1>
			<h2>Total R$ ${carrinho.valor } </h2>
			<table>
	            <tr>
	                <th>Produto</th>
	                <th>Preço</th>
	                <th>Detalhes</th>
	                <th>Qtd. Item</th>
	            </tr>	            
	            	<c:forEach items="${carrinho.items}" var="item" varStatus="loop">
		                <tr>
		                    <td><c:out value="${item.produto.nome}" /></td>
		                    <td><c:out value="${item.produto.preco}" /></td>
		                    <td><c:out value="${item.produto.detalhes}" /></td>
		                    <td><c:out value="${item.qtdItem}" /></td>
		                    <td><a href="CarrinhoController?app=remover&indice=${loop.index}">Remover</a></td>
		                </tr>
	                </c:forEach>
	       	</table>
		    <br>
		    <a href="LojaController">Continuar Comprando</a>
		</div>
	</body>
</html>