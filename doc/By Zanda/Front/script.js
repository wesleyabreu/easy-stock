const formulario = document.querySelector("form");

const Inome = document.querySelector(".nome");
const Isenha = document.querySelector(".senha");
const Icra = document.querySelector(".cra");

function cadastrar (){
    fetch("http://localhost:8080/students",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            senha: Isenha.value,
            cra: Icra.value
        })
    })
    .then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrar();
    limpar();

});

function limpar(){
    Inome.value = "",
    Isenha.value = "",
    Icra.value = ""
}