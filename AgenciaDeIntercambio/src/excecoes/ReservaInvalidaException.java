package excecoes;

public class ReservaInvalidaException extends Exception{
    public ReservaInvalidaException(){
        super("A reserva selecionada é muito baixa");
    }
}
