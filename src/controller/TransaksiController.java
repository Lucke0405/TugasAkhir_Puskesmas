package controller;

import entity.AntrianEntity;
import entity.PasienEntity;
import entity.TransaksiEntity;
import view.Spa;
import view.pages.BuatDetailTransaksi;
import view.pages.Dashboard;

public class TransaksiController extends Init {
    public void buatDetailTransaksi(int nomerAntrian, String namaAdmin, int uangBayaran){
        System.out.println("Masuk controller");
        if(nomerAntrian == -1 && uangBayaran == -1 && namaAdmin == null){
            new Spa().setComponent( new BuatDetailTransaksi().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        AntrianEntity cekAntrian = antrianModel.cariAntrianBerdasarkanNomer(nomerAntrian);

        if(cekAntrian == null){
            new Spa().setComponent( new BuatDetailTransaksi().getComponent("Antrian tidak di temukan"));
            return;
        }

        if( adminModel.cariAdmin(namaAdmin) == null){
            new Spa().setComponent( new BuatDetailTransaksi().getComponent("Admin tidak di temukan"));
            return;
        }

        String namaPasien = cekAntrian.getNamaPasien();

        PasienEntity pasien = pasienModel.cariPasienBerdasarkanNama(namaPasien);
        TransaksiEntity transaksi = transaksiModel.buatTransaksi(pasien.getNama(), namaAdmin, uangBayaran);
        // salah
        adminModel.tambahTransaksi(transaksi, namaAdmin);
        System.out.println("pasienModel tambahTransaksi");
        pasienModel.tambahTransaksi(transaksi, namaPasien);

        System.out.println("1");
        pasienModel.hapusAntrian(pasien);
        System.out.println("2");
        poliModel.hapusAntrian(cekAntrian.getNomerAntrian());
        System.out.println("3");
        antrianModel.hapusAntrian(cekAntrian.getNomerAntrian());

        new Spa().setComponent( new Dashboard().getComponent("Detail transaksi bisa di liat di database"));
    }
}