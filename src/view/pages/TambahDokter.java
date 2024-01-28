package view.pages;

import controller.DokterController;
import controller.PoliController;
import entity.PoliEntity;
import view.Spa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TambahDokter extends Spa {
    private final DokterController dokterController = new DokterController();
    private final PoliController poliController = new PoliController();
    private final JPanel form = new JPanel();
    private final JTextField namaDokterField = new JTextField(20);
    private JComboBox<String> poliComboBox;
    private JButton kembaliButton;
    private JButton tambahDokterButton;
    private int pilihPoli = -1;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        addFormField(namaDokterField, constraints);

        JLabel poliLabel = new JLabel("Pilih spesialisasi:");
        constraints.gridx = 0;
        constraints.gridy++;
        poliLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(poliLabel, constraints);

        poliComboBox = new JComboBox<>();
        populatePoliComboBox();
        constraints.gridx = 1;
        form.add(poliComboBox, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy++;
        this.kembali(kembaliButton);
        form.add(kembaliButton, constraints);

        tambahDokterButton = new JButton("Tambah Dokter");
        constraints.gridx = 1;
        this.eventTambahDokterButton();
        form.add(tambahDokterButton, constraints);

        return form;
    }

    private void addFormField(JTextField textField, GridBagConstraints constraints) {
        JLabel formLabel = new JLabel("Masukkan nama dokter:");
        constraints.gridx = 0;
        constraints.gridy++;
        formLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(formLabel, constraints);

        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 1;
        constraints.gridy++;
        form.add(textField, constraints);
    }

    private void populatePoliComboBox() {
        ArrayList<PoliEntity> listPoli = poliController.lihatSemuaPoli();
        for (PoliEntity poli : listPoli) {
            poliComboBox.addItem(poli.getId() + ". " + poli.getNamaPoli());
        }
    }

    private void eventTambahDokterButton() {
        tambahDokterButton.addActionListener(e -> {
            String namaDokter = namaDokterField.getText();
            String selectedPoli = (String) poliComboBox.getSelectedItem();
            assert selectedPoli != null;
            pilihPoli = Integer.parseInt(selectedPoli.split("\\. ")[0]);

            dokterController.tambahDokter(namaDokter, pilihPoli);
        });
    }
}