package gui.controladores.funcionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.entidades.Hospedagem;
import negocio.entidades.Republica;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaConsultarHospedagensController implements Initializable {

    @FXML
    private TextArea hospedagens;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaConsultarHospedagensController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarHospedagens(ActionEvent event) {
        ArrayList<Hospedagem> hospedagemArrayList = fachadaAdministrador.consultarTodasHospedagens();
        StringBuilder hospedagens = new StringBuilder();

        for (Hospedagem h : hospedagemArrayList) {
            if (h instanceof Republica) {
                hospedagens.append("República: " + h + "\n");
            } else {
                hospedagens.append("Host Family: " + h + "\n");
            }

        }

        this.hospedagens.setText(String.valueOf(hospedagens));
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/funcionario/TelaConsultarDisponibilidade.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaConsultarDisponibilidadeController) fxmlLoader.getController()).setStage(stage);

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
