package il.cshaifasweng.OCSFMediatorExample.client;




/**
 * Sample Skeleton for 'Nurse.fxml' Controller Class
 */

        import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;

public class NurseController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="app_id_col"
    private TableColumn<?, ?> app_id_col; // Value injected by FXMLLoader

    @FXML // fx:id="firstName_col"
    private TableColumn<?, ?> firstName_col; // Value injected by FXMLLoader

    @FXML // fx:id="lastName_col"
    private TableColumn<?, ?> lastName_col; // Value injected by FXMLLoader

    @FXML // fx:id="logOut_btn"
    private Button logOut_btn; // Value injected by FXMLLoader

    @FXML // fx:id="logout_btn"
    private FontAwesomeIconView logout_btn; // Value injected by FXMLLoader

    @FXML // fx:id="nextPatient_btn"
    private Button nextPatient_btn; // Value injected by FXMLLoader

    @FXML // fx:id="patientId_col"
    private TableColumn<?, ?> patientId_col; // Value injected by FXMLLoader

    @FXML // fx:id="patients_table"
    private TableView<?> patients_table; // Value injected by FXMLLoader

    @FXML // fx:id="reload_btn"
    private Button reload_btn; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert app_id_col != null : "fx:id=\"app_id_col\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert firstName_col != null : "fx:id=\"firstName_col\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert lastName_col != null : "fx:id=\"lastName_col\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert logOut_btn != null : "fx:id=\"logOut_btn\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert logout_btn != null : "fx:id=\"logout_btn\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert nextPatient_btn != null : "fx:id=\"nextPatient_btn\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert patientId_col != null : "fx:id=\"patientId_col\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert patients_table != null : "fx:id=\"patients_table\" was not injected: check your FXML file 'Nurse.fxml'.";
        assert reload_btn != null : "fx:id=\"reload_btn\" was not injected: check your FXML file 'Nurse.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
