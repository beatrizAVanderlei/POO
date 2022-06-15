package excecoes;
import negocio.entidades.Escolas;

public class EscolaNaoExisteException extends Exception{
    public EscolaNaoExisteException(){
        super("A escola não existe nos registros");
    }
}
