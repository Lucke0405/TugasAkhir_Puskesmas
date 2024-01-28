package view.pages;

import controller.DokterController;
import controller.JadwalController;
import entity.DokterEntity;
import entity.JadwalEntity;
import view.Spa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateJadwalDokter extends Spa {
    private final DokterController dokterController = new DokterController();
    private final JadwalController jadwalController = new JadwalController();
    private final JPanel form = new JPanel();
    private JComboBox<String> dokterComboBox;
    private JComboBox<String> jadwalComboBox;
    private JTextField hariField;
    private JTextField jamField;
    private JButton kembaliButton;
    private JButton updateJadwalButton;
    private int selectedDokterId = -1;

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

        JLabel jadwalLabel = new JLabel("Pilih jadwal:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        jadwalLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(jadwalLabel, constraints);

        jadwalComboBox = new JComboBox<>();
        constraints.gridx = 1;
        form.add(jadwalComboBox, constraints);

        JLabel hariLabel = new JLabel("Masukkan jadwal hari baru:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        hariLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(hariLabel, constraints);

        hariField = new JTextField(20);
        constraints.gridx = 1;
        form.add(hariField, constraints);

        JLabel jamLabel = new JLabel("Masukkan jadwal jam baru:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        jamLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(jamLabel, constraints);

        jamField = new JTextField(20);
        constraints.gridx = 1;
        form.add(jamField, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.kembali(kembaliButton);
        form.add(kembaliButton, constraints);

        updateJadwalButton = new JButton("Update Jadwal");
        constraints.gridx = 1;
        this.eventUpdateJadwalButton();
        form.add(updateJadwalButton, constraints);

        return form;
    }

    private void populateDokterComboBox() {
        ArrayList<DokterEntity> listDokter = dokterController.lihatSemuaDokter();
        for (DokterEntity dokter : listDokter) {
            dokterComboBox.addItem(dokter.getId() + ". " + dokter.getNama());
        }

        dokterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDokter = (String) dokterComboBox.getSelectedItem();
                assert selectedDokter != null;
                selectedDokterId = Integer.parseInt(selectedDokter.split("\\. ")[0]);
                populateJadwalComboBox(selectedDokterId);
            }
        });
    }

    private void populateJadwalComboBox(int dokterId) {
        jadwalComboBox.removeAllItems();
        ArrayList<JadwalEntity> listJadwal = dokterController.cariJadwalBerdasarkanDokter(dokterId);
        for (JadwalEntity jadwal : listJadwal) {
            jadwalComboBox.addItem(jadwal.getId() + ". hari: " + jadwal.getJadwalhari() + ", jam: " + jadwal.getJadwalJam());
        }
    }

    private void eventUpdateJadwalButton() {
        updateJadwalButton.addActionListener(e -> {
            if (selectedDokterId != -1) {
                String selectedJadwal = (String) jadwalComboBox.getSelectedItem();
                assert selectedJadwal != null;
                int selectedJadwalId = Integer.parseInt(selectedJadwal.split("\\. ")[0]);
                String newHari = hariField.getText();
                String newJam = jamField.getText();

                jadwalController.updateJadwalDokter(selectedJadwalId, newHari, newJam, selectedDokterId);
            }
        });
    }
}