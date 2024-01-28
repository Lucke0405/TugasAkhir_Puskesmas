package entity;

import java.util.ArrayList;

public class AdminEntity {
    private String username;
    private String password;
    private ArrayList<TransaksiEntity> transaksi;

    public AdminEntity(){
        transaksi = new ArrayList<TransaksiEntity>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setTransaksi(TransaksiEntity transaksi) {
        this.transaksi.add(transaksi);
    }
}