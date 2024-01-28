package entity;

public class AntrianEntity {
    private final int nomerAntrian;
    private final String namaPoli;
    private final String dokterYangMenangani;
    private final String namaPasien;
    private final String jadwalHari;
    private final String jadwalJam;

    public AntrianEntity(int nomerAntrian, String namaPoli, String dokterYangMenagani, String namaPasien, String jadwalHari, String jadwalJam){
        this.nomerAntrian = nomerAntrian;
        this.namaPoli = namaPoli;
        this.dokterYangMenangani = dokterYangMenagani;
        this.namaPasien = namaPasien;
        this.jadwalHari = jadwalHari;
        this.jadwalJam = jadwalJam;
    }

    public int getNomerAntrian() {
        return nomerAntrian;
    }

    public String getJadwalHari() {
        return jadwalHari;
    }

    public String getJadwalJam() {
        return jadwalJam;
    }

    public String getNamaPasien() {
        return namaPasien;
    }
}