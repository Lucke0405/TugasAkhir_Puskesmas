package view.pages;

import entity.AdminEntity;
import view.Spa;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Dashboard extends Spa {
    JPanel form;
    JButton pasienBaru;
    JButton ambilAntrian;
    JButton tambahPoli;
    JButton buatTransaksi;
    JButton lihatJadwalDokter;
    JButton tambahDokter;
    JButton tambahJadwalDokter;
    JButton updateJadwalDokter;
    JButton logout;

    public JPanel getComponent(String flashMessage) {
        if (!Objects.equals(flashMessage, "")) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(223, 223, 223));

        pasienBaru = addButton("Pasien Baru", 0, 0);
        this.href(pasienBaru, new PasienBaru().getComponent(""));

        ambilAntrian = addButton("Ambil Antrian", 0, 1);
        this.href(ambilAntrian, new AmbilAntrian().getComponent(""));

        tambahPoli = addButton("Tambah List Poli", 1, 0);
        this.href(tambahPoli, new TambahListPoli().getComponent(""));

        buatTransaksi = addButton("Buat Transaksi", 1, 1);
        this.href(buatTransaksi, new BuatDetailTransaksi().getComponent(""));

        tambahDokter = addButton("Tambah dokter", 1, 2);
        this.href(tambahDokter, new TambahDokter().getComponent(""));

        lihatJadwalDokter = addButton("Lihat Jadwal Dokter", 2, 0);
        this.href(lihatJadwalDokter, new LihatJadwalDokter().getComponent(""));

        tambahJadwalDokter = addButton("Tambah Jadwal Dokter", 2, 1);
        this.href(tambahJadwalDokter, new TambahJadwalDokter().getComponent(""));

        updateJadwalDokter = addButton("Update jadwal Dokter", 3, 0);
        this.href(updateJadwalDokter, new UpdateJadwalDokter().getComponent(""));

        logout = addButton("Logout", 4, 0);
        requestLogout(logout);

        return form;
    }

    private JButton addButton(String buttonText, int gridx, int gridy) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.insets = new Insets(10, 10, 10, 10);

        form.add(button, constraints);
        return button;
    }

    private void requestLogout(JButton btn){
        btn.addActionListener((event) -> {
            try {
                setComponent( new Login().getComponent("") );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}