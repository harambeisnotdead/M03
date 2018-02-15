package dam.m03.uf5.grupo8.tpv.vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUICajaRegistradora extends JFrame {

    private JButton bNewCompra;
    private JButton bAddCliente;
    private JButton bAddProducto;
    private JButton bListCompras;

    public GUICajaRegistradora() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel ventana = new JPanel(new GridLayout(2, 2, 10, 10));

        bNewCompra = new JButton("Nueva Compra");
        bAddCliente = new JButton("Alta Cliente");
        bAddProducto = new JButton("Añadir producto");
        bListCompras = new JButton("Listar Compras");

        ventana.add(bNewCompra);
        ventana.add(bAddCliente);
        ventana.add(bAddProducto);
        ventana.add(bListCompras);
        
        this.setVisible(true);
        this.add(ventana);
        ventana.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.pack();
        this.setSize(600, 300);
    }
    
    public void addBtnListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    public JButton getbNewCompra() {
        return bNewCompra;
    }

    public JButton getbAddCliente() {
        return bAddCliente;
    }

    public JButton getbAddProducto() {
        return bAddProducto;
    }

    public JButton getbListCompras() {
        return bListCompras;
    }
    
    public static void main(String[] args) {
        new GUICajaRegistradora();
    }
}
