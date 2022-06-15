package excecoes;

public class QuantidadeDeAlunosInvalidaException extends Exception{
    public QuantidadeDeAlunosInvalidaException(){
        super("A quantidade de alunos é muito baixa");
    }
}
