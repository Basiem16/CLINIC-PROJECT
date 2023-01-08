package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NurseEntity extends UserEntity{
    @Id
    private int nurse_id;

    public NurseEntity(int id, String first_name, String family_name, String mail, String Password) {
        super(id, first_name, family_name, mail, Password);
    }

    public NurseEntity() {
    }

    public int getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(int nurse_id) {
        this.nurse_id = nurse_id;
    }
}
