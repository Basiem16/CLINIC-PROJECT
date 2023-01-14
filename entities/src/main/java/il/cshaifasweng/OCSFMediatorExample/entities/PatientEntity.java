package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Patient")
public class PatientEntity extends UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Patient_id")
    private int patient_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

    @ManyToOne(targetEntity = AppointmentEntity.class)
    protected AppointmentEntity next_app;


    @ManyToOne(targetEntity = DoctorEntity.class)
    protected DoctorEntity doctor;

    @OneToMany(mappedBy = "patient")
    List<DoctorPatientEntity> doctorPatientEntities;


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "patient")
    private List<AppointmentEntity> appointments;

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
        clinic.getPatients().add(this);
    }

    public PatientEntity(int id, String first_name, String family_name, String mail, String Password,DoctorEntity doctor, ClinicEntity clinic,String Card_number) throws NoSuchAlgorithmException{
        super(id, first_name, family_name, mail, Password,Card_number);
        //this.patient_id = id;
        this.appointments = new ArrayList<AppointmentEntity>();
        this.clinic=clinic;
        this.doctorPatientEntities = new ArrayList<DoctorPatientEntity>();
        this.doctor=doctor;
        this.next_app = null;
    }

    public PatientEntity() {

    }

    public List<DoctorPatientEntity> getDoctorPatientEntities() {
        return doctorPatientEntities;
    }

    public void setDoctorPatientEntities(List<DoctorPatientEntity> doctorPatientEntities) {
        this.doctorPatientEntities = doctorPatientEntities;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public AppointmentEntity getNext_app() {
        return next_app;
    }

    public void setNext_app(AppointmentEntity next_app) {
        this.next_app = next_app;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}
