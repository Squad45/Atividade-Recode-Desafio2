<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

<head>
    <title>cadastro pessoa</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./css/style.css">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>

<body>

     <!-- section da header navbar -->
     <section class="container-fuid">
        <nav class="nav justify-content-center fixed-top nav-bg">
            <a class="nav-link text-light" href="./index.html">HOME</a>
            <a class="nav-link text-light" href="./projeto.html">PROJETOS</a>
            <a class="nav-link text-light" href="./cadastro1_geral.jsp">CADASTRE-SE</a>
            <a class="nav-link text-light" href="./contatos.html">CONTATOS</a>
        </nav>
      </section>

    <!-- background da pagina -->
    <section class="container-fluid sect-form">
        <!-- imagem de fundo -->
        <div class="img-back">
            <img src="./img/Saly-12.png" alt="">
        </div>

        <main class="main-form-geral">

            <!-- icons de navegação -->
            <div class="icon">
                <!-- icon 1 -->
                <button class="icon-btn btn-1">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                        class="bi bi-emoji-smile" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                        <path
                            d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z" />
                    </svg>
                </button>

                <div class="linha"></div>

                <!-- icon 2 -->
                <button class="icon-btn btn-2" id="iconP-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                        class="bi bi-house" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                            d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
                        <path fill-rule="evenodd"
                            d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" />
                    </svg>
                </button>
            </div>

            <!-- titulo -->
            <h2>Cadastro pessoal</h2>


            <!-- começo do formulario pessoa -->
            <form class="form-pessoa" action="">

                <!-- PARTE 1 -->
                <div class="disp-non" id="formP1">
                    <!-- input de texto Nome -->
                    <div class="div-input">
                        <label for="nome">Nome:</label>
                        <input type="text" name="nome" placeholder="Nome completo">
                        <div class="underline"></div>
                    </div>
                    <!-- input de texto Email -->
                    <div class="div-input">
                        <label for="email">Email:</label>
                        <input type="email" name="email" placeholder="Digite...">
                        <div class="underline"></div>
                    </div>
                    <!-- input de texto Telefone  -->
                    <div class="div-input">
                        <label for="telefone">Telefone:</label>
                        <input type="tel" name="telefone" placeholder="(xx) xxxxx-xxxx">
                        <div class="underline"></div>
                    </div>
                    <!-- input de texto CPF -->
                    <div class="div-input">
                        <label for="cpf">CPF:</label>
                        <input type="text" name="cpf" placeholder="Apenas número">
                        <div class="underline"></div>
                    </div>
                </div>
                <!-- PARTE 2 -->
                <div class="disp-none" id="formP2">
                    <div class="div-input">
                        <label for="nome">CEP</label>
                        <input type="text" name="cep" placeholder="CEP">
                        <div class="underline"></div>
                    </div>

                    <div class="div-input">
                        <label for="endereço">Endereço</label>
                        <input type="text" name="endereco" placeholder="Endereço">
                        <div class="underline"></div>
                    </div>

                    <div class="div-input">
                        <label for="telefone">ponto de Referência</label>
                        <input type="text" name="pontoRef" placeholder="Digite...">
                        <div class="underline"></div>
                    </div>

                    <div class="escolha" id="escolhaPessoa">
                        <h5>Eu:</h5>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" onclick="doadorP()">
                            <label class="form-check-label" for="flexRadioDefault1">
                              Sou doador
                            </label>
                          </div>
                          <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" onclick="precisoP()">
                            <label class="form-check-label" for="flexRadioDefault2">
                              Preciso de Equipamento
                            </label>
                          </div>
                    </div>
                    <input class="btn-continue disp-none" id="btn-continueP" type="submit" value="continue">
                </div>
            </form>

             <!-- BOTAO -->
      <div class="next-prev">
        <!-- BOTAO PREV -->
        <button class="btn-prev disp-none" id="btn-prevP" onclick="retornaEtapaP()">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left"
            viewBox="0 0 16 16">
            <path fill-rule="evenodd"
              d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z" />
          </svg>
        </button>
        <!-- BOTAO NEXT -->
        <button class="btn-next" id="btn-nextP" onclick="proximaEtapaP()">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right"
            viewBox="0 0 16 16">
            <path fill-rule="evenodd"
              d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
          </svg>
        </button>
      </div>

        </main>
    </section>

    
<script src="./script/script.js"></script>

    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
</body>

</html>