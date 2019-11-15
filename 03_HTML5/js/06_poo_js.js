var div = document.getElementById("contenido");

var bebida = new Object();
bebida.tipo = "Cerveza";
bebida.cantidad = "3 litros";

div.innerHTML+="Bebida es " + bebida.tipo + "<br/>";
// En JS, los objetos son mapas 
// (como el HashMap<String, Object> de Java)
div.innerHTML+="Cantidad es " + bebida["cantidad"];

bebida["propiedades"] = "Tiene alcohol, gas y emborracha";
div.innerHTML += "<br/>Propiedades: " 
    + bebida.propiedades;

function suma(x, y) {
    return x + y;
}
div.innerHTML += "<br/>suma(5, 3) = " + suma(5, 3);
div.innerHTML += "<br/>suma('5', '3') = " 
        + suma('5', '3');

// Para hacer una especie clase, sólo creamos una función constructora
function Bebida(tipo, cant, prop) {
    this.tipo = tipo;
    this.cantidad = cant;
    this.propiedades = prop;
    this.mostrar = function () {
        div.innerHTML += "<p>Bebida: " 
            + this.tipo + ", " + this.cantidad
            + ", " + this.propiedades + "</p>";
    }
}
var zumo = new Bebida("zumo de naranja", "1 L", "Vitamina C");
zumo["propiedades"] += ", y es de color naranja";
zumo.mostrar();