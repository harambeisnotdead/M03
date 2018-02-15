package dam.m03.uf5.grupo8.tpv.vista;

import javax.swing.*;

public class GUIListaYTicket extends JFrame {
    private JTextArea pantalla;
    
    public GUIListaYTicket() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        pantalla = new JTextArea();
        pantalla.setLineWrap(true);
        pantalla.setWrapStyleWord(true);
        pantalla.setEditable(false);
        this.add(pantalla);
        this.setVisible(true);
        this.pack();
        this.setSize(500, 600);
    }
    
    public void setListado(String listado) { this.pantalla.setText(listado); }
}
