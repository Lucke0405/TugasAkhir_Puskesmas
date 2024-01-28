package view;

import entity.AdminEntity;
import view.layout.Frame;
import view.pages.Dashboard;

import javax.swing.*;
import java.util.Scanner;

public class Spa {
    private final Frame frame;
    protected final Scanner scanner = new Scanner(System.in);

    public Spa() {
        frame = Frame.getInstance();
    }

    public void setComponent(JPanel page){
        frame.setContainer( page );
    }

    protected void href(JButton btnHref, JPanel component){
        btnHref.addActionListener((event) -> {
            setComponent( component );
        });
    }

    protected void kembali(JButton btn){
        btn.addActionListener((event) -> {
            setComponent( new Dashboard().getComponent("") );
        });
    }
}