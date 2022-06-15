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

public class TelaGerenciarHospedagensController implements Initializable {

    @FXML
    private Button buttonAdicionarHospedagem;
    @FXML
    private Button buttonAtualizarHospedagem;
    @FXML
    private Button buttonRemoverHospedagem;
    @FXML
    private Button buttonConsultarHospedagem;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarTelaAdicionarHospedagem(ActionEvent event) {
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

    @FXML
    public void carregarTelaAtualizarHospedagem(ActionEvent event) {
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

    @FXML
    public void carregarTelaRemoverHospedagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaRemoverHospedagem.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaRemoverHospedagemController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void carregarTelaConsultarHospedagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaConsultarHospedagens.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaConsultarHospedagensController) fxmlLoader.getController()).setStage(stage);

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
