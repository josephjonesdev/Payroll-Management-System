package oop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class RecordVactionTime {
    public static boolean recordVacationTime(String name, LocalDate from, LocalDate to) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./vacationTimes"));
            writer.write(name + "-" + from + '-' + to);
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

    }
}
