package controller;

import entity.AdminEntity;
import helper.HashPassword;
import view.Spa;
import view.pages.Dashboard;
import view.pages.Login;

import java.util.Objects;

public class LoginAdminController extends Init {
    public void viewLogin(){
        new Spa().setComponent( new Login().getComponent("") );
    }

    public void requestLogin(String username, String password) {
        AdminEntity admin = adminModel.cariAdmin(username);

        if (admin == null) {
            new Spa().setComponent( new Login().getComponent("Admin tidak di temukan") );
            return;
        }

        password = HashPassword.encode(password);
        if (Objects.equals(admin.getUsername(), username)
                && Objects.equals(admin.getPassword(), password)) {

            System.out.println("loginController admin : " + admin.getUsername());
            new Spa().setComponent( new Dashboard().getComponent("selamat datang kembali " + admin.getUsername()));
            return;
        }

        new Spa().setComponent( new Login().getComponent("Username / Password salah") );
    }
}