package gui.controladores.administrador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaGerenciarEscolasController implements Initializable {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarTelaAdicionarEscola(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAdicionarEscola.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAdicionarEscolaController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaAtualizarEscola(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaAtualizarEscola.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaAtualizarEscolaController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaRemoverEscola(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaRemoverEscola.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaRemoverEscolaController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaConsultarEscola(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaConsultarEscolas.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaConsultarEscolasController) fxmlLoader.getController()).setStage(stage);

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
