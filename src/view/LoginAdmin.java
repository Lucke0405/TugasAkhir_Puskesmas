package view;

import controller.LoginAdminController;

import java.util.Scanner;

public class LoginAdmin {
    private static Scanner scanner = new Scanner(System.in);
    private static LoginAdminController adminController = new LoginAdminController();

    public static void view(String flashMessage) {
        while (true) {
            System.out.println(" ----- Home ------");

            if(flashMessage != ""){
                System.out.println("------------");
                System.out.println("pesan : " + flashMessage);
                System.out.println("------------");
            }

            System.out.println("1. Login admin");
            System.out.println("2. Keluar program");

            System.out.print("Masukan pilihan : ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Username : ");
                String username = scanner.nextLine();

                System.out.print("Password : ");
                String password = scanner.nextLine();

                adminController.requestLogin(username, password);

            } else if (pilihan == 2) {
                break;
            } else {
                System.out.println("Format tidak ditemukan");
            }
        }
    }

    private void tampilanAdmin(){
        while ( true ){
            System.out.println("1. Login admin");
            System.out.println("2. Keluar");

            int pilihan = scanner.nextInt();

            if(pilihan == 1){
                
            }else if(pilihan == 2){
                break;
            }else{
                System.out.println("Format tidak di temukan");
            }
        }
    }
}




//        form.setBackground( new Color(223, 223, 223));
//
//        username = Input.input("Username : ", "text", 12, 23);
//        password = Input.input("Password : ", "password", 14, 50);
//
//        pindahRegister = Button.btn("belum punya akun?", 233, 233, 233);
//        this.href( pindahRegister, new Dashboard().getComponent("") );
//
//        loginBtn = Button.btn("Login", 233, 233, 233);
//        requestLogin(loginBtn);
//
////        form.setLayout( new GridLayout(3, 1) );
//        form.add(username);
//        form.add(password);
//
//        JPanel wrapBtn = new JPanel( new GridBagLayout() );
//
//        wrapBtn.add(pindahRegister);
//        wrapBtn.add(loginBtn);
//
//        form.add(wrapBtn);