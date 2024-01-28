package view.pages;

import controller.PoliController;
import view.Spa;

import javax.swing.*;
import java.awt.*;

public class TambahListPoli extends Spa {
    private final PoliController poliController = new PoliController();
    private final JPanel form = new JPanel();
    private final JTextField namaPoliField = new JTextField(20);
    private JButton kembaliButton;
    private JButton tambahPoliButton;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        addFormField(namaPoliField, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.kembali(kembaliButton);
        form.add(kembaliButton, constraints);

        tambahPoliButton = new JButton("Tambah Poli");
        constraints.gridx = 1;
        constraints.gridy = 2;
        eventTambahPoliButton();
        form.add(tambahPoliButton, constraints);

        return form;
    }

    private void addFormField(JTextField textField, GridBagConstraints constraints) {
        JLabel formLabel = new JLabel("Masukkan nama poli:");
        constraints.gridx = 0;
        constraints.gridy++;
        formLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        form.add(formLabel, constraints);

        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        constraints.gridx = 1;
        constraints.gridy--;
        form.add(textField, constraints);
    }

    private void eventTambahPoliButton() {
        tambahPoliButton.addActionListener(e -> {
            String namaPoli = namaPoliField.getText();
            poliController.tambahPoli(namaPoli);
        });
    }
}
