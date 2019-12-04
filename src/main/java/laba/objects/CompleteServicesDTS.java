package laba.objects;

public class CompleteServicesDTS {
    private int id;
    private String serviceName;
    private String nameDoctor;
    private String namePatient;
    private String dateComplete;
    private String timeBegin;
    private String timeEnd;
    private int cost;

    public CompleteServicesDTS() {}

    public CompleteServicesDTS(int id, String serviceName, String nameDoctor, String namePatient, String dateComplete, String timeBegin, String timeEnd, int cost) {
        this.id = id;
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

    public String getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(String dateComplete) {
        this.dateComplete = dateComplete;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return id + "\t" + serviceName + "\t" + nameDoctor + "\t" + namePatient + "\t" + dateComplete + "\t" + timeBegin
                + "\t\t" + timeEnd + "\t\t" + cost + "\r\n";
    }
}
