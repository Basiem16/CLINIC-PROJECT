package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorEntity extends UserEntity{
    @Id
    private int doctor_id;


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
}
