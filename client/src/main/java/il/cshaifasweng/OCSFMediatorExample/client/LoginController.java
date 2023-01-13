package il.cshaifasweng.OCSFMediatorExample.client;

import Models.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    private ChoiceBox<String> acc_selector; // Value injected by FXMLLoader

    @FXML // fx:id="error_lbl"
    private Label error_lbl; // Value injected by FXMLLoader

    @FXML // fx:id="login_btn"
    private Button login_btn; // Value injected by FXMLLoader

    @FXML // fx:id="password_fld"
    private TextField password_fld; // Value injected by FXMLLoader

    @FXML // fx:id="password_lbl"
    private Label password_lbl; // Value injected by FXMLLoader

    private String[] people = {"Patient", "Doctor", "Nurse", "Manager"};

    @FXML
    void signInFun(ActionEvent event) throws IOException {
        /*Model.getInstance().getViewFactory();
        Model.getInstance().getViewFactory().showPatientWindow();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();*/
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(acc_id_fld.getText());
        if (m.matches()) {
            SimpleClient.getClient().LogIn(Integer.parseInt(acc_id_fld.getText()), password_fld.getText());
            while (SimpleClient.getClient().logInFlag == -1) {
                ProgressBar pb = new ProgressBar(0.6);
                ProgressBar pi = new ProgressBar(0.6);
            }
            if (SimpleClient.getClient().logInFlag == 1 && acc_id_fld.getText().length() < 10) { // TODO change to == 9
                if(SimpleClient.getClient().getAvailableUsers() < 1){ // error in available users
                    if((acc_selector.getValue() == "Patient") && (SimpleClient.getPatientClient() != null)) {
                        SimpleClient.getClient().logInFlag = -1;
                    }
                }else if(SimpleClient.getClient().getAvailableUsers() == 1){
                    App.setRoot("patient");
                    SimpleClient.getClient().setCurrentUser(0);
                }else{
                    if((acc_selector.getValue() == "Patient") && (SimpleClient.getPatientClient() != null))
                        App.setRoot("Patient");
                    else if((acc_selector.getValue() == "Doctor") && (SimpleClient.getDoctorClient() != null))
                        App.setRoot("Doctor");
                    else if((acc_selector.getValue() == "Nurse") && (SimpleClient.getNurseClient() != null))
                        App.setRoot("Nurse");
                    else if((acc_selector.getValue() == "Admin") && (SimpleClient.getManagerClient() != null))
                        App.setRoot("Admin");
                }
            }
            else if(SimpleClient.getClient().logInFlag == 3){
                SimpleClient.getClient().logInFlag = -1;
                acc_id_fld.setText("");
                password_fld.setText("");
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            String.format("User already active")
                    );
                    alert.show();
                    error_lbl.setText("User already active");
                });
            } else {
                password_fld.setText("");
                SimpleClient.getClient().logInFlag = -1;
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            String.format("Incorrect Id or Password, try again")
                    );
                    alert.show();
                    error_lbl.setText("Invalid Id or Password, please try again!");
                });
            }
        } else {
            acc_id_fld.setText("");
            password_fld.setText("");
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        String.format("ID should contain only numbers, try again")
                );
                alert.show();
                error_lbl.setText("ID should only contain numbers, please try again!");
            });
        }
    }

    @FXML
    void magneticStationFun(ActionEvent event) throws IOException {
        App.setRoot("MagneticStation"); // Open Magnetic Station in Clinic
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
        acc_selector.getItems().addAll(people);
        //acc_selector.setItems(FXCollections.observableArrayList(Account));
    }
}


/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

