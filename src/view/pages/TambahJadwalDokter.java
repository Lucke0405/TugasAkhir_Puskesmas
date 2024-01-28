package view.pages;

import controller.DokterController;
import controller.JadwalController;
import entity.DokterEntity;
import view.Spa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TambahJadwalDokter extends Spa {
    private final JadwalController jadwalController = new JadwalController();
    private final DokterController dokterController = new DokterController();
    private final JPanel form = new JPanel();
    private JComboBox<String> dokterComboBox;
    private JTextField hariField;
    private JTextField jamField;
    private JButton kembaliButton;
    private JButton tambahJadwalButton;
    private int pilihDokter = -1;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel dokterLabel = new JLabel("Pilih dokter:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dokterLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(dokterLabel, constraints);

        dokterComboBox = new JComboBox<>();
        populateDokterComboBox();
        constraints.gridx = 1;
        form.add(dokterComboBox, constraints);

        JLabel hariLabel = new JLabel("Masukkan jadwal hari:");
        constraints.gridx = 0;
        constraints.gridy++;
        hariLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(hariLabel, constraints);

        hariField = new JTextField(20);
        constraints.gridx = 1;
        form.add(hariField, constraints);

        JLabel jamLabel = new JLabel("Masukkan jadwal jam:");
        constraints.gridx = 0;
        constraints.gridy++;
        jamLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(jamLabel, constraints);

        jamField = new JTextField(20);
        constraints.gridx = 1;
        form.add(jamField, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy++;
        this.kembali(kembaliButton);
        form.add(kembaliButton, constraints);

        tambahJadwalButton = new JButton("Tambah Jadwal");
        constraints.gridx = 1;
        this.eventTambahJadwalButton();
        form.add(tambahJadwalButton, constraints);

        return form;
    }

    private void populateDokterComboBox() {
        ArrayList<DokterEntity> listDokter = dokterController.lihatSemuaDokter();
        for (DokterEntity dokter : listDokter) {
            dokterComboBox.addItem(dokter.getId() + ". " + dokter.getNama());
        }
    }

    private void eventTambahJadwalButton() {
        tambahJadwalButton.addActionListener(e -> {
            String selectedDokter = (String) dokterComboBox.getSelectedItem();
            assert selectedDokter != null;
            pilihDokter = Integer.parseInt(selectedDokter.split("\\. ")[0]);
            String hari = hariField.getText();
            String jam = jamField.getText();

            jadwalController.tambahJadwalDokter(hari, jam, pilihDokter);
        });
    }
}
