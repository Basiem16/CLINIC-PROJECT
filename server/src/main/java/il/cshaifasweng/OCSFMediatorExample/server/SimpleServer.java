package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.*;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class SimpleServer extends AbstractServer {

	public static Session session;
	private static List<ClinicEntity> Clinics;
	private static List<PatientEntity> Patients ;
	private static List<ManagerEntity> managers;
	public static ArrayList<AppointmentEntity> Appointments=new ArrayList<AppointmentEntity>();

	public SimpleServer(int port) {
		super(port);
		initSession();
		MyThread myThread = new MyThread();
		myThread.start();

		
	}

	public void initSession() {
		session = getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			ClinicEntity clinic1 = new ClinicEntity(1, "Mashad", "8:00", "13:00", new ArrayList<PatientEntity>());
			session.save(clinic1);
			ClinicEntity clinic2 = new ClinicEntity(2, "Dier Hanna", "8:00", "13:00", new ArrayList<PatientEntity>());
			session.save(clinic2);
			ClinicEntity clinic3 = new ClinicEntity(3, "Haifa", "8:00", "13:00", new ArrayList<PatientEntity>());
			session.save(clinic3);
			ClinicEntity clinic4 = new ClinicEntity(4, "Amesterdam", "8:00", "13:00", new ArrayList<PatientEntity>());
			session.save(clinic4);


			PatientEntity pat1 = new PatientEntity(318582095, "Ehab", "Mansour", "Ehab.m.97@hotmail.com", "Ehab123", clinic1);
			session.save(pat1);
			PatientEntity pat2 = new PatientEntity(207340514, "Baseem", "Salem", "Baseem.2@hotmail.com", "Baseem123", clinic2);
			session.save(pat2);
			PatientEntity pat3 = new PatientEntity(123455667, "Shady", "Shkyko", "shakyko.2@hotmail.com", "shaky123", clinic3);
			session.save(pat3);
			PatientEntity pat4 = new PatientEntity(234567564, "Malki", "Growsman", "malki@hotmail.com", "malki123", clinic4);
			session.save(pat4);
			PatientEntity pat5 = new PatientEntity(345678565, "Shir", "Sneh", "Shir@hotmail.com", "Shir123", clinic4);
			session.save(pat5);


			DoctorEntity doc1 = new DoctorEntity(123456234, "d.Ehab", "Mansour", "Ehab@gmail.com", "Ehab123");
			session.save(doc1);
			DoctorEntity doc2 = new DoctorEntity(123456234, "d.Baseem", "Salem", "Bas@gmail.com", "Bass123");
			session.save(doc2);
			DoctorEntity doc3 = new DoctorEntity(123456234, "d.Shaky", "Salem", "Shakyko@gmail.com", "Shaky123");
			session.save(doc3);
			DoctorEntity doc4 = new DoctorEntity(123456234, "d.Hannah", "Baker", "Hannah@gmail.com", "Hannah123");
			session.save(doc4);


			NurseEntity nurse1 = new NurseEntity(1234567836, "Nurse", "1", "Nurse1@gmail.com", "Nurse1123", clinic1);
			session.save(nurse1);
			NurseEntity nurse2 = new NurseEntity(567898766, "Nurse", "2", "Nurse2@gmail.com", "Nurse2123", clinic2);
			session.save(nurse2);
			NurseEntity nurse3 = new NurseEntity(1234562678, "Nurse", "3", "Nurse3@gmail.com", "Nurse2123", clinic3);
			session.save(nurse3);
			NurseEntity nurse4 = new NurseEntity(1234564578, "Nurse", "4", "Nurse4@gmail.com", "Nurse2123", clinic4);
			session.save(nurse4);

			DoctorClinicEntity doctorClinic1 = new DoctorClinicEntity(doc1, clinic1);
			session.save(doctorClinic1);
			DoctorClinicEntity doctorClinic2 = new DoctorClinicEntity(doc2, clinic2);
			session.save(doctorClinic2);
			DoctorClinicEntity doctorClinic3 = new DoctorClinicEntity(doc3, clinic3);
			session.save(doctorClinic3);
			DoctorClinicEntity doctorClinic4 = new DoctorClinicEntity(doc4, clinic4);
			session.save(doctorClinic4);


			ManagerEntity manager1 = new ManagerEntity(123457834, "Jamal", "Salem", "jabashli@yahoo.com", "12345", clinic1);
			session.save(manager1);
			ManagerEntity manager2 = new ManagerEntity(123457835, "Yousef", "Arrabi", "jkl@yahoo.com", "12345", clinic2);
			session.save(manager2);
			ManagerEntity manager3 = new ManagerEntity(123457836, "Basel", "Ali", "sadkjn@yahoo.com", "12345", clinic3);
			session.save(manager3);
			ManagerEntity manager4 = new ManagerEntity(123457837, "Hasbi", "Mago", "sdf@yahoo.com", "12345", clinic4);
			session.save(manager4);

			DoctorPatientEntity docPatient1 = new DoctorPatientEntity(doc1,pat1);
			session.save(docPatient1);
			DoctorPatientEntity docPatient2 = new DoctorPatientEntity(doc2,pat2);
			session.save(docPatient2);
			DoctorPatientEntity docPatient3 = new DoctorPatientEntity(doc3,pat3);
			session.save(docPatient3);
			DoctorPatientEntity docPatient4 = new DoctorPatientEntity(doc4,pat4);
			session.save(docPatient4);

			session.flush();
			session.getTransaction().commit();

			Appointments=(ArrayList<AppointmentEntity>) GetAllAppointments();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		}
	}

	public void stopSession() {
		if (session != null) {
			session.close();
		}
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(ClinicEntity.class);
		configuration.addAnnotatedClass(PatientEntity.class);
		configuration.addAnnotatedClass(NurseEntity.class);
		configuration.addAnnotatedClass(DoctorEntity.class);
		configuration.addAnnotatedClass(DoctorClinicEntity.class);
		configuration.addAnnotatedClass(ManagerEntity.class);
		configuration.addAnnotatedClass(DoctorPatientEntity.class);
		configuration.addAnnotatedClass(AppointmentEntity.class);




		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		return configuration.buildSessionFactory(serviceRegistry);
	}


	public  static List<AppointmentEntity> GetAllAppointments(){
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<AppointmentEntity> query = builder.createQuery(AppointmentEntity.class);
		query.from(AppointmentEntity.class);
		List<AppointmentEntity> result = session.createQuery(query).getResultList();
		return result;
	}



	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		String msgString = msg.toString();
		if (msgString.startsWith("#warning")) {
			Warning warning = new Warning("Warning from server!");
			try {
				client.sendToClient(warning);
				System.out.format("Sent warning to client %s\n", client.getInetAddress().getHostAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (msgString.startsWith("#CloseSession")) {
			stopSession();
		}
	}

	}




