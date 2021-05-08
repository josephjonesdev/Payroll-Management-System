package oop;
import oop.Employee;
import oop.Faculty;
public abstract class Employee {
    int paidTimeOff;
    String payType;
    String name;
    double payRate;
    int daysTakenOff;

    public Employee(int paidTimeOff, String payType, String name, double payRate) {
        this.paidTimeOff = paidTimeOff;
        this.payType = payType;
        this.name = name;
        this.payRate = payRate;

    }

    public int getPaidTimeOff() {
        return paidTimeOff;
    }

    public void setPaidTimeOff(int paidTimeOff) {
        this.paidTimeOff = paidTimeOff;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getDaysTakenOff() {
        return daysTakenOff;
    }

    public void setDaysTakenOff(int daysTakenOff) {
        this.daysTakenOff = daysTakenOff;
    }
}
