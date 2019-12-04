package laba.objects;

import org.springframework.stereotype.Component;

@Component
public class ServiceType {
    private String typeServiceCode;
    private String typeName;

    public ServiceType() {}

    public ServiceType(String typeServiceCode, String typeName) {
        this.typeServiceCode = typeServiceCode;
        this.typeName = typeName;
    }

    public String getTypeServiceCode() {
        return typeServiceCode;
    }

    public void setTypeServiceCode(String typeServiceCode) {
        this.typeServiceCode = typeServiceCode;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeServiceCode + "\t\t" + typeName + "\r\n";
    }
}
