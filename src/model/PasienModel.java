package model;

import entity.AntrianEntity;
import entity.PasienEntity;
import entity.TransaksiEntity;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Objects;


public class PasienModel extends Model<PasienEntity>{
    public PasienModel() {
        super("./src/database/pasien.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<PasienEntity>>() {}.getType());
    }

    public void tambahPasien(String nama, String alamat, Character
            kelamin, String tempatTglLahir, String nik, String nomerBpjs) {

        PasienEntity pasien = new PasienEntity(nama, alamat, kelamin,
                tempatTglLahir, nik, nomerBpjs);

        dataList.add(pasien);
        commitData();

    }

    public PasienEntity cariPasienBerdasarkanNik(String nik) {
        for (PasienEntity pasien : dataList){
            if (Objects.equals(pasien.getNik(), nik)) return pasien;
        }

        return null;
    }

    public PasienEntity cariPasienBerdasarkanNama(String nama){
        for (PasienEntity pasien : dataList){
            if (Objects.equals(pasien.getNama(), nama)) return pasien;
        }

        return null;
    }

    public void hapusAntrian(PasienEntity pasien){
        pasien.setAntrian(null);
        commitData();
    }

    public void setPasienDanCommit(PasienEntity pasien, AntrianEntity antrian){
        pasien.setAntrian(antrian);
        commitData();
    }

    public void tambahTransaksi(TransaksiEntity transaksi, String nama){
        PasienEntity pasien = cariPasienBerdasarkanNama(nama);
        pasien.setTransaksi(transaksi);

        commitData();
    }
}