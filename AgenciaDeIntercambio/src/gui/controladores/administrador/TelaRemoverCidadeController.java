package gui.controladores.administrador;

import excecoes.CidadeNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;

public class TelaRemoverCidadeController {

    @FXML
    private TextField textFieldCidade;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverCidadeController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void removerCidade(ActionEvent event) {
        try {
            fachadaAdministrador.removerCidade(textFieldCidade.getText());
            labelErro.setText("Removido com sucesso!");

        } catch (CidadeNaoExisteException cnee) {
            labelErro.setText("A cidade a ser removida não existe!");
            
        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarCidades.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarCidadesController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
