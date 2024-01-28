package model;

import com.google.gson.reflect.TypeToken;
import entity.TransaksiEntity;
import helper.TimeStamp;
import modelJson.ModelJSON;
import java.util.ArrayList;

public class TransaksiModel {
    public ArrayList<TransaksiEntity> listTransaksi;
    public ModelJSON<TransaksiEntity> modelJSONTransaksi;

    public TransaksiModel() {
        listTransaksi = new ArrayList<>();
        modelJSONTransaksi = new ModelJSON <>("./src/database/transaksi.json");
        loadData();
    }

    private void loadData() {
        listTransaksi = modelJSONTransaksi.readFromFile(new TypeToken<ArrayList<TransaksiEntity>>() {}.getType());
    }

    public TransaksiEntity buatTransaksi(String namaPasien, String adminPengelola, int bayaran){

        String waktuSaatIni = TimeStamp.buat();

        TransaksiEntity transaksi = new TransaksiEntity(namaPasien, adminPengelola, bayaran);
        transaksi.setTimeStamp( waktuSaatIni );
        listTransaksi.add(transaksi);
        commitData();

        return transaksi;
    }

    private void commitData(){
        modelJSONTransaksi.writeToFile(listTransaksi);
    }
}