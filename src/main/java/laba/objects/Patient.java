package laba.objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Patient {
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private String numPassport;
    private String FIO;
    private String doctorFIO;
    private Date DoB;
    private Date recordingDate;
    private boolean sex;

    public Patient() {}

    public Patient(String numPassport, String FIO, String doctorFIO, Date DoB, Date recordingDate, boolean sex) {
        this.numPassport = numPassport;
        this.FIO = FIO;
        this.doctorFIO = doctorFIO;
        this.DoB = DoB;
        this.recordingDate = recordingDate;
        this.sex = sex;
    }

    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String num_passport) {
        this.numPassport = num_passport;
    }

    public String getDoctorFIO() {
        return doctorFIO;
    }

    public void setDoctorFIO(String doctorFIO) {
        this.doctorFIO = doctorFIO;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public Date getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public static Date stringToDate(String string) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(string);
        return date;
    }
}
