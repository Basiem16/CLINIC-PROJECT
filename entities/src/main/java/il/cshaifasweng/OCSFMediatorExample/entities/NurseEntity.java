package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "Nurse")
public class NurseEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nurse_id")
    private int nurse_id;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }

    public NurseEntity(int id, String first_name, String family_name, String mail, String Password, ClinicEntity clinic) throws NoSuchAlgorithmException {
        super(id, first_name, family_name, mail, Password);
        this.clinic = clinic;
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
