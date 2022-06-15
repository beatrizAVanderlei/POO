package negocio.entidades;

import excecoes.QuantidadeDeMesesInvalidaException;
import excecoes.ReservaInvalidaException;
import java.io.Serializable;

/**
 * Essa classe representa todos os dados que uma conta na agência deve estar associada.
 * Uma conta deve possuir uma hospedagem(Classe Hospedagem), um cliente vinculado a ela(Classe Cliente),
 * uma escola à qual o cliente estará matriculado(Classe Escola), uma cidade que ficará hospedado(Classe
 * Cidade) uma reserva financeira de emergência(int) e um tempo definido de intercâmbio(int).
 * Essa classe pode lançar a exceção ReservaInvalidaException.
 * Essa classe pode lançar a exceção QuantidadeDeMesesInvalidaException.
 * @author Ana Beatriz Almeida
 */

public class Conta implements ICustos, Serializable {
    private Hospedagem hospedagem;
    private Cliente cliente;
    private Escolas escola;
    private Cidade cidade;
    private double reservaEmergencia;
    private double quantidadeMeses;

    public Conta (Cidade cidade, Hospedagem hospedagem, Cliente cliente, Escolas escola, double reserva, double meses) throws QuantidadeDeMesesInvalidaException, ReservaInvalidaException {
        this.hospedagem = hospedagem;
        this.cliente = cliente;
        this.escola = escola;
        this.cidade = cidade;

        if(reserva >= 500)
            this.reservaEmergencia = reserva;
        else
            throw new ReservaInvalidaException();
        if(meses > 0)
            this.quantidadeMeses = meses;
        else
            throw new QuantidadeDeMesesInvalidaException();
    }

    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Escolas getEscola(){
        return escola;
    }
    public void setEscola(Escolas escola){
        this.escola = escola;
    }

    public double getReservaEmergencia(){
        return this.reservaEmergencia;
    }
    public void setReservaEmergencia(double reserva){
        this.reservaEmergencia = reserva;
    }

    public Cidade getCidade(){
        return this.cidade;
    }
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }

    public double getQuantidadeMeses(){
        return this.quantidadeMeses;
    }
    public void setQuantidadeMeses(double quantidadeDias){
        this.quantidadeMeses = quantidadeDias;
    }

    public Hospedagem getHospedagem(){
        return this.hospedagem;
    }
    public void setHospedagem(Hospedagem hospedagem){
        this.hospedagem = hospedagem;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Conta){
            Conta c = (Conta) obj;
            return this.cliente.equals(c.getCliente());
        }
        return false;
    }

    /** O método é herdado da interface Custo para poder calcular os gastos gerais do intercambista,
     * já que a classe Cliente recebe todas as informações referentes, como mensalidade da hospedagem,
     * mensalidade escolar, reserva de emergência etc.
     */

    @Override
    public double calcularCustos(){
        return (this.escola.getMensalidade()*this.getQuantidadeMeses()) + this.getReservaEmergencia() + this.cidade.getPais().getPrecoDaPassagemIdaVolta() + (this.getHospedagem().getMensalidade() * this.getQuantidadeMeses());
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s - Pais: %s - Cidade: %s - Escola: %s - Hospedagem: %s - Reserva: R$ %.2f - Meses: %.1f", this.cliente.getNomeCompleto(),
                this.cidade.getPais().getNome(), this.cidade.getNome(), this.escola.getNome(), this.hospedagem.getId(), this.reservaEmergencia, this.quantidadeMeses);
    }
}

