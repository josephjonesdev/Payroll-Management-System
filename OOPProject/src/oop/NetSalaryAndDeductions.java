package oop;

public class NetSalaryAndDeductions {

    public static String calculateNetSalaryAndDeductions(Object o , String type, String department) {
        double payRate = 0;
        int excessDays = 0;
        Faculty f = null;
        Staff s = null;
        if (department.equalsIgnoreCase("Staff")) {
            s = (Staff) o;
        }
        else if (department.equalsIgnoreCase("Faculty")) {
            f = (Faculty) o;
        }

        if (type.equalsIgnoreCase("Instructor")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = f.getDaysTakenOff() - f.getPaidTimeOff();
            }
        } else if (type.equalsIgnoreCase("Associate Professor")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = f.getDaysTakenOff() - f.getPaidTimeOff();
            }
        }
        else if (type.equalsIgnoreCase("Assistant Professor")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = f.getDaysTakenOff() - f.getPaidTimeOff();
            }
        }
        else if (type.equalsIgnoreCase("Full Professor")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = f.getDaysTakenOff() - f.getPaidTimeOff();
            }
        }
        else if (type.equalsIgnoreCase("Hourly Staff")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = s.getDaysTakenOff() - s.getPaidTimeOff();
            }
        }
        else if (type.equalsIgnoreCase("Annual Staff")) {
            if (f.getDaysTakenOff() > f.getPaidTimeOff()) {
                excessDays = s.getDaysTakenOff() - s.getPaidTimeOff();
            }
        }
        double excessDaysOffDeduction = calculateTimeOffDeductions(payRate, excessDays, type);
        double taxDeductions = taxDeduction(payRate);
        double netSalary = payRate - (excessDaysOffDeduction + taxDeductions);
        if (type.equalsIgnoreCase("Hourly Staff")) {
            return "The hourly pay is " + payRate  + ". The excess days off " +
                    "deductions are " + excessDaysOffDeduction;
        } else {
            return "The net salary is " + netSalary + ". The tax deductions are " + taxDeductions + ". The excess days off " +
                    "deductions are " + excessDaysOffDeduction;
        }
    }

    public static double taxDeduction(double payRate) {
        double taxDeductions = 0;


        if (payRate > 50000) {
            taxDeductions = payRate * .1;
        } else if (payRate > 70000) {
            taxDeductions = payRate * .15;
        } else if (payRate > 90000) {
            taxDeductions = payRate * .2;
        } else if (payRate > 120000) {
            taxDeductions = payRate * .3;
        }
        return taxDeductions;
    }

    public static double calculateTimeOffDeductions(double payRate,int excessDays, String type) {
        double excessDaysOffDeductions;

        if (type.equalsIgnoreCase("Instructor")) {
            excessDaysOffDeductions = payRate/365 * 1.5;
          return excessDays * excessDaysOffDeductions;

        } else if (type.equalsIgnoreCase("Associate Professor")) {
            excessDaysOffDeductions = payRate/365 * 1.3;
          return excessDays * excessDaysOffDeductions;
        }
        else if (type.equalsIgnoreCase("Assistant Professor")) {
            excessDaysOffDeductions = payRate/365 * 1.4;
          return excessDays * excessDaysOffDeductions;
        }
        else if (type.equalsIgnoreCase("Full Professor")) {
            excessDaysOffDeductions = payRate/365 * 1.2;
           return excessDays * excessDaysOffDeductions;
        }
        else if (type.equalsIgnoreCase("Hourly Staff")) {
            excessDaysOffDeductions = payRate * 8;
           return excessDays * excessDaysOffDeductions;
        }
       else if (type.equalsIgnoreCase("Annual Staff")) {
            excessDaysOffDeductions = payRate/365;
            return excessDays * excessDaysOffDeductions;
        }
       return 0;
    }
}
