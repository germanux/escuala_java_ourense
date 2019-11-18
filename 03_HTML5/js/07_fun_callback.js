// Todo son funciones callbcaks o de retrollamada

// Nomenclatura típica de function en variable
let suma = function(x, y) { 
    return x + y; 
}
// Nomenclatura típica de function
function multiplica(x, y) {
    return x * y;
}
// Nomenclatura de objeto Function
let divide = new Function("x", "y", "return x / y;");

// Nomenclatura de función flecha
let resta = (x, y) => {
    return x - y;
}
function hacerPunto(x, y) {
    // Usando templates strings de ES6
    return `( ${x} , ${y} )`;
}