package model;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import entity.TransaksiEntity;
import java.util.ArrayList;

public class AdminModel extends Model<AdminEntity>{
    public AdminModel() {
        super("./src/database/admin.json");
    }

    @Override
    protected void loadData() {
        dataList = modelJSON.readFromFile(new TypeToken<ArrayList<AdminEntity>>() {}.getType());
    }

    public AdminEntity cariAdmin(String username) {
        for (AdminEntity admin : dataList){
            if (admin.getUsername().equals( username )) {
                return admin;
            }
        }

        return null;
    }

    public void tambahTransaksi(TransaksiEntity transaksi, String usernameAdmin){
        AdminEntity admin = cariAdmin(usernameAdmin);
        System.out.println("awdawd" + admin.getUsername() + " " + usernameAdmin);
        admin.setTransaksi(transaksi);

        System.out.println("last model transaksi");
        commitData();
    }
}