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

  // nuevaCuenta va sin ID
  public add(nuevaCuenta: CuentaBanc, lambda: any) : Observable<CuentaBanc>
   {  
      let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest, 
      nuevaCuenta, this.httpOptions);
      observable.subscribe((datos) => { // Datos el la cuenta con el ID
        this.alCambiar(datos);   // Probablemente actualiza la lista
        lambda(datos);           // Invoca a la suscripción del componente nuevo
      });
    return observable;
  }
  // nuevaCuenta va sin ID
  public modificar(id: Number, nuevaCuenta: CuentaBanc, lambda: any) : Observable<CuentaBanc>
   {  
    let urlPeticionDelete = `${this.urlApiRest}/${id}`;
      let observable: Observable<CuentaBanc> = this.httpCli.put<CuentaBanc>(
        urlPeticionDelete, 
        nuevaCuenta, this.httpOptions);
        observable.subscribe((datos) => { // Datos el la cuenta con el ID
          this.alCambiar(datos);   // Probablemente actualiza la lista
          lambda(datos);           // Invoca a la suscripción del componente nuevo
      });
    return observable;
  }
  public traerTodos()  : Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }
  public eliminar(id: Number) {
    let urlPeticionDelete = `${this.urlApiRest}/${id}`;
    console.log(urlPeticionDelete);
    this.httpCli.delete( urlPeticionDelete, this.httpOptions)
        .subscribe((datos) => {
              this.alCambiar(datos);
              console.log("ELiminado " + id);
    });
  }
}
