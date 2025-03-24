package modul5latihan1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

    @FXML
    private TextField inputUsername;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelError;

    @FXML
    private void handleButtonLoginAction(ActionEvent event) throws Exception {
        checkLogin();
    }

    private void checkLogin() throws Exception {
        String username = inputUsername.getText().trim();
        String password = inputPassword.getText().trim();

        if (username.equals("admin") && password.equals("123")) {
            labelError.setText("Login Sukses");

            Main main = new Main();
            main.changeScene("/latihanmodul5/Dashboard.fxml");
        } else if (username.isEmpty() && password.isEmpty()) {
            labelError.setText("Isi Username dan Password!");
        } else {
            labelError.setText("Username atau Password salah!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inisialisasi jika diperlukan
    }
}