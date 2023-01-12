package il.cshaifasweng.OCSFMediatorExample.client;


/**
 * Sample Skeleton for 'ShowApps.fxml' Controller Class
 */


        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.text.Text;

public class ShowAppController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="app_clinic_location"
    private TableColumn<?, ?> app_clinic_location; // Value injected by FXMLLoader

    @FXML // fx:id="app_date"
    private TableColumn<?, ?> app_date; // Value injected by FXMLLoader

    @FXML // fx:id="app_id"
    private TableColumn<?, ?> app_id; // Value injected by FXMLLoader

    @FXML // fx:id="app_status_txt"
    private Text app_status_txt; // Value injected by FXMLLoader

    @FXML // fx:id="app_time"
    private TableColumn<?, ?> app_time; // Value injected by FXMLLoader

    @FXML // fx:id="apps_table"
    private TableView<?> apps_table; // Value injected by FXMLLoader

    @FXML // fx:id="confirm_app_btn"
    private Button confirm_app_btn; // Value injected by FXMLLoader

    @FXML // fx:id="doc_name"
    private TableColumn<?, ?> doc_name; // Value injected by FXMLLoader

    @FXML // fx:id="hello_user_lbl"
    private Text hello_user_lbl; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert app_clinic_location != null : "fx:id=\"app_clinic_location\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert app_date != null : "fx:id=\"app_date\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert app_id != null : "fx:id=\"app_id\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert app_status_txt != null : "fx:id=\"app_status_txt\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert app_time != null : "fx:id=\"app_time\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert apps_table != null : "fx:id=\"apps_table\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert confirm_app_btn != null : "fx:id=\"confirm_app_btn\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert doc_name != null : "fx:id=\"doc_name\" was not injected: check your FXML file 'ShowApps.fxml'.";
        assert hello_user_lbl != null : "fx:id=\"hello_user_lbl\" was not injected: check your FXML file 'ShowApps.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
