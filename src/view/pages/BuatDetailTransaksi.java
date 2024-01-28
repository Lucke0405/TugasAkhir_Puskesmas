package view.pages;

import controller.TransaksiController;
import view.Spa;

import javax.swing.*;
import java.awt.*;

public class BuatDetailTransaksi extends Spa {
    private final TransaksiController transaksiController = new TransaksiController();
    private final JPanel form = new JPanel();
    private JTextField nomerAntrianField = new JTextField(20);
    private JTextField uangPembayaranField = new JTextField(20);
    private JTextField namaAdminField = new JTextField(20);
    private JButton buatTransaksiButton;
    private JButton kembaliButton;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        addFormField("Masukkan nomer antrian:", nomerAntrianField, constraints);
        addFormField("Masukkan nama admin:", namaAdminField, constraints);
        addFormField("Masukkan uang pembayaran:", uangPembayaranField, constraints);

        buatTransaksiButton = new JButton("Buat Transaksi");
        constraints.gridx = 1;
        constraints.gridy = 3;
        eventBuatTransaksiButton();
        form.add(buatTransaksiButton, constraints);

        kembaliButton = new JButton("Back");
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.kembali(kembaliButton);
        form.add(kembaliButton, constraints);

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

    private void eventBuatTransaksiButton() {
        buatTransaksiButton.addActionListener(e -> {
            try {
                int nomerAntrian = Integer.parseInt(nomerAntrianField.getText());
                int uangPembayaran = Integer.parseInt(uangPembayaranField.getText());
                String namaAdmin = namaAdminField.getText();

                transaksiController.buatDetailTransaksi(nomerAntrian, namaAdmin, uangPembayaran);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Masukkan angka yang valid.");
            }
        });
    }
}
