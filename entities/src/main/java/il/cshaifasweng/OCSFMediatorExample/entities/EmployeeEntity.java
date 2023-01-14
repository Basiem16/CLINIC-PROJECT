package il.cshaifasweng.OCSFMediatorExample.entities;

public class EmployeeEntity extends UserEntity{

    protected int Employee_number;
    protected int Room_number;

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
