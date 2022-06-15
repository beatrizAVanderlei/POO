package excecoes;

public class EscolaLotadaException extends Exception {
    public EscolaLotadaException(){
        super("Não é possível adicionar mais alunos pois a escola está lotada.");
    }
}
