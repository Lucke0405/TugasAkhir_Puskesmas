package controller;

import entity.DokterEntity;
import entity.JadwalEntity;
import entity.PoliEntity;
import view.Spa;
import view.pages.Dashboard;
import view.pages.TambahDokter;

import java.util.ArrayList;

public class DokterController extends Init{
    public ArrayList<DokterEntity> lihatSemuaDokter(){
        return dokterModel.lihatSemuaDokter();
    }

    public void tambahDokter(String nama, int idPoli){
        if(nama == null) {
            new Spa().setComponent( new TambahDokter().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        if(idPoli == -1) {
            new Spa().setComponent( new TambahDokter().getComponent("Combo box harus di klik"));
            return;
        }

        DokterEntity dokter = dokterModel.cariDokter(nama);

        if(dokter != null){
            new Spa().setComponent( new TambahDokter().getComponent("Nama dokter tidak boleh sama"));
            return;
        }

        PoliEntity poli = poliModel.cariPoli(idPoli);

        if(poli == null){
            new Spa().setComponent( new TambahDokter().getComponent("Poli tidak di temukan"));
            return;
        }

        DokterEntity dokterBaru = dokterModel.tambahDokter(nama, poli.getNamaPoli());
        poliModel.tambahDokter(poli, dokterBaru);

        new Spa().setComponent( new Dashboard().getComponent("Dokter " +
                dokterBaru.getNama() + " sudah di buat"));
    }

    public ArrayList<JadwalEntity> cariJadwalBerdasarkanDokter(int id){
        return dokterModel.cariDokter(id).getJadwal();
    }
}