package model;

import com.google.gson.reflect.TypeToken;
import entity.*;
import java.util.ArrayList;
import java.util.Objects;

public class DokterModel extends Model<DokterEntity>{
    public DokterModel() {
        super("./src/database/dokter.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<DokterEntity>>() {}.getType());
    }

    public ArrayList<DokterEntity> lihatSemuaDokter(){
        loadData();
        return dataList;
    }

    // polymorp / overloading
    public DokterEntity cariDokter(int idDokter) {
        for (DokterEntity dokter : dataList){
            if (dokter.getId() == idDokter) return dokter;
        }

        return null;
    }

    // polymorp / overloading
    public DokterEntity cariDokter(String namaDokter){
        for(DokterEntity dokter : dataList){
            if (Objects.equals(dokter.getNama(), namaDokter)) return dokter;
        }

        return null;
    }

    public DokterEntity tambahDokter(String nama, String spesialis){
        DokterEntity dokter = new DokterEntity(dataList.size() + 1 , nama,  spesialis);

        dataList.add(dokter);
        commitData();

        return dokter;
    }

    public void setJadwalDanCommit(DokterEntity dokter, JadwalEntity jadwal){
        dokter.setJadwal(jadwal);
        commitData();
    }

    public void updateJadwal(int idJadwal, String hari, String jam, DokterEntity dokter){
        for(JadwalEntity jadwal : dokter.getJadwal()){
            if(jadwal.getId() == idJadwal){
                jadwal.setJadwalhari(hari);
                jadwal.setJadwalJam(jam);
                break;
            }
        }

        commitData();
    }
}