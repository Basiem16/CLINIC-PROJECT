package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor_entity")
public class DoctorEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctor_id;

    @OneToOne(mappedBy = "doctor")
    DoctorClinicEntity doctorClinicEntities;

    @OneToMany(mappedBy = "doctor")
    List<DoctorPatientEntity> doctorPatientEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<AppointmentEntity> appointments;


    public DoctorEntity(int id, String first_name, String family_name, String mail, String Password) {
        super(id, first_name, family_name, mail, Password);


    }

    public DoctorEntity() {

    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public DoctorClinicEntity getDoctorClinicEntities() {
        return doctorClinicEntities;
    }

    public void setDoctorClinicEntities(DoctorClinicEntity doctorClinicEntities) {
        this.doctorClinicEntities = doctorClinicEntities;
    }

    public List<DoctorPatientEntity> getDoctorPatientEntities() {
        return doctorPatientEntities;
    }

    public void setDoctorPatientEntities(List<DoctorPatientEntity> doctorPatientEntities) {
        this.doctorPatientEntities = doctorPatientEntities;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}
