package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MakeAppointmentController implements Initializable {
    public Text hello_user_lbl;
    public DatePicker date_selector_cl;
    public ChoiceBox time_selector;
    public Button confirm_app_btn;
    public Text app_status_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
