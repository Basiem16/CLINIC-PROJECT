package il.cshaifasweng.OCSFMediatorExample.entities;

import java.security.NoSuchAlgorithmException;

public class EmployeeEntity extends UserEntity{

    protected int Employee_number;
    protected int Room_number;
    protected String Role;

    public EmployeeEntity(int id, String first_name, String family_name, String mail, String Password, String Card_number, int employee_number, int room_number, String role) throws NoSuchAlgorithmException {
        super(id, first_name, family_name, mail, Password, Card_number);
        Employee_number = employee_number;
        Room_number = room_number;
        Role = role;
    }

    public EmployeeEntity(int employee_number, int room_number, String role) {
        Employee_number = employee_number;
        Room_number = room_number;
        Role = role;
    }

    public int getEmployee_number() {
        return Employee_number;
    }

    public void setEmployee_number(int employee_number) {
        Employee_number = employee_number;
    }

    public int getRoom_number() {
        return Room_number;
    }

    public void setRoom_number(int room_number) {
        Room_number = room_number;
    }
}
