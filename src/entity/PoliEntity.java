package entity;

import java.util.ArrayList;

public class PoliEntity {
    private final int id;
    private final String namaPoli;
    private final ArrayList<AntrianEntity> antrian;
    private final ArrayList<DokterEntity> dokter;

    public PoliEntity(String namaPoli, int id){
        antrian = new ArrayList<>();
        dokter = new ArrayList<>();
        this.namaPoli = namaPoli;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getNamaPoli() {
        return namaPoli;
    }


    public ArrayList<AntrianEntity> getAntrian() {
        return antrian;
    }

    public void setAntrian(AntrianEntity antrian) {
        this.antrian.add(antrian);
    }

    public ArrayList<DokterEntity> getDokter() {
        return dokter;
    }

    public void setDokter(DokterEntity dokter) {
        this.dokter.add(dokter);
    }
}