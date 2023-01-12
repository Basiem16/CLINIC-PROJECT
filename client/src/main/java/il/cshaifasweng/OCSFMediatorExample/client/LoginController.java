package il.cshaifasweng.OCSFMediatorExample.client;

import Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button Magnetic_Station_btn;

    @FXML // fx:id="acc_id_fld"
    private TextField acc_id_fld; // Value injected by FXMLLoader

    @FXML // fx:id="acc_id_lbl"
    private Label acc_id_lbl; // Value injected by FXMLLoader

    @FXML // fx:id="acc_selector"
    private ChoiceBox<?> acc_selector; // Value injected by FXMLLoader

    @FXML // fx:id="error_lbl"
    private Label error_lbl; // Value injected by FXMLLoader

    @FXML // fx:id="login_btn"
    private Button login_btn; // Value injected by FXMLLoader

    @FXML // fx:id="password_fld"
    private TextField password_fld; // Value injected by FXMLLoader

    @FXML // fx:id="password_lbl"
    private Label password_lbl; // Value injected by FXMLLoader

    @FXML
    void signInFun(ActionEvent event) {
        Model.getInstance().getViewFactory();
        Model.getInstance().getViewFactory().showPatientWindow();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert acc_id_fld != null : "fx:id=\"acc_id_fld\" was not injected: check your FXML file 'Login.fxml'.";
        assert acc_id_lbl != null : "fx:id=\"acc_id_lbl\" was not injected: check your FXML file 'Login.fxml'.";
        assert acc_selector != null : "fx:id=\"acc_selector\" was not injected: check your FXML file 'Login.fxml'.";
        assert error_lbl != null : "fx:id=\"error_lbl\" was not injected: check your FXML file 'Login.fxml'.";
        assert login_btn != null : "fx:id=\"login_btn\" was not injected: check your FXML file 'Login.fxml'.";
        assert password_fld != null : "fx:id=\"password_fld\" was not injected: check your FXML file 'Login.fxml'.";
        assert password_lbl != null : "fx:id=\"password_lbl\" was not injected: check your FXML file 'Login.fxml'.";
        assert Magnetic_Station_btn != null : "fx:id=\"Magnetic_Station_btn\" was not injected: check your FXML file 'Login.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}


/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

