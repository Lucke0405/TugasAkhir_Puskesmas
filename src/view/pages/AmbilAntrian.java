package view.pages;

import controller.AntrianController;
import controller.PoliController;
import entity.DokterEntity;
import entity.PoliEntity;
import view.Spa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AmbilAntrian extends Spa {
    private AntrianController antrianController = new AntrianController();
    private PoliController poliController = new PoliController();
    private JTextField nikField;
    private JComboBox<String> poliComboBox;
    private JTextField nomorBpjsField;
    private JComboBox<String> dokterComboBox;
    private JTextField hariField;
    private JButton kembaliButton;
    private JButton buatAntrianButton;
    private int pilihPoli = -1;
    private int pilihDokter = -1;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Ambil Antrian");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        form.add(titleLabel, constraints);

        constraints.gridwidth = 1;

        if (!flashMessage.isEmpty()) {
            JLabel flashLabel = new JLabel("Flash message: " + flashMessage);
            flashLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            constraints.gridx = 0;
            constraints.gridy = 1;
            form.add(flashLabel, constraints);
        }

        JLabel nikLabel = new JLabel("NIK:");
        nikLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 0;
        constraints.gridy = 2;
        form.add(nikLabel, constraints);

        nikField = new JTextField(20);
        nikField.setFont(new Font("Arial", Font.PLAIN, 15));
        nikField.setPreferredSize(new Dimension(200, 30));
        constraints.gridx = 1;
        constraints.gridy = 2;
        form.add(nikField, constraints);

        JLabel poliLabel = new JLabel("Poli:");
        poliLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 0;
        constraints.gridy = 3;
        form.add(poliLabel, constraints);

        poliComboBox = new JComboBox<>();
        System.out.println("1");
        for (PoliEntity poli : poliController.lihatSemuaPoli()) {
            poliComboBox.addItem(poli.getId() + ". " + poli.getNamaPoli());
        }
        constraints.gridx = 1;
        constraints.gridy = 3;
        form.add(poliComboBox, constraints);

        JLabel nomorBpjsLabel = new JLabel("Nomor BPJS:");
        nomorBpjsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 0;
        constraints.gridy = 4;
        form.add(nomorBpjsLabel, constraints);

        nomorBpjsField = new JTextField(20);
        nomorBpjsField.setFont(new Font("Arial", Font.PLAIN, 15));
        nomorBpjsField.setPreferredSize(new Dimension(200, 30));
        constraints.gridx = 1;
        constraints.gridy = 4;
        form.add(nomorBpjsField, constraints);

        JLabel dokterLabel = new JLabel("Dokter:");
        dokterLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 0;
        constraints.gridy = 5;
        form.add(dokterLabel, constraints);

        dokterComboBox = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 5;
        form.add(dokterComboBox, constraints);

        eventClickPoli();

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy = 7;
        this.kembali(kembaliButton);

        form.add(kembaliButton, constraints);

        buatAntrianButton = new JButton("Buat Antrian");
        constraints.gridx = 1;
        constraints.gridy = 7;
        eventBuatAntrianButton();
        form.add(buatAntrianButton, constraints);

        return form;
    }

    private void eventClickPoli(){
        poliComboBox.addActionListener(e -> {
            String selectedPoli = (String) poliComboBox.getSelectedItem();

            String[] poliParts = selectedPoli.split("\\. ");
            pilihPoli = Integer.parseInt( poliParts[0] );

            updateDokterComboBox(selectedPoli);
        });
    }

    private void updateDokterComboBox(String selectedPoli) {
        dokterComboBox.removeAllItems();

        int selectedPoliId = Integer.parseInt(selectedPoli.split("\\. ")[0]);
        ArrayList<DokterEntity> listDokterBerdasarkanPoli = PoliController.lihatDokterBerdasarkanPoli(selectedPoliId);

        for (DokterEntity dokter : listDokterBerdasarkanPoli) {
            dokterComboBox.addItem(dokter.getId() + ". " + dokter.getNama());
        }

        updateJadwalComboBox();
    }

    private void updateJadwalComboBox(){
        dokterComboBox.addActionListener(e -> {
            String selectedPoli = (String) dokterComboBox.getSelectedItem();

            String[] DokterParts = selectedPoli.split("\\. ");
            pilihDokter = Integer.parseInt( DokterParts[0] );
        });
    }

    private void eventBuatAntrianButton(){
        buatAntrianButton.addActionListener(e -> {
            String nik = nikField.getText();
            String nomerBpjs = nomorBpjsField.getText();

            antrianController.ambilAntrian(nik, nomerBpjs, pilihPoli, pilihDokter);
        });
    }
}