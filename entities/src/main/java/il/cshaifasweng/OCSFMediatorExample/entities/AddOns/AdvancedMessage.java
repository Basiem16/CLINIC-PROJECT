package il.cshaifasweng.OCSFMediatorExample.entities.AddOns;



import il.cshaifasweng.OCSFMediatorExample.entities.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class AdvancedMessage implements Serializable {
    /* ---------- Message Necessary Info ---------- */
    private int id;
    private String action;
    private String type;
    private String error;
    /* ---------- Handling users ---------- */
    private UserEntity user;
    private PatientEntity patient;
    private String username;
    private String first_name;
    private String password;
    private String userType;
    private String status;
    private String sessionID;
    private String UserCardNumber;
    private LocalDate BirthDate=null;
    private String patientName;
    /*----------Handling clinics----*/
    private ClinicEntity clinic;
    public List<String> ClinicList;
    private String clinic_name;
    private LocalTime opening_hour;
    private LocalTime closing_hour;
    private String address;
    private int room;
    List<ClinicEntity> clinics;
    /*-------Handling appointments---*/
    private AppointmentEntity appointment;
    private List<AppointmentEntity> nearest_apps;
    private boolean arrived;
    private long app_count;
    private LocalDate appDate;
    private LocalTime appTime;
    private boolean saved;
    private boolean removed;

    /*-------Handling Employees-------*/
    private int employee_id;
    private String role;
    private EmployeeEntity employee;
    private String employeeName;
    private List<DoctorEntity> employeeList;
    private ManagerEntity manager;


    /*-------Handling updates-------*/
    private String service_name;
    private List<String> services;
    private List<String> doctors;
    private String doctor;



    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public AdvancedMessage() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getUserCardNumber() {
        return UserCardNumber;
    }

    public void setUserCardNumber(String userCardNumber) {
        UserCardNumber = userCardNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }

    public List<String> getClinicList() {
        return ClinicList;
    }

    public void setClinicList(List<String> clinicList) {
        ClinicList = clinicList;
    }

    public String getClinicName(){
        return clinic_name;
    }

    public void setClinicName(String name){
        this.clinic_name = name;
    }

    public void setOpeningHour (LocalTime opening_hour){
        this.opening_hour = opening_hour;
    }

    public LocalTime getOpeningHour(){
        return opening_hour;
    }

    public void setClosingHour (LocalTime closing_hour){
        this.closing_hour = closing_hour;
    }

    public LocalTime getClosingHour(){
        return closing_hour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentEntity appointment) {
        this.appointment = appointment;
    }

    public long getAppCount() {
        return app_count;
    }

    public void setAppCount(long app_count) {
        this.app_count = app_count;
    }

    public List<AppointmentEntity> getNearest_apps() {
        return nearest_apps;
    }

    public void setNearest_apps(List<AppointmentEntity> nearest_apps) {
        this.nearest_apps = nearest_apps;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        this.doctors = doctors;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public boolean patientArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }







    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public List<ClinicEntity> getClinics() {
        return clinics;
    }

    public void setClinics(List<ClinicEntity> clinics) {
        this.clinics = clinics;
    }

    public LocalDate getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDate appDate) {
        this.appDate = appDate;
    }

    public LocalTime getAppTime() {
        return appTime;
    }

    public void setAppTime(LocalTime appTime) {
        this.appTime = appTime;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public List<DoctorEntity> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<DoctorEntity> employeeList) {
        this.employeeList = employeeList;
    }




    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public PatientEntity getPatient() {
        return patient;
    }
}

