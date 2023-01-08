package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DoctorPatientEntity implements Serializable {
    @Id
    private int doctor_patient_id;
    @OneToMany
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
    }

    public DoctorPatientEntity() {
    }

    public DoctorPatientEntity(DoctorEntity doctor, PatientEntity patient) {
        this.doctor = doctor;
        this.patient = patient;
    }
}
