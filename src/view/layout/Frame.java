package view.layout;

import helper.CekUkuranLayar;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Frame {
    private static Frame instance;
    private final JFrame frame;

    private Frame() {
        frame = new JFrame("Tugas Akhir");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        HashMap<String, Integer> size = CekUkuranLayar.ukur(0.60);

        frame.setSize( size.get("width"), size.get("height") );
        frame.setLocationRelativeTo(null);
    }

    public static synchronized Frame getInstance() {
        if (instance == null) instance = new Frame();
        return instance;
    }

    public void setContainer(JPanel component) {
        frame.getContentPane().removeAll();
        frame.add(component, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}