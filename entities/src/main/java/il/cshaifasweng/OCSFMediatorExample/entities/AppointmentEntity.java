package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointments")
public class AppointmentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int id;
    private LocalDateTime date; // date of appointment
    private LocalDateTime time; // time of appointment
    private boolean reserved = false;
    private int timeDuration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;



    public AppointmentEntity() {
    }

    public AppointmentEntity(LocalDateTime date, LocalDateTime time, boolean reserved, int timeDuration, ClinicEntity clinic, PatientEntity patient, DoctorEntity doctor) {
        this.date = date;
        this.time = time;
        this.reserved = reserved;
        this.timeDuration = timeDuration;
        this.clinic = clinic;
        this.patient = patient;
        this.doctor = doctor;
    }

    public AppointmentEntity(LocalDateTime date, DoctorClinicEntity doc_clinic,int duration)
    {
        this.date=date;
        setClinic_app(doc_clinic.clinic);// TODO change tp set
        setDoctor_app(doc_clinic.doctor); // TODO change tp set
        this.reserved = false;
        this.timeDuration = duration;
    }

    public AppointmentEntity(LocalDateTime actual_date,LocalDateTime date, ClinicEntity clinic,PatientEntity patient,NurseEntity nurse,boolean valid,int duration)
    {
        this.date=date;
        this.clinic = clinic; // TODO change tp set
        this.patient = patient; // TODO change tp set
//        setNurse_app(nurse); // TODO change tp set
        this.time=actual_date;
        this.reserved = valid;
        this.timeDuration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }


    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }

    public void setClinic_app(ClinicEntity clinic) {
        this.clinic = clinic;
        clinic.getAppointments().add(this);
    }

    public void setPatient_app(PatientEntity patient) {
        this.patient=patient;
        patient.getAppointments().add(this);
    }

    public void setDoctor_app(DoctorEntity doctor) {
        this.doctor=doctor;
        doctor.getAppointments().add(this);
    }
}
