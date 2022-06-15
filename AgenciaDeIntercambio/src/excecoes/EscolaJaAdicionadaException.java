package excecoes;
import negocio.entidades.Escolas;

public class EscolaJaAdicionadaException extends Exception{
    public EscolaJaAdicionadaException(Escolas escola){
        super("A escola "+escola.getNome()+" já foi adicionada");
    }
}
