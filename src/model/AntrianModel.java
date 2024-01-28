package model;

import com.google.gson.reflect.TypeToken;
import entity.AntrianEntity;

import java.util.ArrayList;

public class AntrianModel extends Model<AntrianEntity>{
    public AntrianModel() {
        super("./src/database/antrian.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<AntrianEntity>>() {}.getType());
    }

    public AntrianEntity buatAntrian( String namaPoli, String dokterYangMenangani, String namaPasien, String jadwalHari, String jadwalJam ){


        AntrianEntity antrian = new AntrianEntity( dataList.size() + 1,
                namaPoli, dokterYangMenangani, namaPasien, jadwalHari, jadwalJam);

        dataList.add(antrian);
        commitData();

        return antrian;
    }

    public AntrianEntity cariAntrianBerdasarkanNomer(int nomerAntrian){
        for (AntrianEntity antrian : dataList){
            if (antrian.getNomerAntrian() == nomerAntrian) {
                return antrian;
            }
        }

        return null;
    }

    public void hapusAntrian(int nomerAntrian){
        dataList.removeIf(antrian -> antrian.getNomerAntrian() == nomerAntrian);

        commitData();
    }
}