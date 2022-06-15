package dados.repositórios;

import excecoes.PrecoDaPassagemInvalidoException;
import negocio.entidades.Pais;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe que representa o repositório de países, implementa a interface IRepositorioDePaises e armazena os dados de forma
 * persistente em arquivos.dat. Esta classe lança as seguintes exceções relacionadas a manipulação de arquivos:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Gabriel Viana
 */
public class RepositorioDePaises implements IRepositorioDePaises {
    private ArrayList<Pais> paises;
    private static final String nomeDoArquivo = "repositorioDePaises.dat";

    public RepositorioDePaises() {
        this.paises = new ArrayList<>();

        try {
            lerArquivoDoRepositorio();

        } catch (FileNotFoundException fnde) {
            adicionarPaisDefault();

        } catch (EOFException eofe) {
            adicionarPaisDefault();

        } catch (IOException ioe) {
            adicionarPaisDefault();

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarPaisDefault() {
        try {
            Pais pais = new Pais("EUA", "Inglês", 2000);
            this.paises.add(pais);
        } catch (PrecoDaPassagemInvalidoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void adicionar(Pais pais) throws IOException {
        this.paises.add(pais);
        salvarRepositorioNoArquivo();
    }

    public void atualizar(Pais pais, Pais paisAtualizado) throws IOException {
        this.paises.set(this.paises.indexOf(pais), paisAtualizado);
        salvarRepositorioNoArquivo();
    }

    public ArrayList<Pais> recuperar() {
        return paises;
    }

    public void remover(Pais pais) throws IOException {
        this.paises.remove(pais);
        salvarRepositorioNoArquivo();
    }

    public boolean existe(Pais pais) {
        if (this.paises.contains(pais)) {
            return true;
        } else {
            return false;
        }
    }

    public Pais consultarPais(String nome) {
        Pais pais = null;

        for (Pais p : this.paises) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                pais = p;
                break;
            }
        }

        return pais;
    }

    public ArrayList<String> consultarIdiomaDosPaises() {
        ArrayList<String> idiomas = new ArrayList<>();

        for (Pais p : this.paises) {
            if (!idiomas.contains(p.getIdiomaOficial())) {
                idiomas.add(p.getIdiomaOficial());
            }
        }

        return idiomas;
    }

    public ArrayList<Pais> procurarPaisPeloIdioma(String idioma) {
        ArrayList<Pais> paises = new ArrayList<>();

        for (Pais p : this.paises) {
            if (p.getIdiomaOficial().equalsIgnoreCase(idioma)) {
                paises.add(p);
            }
        }

        return paises;
    }

    private void lerArquivoDoRepositorio() throws FileNotFoundException, EOFException, IOException, ClassNotFoundException{
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.paises = (ArrayList<Pais>) inputStream.readObject();
        inputStream.close();
    }

    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.paises);
        outputStream.close();
    }

}
