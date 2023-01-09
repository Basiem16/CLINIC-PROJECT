package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.AppointmentEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String toEmail, String subject, String body)
    {
        try
        {
            final String fromEmail = "magic.baseem@gmail.com";
            final String password = "123";

            Authenticator auth = new Authenticator() {
                //@Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);

                }
            };
            Properties props = new Properties();
            props.put("mail.smtp.host", "stmp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.enable","true");

            Session session = Session.getInstance(props,auth);
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format","flowed");
            msg.addHeader("Content-Transfer-Encoding","8bit");

            msg.setFrom(new InternetAddress("magic.baseem@gmail.com"));
            msg.setReplyTo(InternetAddress.parse("magic.baseem@gmail.com",false));
            msg.setSubject(subject,"UTF-8");
            msg.setText(body,"UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail,false));
            Transport.send(msg);

            System.out.println("Email Sent Successfully.");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void sendEmailAppointment(AppointmentEntity app){
        try {
            final String fromEmail = "magic.baseem@gmail.com";
            final String password = "123";

            Authenticator auth = new Authenticator() {
                //@Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail,password);
                }
            };

            Properties props = new Properties();
            props.put("mail.smtp.host", "stmp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.enable","true");

            Session session = Session.getInstance(props,auth);
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format","flowed");
            msg.addHeader("Content-Transfer-Encoding","8bit");
            msg.setFrom(new InternetAddress("magic.baseem@gmail.com","clinics"));
            msg.setReplyTo(InternetAddress.parse("magic.baseem@gmail.com",false));
            msg.setSubject("reminder for appointment","UTF-8");
            String body="your appointment in,"+ app.getClinic().getName()+"\n"+" at: "+app.getDoctor().getFamily_name()+"\n";
            msg.setText(body,"UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(app.getPatient().getMail(),false));
            Transport.send(msg);
            System.out.println("Email sent successfully.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
