package gui.controladores.administrador;

import excecoes.CidadeNaoExisteException;
import excecoes.GeneroInvalidoException;
import excecoes.HospedagemJaAdicionadaException;
import excecoes.MensalidadeInvalidaException;
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

public class TelaAdicionarHFamilyController implements Initializable {

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

    public TelaAdicionarHFamilyController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void adicionarHFamily(ActionEvent event) {
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
            this.fachadaAdministrador.adicionarHospedagem(hospedagem);
            labelErro.setText("Adicionado com sucesso!");

        } catch (NumberFormatException nfe) {
            labelErro.setText("Digite apenas n??mero nos campos de quantidade de pessoas e mensalidade!");
        } catch (CidadeNaoExisteException cnee) {
            labelErro.setText("A cidade n??o est?? no reposit??rio!");
        } catch (MensalidadeInvalidaException mie) {
            labelErro.setText("Valor de mensalidade inv??lido!");
        } catch (GeneroInvalidoException gie) {
            labelErro.setText("G??nero inv??lido!");
        } catch (HospedagemJaAdicionadaException hjae) {
            labelErro.setText("Essa hospedagem j?? foi adicionada no reposit??rio!");
        } catch (IOException ioe) {
            labelErro.setText("Erro na grava????o do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAdicionarHFamilyOuRepublica.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAdicionarHFamilyOuRepublicaController) fxmlLoader.getController()).setStage(stage);

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
