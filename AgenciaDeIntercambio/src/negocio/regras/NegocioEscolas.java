package negocio.regras;
import excecoes.CidadeNaoExisteException;
import excecoes.EscolaJaAdicionadaException;
import excecoes.EscolaNaoExisteException;
import negocio.entidades.Cidade;
import negocio.entidades.Escolas;
import dados.repositórios.IRepositorioDeEscolas;
import java.io.IOException;
import java.util.ArrayList;

public class NegocioEscolas {
    private IRepositorioDeEscolas repositorio;

    public NegocioEscolas(IRepositorioDeEscolas repositorioDeEscolas){
        this.repositorio = repositorioDeEscolas;
    }

    public void adicionar(Escolas escola) throws EscolaJaAdicionadaException, IOException{
        if(!this.repositorio.existe(escola))
            this.repositorio.adicionarEscola(escola);
        else
            throw new EscolaJaAdicionadaException(escola);
    }

    public void remover(Escolas escola) throws EscolaNaoExisteException, IOException{
        if(this.repositorio.existe(escola))
            this.repositorio.removerEscola(escola);
        else
            throw new EscolaNaoExisteException();
    }

    public void atualizar(Escolas escola, Escolas escolaAtualizada) throws EscolaNaoExisteException, IOException {
        if(this.repositorio.existe(escola))
            this.repositorio.atualizarEscola(escola, escolaAtualizada);
        else
            throw new EscolaNaoExisteException();
    }

    public ArrayList<Escolas> recuperar(){
        return this.repositorio.recuperar();
    }

    public ArrayList<Escolas> procurarEscolaPelaCidade(String cidade) throws CidadeNaoExisteException {
        if (this.repositorio.procurarEscolaPelaCidade(cidade).size() == 0) {
            throw new CidadeNaoExisteException();
        } else {
            return this.repositorio.procurarEscolaPelaCidade(cidade);
        }
    }

    public Escolas consultarEscola(String nome) throws EscolaNaoExisteException{
        Escolas escola = this.repositorio.consultarEscola(nome);

        if(escola == null)
            throw new EscolaNaoExisteException();
        else
            return escola;
    }

}
