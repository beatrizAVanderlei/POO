package negocio.entidades;
import excecoes.*;
import java.io.Serializable;

/** Essa classe representa todos os dados que uma escola vinculada a agência deve receber.
 * A escola deve estar vinculada a uma cidade(Cidade), um endereço(String), um nome(String),
 * uma quantidade de alunos máxima(int), uma quantidade de alunos intercambistas já matriculados(int),
 * um e-mail para contato(String) e uma mensalidade(double).
 * Essa classe pode lançar a exceção EscolaLotadaException.
 * Essa classe pode lançar a exceção EscolaVaziaException.
 * Essa classe pode lançar a exceção MensalidadeInvalidaException.
 * Essa classe pode lançar a exceção NomeInvalidoException.
 * Essa classe pode lançar a exceção EmailInvalidoException.
 * Essa classe pode lançar a exceção EnderecoInvalidoException.
 * Essa classe pode lançar a exceção QuantidadeDeAlunosInválidaException.
 * @author Ana Beatriz Almeida.
 */

public class Escolas implements Serializable {
    private Cidade cidade;
    private String endereco;
    private String nome;
    private String email;
    private int quantidadeDeAlunosMaxima;
    private int quantidadeDeAlunosAtual;
    private double mensalidade;

    public Escolas (Cidade cidade, String email, String endereco, String nome, int alunos, double mensalidade) throws MensalidadeInvalidaException, EmailInvalidoException, EnderecoInvalidoException, NomeInvalidoException, QuantidadeDeAlunosInvalidaException {
        this.quantidadeDeAlunosAtual = 0;
        this.cidade = cidade;

        if(nome.length() > 5)
            this.nome = nome;
        else
            throw new NomeInvalidoException();

        if(endereco.length() > 10)
            this.endereco = endereco;
        else
            throw new EnderecoInvalidoException();

        if(alunos > 0)
            this.quantidadeDeAlunosMaxima = alunos;
        else
            throw new QuantidadeDeAlunosInvalidaException();

        if (mensalidade > 0.0)
            this.mensalidade = mensalidade;
        else
            throw new MensalidadeInvalidaException();

        if(email.length() > 20)
            this.email = email;
        else
            throw new EmailInvalidoException();
    }

    /**
     * O método adicionarAlunos serve para controlar a quantidade de alunos intercambistas que uma
     * escola deseja recepcionar, a cada vez que alguém se matricula nela, adiciona-se uma unidade
     * em quantidadeDeAlunosAtual.
     * @throws EscolaLotadaException
     * @author Ana Beatriz Almeida
     */

    public void adicionarAlunos() throws EscolaLotadaException {
        if(quantidadeDeAlunosAtual <= quantidadeDeAlunosMaxima)
            quantidadeDeAlunosAtual++;
        else
            throw new EscolaLotadaException();
    }

    /**
     * O método removerAluno serve para controlar a quantidade de alunos intercambistas que sairam
     * da escola, removendo uma unidade cada vez que alguém concluí aquele período em quantidadeDeAlunosAtual.
     * @throws EscolaVaziaException
     * @author Ana Beatriz Almeida
     */

    public void removerAluno() throws EscolaVaziaException{
        if(quantidadeDeAlunosAtual >= 0)
            quantidadeDeAlunosAtual--;
        else
            throw new EscolaVaziaException();
    }

    public String getNome(){ return this.nome; }

    public Cidade getCidade(){ return this.cidade; }

    public String getEndereco(){ return this.endereco; }

    public int getQuantidadeDeAlunosAtual(){ return this.quantidadeDeAlunosAtual; }

    public String getEmail(){ return this.email; }

    public void setNome(String nome) throws NomeInvalidoException{
        if(nome.length() > 5)
            this.nome = nome;
        else
            throw new NomeInvalidoException();
    }

    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) throws EnderecoInvalidoException{
        if(endereco.length() > 10)
            this.endereco = endereco;
        else
            throw new EnderecoInvalidoException();

    }

    public void setEmail(String email) throws EmailInvalidoException{
        if(email.length() > 20)
            this.email = email;
        else
            throw new EmailInvalidoException();
    }

    public int getQuantidadeDeAlunosMaxima(){ return this.quantidadeDeAlunosMaxima; }

    public void setQuantidadeDeAlunosMaxima(int alunos) throws QuantidadeDeAlunosInvalidaException{
        if(alunos > 0)
            this.quantidadeDeAlunosMaxima = alunos;
        else
            throw new QuantidadeDeAlunosInvalidaException();
    }

    public double getMensalidade(){
        return this.mensalidade;
    }

    public void setMensalidade(double mensalidade) throws MensalidadeInvalidaException{
        if (mensalidade > 0.0)
            this.mensalidade = mensalidade;
        else
            throw new MensalidadeInvalidaException();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Escolas){
            Escolas escolas = (Escolas) obj;
            return this.getEndereco().equals(escolas.getEndereco()) & this.getCidade().equals(escolas.getCidade());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Qtd. atual de alunos: %d - Qtd. máx. de alunos: %d - Mensalidade: R$ %.2f",
                this.nome, this.quantidadeDeAlunosAtual, this.quantidadeDeAlunosMaxima, this.mensalidade);
    }

}
