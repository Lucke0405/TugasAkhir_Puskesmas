package model;

import com.google.gson.reflect.TypeToken;
import entity.JadwalEntity;
import entity.PasienEntity;

import java.util.ArrayList;

public class JadwalModel extends Model<JadwalEntity>{
    public JadwalModel() {
        super("./src/database/jadwal.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<PasienEntity>>() {}.getType());
    }

    public JadwalEntity buatJadwal(String hari, String jam){
        JadwalEntity jadwal = new JadwalEntity(dataList.size() + 1, hari, jam);
        dataList.add(jadwal);
        commitData();

        return jadwal;
    }
}
