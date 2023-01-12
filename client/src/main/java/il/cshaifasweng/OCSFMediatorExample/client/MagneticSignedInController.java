/**
 * Sample Skeleton for 'MagneticSignedIn.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MagneticSignedInController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="addNurseApp_btn"
    private Button addNurseApp_btn; // Value injected by FXMLLoader

    @FXML // fx:id="appId_txt"
    private TextField appId_txt; // Value injected by FXMLLoader

    @FXML // fx:id="appTime_txt"
    private TextField appTime_txt; // Value injected by FXMLLoader

    @FXML // fx:id="docNurseName_txt"
    private TextField docNurseName_txt; // Value injected by FXMLLoader

    @FXML // fx:id="getTickInfo_btn"
    private Button getTickInfo_btn; // Value injected by FXMLLoader

    @FXML // fx:id="logOut_btn"
    private Button logOut_btn; // Value injected by FXMLLoader

    @FXML // fx:id="logout_btn"
    private FontAwesomeIconView logout_btn; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert addNurseApp_btn != null : "fx:id=\"addNurseApp_btn\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert appId_txt != null : "fx:id=\"appId_txt\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert appTime_txt != null : "fx:id=\"appTime_txt\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert docNurseName_txt != null : "fx:id=\"docNurseName_txt\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert getTickInfo_btn != null : "fx:id=\"getTickInfo_btn\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert logOut_btn != null : "fx:id=\"logOut_btn\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";
        assert logout_btn != null : "fx:id=\"logout_btn\" was not injected: check your FXML file 'MagneticSignedIn.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
