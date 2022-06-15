package negocio.entidades;

import excecoes.HospedagemLotadaException;
import excecoes.MensalidadeInvalidaException;

import java.io.Serializable;

/**
 * Esta classe representa uma hospedagem na qual o intercambista pode se hospedar. Ela é uma superclasse, visto que as hospedagens
 * que um intercambista pode ficar é uma república ou uma host family, assim, ambas as subclasses compartilham atributos comuns
 * (p.e. quantidade atual de pessoas), por isso a criação da superclasse Hospedagem. A superclasse também é abstrata,
 * pois não faz sentindo criar um objeto hospedagem sem espicificar o que ele realmente é, uma república ou uma host family.
 * Uma hospedagem possui um id (String), uma cidade (classe Cidade), a quantidade máx. de pessoas (int), a quantidade atual
 * de pessoas (int) e a mensalidade (double). E esta classe pode lançar a exceção MensalidadeInvalidaException, se a mensalidade assumir
 * valor menor ou igual a zero.
 *
 * @author Gabriel Viana
 */
public abstract class Hospedagem implements Serializable {
    private final String id;
    private Cidade cidade;
    protected int quantidadeAtualDePessoas;
    private int quantidadeMaxDePessoas;
    private double mensalidade;

    public Hospedagem(String id, Cidade cidade, int quantidadeAtualDePessoas, int quantidadeMaxDePessoas, double mensalidade) throws MensalidadeInvalidaException {
        this.id = id;
        this.cidade = cidade;
        this.quantidadeAtualDePessoas = quantidadeAtualDePessoas;
        this.quantidadeMaxDePessoas = quantidadeMaxDePessoas;
        if (mensalidade > 0) {
            this.mensalidade = mensalidade;
        } else {
            throw new MensalidadeInvalidaException();
        }
    }

    public String getId() {
        return id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getQuantidadeAtualDePessoas() {
        return quantidadeAtualDePessoas;
    }

    public int getQuantidadeMaxDePessoas() {
        return quantidadeMaxDePessoas;
    }

    public void setQuantidadeMaxDePessoas(int quantidadeMaxDePessoas) {
        this.quantidadeMaxDePessoas = quantidadeMaxDePessoas;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) throws MensalidadeInvalidaException {
        if (mensalidade > 0) {
            this.mensalidade = mensalidade;
        } else {
            throw new MensalidadeInvalidaException();
        }
    }

    public void adicionarPessoa() throws HospedagemLotadaException{
        if (this.quantidadeAtualDePessoas < this.quantidadeMaxDePessoas) {
            this.quantidadeAtualDePessoas++;

        } else {
            throw new HospedagemLotadaException();
        }
    }

    /**
     * O método removerPessoa é abstrado pois as subclasses Republica e HostFamily removem pessoas de um jeito diferente entre elas.
     * Como o método é abstrato, possibilita a ocorrência de polimorfismo. Já que ambas as subclasses dessa hierarquia implementam
     * este método de forma diferente.
     */
    public abstract void removerPessoa();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hospedagem) {
            Hospedagem hospedagem = (Hospedagem) obj;

            return this.getId().equals(hospedagem.getId());
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("ID: %s - Cidade: %s - Mensalidade: R$ %.2f - Qtd. atual de pessoas: %d - Qtd. máx. de pessoas: %d",
                this.id, this.cidade.getNome(), this.mensalidade, this.quantidadeAtualDePessoas, this.quantidadeMaxDePessoas);
    }
}
