package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.*;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class SimpleServer extends AbstractServer {

	public static Session session;
	private static List<ClinicEntity> Clinics;
	private static List<PatientEntity> Patients ;
	private static List<ManagerEntity> managers;
	private static ArrayList<AppointmentEntity> doc_old_apps = new ArrayList<AppointmentEntity>();
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
		} else if (msgString.startsWith("#getAllPatients")){
			List<PatientEntity> patients = getALLPatients();
			Patients = patients;
			try
			{
				client.sendToClient(Patients);
			} catch (IOException e){
				e.printStackTrace();
			}
		} else if (msgString.startsWith("#getPatientApps")){
			msgString = msgString.substring(16);
			try {
				ArrayList<AppointmentEntity> patient_apps = get_apps_with_patientsId((Integer.parseInt(msgString)));
				client.sendToClient(patient_apps);
			} catch (IOException e){
				e.printStackTrace();
			}

		} else if(msgString.equals("#getAllManagers"))
		{
			managers = getALLMangers();
			try {
				client.sendToClient(managers);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (msgString.equals("#GetAllClinics")) {
			try {
				List<ClinicEntity> clinics = getALLClinics();
				Clinics = clinics;
				client.sendToClient(clinics);
				System.out.format("Sent all clinics to client %s\n", client.getInetAddress().getHostAddress());
			} catch (Exception e) {
				if (session != null) {
					session.getTransaction().rollback();
				}
			}
		} else if(msgString.startsWith("#updateAppsForDoc:")) {
			msgString = msgString.substring(18);
			int i =Integer.parseInt(msgString);
			AppointmentEntity current_app = Appointments.get(i);
			while(Appointments.get(i).getDoctor().getDoctor_id() == current_app.getDoctor().getDoctor_id() && Appointments.get(i).getClinic().getId() == current_app.getClinic().getId()
					&& ((Appointments.get(i).getDate().equals(Appointments.get(i-1).getDate().plusMinutes(15)))) )
			{
				AppointmentEntity tmp = Appointments.get(i);
				LocalDateTime time = tmp.getDate();
				if(tmp.getTime() != null)
				{
					time = tmp.getTime();
				}
				tmp.setTime(time.plusMinutes(15));
				if(Appointments.get(i).getPatient().equals(null)) //if we found an appointment with a null patient this means that we have already updated all the reserved appointments
				{
					break;
				}

			}
		} else if (msg.getClass().equals(ClinicEntity.class)) {
			for (int i = 0; i < Clinics.size(); i++) {
				if (Clinics.get(i).getId() == ((ClinicEntity) msg).getId()) {
					session.beginTransaction();
					Clinics.get(i).setOpen(((ClinicEntity) msg).getOpen());
					Clinics.get(i).setClose(((ClinicEntity) msg).getClose());
					session.save(Clinics.get(i));
					session.flush();
					session.getTransaction().commit();
					System.out.format("Updating all clinics on client %s\n", client.getInetAddress().getHostAddress());
				}
			}
		} else if (msg.getClass().equals(AppointmentEntity.class)) {
			AppointmentEntity app = get_app_with_id(((AppointmentEntity) msg).getId());
			System.out.println(app.getDate());
			if(!((AppointmentEntity) msg).isReserved()) // the client has pressed on app but not confirmed the reservation yet
			{
				app.setReserved(true);

			}
			else if((app.getPatient()==null) ) { // the client has confirmed the reservation
				app.setPatient(((AppointmentEntity) msg).getPatient());
				EmailUtil.sendEmail((((AppointmentEntity) msg).getPatient()).getMail(),"appointment confirmation","you have appointment in :"+app.getClinic().getName().toString()+"\n"+"with doctor: "+app.getDoctor().getFamily_name().toString()+"\n"+"at : "+app.getDate());
				try {
					client.sendToClient("reservation done!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				((AppointmentEntity) msg).getPatient().getAppointments().add((AppointmentEntity) msg);
			}
			else  // isReserved=true and patient != null so we need to cancel the appointment
			{
				app.setReserved(false);
				app.setPatient(null);
				try {
					client.sendToClient("Appointment Cancelled!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			session.beginTransaction();
			session.saveOrUpdate(app);
			// session.saveOrUpdate(((AppointmentEntity) msg).getPatient());
			session.flush();
			session.getTransaction().commit();
		} else if (msg.getClass().equals(UserEntity.class)){
			System.out.println(msg.toString());
			System.out.println(msg.getClass().toString());
			List<ManagerEntity> Mangers = getALLMangers();
			boolean flag_manager = checkPassword(Mangers,((UserEntity) msg),client);
			List<DoctorEntity> Doctors = getALLDoctors();
			boolean flag_doctor = checkPassword(Doctors,((UserEntity) msg),client);
			List<NurseEntity> Nurses = getALLNurses();
			boolean flag_nurse = checkPassword(Nurses,((UserEntity) msg),client);
			List<PatientEntity> Patients = getALLPatients();
			boolean flag_patient = checkPassword(Patients,((UserEntity) msg),client);
			String stringResult="";
			if(flag_manager||flag_doctor||flag_patient||flag_nurse){
				System.out.println("flags ok");
				stringResult="#Login Success";
			}else{
				stringResult="#Login Failure";
			}
			try {

				client.sendToClient(stringResult);

			}catch (Exception e) {
				if (session != null) {
					session.getTransaction().rollback();
				}
			}

		}
	}

	private static List<PatientEntity> getALLPatients()  // get all the patients from the database
	{
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PatientEntity> query = builder.createQuery(PatientEntity.class);
		query.from(PatientEntity.class);
		List<PatientEntity> result = session.createQuery(query).getResultList();
		return result;
	}

	private static ArrayList<AppointmentEntity> get_apps_with_patientsId(int patient_id)  // get all the appointments of the given patient
	{
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<AppointmentEntity> query = builder.createQuery(AppointmentEntity.class);
			Root<AppointmentEntity> tmp = query.from(AppointmentEntity.class);
			query.select(tmp);
			query.where(builder.equal(tmp.get("patient"),patient_id));
			TypedQuery<AppointmentEntity> q = session.createQuery(query);
			ArrayList<AppointmentEntity> apps = (ArrayList<AppointmentEntity>) q.getResultList(); //getSingleResult();
			return apps;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private static List<ManagerEntity> getALLMangers() { // get all the managers from the database
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ManagerEntity> query = builder.createQuery(ManagerEntity.class);
		query.from(ManagerEntity.class);
		List<ManagerEntity> result = session.createQuery(query).getResultList();
		return result;
	}

	private static List<ClinicEntity> getALLClinics() { // get all the clinics from the database3
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ClinicEntity> query = builder.createQuery(ClinicEntity.class);
		query.from(ClinicEntity.class);
		List<ClinicEntity> result = session.createQuery(query).getResultList();
		return result;
	}

	public static int getDayNumberNew(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return (day.getValue());
	}

	private static AppointmentEntity get_app_with_id(int id)  // get the appointment with the same id from the database
	{
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<AppointmentEntity> query = builder.createQuery(AppointmentEntity.class);
			Root<AppointmentEntity> tmp = query.from(AppointmentEntity.class);
			query.select(tmp);
			query.where(builder.equal(tmp.get("id"),id));
			TypedQuery<AppointmentEntity> q = session.createQuery(query);
			AppointmentEntity app = q.getSingleResult(); //getSingleResult();
			return app;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	<T extends UserEntity> boolean checkPassword(List<T> Users,UserEntity user,ConnectionToClient client){  // check if the entered username and password exists and correct
		for (int i = 0 ; i < Users.size(); i++){
			if(user.getId() == Users.get(i).getId()){
				if(Users.get(i).comparePassword(user.getPassword())) {
					try {
						client.sendToClient(Users.get(i));
						return true;
					} catch (IOException e) {
						e.printStackTrace();
						if (session != null) {
							session.getTransaction().rollback();
						}
					}
				}else{

					return false;
				}
			}
		}
		return  false;
	}

	private static List<DoctorEntity> getALLDoctors() {  // get all the doctors from the database
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<DoctorEntity> query = builder.createQuery(DoctorEntity.class);
		query.from(DoctorEntity.class);
		List<DoctorEntity> result = session.createQuery(query).getResultList();
		return result;
	}

	private static List<NurseEntity> getALLNurses() {  // get all the nurses from the database
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<NurseEntity> query = builder.createQuery(NurseEntity.class);
		query.from(NurseEntity.class);
		List<NurseEntity> result = session.createQuery(query).getResultList();
		return result;
	}

	static <T> Predicate equal(CriteriaBuilder cb, Expression<T> left, T right) {
		return cb.equal(left, right);
	}

	private static ManagerEntity get_manager_with_id(int id)  // get the manager with the given id from the database
	{
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<ManagerEntity> query = builder.createQuery(ManagerEntity.class);
			Root<ManagerEntity> tmp = query.from(ManagerEntity.class);
			query.select(tmp);
			query.where(builder.equal(tmp.get("manager_id"),id));
			TypedQuery<ManagerEntity> q = session.createQuery(query);
			ManagerEntity manager = q.getSingleResult(); //getSingleResult();
			return manager;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}


}




