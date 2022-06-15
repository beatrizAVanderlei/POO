package negocio.entidades;

import excecoes.MensalidadeInvalidaException;
import excecoes.GeneroInvalidoException;

/**
 * Esta classe representa uma host family na qual o intercambista pode se hospedar.
 * Ela faz parte da hierarquia da classe Hospedagem, sendo assim, uma subclasse de Hospedagem.
 * Uma host family possui alguns atributos adicionais, a quantidade de membros oficiais (int), se tem pai (boolean),
 * se tem mãe (boolean) e o genero do intercambista (char).
 * Esta classe pode lançar as exceções MensalidadeInvalidaException (lançada na superclasse) e GeneroInvalidoException,
 * se o genero for diferente de (M ou F).
 */

public class HostFamily extends Hospedagem {
    // esse atributo diz a quantidade pessoas que compõem a host family, sem contar os intercambistas.
    private int quantidadeDeMembrosOficial;
    private boolean temPai;
    private boolean temMae;
    // esse atributo é sobre o gênero do intercambista que a Host Family prefere (M - masc, F - fem).
    private char generoDoIntercambista;

    public HostFamily(String id, Cidade cidade, int quantidadeAtualDePessoas, int quantidadeMaxDePessoas, double mensalidade, int quantidadeDeMembrosOficial, boolean temPai, boolean temMae) throws MensalidadeInvalidaException {
        super(id, cidade, quantidadeAtualDePessoas, quantidadeMaxDePessoas, mensalidade);
        this.quantidadeDeMembrosOficial = quantidadeDeMembrosOficial;
        this.temPai = temPai;
        this.temMae = temMae;
    }

    public HostFamily(String id, Cidade cidade, int quantidadeAtualDePessoas, int quantidadeMaxDePessoas, double mensalidade, int quantidadeDeMembrosOficial, boolean temPai, boolean temMae, String generoDoIntercambista) throws MensalidadeInvalidaException, GeneroInvalidoException {
        this(id, cidade, quantidadeAtualDePessoas, quantidadeMaxDePessoas, mensalidade, quantidadeDeMembrosOficial, temPai, temMae);

        if ((generoDoIntercambista.toUpperCase().charAt(0) == 'M') || (generoDoIntercambista.toUpperCase().charAt(0) == 'F')) {
            this.generoDoIntercambista = generoDoIntercambista.toUpperCase().charAt(0);
        } else {
            throw new GeneroInvalidoException();
        }

    }

    public int getQuantidadeDeMembrosOficial() {
        return quantidadeDeMembrosOficial;
    }

    public void setQuantidadeDeMembrosOficial(int quantidadeDeMembrosOficial) {
        this.quantidadeDeMembrosOficial = quantidadeDeMembrosOficial;
    }

    public boolean isTemPai() {
        return temPai;
    }

    public void setTemPai(boolean temPai) {
        this.temPai = temPai;
    }

    public boolean isTemMae() {
        return temMae;
    }

    public void setTemMae(boolean temMae) {
        this.temMae = temMae;
    }

    public char getGeneroDoIntercambista() {
        return generoDoIntercambista;
    }

    public void setGeneroDoIntercambista(String generoDoIntercambista) throws GeneroInvalidoException {
        if ((generoDoIntercambista.toUpperCase().charAt(0) == 'M') || (generoDoIntercambista.toUpperCase().charAt(0) == 'F')) {
            this.generoDoIntercambista = generoDoIntercambista.toUpperCase().charAt(0);
        } else {
            throw new GeneroInvalidoException();
        }
    }

    /**
     * O método removerPessoa de HostFamily pode remover pessoas enquanto o número de pessoas da casa forem maior que o
     * número de membros oficiais, pois quando o número de pessoas forem iguais ao número de membros oficias, quer dizer
     * que não existem mais intercambistas nessa host family.
     */
    @Override
    public void removerPessoa() {
        if (this.getQuantidadeAtualDePessoas() > this.getQuantidadeDeMembrosOficial()) {
            this.quantidadeAtualDePessoas--;
        }
    }
}
