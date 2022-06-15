package gui.controladores.administrador;

import excecoes.HospedagemNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaRemoverHospedagemController implements Initializable {

    @FXML
    private TextField textFieldHospedagem;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverHospedagemController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void removerHospedagem(ActionEvent event) {
        String id = textFieldHospedagem.getText();

        try {
            this.fachadaAdministrador.removerHospedagem(id);
            this.labelErro.setText("Removido com sucesso");
        } catch (HospedagemNaoExisteException hnee) {
            labelErro.setText("A hospedagem a ser removida não está no repositório!");
        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarHospedagens.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarHospedagensController) fxmlLoader.getController()).setStage(stage);

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
