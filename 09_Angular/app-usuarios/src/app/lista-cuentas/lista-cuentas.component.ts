import { Component, OnInit } from '@angular/core';
import { CuentaBanc } from '../modelo/CuentaBanc';
import { CuentasRestService } from '../cuentas-rest.service';

@Component({
  selector: 'app-lista-cuentas',
  templateUrl: './lista-cuentas.component.html',
  styleUrls: ['./lista-cuentas.component.css']
})
export class ListaCuentasComponent implements OnInit {

  arrayCuentas : CuentaBanc[];
  cuentaEditar: CuentaBanc = null;

  constructor(private srvCuentas : CuentasRestService) { 
    this.srvCuentas.alCambiar = () => {
      this.ngOnInit();
    };
  }

  ngOnInit() {
    this.arrayCuentas = [];
    this.srvCuentas.traerTodos().subscribe((cuentasTraidas: CuentaBanc[]) => {
        this.arrayCuentas = cuentasTraidas;
        console.log("Respuesta AJAX: " + cuentasTraidas.toString());
    });
    console.log(">>> LLamada asincrona AJAX realizada");
  }
  eliminar(id: Number) {
    this.srvCuentas.eliminar(id);
  }
  prepararModificar(cuentaModif: CuentaBanc) {
    this.cuentaEditar = cuentaModif;
  }
  modificar(id: Number, cuentaMod: CuentaBanc) {
    this.srvCuentas.modificar(id, cuentaMod, (c) => {
      console.log("Modificado: " + c.toString());
      this.cuentaEditar = null;
    });
  }
}
