package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Client Views
     private AnchorPane makeAppointmentView;
     public ViewFactory(){};

     public AnchorPane getMakeAppointmentView() {
          if(makeAppointmentView == null)
          {
               try {
                    makeAppointmentView = new FXMLLoader(getClass().getResource("/il.cshaifasweng.OCSFMediatorExample.client/MakeAppointment.fxml")).load();
               } catch (Exception e)
               {
                    e.printStackTrace();
               }
          }
          return makeAppointmentView;
     }

     public void showLoginWindow(){
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/il.cshaifasweng.OCSFMediatorExample.client/Login.fxml"));
         createStage(loader);
     }

     public void showPatientWindow() {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/il.cshaifasweng.OCSFMediatorExample.client/Patient.fxml"));
         PatientController patientController = new PatientController();
         loader.setController(patientController);
         createStage(loader);
     }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Health Center");
        stage.show();
    }
}
