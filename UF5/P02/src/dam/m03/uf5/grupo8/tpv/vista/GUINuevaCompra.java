package dam.m03.uf5.grupo8.tpv.vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUINuevaCompra extends JFrame {

    private JButton anadir;
    private JButton finalizar;
    private JTextField codigo;

    public GUINuevaCompra() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        JPanel ventana = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel lblCodigo = new JLabel("Codigo producto:");
        codigo = new JTextField();
        anadir = new JButton("Añadir a la cesta");
        finalizar = new JButton("Finalizar compra");

        ventana.add(lblCodigo);
        ventana.add(codigo);
        ventana.add(anadir);
        ventana.add(finalizar);

        this.add(ventana);
        ventana.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        this.pack();
        this.setVisible(true);
        this.setSize(400, 150);
    }
    
    public void addBtnListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    public static void main(String[] args) {
        new GUINuevaCompra();
    }

    public JButton getbAnadir() { return anadir; }
    public JButton getbFinalizar() { return finalizar; }
    public String getCodigo() { return codigo.getText(); }
    public void setCodigo(String text) { codigo.setText(text); }
}
