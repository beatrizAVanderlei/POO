package gui.controladores.administrador;

import gui.controladores.Main;
import gui.controladores.TelaInicialController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaLoginAdministradorController implements Initializable {

    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Label usuarioSenhaInvalido;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarTelaInicialAdm(ActionEvent event) {
        if (textFieldUsuario.getText().equals(FachadaAdministrador.getUSUARIO()) && passwordField.getText().equals(FachadaAdministrador.getSENHA())) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaInicialAdministrador.fxml"));
                Parent root = fxmlLoader.load();
                ((TelaInicialAdministradorController) fxmlLoader.getController()).setStage(stage);

                Scene scene = new Scene(root);
                stage.setScene(scene);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }


        } else {
            usuarioSenhaInvalido.setText("Usuário ou senha inválidos! Digite novamente.");
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/TelaInicial.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaInicialController) fxmlLoader.getController()).setStage(stage);

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
