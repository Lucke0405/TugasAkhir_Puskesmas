package controller;

import entity.*;
import view.Spa;
import view.pages.AmbilAntrian;
import view.pages.Dashboard;

import java.util.Random;

public class AntrianController extends Init {
    public void ambilAntrian(String nik, String nomerBpjs, int idPoli, int idDokterDiPilih){

        if(idPoli == -1 && idDokterDiPilih == -1){
            new Spa().setComponent( new AmbilAntrian().getComponent("Combo box harus di klik"));
            return;
        }

        PasienEntity pasien = pasienModel.cariPasienBerdasarkanNik(nik);

        if(pasien == null){
            new Spa().setComponent( new AmbilAntrian().getComponent("Pasien tidak di temukan"));
            return;
        }

        if(pasien.getAntrian() != null){
            new Spa().setComponent(
                    new Dashboard().getComponent("Anda sudah memiliki antrian nomer : "
                    + pasien.getAntrian().getNomerAntrian()));

            return;
        }

        if( !pasien.getNomerBpjs().equals(nomerBpjs) ){
            new Spa().setComponent( new AmbilAntrian().getComponent("Nomer bpjs tidak sama"));
            return;
        }

        PoliEntity poliYangDiPilih = poliModel.cariPoli(idPoli);

        DokterEntity dokterYangTerpilih = dokterModel.cariDokter( idDokterDiPilih );
        String namaDokter = dokterYangTerpilih.getNama();
        JadwalEntity jadwal;

        if (dokterYangTerpilih.getJadwal() != null && !dokterYangTerpilih.getJadwal().isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(dokterYangTerpilih.getJadwal().size());

            jadwal = dokterYangTerpilih.getJadwal().get(randomIndex);
        } else {
            new Spa().setComponent( new AmbilAntrian().getComponent("Antrian tidak di temukan"));
            return;
        }

        assert jadwal != null;
        AntrianEntity antrian = antrianModel.buatAntrian( poliYangDiPilih.getNamaPoli(), namaDokter, pasien.getNama(), jadwal.getJadwalhari(), jadwal.getJadwalJam());
        pasienModel.setPasienDanCommit( pasien, antrian );
        poliModel.setAntrianDanCommit( poliYangDiPilih, antrian );

        new Spa().setComponent( new Dashboard().getComponent("Nomer antrian : " + antrian.getNomerAntrian()
                + ", Hari : " + antrian.getJadwalHari()
                + ", Jam : " + antrian.getJadwalJam()));
    }
}