public class Conta{
    String numero;
    double saldo;
    Contador contador;
    double taxa;

    Conta(String n, double s){
        this.numero = n;
        this.saldo = s;
        this.contador = new Contador();
        this.taxa = 2.00;
    }

    public double consultarSaldo(){
        return this.saldo;
    }
    void creditar(double credito){
        this.saldo = this.saldo + credito;
    }
    void debitar(double debito){
        if (debito <= this.saldo){
            this.saldo = this.saldo - debito;
        }
    }

    void transferencia(Conta destino, double valor) {
        if (this.saldo > valor) {
            this.saldo = this.saldo - valor;
            destino.saldo = destino.saldo + valor;
            contador.incrementar();

            if(contador.consultar() % 5 == 0){
                if (this.saldo > this.taxa){
                    this.saldo = this.saldo - this.taxa;
                }
                else{
                    this.taxa = this.taxa + 1;
                }
            }

        }
    }
}
