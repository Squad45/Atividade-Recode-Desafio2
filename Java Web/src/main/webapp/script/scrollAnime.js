const navbar = document.getElementById("nav");
const limite = document.getElementById("texto-explicativo");
window.addEventListener("scroll", function(){
    const window = this.window.pageYOffset + ((this.window.innerHeight /2)/2);
    
    if(window >= limite.offsetTop){
        navbar.classList.add("nav-bg");
    }else{
        navbar.classList.remove("nav-bg");
    }
})