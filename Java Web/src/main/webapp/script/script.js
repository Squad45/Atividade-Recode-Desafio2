
// da empresa
// pegando o id da parte 1 e 2 do formulário
const formEPartI = document.getElementById("formE1");
const formEPartII = document.getElementById("formE2");

//pegando os id dos botões
const prevE = document.getElementById("btn-prevE");
const nextE = document.getElementById("btn-nextE");
const continuarE = document.getElementById("btn-continueE");

//executando as funções onclick
function proximaEtapaE(){
    document.getElementById("iconE-2").style.backgroundColor = "var(--cor-terciaria)";
    formEPartI.classList.add("disp-none");
    formEPartII.classList.remove("disp-none");
    prevE.classList.remove("disp-none");
    nextE.classList.add("disp-none");
    continuarE.classList.remove("disp-none");
};
function retornaEtapaE(){
    document.getElementById("iconE-2").style.backgroundColor = "white";
    formEPartI.classList.remove("disp-none");
    formEPartII.classList.add("disp-none");
    prevE.classList.add("disp-none");
    nextE.classList.remove("disp-none");
    continuarE.classList.add("disp-none");
}

// da pessoa
// pegando o id da parte 1 e 2 do formulário
const formPPartI = document.getElementById("formP1");
const formPPartII = document.getElementById("formP2");

//pegando os id dos botões
const prevP = document.getElementById("btn-prevP");
const nextP = document.getElementById("btn-nextP");
const continuarP = document.getElementById("btn-continueP");

//executando as funções onclick
function proximaEtapaP(){ 
    document.getElementById("iconP-2").style.backgroundColor = "var(--cor-terciaria)";
    formPPartI.classList.add("disp-none");
    formPPartII.classList.remove("disp-none");
    prevP.classList.remove("disp-none");
    nextP.classList.add("disp-none");
    continuarP.classList.remove("disp-none");
};
function retornaEtapaP(){
    document.getElementById("iconP-2").style.backgroundColor = "white";
    formPPartI.classList.remove("disp-none");
    formPPartII.classList.add("disp-none");
    prevP.classList.add("disp-none");
    nextP.classList.remove("disp-none");
    continuarP.classList.add("disp-none");
}

//para outras paginas
function doadorP(){
    let aI = document.getElementById("ancoraP");
    aI.href = "./cadastro_doacao.html";
}
function precisoP(){
    let aI = document.getElementById("ancoraP");
    aI.href = "./cadastro_preciso.html";
}
function doadorE(){
    let aII = document.getElementById("ancoraE");
    aII.href = "./cadastro_doacao.html";
}
function precisoE(){
    let aII = document.getElementById("ancoraE");
    aII.href = "./cadastro_preciso.html";
}

const fimForm = document.getElementById("confirm");

fimForm.addEventListener("click", () =>{
    alert("formulario feito!");
})