package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Clinic")
public class ClinicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Clinic_id")
    private int id;
    private String name;
    private  String open;
    private String close;


    @OneToOne(mappedBy = "clinic", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private  ManagerEntity manager;

    @OneToMany (mappedBy = "clinic")
    private List<PatientEntity> Patients;

    @OneToMany(mappedBy = "clinic")
    private List<NurseEntity> nurses;

    @OneToMany(mappedBy = "clinic")
    private List<DoctorClinicEntity> doctorClinicEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
    private List<AppointmentEntity> appointments;


    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public ClinicEntity() {
    }

    public ClinicEntity(int id, String name, String open, String close, List<PatientEntity> Patients) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.close = close;
        this.Patients = new ArrayList<PatientEntity>();
        this.nurses=new ArrayList<NurseEntity>();
        this.doctorClinicEntities=new ArrayList<DoctorClinicEntity>();
        this.appointments=new ArrayList<AppointmentEntity>();
    }

    public ClinicEntity(ClinicEntity CE) {
        this.name = CE.name;
        this.open = CE.open;
        this.close = CE.close;
        this.Patients=CE.Patients;
        this.nurses= CE.nurses;
        this.doctorClinicEntities=CE.doctorClinicEntities;
        this.manager=CE.manager;
    }

    public ClinicEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public List<PatientEntity> getPatients() {
        return Patients;
    }

    public void setPatients(List<PatientEntity> patients) {
        Patients = patients;
    }

    public void updateManager(ManagerEntity manager){
        this.manager = manager;
    }

    public List<NurseEntity> getNurses() {
        return nurses;
    }

    public void setNurses(List<NurseEntity> nurses) {
        this.nurses = nurses;
    }

    public List<DoctorClinicEntity> getDoctorClinicEntities() {
        return doctorClinicEntities;
    }

    public void setDoctorClinicEntities(List<DoctorClinicEntity> doctorClinicEntities) {
        this.doctorClinicEntities = doctorClinicEntities;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}
