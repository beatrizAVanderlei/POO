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
import negocio.entidades.Hospedagem;
import negocio.entidades.HostFamily;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAtualizarHFamilyController implements Initializable {

    @FXML
    private TextField textFieldIdAntigo;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldCidade;
    @FXML
    private TextField textFieldQtdAtualPessoas;
    @FXML
    private TextField textFieldQtdMaxPessoas;
    @FXML
    private TextField textFieldMensalidade;
    @FXML
    private TextField textFieldMembros;
    @FXML
    private TextField textFieldTemPai;
    @FXML
    private TextField textFieldTemMae;
    @FXML
    private TextField textFieldGenero;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAtualizarHFamilyController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void atualizarHFamily(ActionEvent event) {
        String idAntigo = textFieldIdAntigo.getText();
        String id = textFieldId.getText();
        String nomeCidade = textFieldCidade.getText();
        String genero = textFieldGenero.getText();
        boolean temPai;
        boolean temMae;
        int qtdAtualPessoas;
        int qtdMaxPessoas;
        int qtdMembros;
        double mensalidade;
        try {
            qtdAtualPessoas = Integer.parseInt(textFieldQtdAtualPessoas.getText());
            qtdMaxPessoas = Integer.parseInt(textFieldQtdMaxPessoas.getText());
            qtdMembros = Integer.parseInt(textFieldMembros.getText());
            mensalidade = Double.parseDouble(textFieldMensalidade.getText());
            Cidade cidade = fachadaAdministrador.consultarCidade(nomeCidade);

            if (textFieldTemPai.getText().equalsIgnoreCase("sim")) {
                temPai = true;
            } else {
                temPai = false;
            }

            if (textFieldTemMae.getText().equalsIgnoreCase("sim")) {
                temMae = true;
            } else {
                temMae = false;
            }

            Hospedagem hospedagem = new HostFamily(id, cidade, qtdAtualPessoas, qtdMaxPessoas, mensalidade, qtdMembros, temPai, temMae, genero);
            this.fachadaAdministrador.atualizarHospedagem(idAntigo, hospedagem);
            labelErro.setText("Atualizado com sucesso!");

        } catch (NumberFormatException nfe) {
            labelErro.setText("Digite apenas número nos campos de quantidade de pessoas e mensalidade!");
        } catch (CidadeNaoExisteException cnee) {
            labelErro.setText("A cidade não está no repositório!");
        } catch (MensalidadeInvalidaException mie) {
            labelErro.setText("Valor de mensalidade inválido!");
        } catch (GeneroInvalidoException gie) {
            labelErro.setText("Gênero inválido!");
        } catch (HospedagemNaoExisteException hnee) {
            labelErro.setText("A hospedagem a ser atualizada não está no repositório!");
        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAtualizarHFamilyOuRepublica.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAtualizarHFamilyOuRepublicaController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
