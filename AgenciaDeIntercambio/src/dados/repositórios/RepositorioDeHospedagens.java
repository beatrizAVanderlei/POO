package dados.repositórios;

import excecoes.MensalidadeInvalidaException;
import excecoes.PrecoDaPassagemInvalidoException;
import negocio.entidades.Cidade;
import negocio.entidades.Hospedagem;
import negocio.entidades.Pais;
import negocio.entidades.Republica;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe que representa o repositório de hospedagens, implementa a interface IRepositorioDeHospedagens e armazena os dados
 * de forma persistente em arquivos.dat. Esta classe lança as seguintes exceções relacionadas a manipulação de arquivos:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Gabriel Viana
 */
public class RepositorioDeHospedagens implements IRepositorioDeHospedagens {
    private ArrayList<Hospedagem> hospedagens;
    private static final String nomeDoArquivo = "repositorioDeHospedagens.dat";

    public RepositorioDeHospedagens() {
        this.hospedagens = new ArrayList<>();
        try {
            lerArquivoDoRepositorio();

        } catch (FileNotFoundException fnde) {
            adicionarHospedagemDefault();

        } catch (EOFException eofe) {
            adicionarHospedagemDefault();

        } catch (IOException ioe) {
            adicionarHospedagemDefault();

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarHospedagemDefault() {
        try {
            Pais pais = new Pais("EUA", "Inglês", 2000);
            Cidade cidade = new Cidade(pais, "New York");
            Hospedagem hospedagem = new Republica("123", cidade, 0, 100, 150);
            this.hospedagens.add(hospedagem);
        } catch (PrecoDaPassagemInvalidoException | MensalidadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
    }

    public void adicionar(Hospedagem hospedagem) throws IOException {
        this.hospedagens.add(hospedagem);
        salvarRepositorioNoArquivo();
    }

    public void atualizar(Hospedagem hospedagem, Hospedagem hospedagemAtualizada) throws IOException {
        this.hospedagens.set(this.hospedagens.indexOf(hospedagem), hospedagemAtualizada);
        salvarRepositorioNoArquivo();
    }

    public ArrayList<Hospedagem> recuperar() {
        return hospedagens;
    }

    public void remover(Hospedagem hospedagem) throws IOException {
        this.hospedagens.remove(hospedagem);
        salvarRepositorioNoArquivo();
    }

    public boolean existe(Hospedagem hospedagem) {
        if (this.hospedagens.contains(hospedagem)) {
            return true;
        } else {
            return false;
        }
    }

    public Hospedagem consultarHospedagem(String id) {
        Hospedagem hospedagem = null;

        for (Hospedagem h : this.hospedagens) {
            if (h.getId().equals(id)) {
                hospedagem = h;
                break;
            }
        }

        return hospedagem;
    }

    public ArrayList<Hospedagem> procurarHospedagensPelaCidade(Cidade cidade) {
        ArrayList<Hospedagem> hospedagens = new ArrayList<>();

        for (Hospedagem h : this.hospedagens) {
            if (h.getCidade().equals(cidade)) {
                hospedagens.add(h);
            }
        }

        return hospedagens;
    }

    private void lerArquivoDoRepositorio() throws FileNotFoundException, EOFException, IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.hospedagens = (ArrayList<Hospedagem>) inputStream.readObject();
        inputStream.close();
    }

    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.hospedagens);
        outputStream.close();
    }

}
