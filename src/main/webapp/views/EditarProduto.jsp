<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Atualização de Produto</title>
		<style>		
			.container {
				width: 100%;
				height: 90vh;
				display: flex;
				flex-direction: column;
				align-items: center;
				justify-content: center;
			}
			
			form {
				width: 320px;
				display: flex;
				flex-direction: column;
				box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
				padding: 50px 20px;
			}
			
			form, input, button, textarea {
				margin: 10px;
			}
			
			input, button, textarea {
				padding: 10px;
				cursor: pointer;
				border-radius: 12px;
			}
			
			button {
				border: 2px solid #1976D2;
				background-color: #1976D2;
				color: #F5F5F5;
			}
			
			input, textarea {
				border: 2px solid #1976D2;
				color: #1976D2;
			}
			
			h3 {
				color: #1976D2;
				font-family: 'Tahoma';
				text-align: center;
				font-size: 16px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<form action="ProdutoController" method="post">
				<h3>Atualização de Produto</h3>
				<input type="hidden" name="id" value="${produto.id}">
				<input type="text" placeholder="Nome" value="${produto.nome}" name="nome" />
				<input type="text" placeholder="Preço" value="${produto.preco}" name="preco" />
				<input type="number" placeholder="Estoque" value="${produto.estoque}" name="estoque" min="1" max="100">
				<input type="text" placeholder="Detalhes" value="${produto.detalhes}" name="detalhes" />
				<button type="submit">Atualizar</button>
			</form>
		</div>
	</body>
</html>