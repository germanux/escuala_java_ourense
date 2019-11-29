
export class CuentaBanc {

    constructor(
        private id: number,
        private iban: string,
        private dni: string ) 
    {  }

    public toString(): string {
        return `Cuenta: ${this.id}
        IBAN: ${this.iban}
        DNI: ${this.dni}`;
    }
}