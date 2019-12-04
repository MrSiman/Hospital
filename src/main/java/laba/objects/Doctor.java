package laba.objects;

import org.springframework.stereotype.Component;

@Component
public class Doctor {
    private String numPassport;
    private String FIO;
    private String profession;
    private int salary;
    private String sex;

    public Doctor() {}

    public Doctor(String numPassport, String FIO, String profession, int salary, String sex) {
        this.numPassport = numPassport;
        this.FIO = FIO;
        this.profession = profession;
        this.salary = salary;
        this.sex = sex;
    }

    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return numPassport + "\t" + FIO + "\t\t" + profession + "\t" + salary + "\t" + sex + "\r\n";
    }
}
