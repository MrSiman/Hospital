package laba.objects;

import org.springframework.stereotype.Component;

@Component
public class Service {
    private String code;
    private String typeName;
    private String name;
    private int cost;

    public Service() {}

    public Service(String code, String typeName, String name, int cost) {
        this.code = code;
        this.typeName = typeName;
        this.name = name;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return code + "\t\t" + typeName + "\t\t\t\t\t" + name + "\t" + cost + "\r\n";
    }
}
