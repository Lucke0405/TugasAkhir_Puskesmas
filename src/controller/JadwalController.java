package controller;

import entity.DokterEntity;
import entity.JadwalEntity;
import view.Spa;
import view.pages.Dashboard;
import view.pages.TambahJadwalDokter;
import view.pages.UpdateJadwalDokter;

public class JadwalController extends Init {
    public void tambahJadwalDokter(String hari, String jam, int idDokter){
        if(hari == null && jam == null){
            new Spa().setComponent( new TambahJadwalDokter().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        if(idDokter == -1){
            new Spa().setComponent( new TambahJadwalDokter().getComponent("Combo box harus di klik"));
            return;
        }

        DokterEntity dokter = dokterModel.cariDokter(idDokter);
        JadwalEntity jadwal = jadwalModel.buatJadwal(hari, jam);

        dokterModel.setJadwalDanCommit(dokter, jadwal);
        poliModel.commitData();
        new Spa().setComponent( new Dashboard().getComponent("jadwal dokter " +
                dokter.getNama() + "sudah di tambahkan"));
    }

    public void updateJadwalDokter(int idJadwal, String hariBaru, String jamBaru, int idDokter){
        if(idJadwal == -1 && idDokter == -1){
            new Spa().setComponent( new UpdateJadwalDokter().getComponent("Combo box harus di klik"));
            return;
        }

        if(hariBaru == null && jamBaru == null){
            new Spa().setComponent( new UpdateJadwalDokter().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        DokterEntity dokter = dokterModel.cariDokter(idDokter);

        dokterModel.updateJadwal(idJadwal, hariBaru, jamBaru, dokter);
        poliModel.commitData();
        new Spa().setComponent( new Dashboard().getComponent("jadwal dokter " + dokter.getNama() + "sudah di update"));
    }
}