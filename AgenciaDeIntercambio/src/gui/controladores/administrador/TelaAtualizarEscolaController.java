package gui.controladores.administrador;

import excecoes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.entidades.Cidade;
import negocio.entidades.Escolas;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAtualizarEscolaController implements Initializable {
    @FXML
    private TextField textFieldNomeAntigo;
    @FXML
    private TextField textFieldNomeNovo;
    @FXML
    private TextField textFieldMensalidade;
    @FXML
    private TextField textFieldAlunos;
    @FXML
    private TextField textFieldNomeCidade;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldEndereco;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAtualizarEscolaController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarEscolas.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarEscolasController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void salvar(ActionEvent actionEvent){
        String nomeAntigo;
        String nomeNovo;
        String cidade;
        String endereco;
        String email;
        int alunos;
        double mensalidade;
        try{
            nomeAntigo = textFieldNomeAntigo.getText();
            nomeNovo = textFieldNomeNovo.getText();
            cidade = textFieldNomeCidade.getText();
            endereco = textFieldEndereco.getText();
            email = textFieldEmail.getText();
            alunos = Integer.parseInt(textFieldAlunos.getText());
            mensalidade = Double.parseDouble(textFieldMensalidade.getText());
            Escolas e = fachadaAdministrador.consultarEscola(nomeAntigo);
            Cidade c = fachadaAdministrador.consultarCidade(cidade);
            fachadaAdministrador.atualizarEscola(e, c, email, endereco, nomeNovo, alunos, mensalidade);
            labelErro.setText("Escola atualizada com sucesso");
        } catch (CidadeNaoExisteException e) {
            labelErro.setText("A cidade selecionada não existe");
        } catch (MensalidadeInvalidaException e) {
            labelErro.setText("Mensalidade inválida");
        } catch (EmailInvalidoException e) {
            labelErro.setText("Email inválido");
        } catch (NomeInvalidoException e) {
            labelErro.setText("Nome inválido");
        } catch (EscolaNaoExisteException e) {
            labelErro.setText("A escola selecionada não existe");
        } catch (EnderecoInvalidoException e) {
            labelErro.setText("O endereço é inválido");
        } catch (QuantidadeDeAlunosInvalidaException e) {
            labelErro.setText("A quantidade de alunos é inválida");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar arquivo");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
