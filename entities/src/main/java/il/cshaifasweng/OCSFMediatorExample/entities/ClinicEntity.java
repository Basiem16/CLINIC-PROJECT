package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class ClinicEntity implements Serializable {
    @Id
    private int id;
    private String name;
    private  String open;
    private String close;

    private List<PatientEntity> Patients;

    public ClinicEntity() {
    }

    public ClinicEntity(int id, String name, String open, String close, List<PatientEntity> Patients) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.close = close;
        this.Patients = Patients;
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
}
