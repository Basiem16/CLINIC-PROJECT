/**
 * Sample Skeleton for 'MagneticStation.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MagneticStationController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="acc_id_lbl"
    private Label acc_id_lbl; // Value injected by FXMLLoader

    @FXML // fx:id="magnetic_card_number_fld"
    private TextField magnetic_card_number_fld; // Value injected by FXMLLoader

    @FXML // fx:id="scan_btn"
    private Button scan_btn; // Value injected by FXMLLoader

    @FXML
    void signInFun(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert acc_id_lbl != null : "fx:id=\"acc_id_lbl\" was not injected: check your FXML file 'MagneticStation.fxml'.";
        assert magnetic_card_number_fld != null : "fx:id=\"magnetic_card_number_fld\" was not injected: check your FXML file 'MagneticStation.fxml'.";
        assert scan_btn != null : "fx:id=\"scan_btn\" was not injected: check your FXML file 'MagneticStation.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
