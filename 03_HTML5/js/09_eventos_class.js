// Manera EcmaScript 5
function GestorEventosES5(inputId, btnId, divInfoId) {
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divInfoId);
    this.funCallbkAlPulsarBIND = this.funCallbkAlPulsar.bind(this);
    this.boton.addEventListener("click", this.funCallbkAlPulsarBIND);
    
    this.funCallbkOnClick_2 =    (evento) => {
        this.input.style = "background-color: lightblue; ";
        evento.currentTarget.value = "Puedes repetir";
        
        this.divInfo.innerHTML += "evento.currentTarget.id = " + evento.currentTarget.id;
        this.divInfo.className = "div-marco";
        evento.currentTarget.removeEventListener("click", this.funCallbkAlPulsarBIND);
    };
    this.boton.addEventListener("click", this.funCallbkOnClick_2);
}
GestorEventosES5.prototype.funCallbkAlPulsar = new Function("evento", ` {
    this.input.value = "Tipo evento: " + evento.type;
}`);
GestorEventosES5.metodoEstatico = function() {
    alert("Método estático");
}

class GestorEventosES6 {    // Manera EcmaScript 2015 ó ES6
    constructor(inputId, btnId, divInfoId) {
        this.input = document.getElementById(inputId);
        this.boton = document.getElementById(btnId);
        this.divInfo = document.getElementById(divInfoId);
        this.boton.addEventListener("click", this.funCallbkAlPulsar.bind(this));
        this.boton.addEventListener("click", this.funCallbkOnClick_2);
    }
    funCallbkAlPulsar(evento) {
        this.input.value = "Tipo evento: " + evento.type;
    }
    funCallbkOnClick_2 = (evento) => {
        this.input.style = "background-color: lightblue; ";
    }    
    static metodoEstatico() {
        alert("Método estático");
    }
}