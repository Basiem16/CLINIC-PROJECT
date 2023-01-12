/**
 * Sample Skeleton for 'AppointmentDisplay.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AppointmentDisplayContoller implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Doctor_nextapp_Display"
    private TextArea Doctor_nextapp_Display; // Value injected by FXMLLoader

    @FXML // fx:id="Nurse_next_app_btn"
    private Button Nurse_next_app_btn; // Value injected by FXMLLoader

    @FXML // fx:id="Nurse_nextapp_Display"
    private TextArea Nurse_nextapp_Display; // Value injected by FXMLLoader

    @FXML // fx:id="doctor_next_app_btn"
    private Button doctor_next_app_btn; // Value injected by FXMLLoader

    @FXML
    void doctor_app_action(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Doctor_nextapp_Display != null : "fx:id=\"Doctor_nextapp_Display\" was not injected: check your FXML file 'AppointmentDisplay.fxml'.";
        assert Nurse_next_app_btn != null : "fx:id=\"Nurse_next_app_btn\" was not injected: check your FXML file 'AppointmentDisplay.fxml'.";
        assert Nurse_nextapp_Display != null : "fx:id=\"Nurse_nextapp_Display\" was not injected: check your FXML file 'AppointmentDisplay.fxml'.";
        assert doctor_next_app_btn != null : "fx:id=\"doctor_next_app_btn\" was not injected: check your FXML file 'AppointmentDisplay.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
