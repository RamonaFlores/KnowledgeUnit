package model;

public class ClientDesignedManager {
 private String clientManagerName;
 private String clientManagerPhone;
 private String clientManagerId;
    public ClientDesignedManager(String clientManagerName, String clientManagerPhone, String clientManagerId) {
        this.clientManagerName = clientManagerName;
        this.clientManagerPhone = clientManagerPhone;
        this.clientManagerId = clientManagerId;
    }

    public String getClientManagerName() {
        return clientManagerName;
    }

    public void setClientManagerName(String clientManagerName) {
        this.clientManagerName = clientManagerName;
    }

    public String getClientManagerPhone() {
        return clientManagerPhone;
    }

    public void setClientManagerPhone(String clientManagerPhone) {
        this.clientManagerPhone = clientManagerPhone;
    }

    public String getClientManagerId() {
        return clientManagerId;
    }

    public void setClientManagerId(String clientManagerId) {
        this.clientManagerId = clientManagerId;
    }
}

