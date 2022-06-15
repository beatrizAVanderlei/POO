package gui.controladores.administrador;

import excecoes.PaisNaoExisteException;
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

public class TelaRemoverPaisController {

    @FXML
    private TextField textFieldPais;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverPaisController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void removerPais(ActionEvent event) {
        try {
            this.fachadaAdministrador.removerPais(textFieldPais.getText());
            labelErro.setText("Removido com sucesso!");

        } catch (PaisNaoExisteException pnee) {
            labelErro.setText("O país a ser removido não está no repositório!");

        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarPaises.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarPaisesController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
