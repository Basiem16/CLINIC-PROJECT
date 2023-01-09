package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.AppointmentEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyThread extends Thread{

    @Override
    public void run(){
        while (true){
            SimpleServer.Appointments = (ArrayList<AppointmentEntity>)SimpleServer.GetAllAppointments();
            System.out.println("in the thread num: "+ this.getId());
            System.out.println(SimpleServer.Appointments.size());


            for(AppointmentEntity app : SimpleServer.Appointments){
                if((app.isReserved()==true)&&(app.getPatient()==null)){
                    app.setReserved(false);
                    SimpleServer.session.getTransaction().begin();
                    SimpleServer.session.saveOrUpdate(app);
                    SimpleServer.session.flush();
                    SimpleServer.session.getTransaction().commit();

                }

                Calendar app_cal = Calendar.getInstance();
                app_cal.set(app.getDate().getYear(),app.getDate().getMonthValue(),app.getDate().getDayOfMonth(),app.getDate().getHour(),app.getDate().getMinute(),app.getDate().getSecond());
                long day_1 = (60 * 60 *24) +(3000000L * 1000)-(500000 * 1000)+(5500600);
                Date now_date_mills = new Date(System.currentTimeMillis());
                long app_time_in_mills= app_cal.getTimeInMillis();

                if((app.isReserved())&&(app.getPatient()!=null)&&(((now_date_mills.getTime()+day_1+30000)>app_time_in_mills))&&(now_date_mills.getTime()+day_1-30000)<(app_time_in_mills))
                {
                  ///////// EmailUtil
                }
            }

        }

    }
}
