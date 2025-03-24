/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5latihan1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import modul5latihan1.Main;

public class MasterDataController {
 
    @FXML
    private Button btnDashboard;
    
    @FXML
    private Button buttonLogout;
    
    
     @FXML
    private void handleButtonDashboard(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("Dashboard.fxml");
    }
    
    @FXML
    private void handleButtonLogoutAction(ActionEvent event) throws Exception{
        
        Main main = new Main();
        main.changeScene("Main.fxml");
    }
}