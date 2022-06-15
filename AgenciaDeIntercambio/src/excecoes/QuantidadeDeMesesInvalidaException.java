package excecoes;

public class QuantidadeDeMesesInvalidaException extends Exception{
    public QuantidadeDeMesesInvalidaException(){
        super("A quantidade de tempo selecionado para o intercambido  é insuficiente.");
    }
}
