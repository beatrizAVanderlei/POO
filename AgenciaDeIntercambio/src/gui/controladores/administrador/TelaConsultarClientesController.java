package gui.controladores.administrador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.entidades.Cliente;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaConsultarClientesController implements Initializable {

    @FXML
    private TextArea clientes;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaConsultarClientesController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarClientes(ActionEvent event) {
        ArrayList<Cliente> clienteArrayList = fachadaAdministrador.consultarTodosOsClientes();
        StringBuilder clientes = new StringBuilder();

        for (Cliente c : clienteArrayList) {
            clientes.append(c + "\n");
        }

        this.clientes.setText(String.valueOf(clientes));
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarClientes.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarClientesController) fxmlLoader.getController()).setStage(stage);

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