package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DoctorPatientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorPatient_id")
    private int doctor_patient_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    PatientEntity patient;

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctor(){
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
        doctor.getDoctorPatientEntities().add(this);
    }

    public DoctorPatientEntity() {
    }

    public DoctorPatientEntity(DoctorEntity doctor, PatientEntity patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getDoctor_patient_id() {
        return doctor_patient_id;
    }

    public void setDoctor_patient_id(int doctor_patient_id) {
        this.doctor_patient_id = doctor_patient_id;
    }
}
