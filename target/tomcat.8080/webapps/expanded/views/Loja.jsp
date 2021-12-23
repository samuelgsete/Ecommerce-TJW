<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF=8">
		<title>Loja Online</title>
		<style>
			* {
				font-family: 'Verdana';
				font-size: 14px;
			}
			
			.container h2 {
				text-align: center;
			}
						
			.card {
				display: flex;
			    flex-direction: column;
			    justify-content: center;
			    align-items: center;
			    text-align: center;
			    cursor: pointer;
				box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
				width: 240px;
    			padding: 30px 10px;
    			margin: 10px;
    			float:left;
			}
			
			h4, a {
				color: #1976D2;
			}
			
			hr {
				border: 1px solid #CEE3F6;
			}
			
			input {
				width: 30px;
			}
			
			input, button {
				margin: 5px;
			}
			
			input, button {
				padding: 10px;
				cursor: pointer;
				border-radius: 12px;
			}
						
			button {
				border: 2px solid #1976D2;
				background-color: #1976D2;
				color: #F5F5F5;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h2>Nosso Catálogo</h2>
			<c:forEach items="${produtos}" var="produto">
	        	<div class="card">
		         	<h3>${produto.nome}</h3>
		            <h4>R$ ${produto.preco}</h4>
		            <span style="color: #3F51B5">${produto.estoque} Unidade(s) disponivel(s)</span>
		            <p>${produto.detalhes}</p>
		            <hr style="width:100%">
		            <form method="post" action="CarrinhoController">
		            	<input type="hidden" name="nome" value="${produto.nome}" />
		            	<input type="hidden" name="preco" value="${produto.preco}" />
		            	<input type="hidden" name="detalhes" value="${produto.detalhes}" />
		           	 	<input type="number" value="1" name="qtdItem" />
		           	 	<button type="submit">Comprar</button>
		            </form>
        		</div>
	         </c:forEach>
		</div>
	</body>
</html>