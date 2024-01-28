package controller;

import view.Spa;
import view.pages.Dashboard;
import view.pages.PasienBaru;

public class PasienController extends Init {
    public void tambahPasien(String nama, String alamat, Character
            kelamin, String tempatTglLahir, String nik, String nomorBpjs){

        if(nama == null && alamat == null
            && kelamin == null && tempatTglLahir == null
                && nik == null && nomorBpjs == null){

            new Spa().setComponent( new PasienBaru().getComponent("Kolom tidak boleh kosong"));
            return;
        }

        if (!String.valueOf(kelamin).equalsIgnoreCase("L")
                && !String.valueOf(kelamin).equalsIgnoreCase("P")) {

            new Spa().setComponent( new PasienBaru().getComponent("Kelamin hanya ( L / l ) & ( P / p )"));
            return;
        }

        if( pasienModel.cariPasienBerdasarkanNik(nik) != null ){
            new Spa().setComponent( new PasienBaru().getComponent("Nik sudah terdaftar"));
            return;
        }

        pasienModel.tambahPasien(nama, alamat, kelamin, tempatTglLahir, nik, nomorBpjs);
        new Spa().setComponent( new Dashboard().getComponent("Pasien sudah di tambahkan"));
    }

}