// Notación JSON: JavaScript Object Notation
// Lo que se puede almacenar en XML, se puede convertir a JSON y viceversa
// Todo se puede almacenar como JSON

var unObjeto = { }; // new Object();
var otroObj = {
    "prop_1": "Propiedad uno",
    "prop_2": "Propiedad dos",
    'prop_3': 'Propiedad tres',
    prop_4: "Propiedad cuatro",
    toString: function() { 
        return "Propiedades: " + this.prop_1 + "; " + this.prop_2 + "; "
                + this.prop_3 + "; " + this.prop_4 + "; " + this.prop_5;
    },
    toStringAll: function() { 
        var strProp = "Lista de propiedades: ";
        for (var i = 0; i < 20; i++ ) {
            if (typeof(this["prop_" + i]) !== "undefined" ) {
                strProp += this["prop_" + i] + "; ";
            }
        }
        return strProp;
    },
    toStringTodasVariablesMiembro: function() {
        var strProp = "Lista de TODAS las propiedades: ";
        for (key in this) {
            strProp += this[key] + "; ";
        }
        return strProp;
    },
    toStringAllProp: function() {
        var strProp = "Lista de TODAS las propiedades: ";
        for (key in this) {
            if (key.indexOf("prop_") >= 0)
                strProp += this[key] + "; ";
        }
        return strProp;
    },
    toStringAllZaira: function() { 
        var strProp = "Lista de propiedades modo Zaira: ";
        var largo = Object.keys(this).length;
        var j = 1;
        for (var i = 0; i < largo; i++ ) {
            /* if (Object.keys(this)[i].indexOf("toString") >=0 ) {
                j++;
            } *//*
            if ( Object.keys(this)[i].indexOf("prop_") >=0 ) {
                strProp += Object.values(this)[i] + "; ";*/
 /**/       var largoNum = Object.keys(this)[i].length;
            var numProp = Object.keys(this)[i].substr(5, largoNum);
            if (Object.keys(this)[i] == "prop_" + numProp) {
                strProp += Object.values(this)[i] + "; "; /* */
            }
        }
        return strProp;
    }
}
otroObj.prop_5 = "Propiedad cinco";
otroObj.prop_19 = "Propiedad dieci-nueve";
var divTris = document.getElementById("contenido_tris");
divTris.innerHTML += otroObj.toString();
divTris.innerHTML += "<br/>" + otroObj.toStringAll();
divTris.innerHTML += "<br/>" + otroObj.toStringTodasVariablesMiembro();
divTris.innerHTML += "<br/>" + otroObj.toStringAllProp();
divTris.innerHTML += "<br/>" + otroObj.toStringAllZaira();
