package controller;

import entity.DokterEntity;
import entity.PoliEntity;
import model.PoliModel;
import view.Spa;
import view.pages.Dashboard;
import view.pages.TambahListPoli;

import java.util.ArrayList;

public class PoliController extends Init {
    public ArrayList<PoliEntity> lihatSemuaPoli(){
        return poliModel.lihatSemuaPoli();
    }

    public void tambahPoli(String namaPoliYangBaru){
        if(namaPoliYangBaru == null){
            new Spa().setComponent( new TambahListPoli().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        PoliEntity poliYangSama = poliModel.cariPoli(namaPoliYangBaru);

        if(poliYangSama != null){
            new Spa().setComponent( new TambahListPoli().getComponent("Poli sudah ada"));
            return;
        }

        poliModel.buatPoli(namaPoliYangBaru);
        new Spa().setComponent( new Dashboard().getComponent("Poli telah terbuat"));
    }

    public static ArrayList<DokterEntity> lihatDokterBerdasarkanPoli(int idPoli){
        PoliModel poli = new PoliModel();
        return poli.cariPoli(idPoli).getDokter();
    }

}