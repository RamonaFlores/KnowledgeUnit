package model;

public class ProyectManager {
    private String proyectManagerName;
    private String proyectManagerPhone;
    private String proyectManagerId;

    public ProyectManager(String proyectManagerName, String proyectManagerPhone, String proyectManagerId){
        this.proyectManagerName=proyectManagerName;
        this.proyectManagerId=proyectManagerId;
        this.proyectManagerPhone=proyectManagerPhone;
    }
    public String getProyectManagerName() {
        return proyectManagerName;
    }

    public void setProyectManagerName(String proyectManagerName) {
        this.proyectManagerName = proyectManagerName;
    }

    public String getProyectManagerPhone() {
        return proyectManagerPhone;
    }

    public void setProyectManagerPhone(String proyectManagerPhone) {
        this.proyectManagerPhone = proyectManagerPhone;
    }

    public String getProyectManagerId() {
        return proyectManagerId;
    }

    public void setProyectManagerId(String proyectManagerId) {
        this.proyectManagerId = proyectManagerId;
    }
}



