package view.pages;

import controller.DokterController;
import entity.DokterEntity;
import entity.JadwalEntity;
import view.Spa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LihatJadwalDokter extends Spa {
    private final DokterController dokterController = new DokterController();
    private final JPanel form = new JPanel();
    private JButton kembaliButton;

    public JPanel getComponent(String flashMessage) {
        if (!flashMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, flashMessage);
        }

        form.setLayout(new BorderLayout());

        ArrayList<DokterEntity> listDokter = dokterController.lihatSemuaDokter();

        String[] columnNames = {"Nama Dokter", "Hari", "Jam", "Spesialis"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (DokterEntity dokter : listDokter) {
            for (JadwalEntity jadwal : dokter.getJadwal()) {
                model.addRow(new Object[]{
                        dokter.getNama(),
                        jadwal.getJadwalhari(),
                        jadwal.getJadwalJam(),
                        dokter.getSpesialis()
                });
            }
        }

        JScrollPane scrollPane = new JScrollPane(table);
        form.add(scrollPane, BorderLayout.CENTER);

        // Adding back button
        kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Spa().setComponent(new Dashboard().getComponent(""));

            }
        });
        form.add(kembaliButton, BorderLayout.SOUTH);

        return form;
    }
}
