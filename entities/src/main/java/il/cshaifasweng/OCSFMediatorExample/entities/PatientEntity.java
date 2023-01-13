package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Patient")
public class PatientEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Patient_id")
    private int patient_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

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

    public PatientEntity(int id, String first_name, String family_name, String mail, String Password, ClinicEntity clinic) throws NoSuchAlgorithmException{
        super(id, first_name, family_name, mail, Password);
        //this.patient_id = id;
        this.appointments = new ArrayList<AppointmentEntity>();
        this.clinic=clinic;
        this.doctorPatientEntities = new ArrayList<DoctorPatientEntity>();
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
