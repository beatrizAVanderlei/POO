package excecoes;

public class EscolaVaziaException extends Exception{
    public EscolaVaziaException(){
        super("A escola está vazia");
    }
}

