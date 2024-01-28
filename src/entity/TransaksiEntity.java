package entity;

public class TransaksiEntity {
    private final String namaPasien;
    private final String adminPengelola;
    private final int uangPembayaran;
    private String timeStamp;

    public TransaksiEntity(String namaPasien, String adminPengelola, int uangPembayaran){
        this.namaPasien = namaPasien;
        this.adminPengelola = adminPengelola;
        this.uangPembayaran = uangPembayaran;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getAdminPengelola() {
        return adminPengelola;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}