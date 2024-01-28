package view.pages;

import controller.PasienController;
import view.Spa;

import javax.swing.*;
import java.awt.*;

public class PasienBaru extends Spa {
    private final PasienController pasienController = new PasienController();
    private final JPanel form = new JPanel();
    private final JTextField namaField = new JTextField(20);
    private final JTextField alamatField = new JTextField(20);
    private final JTextField kelaminField = new JTextField(20);
    private final JTextField tempatTglLahirField = new JTextField(20);
    private final JTextField nikField = new JTextField(20);
    private final JTextField nomerBpjsField = new JTextField(20);
    private JButton kembaliButton;
    private JButton buatPasienButton;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        addFormField("Masukan nama anda:", namaField, constraints);
        addFormField("Masukan alamat anda:", alamatField, constraints);
        addFormField("Masukan kelamin anda:", kelaminField, constraints);
        addFormField("Masukan tempat tanggal lahir anda:", tempatTglLahirField, constraints);
        addFormField("Masukan nik anda:", nikField, constraints);
        addFormField("Masukan nomor bpjs anda:", nomerBpjsField, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy = 7;
        this.kembali(kembaliButton);

        form.add(kembaliButton, constraints);

        buatPasienButton = new JButton("Buat Pasien");
        constraints.gridx = 1;
        constraints.gridy = 7;
        eventBuatPasienButton();
        form.add(buatPasienButton, constraints);

        return form;
    }

    private void addFormField(String label, JTextField textField, GridBagConstraints constraints) {
        JLabel formLabel = new JLabel(label);
        constraints.gridx = 0;
        constraints.gridy++;
        formLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(formLabel, constraints);


        constraints.gridx = 1;
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(textField, constraints);
    }

    private void eventBuatPasienButton(){
        buatPasienButton.addActionListener(e -> {
            String nama = namaField.getText();
            String alamat = alamatField.getText();
            char kelamin = kelaminField.getText().charAt(0);
            String tempatTglLahir = tempatTglLahirField.getText();
            String nik = nikField.getText();
            String nomerBpjs = nomerBpjsField.getText();

            pasienController.tambahPasien(nama, alamat, kelamin, tempatTglLahir, nik, nomerBpjs);
        });
    }
}
