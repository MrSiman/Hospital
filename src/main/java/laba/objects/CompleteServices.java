package laba.objects;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CompleteServices {
    private int id;
    private String serviceName;
    private String nameDoctor;
    private String namePatient;
    private Date dateComplete;
    private Date timeBegin;
    private Date timeEnd;
    private int cost;

    public CompleteServices() {}

    public CompleteServices(String serviceName, String nameDoctor, String namePatient, Date dateComplete, Date timeBegin, Date timeEnd, int cost) {
        this.serviceName = serviceName;
        this.nameDoctor = nameDoctor;
        this.namePatient = namePatient;
        this.dateComplete = dateComplete;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public Date getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        this.dateComplete = dateComplete;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public static String timeToString(Date time) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(time);
    }
}