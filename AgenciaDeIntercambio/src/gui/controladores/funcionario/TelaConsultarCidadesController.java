package gui.controladores.funcionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.entidades.Cidade;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaConsultarCidadesController implements Initializable {

    @FXML
    private TextArea cidades;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaConsultarCidadesController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarCidades(ActionEvent event) {
        ArrayList<Cidade> cidadeArrayList = fachadaAdministrador.consultarTodasCidades();
        StringBuilder cidades = new StringBuilder();

        for (Cidade c : cidadeArrayList) {
            cidades.append(c + "\n");
        }

        this.cidades.setText(String.valueOf(cidades));
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
