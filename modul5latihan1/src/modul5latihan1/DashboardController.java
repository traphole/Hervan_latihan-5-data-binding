package modul5latihan1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class DashboardController implements Initializable {

    @FXML
    private Button buttonLogout;
    @FXML
    private Button btnMasterData;
    
    @FXML
    private void handleButtonLogoutAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("Main.fxml");
    }
     @FXML
    private void handleButtonMasterAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("MasterData.fxml");
    }

    /**
     * Initializes the controller class.
     */
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}