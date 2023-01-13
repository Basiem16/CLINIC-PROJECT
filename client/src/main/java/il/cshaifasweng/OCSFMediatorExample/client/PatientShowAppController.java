/**
 * Sample Skeleton for 'PatientShowApp.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class PatientShowAppController implements Initializable {

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

    @FXML // fx:id="logout_btn"
    private FontAwesomeIconView logout_btn; // Value injected by FXMLLoader

    @FXML // fx:id="make_app_btn"
    private Button make_app_btn; // Value injected by FXMLLoader

    @FXML // fx:id="profile_btn"
    private Button profile_btn; // Value injected by FXMLLoader

    @FXML // fx:id="reload_btn"
    private Button reload_btn; // Value injected by FXMLLoader

    @FXML // fx:id="show_app_btn"
    private Button show_app_btn; // Value injected by FXMLLoader

    @FXML
    void confrimToCancelApp(ActionEvent event) {

    }

    @FXML
    void goToMakeAppPage(ActionEvent event) throws IOException {
        App.setRoot("Patient");
    }

    @FXML
    void goToProfilePage(ActionEvent event) throws IOException {
        App.setRoot("PatientShowInfo");
    }

    @FXML
    void goToShowAppsPage(ActionEvent event) throws IOException {
        App.setRoot("PatientShowApp");
    }

    @FXML
    void logOutPage(ActionEvent event) throws IOException {
        App.setRoot("Login");
        SimpleClient.resetClient();
    }

    @FXML
    void realodPage(ActionEvent event) throws IOException {
        App.setRoot("Patient");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert app_clinic_location != null : "fx:id=\"app_clinic_location\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert app_date != null : "fx:id=\"app_date\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert app_id != null : "fx:id=\"app_id\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert app_status_txt != null : "fx:id=\"app_status_txt\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert app_time != null : "fx:id=\"app_time\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert apps_table != null : "fx:id=\"apps_table\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert confirm_app_btn != null : "fx:id=\"confirm_app_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert doc_name != null : "fx:id=\"doc_name\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert hello_user_lbl != null : "fx:id=\"hello_user_lbl\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert logout_btn != null : "fx:id=\"logout_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert make_app_btn != null : "fx:id=\"make_app_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert profile_btn != null : "fx:id=\"profile_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert reload_btn != null : "fx:id=\"reload_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";
        assert show_app_btn != null : "fx:id=\"show_app_btn\" was not injected: check your FXML file 'PatientShowApp.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleClient.getClient().setCurrentUser(0);
        hello_user_lbl.setText("Hello " + SimpleClient.getPatientClient().getName() + ",");
    }
}

