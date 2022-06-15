package contas;

import java.util.Objects;

public abstract class Conta{
    private String numero;
    private double saldo;

    Conta(String n, double s){
        this.numero = n;
        this.saldo = s;
    }

    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
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

    void transferencia(Conta conta2, double valor) {
        if (this.saldo > valor) {
            this.saldo = this.saldo - valor;
            conta2.saldo = conta2.saldo + valor;
        }
    }

    public abstract String getCodigo();

    @Override
    public boolean equals(Object o) {
        if (o instanceof ClientePessoaFisica){
            ClientePessoaFisica c = (ClientePessoaFisica) o;
            return this.getCodigo().equals(c.getCodigo());
        }
        if (o instanceof ClientePessoaJuridica){
            ClientePessoaJuridica c = (ClientePessoaJuridica) o;
            return this.getCodigo().equals(c.getCodigo());
        }
        return false;
    }
}
