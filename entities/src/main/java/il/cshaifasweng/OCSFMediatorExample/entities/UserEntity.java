package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.MappedSuperclass;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
@MappedSuperclass
public class UserEntity {
    private int id;
    String first_name;
    String family_name;
    String mail;
    private String Password;
    boolean active;

    public UserEntity(int id, String first_name, String family_name, String mail,String Password)  {
        this.id = id;
        this.first_name = first_name;
        this.family_name = family_name;
        this.mail = mail;
        this.Password = Password;
        active = false;
    }

    public UserEntity() {
        this.active = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean comparePassword(String password)
    {
        boolean check = password.compareTo(this.getPassword()) == 0;
        return check;
    }
}
