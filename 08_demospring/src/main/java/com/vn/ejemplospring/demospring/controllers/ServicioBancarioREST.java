package com.vn.ejemplospring.demospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ejemplospring.demospring.modelo.CuentaBanc;
import com.vn.ejemplospring.demospring.modelo.CuentasDAOpanama;

@RestController
// CORS
public class ServicioBancarioREST {
	
	// Nosotros NO instanciamos,   lo hace Spring
	// Nosotros NO gestionamos la dependencia,  >>
	// Tampo asignamos el valor, 				>>
	// Esto es la inyección de dependencias
	@Autowired
	private CuentasDAOpanama repo;
	
	// Nos permite capturar varios médodos HTTP
	@RequestMapping(path = "/cuentas",  method = { RequestMethod.POST  /*, OTRO_METODO, ...*/} )
	// Sólo el método POST
	// @PostMapping
	public CuentaBanc crearCuentaAingenuo(@RequestBody CuentaBanc cuenta) {

		System.out.println(">>> CuentaBanc recibida !"
				+ cuenta.toString());
		return repo.save(cuenta);
	}
}




