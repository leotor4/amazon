
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Livraria Amazon</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body class="container">
    <h1 class="text-center">CADASTRO DE AUTOR</h1>
    <form action="autores" method="POST">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input id="nome" class="form-control" name="nome">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label for="data">Data de Nascimento</label>
            <input id="data" class="form-control" name="data">
        </div>
        <div class="form-group">
            <label for="minicurriculo">Mini Currículo</label>
            <textarea maxlength="255" id="minicurriculo" class="form-control" name="minicurriculo"></textarea>
        </div>

        <input type="submit" value="Cadastrar" class="mt-3 btn-dark">
    </form>
    <h1 class="text-center">LISTA DE AUTORES</h1>
  <table class="table table-dark table-hover table-striped table-bordered">
    <thead>
        <tr>
            <th>NOME</th>
            <th>EMAIL</th>
            <th>DATA DE NASCIMENTO</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${autores}" var="autor">
            <tr>
                <td>${autor.nome}</td>
                <td>${autor.email}</td>
                <td>${autor.dataDeNascimento}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
</body>
</html>