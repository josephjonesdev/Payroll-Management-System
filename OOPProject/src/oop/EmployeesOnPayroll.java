package oop;

import java.util.ArrayList;

public class EmployeesOnPayroll {
    private ArrayList<Staff> staffList = new ArrayList<>();
    private ArrayList<Faculty> facultyList = new ArrayList<>();

    public boolean registerStaff(String name, double payRate, String type) {
        if (type.equalsIgnoreCase("Annual")) {
            staffList.add(new AnnualStaff(name, payRate));
            return true;
        } else if (type.equalsIgnoreCase("Hourly")) {
            staffList.add(new HourlyStaff(name, payRate));
            return true;
        } else {
            return false;
        }
    }

    public boolean registerEmployee(String name, double payRate, String type) {
       if (type.equalsIgnoreCase("Instructor")) {
           facultyList.add(new Instructor(name, payRate));
           return true;
       }
        if (type.equalsIgnoreCase("Assistant Professor")) {
            facultyList.add(new AssistantProfessor(name, payRate));
            return true;
        }
        if (type.equalsIgnoreCase("Associate Professor")) {
            facultyList.add(new AssociateProfessor(name, payRate));
            return true;
        }
        if (type.equalsIgnoreCase("Full Professor")) {
            facultyList.add(new FullProfessor(name, payRate));
            return true;
        } else {
            return false;
        }
    }

     public double avgAnnualSalary() {
        double salaries = 0;
        double employeesOnSalary = 0;
        for (Faculty f : facultyList) {
            salaries += f.getPayRate();
            employeesOnSalary++;
        }
         for (Staff s : staffList) {
             if (s.getPayType().equalsIgnoreCase("Annually")) {
                 salaries += s.getPayRate();
                 employeesOnSalary++;
             }
         }
         return salaries / employeesOnSalary;
     }

     public String findMostPaidEmployee() {
        String name ="";
        double salary = 0;
         for (Faculty f : facultyList) {
            if (f.getPayRate() > salary) {
                salary = f.getPayRate();
                name = f.getName();
            }
         }
         for (Staff s : staffList) {
             if (s.getPayType().equalsIgnoreCase("Annually")) {
                 if (s.getPayRate() > salary) {
                     salary = s.getPayRate();
                     name = s.getName();
                 }
             }
         }
         return name;
     }

     public boolean updateEmployee(String type, String name, double payRate, int daysTakenOff) {
        int index = 0;
        if (type.equalsIgnoreCase("Faculty")) {
            for (Faculty f : facultyList) {
                if (f.getName().equalsIgnoreCase(name)) {
                   break;
                }
                index++;
                }
            Faculty f =  facultyList.get(index);
            if (payRate != 0) {
                f.setPayRate(payRate);
            }
            if (daysTakenOff != 0) {
                f.setDaysTakenOff(f.getDaysTakenOff() + daysTakenOff);
            }
            return true;
        } else if (type.equalsIgnoreCase("Staff")) {
             for (Staff s : staffList) {
                 if (s.getName().equalsIgnoreCase(name)) {
                   break;
                     }
                 index++;
         }
             Staff s =  staffList.get(index);
             if (payRate != 0) {
                 s.setPayRate(payRate);
             }
             if (daysTakenOff != 0) {
                 s.setDaysTakenOff(s.getDaysTakenOff() + daysTakenOff);
             }
             return true;
          }
         return false;
         }

         public boolean deleteEmployee(String type, String name) {
             int index = 0;
             if (type.equalsIgnoreCase("Faculty")) {
                 for (Faculty f : facultyList) {
                     if (f.getName().equalsIgnoreCase(name)) {
                         break;
                     }
                     index++;
                 }
                facultyList.remove(index);
                 return true;
             } else if (type.equalsIgnoreCase("Staff")) {
                 for (Staff s : staffList) {
                     if (s.getName().equalsIgnoreCase(name)) {
                         break;
                     }
                     index++;
                 }
                staffList.remove(index);
                 return true;
             }
             return false;
         }

         
      }


