package model;

import com.google.gson.reflect.TypeToken;
import entity.AntrianEntity;
import entity.DokterEntity;
import entity.PoliEntity;

import java.util.ArrayList;
import java.util.Objects;

public class PoliModel extends Model<PoliEntity>{
    public PoliModel() {
        super("./src/database/poli.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<PoliEntity>>() {}.getType());
    }

    public void buatPoli(String namaPoliYangBaru){
        PoliEntity poli = new PoliEntity( namaPoliYangBaru, dataList.size() + 1 );

        dataList.add(poli);
        commitData();
    }

    public ArrayList<PoliEntity> lihatSemuaPoli(){
        return dataList;
    }


    // polymorp / overloading
    public PoliEntity cariPoli(int idPoli) {
        for (PoliEntity poli : dataList){
            if (poli.getId() == idPoli) return poli;
        }

        return null;
    }

    // polymorp / overloading
    public PoliEntity cariPoli(String namaPoli){
        for (PoliEntity poli : dataList){
            if (Objects.equals(poli.getNamaPoli(), namaPoli)) return poli;
        }

        return null;
    }

    public void setAntrianDanCommit( PoliEntity poli, AntrianEntity antrian ){
        poli.setAntrian( antrian );
        commitData();
    }

    public void tambahDokter(PoliEntity poli, DokterEntity dokter){
        poli.setDokter(dokter);
        commitData();
    }

    public void hapusAntrian(int nomerAntrian){
        for (PoliEntity poli : dataList) {
            poli.getAntrian().removeIf(antrian -> antrian.getNomerAntrian() == nomerAntrian);
        }

        commitData();
    }
}