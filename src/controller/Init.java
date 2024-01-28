package controller;

import model.*;

public class Init {
    protected PasienModel pasienModel;
    protected AntrianModel antrianModel;
    protected PoliModel poliModel;
    protected DokterModel dokterModel;
    protected JadwalModel jadwalModel;
    protected AdminModel adminModel;
    protected TransaksiModel transaksiModel;

    public Init() {
        pasienModel = new PasienModel();
        antrianModel = new AntrianModel();
        poliModel = new PoliModel();
        dokterModel = new DokterModel();
        jadwalModel = new JadwalModel();
        adminModel = new AdminModel();
        transaksiModel = new TransaksiModel();
    }
}