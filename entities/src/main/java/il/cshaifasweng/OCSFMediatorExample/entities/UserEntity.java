package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
@MappedSuperclass
public class UserEntity implements Serializable {
    private int id;
    String first_name;
    String family_name;
    String mail;
    private String Password;
    boolean active;
    private String Salt;
    protected String Card_number;

    public UserEntity(int id, String first_name, String family_name, String mail,String Password, String Card_number)  throws NoSuchAlgorithmException{
        this.id = id;
        this.first_name = first_name;
        this.family_name = family_name;
        this.mail = mail;
        this.Password = Password;
        this.active = false;
        this.Salt = setSalt();
        this.Card_number = Card_number;
        setPassword(Password);
    }

    public UserEntity() {
        this.active = false;
    }


    private String setSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
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

    public String getCard_number() {
        return Card_number;
    }

    public void setCard_number(String card_number) {
        Card_number = card_number;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        getSecurePassword(password,this.Salt);
    }

    private String getSecurePassword(String passwordToHash,
                                     String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean comparePassword(String password)
    {
        String pass = getSecurePassword(password,this.Salt);
        boolean check = pass.compareTo(this.getPassword()) == 0;
        return check;
    }
    public void setTmpPassword(String Password){
        this.Password = Password;
    }
}
