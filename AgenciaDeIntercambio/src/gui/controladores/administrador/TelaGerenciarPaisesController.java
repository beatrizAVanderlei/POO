package gui.controladores.administrador;

import gui.controladores.Main;
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

public class TelaGerenciarPaisesController implements Initializable {

    @FXML
    private Button buttonAdicionarPais;
    @FXML
    private Button buttonAtualizarPais;
    @FXML
    private Button buttonRemoverPais;
    @FXML
    private Button buttonConsultarPais;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarTelaAdicionarPais(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAdicionarPais.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAdicionarPaisController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaAtualizarPais(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAtualizarPais.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAtualizarPaisController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaRemoverPais(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaRemoverPais.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaRemoverPaisController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaConsultarPais(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaConsultarPaises.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaConsultarPaisesController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaInicialAdministrador.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaInicialAdministradorController) fxmlLoader.getController()).setStage(stage);

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
