package entity;

import java.util.ArrayList;

public class PasienEntity {

    private String nama;
    private final String alamat;
    private final Character kelamin;
    private final String tempatTanggalLahir;
    private final String nik;
    private final String nomerBpjs;
    private AntrianEntity antrian;
    private final ArrayList<TransaksiEntity> transaksi;


    public PasienEntity(String nama, String alamat, Character
            kelamin, String tempatTglLahir, String nik, String nomerBpjs){

        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
        this.tempatTanggalLahir = tempatTglLahir;
        this.nik = nik;
        this.nomerBpjs = nomerBpjs;

        transaksi = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public String getNomerBpjs() {
        return nomerBpjs;
    }

    public AntrianEntity getAntrian() {
        return antrian;
    }

    public void setAntrian(AntrianEntity antrian) {
        this.antrian = antrian;
    }

    public void setTransaksi(TransaksiEntity transaksi) {
        this.transaksi.add(transaksi);
    }
}