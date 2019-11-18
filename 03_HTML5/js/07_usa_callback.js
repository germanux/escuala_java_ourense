function operarArrays(arrX, arrY, operaCllbk) {
    // Comprobamos que el tamaño de los arrays son el mismo
    if (arrX.length == arrY.length ) {
        // Declaramos un array con la palabra var: ámbito es de función.
        // A diferencia de let de ES6, que sí es ámbito a nivel de bloque.
        var arrayResult = new Array(arrX.length);  // Una manera de crear array 
        for (let i = 0; i < arrX.length; i++) {
            arrayResult[i] = operaCllbk(arrX[i], arrY[i]);
        }
    }
    return arrayResult;
}
// Otros ejemplos array:
var arrayEjemplo = [];   // Otra manera con notación JSON. No indicamos
                        // el tamaño, por en realidad los arrays de JS
                        // son como los ArrayList<Object> de Java
                        // Incluso a un HashMap<Integer, Object>
arrayEjemplo.push("Primer elemento");
arrayEjemplo[10] = "lo que sea";