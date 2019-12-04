package laba.objects;

public class PatientDTS {
    private String numPassport;
    private String FIO;
    private String doctorFIO;
    private String DoB;
    private String recordingDate;
    private String sex;

    public PatientDTS() {
    }

    public PatientDTS(String numPassport, String FIO, String doctorFIO, String DoB, String recordingDate, String sex) {
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

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(String recordingDate) {
        this.recordingDate = recordingDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Override
    public String toString() {
        return numPassport + "\t" + FIO + "\t" + DoB + "\t" + recordingDate
                + "\t" + sex + "\t" + doctorFIO  + "\r\n";
    }
}
