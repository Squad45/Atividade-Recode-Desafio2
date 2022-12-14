<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>cadastro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./css/style.css">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"  integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

  </head>
  <body>
     <!-- section da header navbar -->
     <section class="container-fuid">
      <nav class="nav justify-content-center fixed-top">
        <a class="nav-link text-light" href="./index.html">HOME</a>
        <a class="nav-link text-light" href="./projeto.html">PROJETOS</a>
        <a class="nav-link text-light" href="./cadastro1_geral.html">CADASTRE-SE</a>
        <a class="nav-link text-light" href="./contatos.html">CONTATOS</a>
    </nav>
    </section>
    


    <section class="container-fluid sect-form">
      <!-- imagem de fundo -->
      <div class="img-back">
          <img src="./img/Saly-12.png" alt="">
      </div>
  
      <main class="main-form-geral">
  
  
      <!-- titulo -->
          <h3>Obrigado por acreditar em nós, ${cliente.getNome()} !</h3>
          <h2>entraremos em contato assim que o avaliarmos</h2>
          <form class="form-pessoa" action="delete" method="GET">
              <div class="div-input">
                <input type="submit" class="btn btn-danger" value="Deletar">
                
              </div>
          </form>
		  <a class="ancora-escolha " href="index.html">Voltar para inicio</a>
      </main>
    </section>



      <!-- footer -->
    <section class="container-fuid footer">
        <!-- so pegar algo do bootstrap q ja ta bom -->
      <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
          <li class="nav-item"><a href="./index.html" class="nav-link px-2 text-muted">Home</a></li>
          <li class="nav-item"><a href="./projeto.html" class="nav-link px-2 text-muted">Projeto</a></li>
          <li class="nav-item"><a href="./cadastro1_geral.html" class="nav-link px-2 text-muted">Cadastro</a></li>
           <li class="nav-item"><a href="./contatos.html" class="nav-link px-2 text-muted">Contatos</a></li>
        </ul>
        <p class="text-center text-muted">© 2022 Tecnologia Solidária na Zona Rural</p>
      </footer>
    </section>



    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
  </body>
</html>