package dados.repositórios;

import excecoes.PrecoDaPassagemInvalidoException;
import negocio.entidades.Cidade;
import negocio.entidades.Pais;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe que representa o repositório de cidades, implementa a interface IRepositorioDeCidades e armazena os dados de
 * forma persistente em arquivos.dat. Esta classe lança as seguintes exceções relacionadas a manipulação de arquivos:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Gabriel Viana
 */
public class RepositorioDeCidades implements IRepositorioDeCidades {
    private ArrayList<Cidade> cidades;
    private static final String nomeDoArquivo = "repositorioDeCidades.dat";

    public RepositorioDeCidades() {
        this.cidades = new ArrayList<>();
        try {
            lerArquivoDoRepositorio();

        } catch (FileNotFoundException fnde) {
            adicionarCidadeDefault();

        } catch (EOFException eofe) {
            adicionarCidadeDefault();

        } catch (IOException ioe) {
            adicionarCidadeDefault();

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarCidadeDefault() {
        try {
            Pais pais = new Pais("EUA", "Inglês", 2000);
            Cidade cidade = new Cidade(pais, "New York");
            this.cidades.add(cidade);
        } catch (PrecoDaPassagemInvalidoException e) {
            System.err.println(e.getMessage());
        }

    }

    public void adicionar(Cidade cidade) throws IOException {
        this.cidades.add(cidade);
        salvarRepositorioNoArquivo();
    }

    public void atualizar(Cidade cidade, Cidade cidadeAtualizada) throws IOException {
        this.cidades.set(this.cidades.indexOf(cidade), cidadeAtualizada);
        salvarRepositorioNoArquivo();
    }

    public ArrayList<Cidade> recuperar() {
        return cidades;
    }

    public void remover(Cidade cidade) throws IOException {
        this.cidades.remove(cidade);
        salvarRepositorioNoArquivo();
    }

    public boolean existe(Cidade cidade) {
        if (this.cidades.contains(cidade)) {
            return true;
        } else {
            return false;
        }
    }

    public Cidade consultarCidade(String nome) {
        Cidade cidade = null;

        for (Cidade c : this.cidades) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cidade = c;
                break;
            }
        }

        return cidade;
    }

    public ArrayList<Cidade> procurarCidadesPeloPais(Pais pais) {
        ArrayList<Cidade> cidades = new ArrayList<>();

        for (Cidade c : this.cidades) {
            if (c.getPais().equals(pais)) {
                cidades.add(c);
            }
        }

        return cidades;
    }

    private void lerArquivoDoRepositorio() throws FileNotFoundException, EOFException, IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.cidades = (ArrayList<Cidade>) inputStream.readObject();
        inputStream.close();
    }

    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.cidades);
        outputStream.close();
    }
}
