/**
 * Sample Skeleton for 'StationAdmin.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StationAdminController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="closeStation_btn"
    private Button closeStation_btn; // Value injected by FXMLLoader

    @FXML // fx:id="logOut_btn"
    private Button logOut_btn; // Value injected by FXMLLoader

    @FXML // fx:id="logout_btn"
    private FontAwesomeIconView logout_btn; // Value injected by FXMLLoader

    @FXML // fx:id="openStation_btn"
    private Button openStation_btn; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert closeStation_btn != null : "fx:id=\"closeStation_btn\" was not injected: check your FXML file 'StationAdmin.fxml'.";
        assert logOut_btn != null : "fx:id=\"logOut_btn\" was not injected: check your FXML file 'StationAdmin.fxml'.";
        assert logout_btn != null : "fx:id=\"logout_btn\" was not injected: check your FXML file 'StationAdmin.fxml'.";
        assert openStation_btn != null : "fx:id=\"openStation_btn\" was not injected: check your FXML file 'StationAdmin.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
