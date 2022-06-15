package excecoesData;

public class DataInvalidaException extends Exception{
    public DataInvalidaException(){
        super("A data inserida é inválida");
    }
}
