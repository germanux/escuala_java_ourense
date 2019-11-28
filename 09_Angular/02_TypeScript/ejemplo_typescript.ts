"use strict";
var lenguaje = "JavaScript";

let textoExtra: String = " con Tipado fuerte OPCIONAL";


console.log("TypeScript es " + lenguaje + textoExtra);

class UnaClase {
	
	constructor(private propiedad: String) {
	}
	public getPropiedad()  : String {
		return this.propiedad;
	}
}
let unObjeto: UnaClase = new UnaClase("Tiene POO");
textoExtra = 2000;

console.log("Y " + unObjeto.getPropiedad());







