package model;
import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Employee {
    private String employeeName;
    private String employeePosition;
    private String employeePhone;
    private String employeeId;

    private List<Capsule> capsulesmadeby;


     public Employee(String name, String position, String id,String phone) {
        this.employeeName= name;
        this.employeePosition= position;
        this.employeeId = id;
        this.employeePhone=phone;

        this.capsulesmadeby=new ArrayList<>();
    }
    public String getEmployeePhone(){
        return employeePosition;
    }
    public void setEmployeePhone(String phone){
        this.employeePosition=phone;
    }
    public void setEmployeeName(String name){
        this.employeeName=name;

    }
    public String getEmployeeName(){
        return employeeName;
    }
    public void setEmployeeId(String id){
        this.employeeId=id;
    }
    public String getEmployeeId(){
         return employeeId;
    }
    public String toString() {
        return "Employee{" +
                "Name='" + employeeName + '\'' +
                ", Phone='" + employeePosition + '\'' +
                ", ='" + employeeId + '\'' +
                '}';}


    public List<Capsule> getCapsules() {
        return capsulesmadeby;
    }
    public void addCapsule(Capsule capsule) {
        capsulesmadeby.add(capsule);
    }


}
