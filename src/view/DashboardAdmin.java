package view;

import controller.*;
import entity.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DashboardAdmin {
    private static Scanner scanner = new Scanner(System.in);
    private static PasienController pasienController = new PasienController();
    private static AntrianController antrianController = new AntrianController();
    private static PoliController poliController = new PoliController();
    private static DokterController dokterController = new DokterController();
    private static TransaksiController transaksiController = new TransaksiController();
    private static JadwalController jadwalController = new JadwalController();

    private static AdminEntity token;

    public static void view(String flashMessage, AdminEntity token){
        while(true){
            if(token != null) {
                DashboardAdmin.token = token;
            }

            System.out.println("Dashboard");
            if(flashMessage != ""){
                System.out.println("-----------------");
                System.out.println("Flash message : " + flashMessage);
                System.out.println("------------------");
            }

            System.out.println("1. Pasien baru");
            System.out.println("2. Ambil antrian");
            System.out.println("3. Tambah list poli");
            System.out.println("4. Buat detail transaksi");
            System.out.println("5. Tambah dokter");
            System.out.println("6. Tambah jadwal praktek dokter");
            System.out.println("7. Lihat jadwal praktek dokter");
            System.out.println("8. Update jadwal praktek dokter");
            System.out.println("9. Logout");

            System.out.print("Masukan pilihan : ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if(pilihan == 1){
                DashboardAdmin.tampilanPasienBaru("");
            }else if(pilihan == 2){
                DashboardAdmin.tampilanAmbilAntrian("");
            }else if(pilihan == 3){
                DashboardAdmin.tampilanTambahListPoli("");
            }else if(pilihan == 4){
                DashboardAdmin.tampilanBuatDetailTransaksi("");
            }else if(pilihan == 5){
                DashboardAdmin.tampilanTambahDokter("");
            }else if(pilihan == 6){
                DashboardAdmin.tampilanTambahDataJadwalPraktekDokter("");
            }else if(pilihan == 7){
                DashboardAdmin.tampilanLihatDataJadwalPraktekDokter("");
            }else if(pilihan == 8){
                DashboardAdmin.tampilanUpdateDataJadwalPraktekDokter("");
            }else if(pilihan == 9){
                break;
            }else{
                System.out.println("Format tidak di temukan");
            }

        }
    }

    public static void tampilanPasienBaru(String flashMessage){
        System.out.println("Pasien baru");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        System.out.println("Masukan nama anda : ");
        String nama = scanner.nextLine();

        System.out.println("Masukan alamat anda : ");
        String alamat = scanner.nextLine();

        System.out.println("Masukan kelamin anda : ");
        String kelamin = scanner.nextLine();

        System.out.println("Masukan tempat tanggal lahir anda : ");
        String tempatTglLahir = scanner.nextLine();

        System.out.println("Masukan nik anda : ");
        String nik = scanner.nextLine();

        System.out.println("Masukan nomor bpjs anda : ");
        String nomerBpjs = scanner.nextLine();


        pasienController.tambahPasien(nama, alamat, kelamin.charAt(0), tempatTglLahir, nik, nomerBpjs);
    }

    public static void tampilanAmbilAntrian(String flashMessage){
        System.out.println("Ambil antrian");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        System.out.println("Masukan nik anda : ");
        String nik = scanner.nextLine();


        System.out.println("Pilih id poli : cth(1)");
        ArrayList<PoliEntity> getDataDariPoli = poliController.lihatSemuaPoli();

        for(PoliEntity poli : getDataDariPoli){
            System.out.println( poli.getId() + ". " + poli.getNamaPoli() );
        }

        int pilihPoli = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukan nomor bpjs pasien : ");
        String nomerBpjs = scanner.nextLine();

        ArrayList<DokterEntity> listDokterBerdasarkanPoli = PoliController.lihatDokterBerdasarkanPoli( pilihPoli );


        if(listDokterBerdasarkanPoli != null) {

            System.out.println("pilih id dokter yang menangani : cth (1)");
            for (DokterEntity dokter : listDokterBerdasarkanPoli) {
                System.out.println(dokter.getId() + ". " + dokter.getNama());
            }
            int dokterYangTerpilih = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Masukan hari terserah dulu ntar pakai btn gui");
            String hari = scanner.nextLine();

            System.out.println("Masukan jam terserah dulu ntar pakai btn gui");
            String jam = scanner.nextLine();

//            antrianController.ambilAntrian(nik, nomerBpjs, pilihPoli, dokterYangTerpilih, hari, jam);

        }
    }


    public static void tampilanBuatDetailTransaksi(String flashMessage){
        System.out.println("Buat detail transaksi");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        System.out.println("Masukan nomer antrian : ");
        int nomerAntrian = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukan uang pembayaran : ");
        int uangPembayaran = scanner.nextInt();
        scanner.nextLine();

//        transaksiController.buatDetailTransaksi(nomerAntrian, DashboardAdmin.token, uangPembayaran);
    }

    public static void tampilanTambahDokter(String flashMessage){
        System.out.println("Tambah dokter");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        System.out.println("Masukan nama dokter : ");
        String nama = scanner.nextLine();

        System.out.println("Pilih spesialisasi : cth(1)");
        ArrayList<PoliEntity> listPoli = poliController.lihatSemuaPoli();

        for(PoliEntity poli : listPoli){
            System.out.println(poli.getId() + ". " + poli.getNamaPoli());
        }
        int pilihPoli = scanner.nextInt();
        scanner.nextLine();

        dokterController.tambahDokter(nama, pilihPoli);
    }

    public static void tampilanCetakDetailTransaksi(TransaksiEntity transaksi){
        System.out.println("Cetak detail transaksi");
        System.out.println("-------------------");
        System.out.println("TAMPILAN CETAK DETAIL");

        System.out.println("Nama pasien : " + transaksi.getNamaPasien());
        System.out.println("Admin       : " + transaksi.getAdminPengelola());
        System.out.println("Waktu       : " + transaksi.getTimeStamp());
    }

    public static void tampilanTambahListPoli(String flashMessage){
        System.out.println("Tambah list poli");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        System.out.print("Masukan nama poli : ");
        String namaPoliYangBaru = scanner.nextLine();

        poliController.tambahPoli(namaPoliYangBaru);
    }

    public static void tampilanTambahDataJadwalPraktekDokter(String flashMessage){
        System.out.println("Tambah data jadwal praktek dokter");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        ArrayList<DokterEntity> listDokter =  dokterController.lihatSemuaDokter();
        for(DokterEntity dokter : listDokter){
            System.out.println(dokter.getId() + ". " + dokter.getNama());
        }
        System.out.println("Masukan id dokter : ");
        int idDokter = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukan jadwal hari : ");
        String hari = scanner.nextLine();

        System.out.println("Masukan jadwal jam : ");
        String jam = scanner.nextLine();

        jadwalController.tambahJadwalDokter(hari, jam, idDokter);
    }

    public static void tampilanLihatDataJadwalPraktekDokter(String flashMessage){
        System.out.println("Lihat data jadwal praktek dokter");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        ArrayList<DokterEntity> listDokter = dokterController.lihatSemuaDokter();
        for(DokterEntity dokter : listDokter){
            System.out.println("Nama dokter : " + dokter.getNama());

            ArrayList<JadwalEntity> listJadwal = dokter.getJadwal();
            for(JadwalEntity jadwal : listJadwal){
                System.out.println("Hari : " + jadwal.getJadwalhari());
                System.out.println("Jam  : " + jadwal.getJadwalJam());
            }

            System.out.println("Spesialis   : " + dokter.getSpesialis());
        }
    }

    public static void tampilanUpdateDataJadwalPraktekDokter(String flashMessage){
        System.out.println("Update data jadwal praktek dokter");
        if(flashMessage != ""){
            System.out.println("-----------------");
            System.out.println("Flash message : " + flashMessage);
            System.out.println("------------------");
        }

        ArrayList<DokterEntity> listDokter =  dokterController.lihatSemuaDokter();
        for(DokterEntity dokter : listDokter){
            System.out.println(dokter.getId() + ". " + dokter.getNama());

            for(JadwalEntity jadwal : dokter.getJadwal()){
                System.out.println(jadwal.getId() + ". hari : "
                        + jadwal.getJadwalhari() + ", jam : "
                        + jadwal.getJadwalJam());
            }

        }
        System.out.println("Masukan id dokter : ");
        int idDokter = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukan id jadwal dokter : ");
        int idJadwalDokter = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukan jadwal hari baru : ");
        String hari = scanner.nextLine();

        System.out.println("Masukan jadwal jam baru : ");
        String jam = scanner.nextLine();

        jadwalController.updateJadwalDokter(idJadwalDokter, hari, jam, idDokter);
    }
}