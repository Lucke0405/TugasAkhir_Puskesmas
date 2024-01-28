package entity;

public class JadwalEntity {
    private final int id;
    private String jadwalhari;
    private String jadwalJam;

    public JadwalEntity(int id, String jadwalHari, String jadwalJam){
        this.id = id;
        this.jadwalhari = jadwalHari;
        this.jadwalJam = jadwalJam;
    }

    public int getId() {
        return id;
    }

    public String getJadwalhari() {
        return jadwalhari;
    }

    public void setJadwalhari(String jadwalhari) {
        this.jadwalhari = jadwalhari;
    }

    public String getJadwalJam() {
        return jadwalJam;
    }

    public void setJadwalJam(String jadwalJam) {
        this.jadwalJam = jadwalJam;
    }
}