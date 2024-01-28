package entity;

import java.util.ArrayList;

public class DokterEntity {
    private final int id;
    private String nama;
    private final ArrayList<JadwalEntity> jadwal;
    private final String spesialis;

    public DokterEntity(int id, String nama, String spesialis){
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
        jadwal = new ArrayList<>();
    }

    public int getId() {
        return id;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<JadwalEntity> getJadwal() {
        return jadwal;
    }

    public void setJadwal(JadwalEntity jadwal) {
        this.jadwal.add(jadwal);
    }

    public String getSpesialis() {
        return spesialis;
    }
}