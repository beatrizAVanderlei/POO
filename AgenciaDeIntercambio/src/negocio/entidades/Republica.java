package negocio.entidades;

import excecoes.MensalidadeInvalidaException;

/**
 * Esta classe representa uma república na qual o intercambista pode se hospedar.
 * Ela faz parte da hierarquia da classe Hospedagem, sendo assim, uma subclasse de Hospedagem.
 * Esta classe pode lançar a exceção MensalidadeInvalidaException (lançada na superclasse).
 *
 * @author Gabriel Viana
 */
public class Republica extends Hospedagem {

    public Republica(String id, Cidade cidade, int quantidadeAtualDePessoas, int quantidadeMaxDePessoas, double mensalidade) throws MensalidadeInvalidaException {
        super(id, cidade, quantidadeAtualDePessoas, quantidadeMaxDePessoas, mensalidade);
    }

    /**
     * O método removerPessoa de Repiblica pode remover pessoas enquanto tiver pessoas na república.
     */
    @Override
    public void removerPessoa() {
        if (this.getQuantidadeAtualDePessoas() > 0) {
            this.quantidadeAtualDePessoas--;
        }
    }
}
