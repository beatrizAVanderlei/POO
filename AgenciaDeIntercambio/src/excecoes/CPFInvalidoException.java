package excecoes;

public class CPFInvalidoException extends Exception {
    public CPFInvalidoException(){
        super("O CPF registrado é inválido");
    }

}
