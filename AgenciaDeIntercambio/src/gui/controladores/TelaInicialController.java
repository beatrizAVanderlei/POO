package gui.controladores;

import gui.controladores.administrador.TelaLoginAdministradorController;
import gui.controladores.funcionario.TelaLoginFuncionarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaInicialController implements Initializable {

    @FXML
    private Button buttonLoginAdm;
    @FXML
    private Button buttonLoginFunc;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    public void carregarTelaLoginAdm(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaLoginAdministrador.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaLoginAdministradorController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
    public void carregarTelaLoginFunc(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/funcionario/TelaLoginFuncionario.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaLoginFuncionarioController) fxmlLoader.getController()).setStage(stage);

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
