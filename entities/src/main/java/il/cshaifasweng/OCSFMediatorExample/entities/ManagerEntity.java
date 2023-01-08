package il.cshaifasweng.OCSFMediatorExample.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ManagerEntity extends UserEntity{

    @Id
    private int manager_id;


    @OneToOne
    @JoinColumn(name = "clinic_id")
    private  ClinicEntity clinic;

    public ManagerEntity(int id, String first_name, String family_name, String mail, String Password, ClinicEntity clinic) {
        super(id, first_name, family_name, mail, Password);
        this.manager_id = manager_id;
        this.clinic = clinic;
    }

    public ManagerEntity() {
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }
}
