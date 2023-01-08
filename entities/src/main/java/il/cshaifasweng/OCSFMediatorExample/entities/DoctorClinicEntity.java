package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DoctorClinicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorClinic_id")
    private int DoctorClinic_id;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    DoctorEntity doctor;
    @OneToOne
    @JoinColumn(name = "clinic_id")
    ClinicEntity clinic;


    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    String day_hours;

    public DoctorClinicEntity() {
    }

    public DoctorClinicEntity(DoctorEntity doctor, ClinicEntity clinic, String day_hours) {
        this.doctor = doctor;
        this.clinic = clinic;
        this.day_hours = day_hours;
    }

    public String get_day_hours()
    {
        return day_hours;
    }


}
