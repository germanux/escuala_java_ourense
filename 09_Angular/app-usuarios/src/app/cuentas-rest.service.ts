import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

// Objeto que Angular se encarga de instaciar como un Singleton
@Injectable({     
  providedIn: 'root'
})
export class CuentasRestService {

  // Infiere / deduce a partir del valor ("" es String)
  urlApiRest = "http://127.0.0.1:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  alCambiar: any;

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc) : Observable<CuentaBanc>
   {
      let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest, 
      nuevaCuenta, this.httpOptions);
      observable.subscribe(this.alCambiar);
    return observable;
  }
  public traerTodos()  : Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }
}
