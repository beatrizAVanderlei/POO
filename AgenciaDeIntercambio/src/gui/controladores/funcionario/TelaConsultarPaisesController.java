package gui.controladores.funcionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.entidades.Pais;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.util.ArrayList;

public class TelaConsultarPaisesController {

    @FXML
    private TextArea paises;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaConsultarPaisesController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarPaises(ActionEvent event) {
        ArrayList<Pais> paisArrayList = fachadaAdministrador.consultarTodosPaises();
        StringBuilder paises = new StringBuilder();

        for (Pais p : paisArrayList) {
            paises.append(p + "\n");
        }

        this.paises.setText(String.valueOf(paises));
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
}
