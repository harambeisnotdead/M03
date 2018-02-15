package dam.m03.uf5.grupo8.tpv.vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIAnadirProducto extends JFrame {
    private JTextField codigo;
    private JTextField descripcion;
    private JTextField precio;
    private JTextField IVA;
    private JCheckBox granel;
    private JButton bAceptar;
    private JButton bCancelar;

    public GUIAnadirProducto() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel ventana = new JPanel(new GridLayout(6, 2, 5, 10));
        JLabel lblCodigo = new JLabel("Código:");
        codigo = new JTextField();
        JLabel lblDescripcion = new JLabel("Descripción:");
        descripcion = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        precio = new JTextField();
        JLabel lblIVA = new JLabel("IVA:");
        IVA = new JTextField();
        JLabel lblGranel = new JLabel("Granel:");
        granel = new JCheckBox();
        bAceptar = new JButton("Aceptar");
        bCancelar = new JButton("Cancelar");

        ventana.add(lblCodigo);
        ventana.add(codigo);
        ventana.add(lblDescripcion);
        ventana.add(descripcion);
        ventana.add(lblPrecio);
        ventana.add(precio);
        ventana.add(lblIVA);
        ventana.add(IVA);
        ventana.add(lblGranel);
        ventana.add(granel);
        ventana.add(bAceptar);
        ventana.add(bCancelar);
        
        this.add(ventana);
        this.setVisible(true);
        ventana.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        this.pack();
        this.setSize(400, 300);
    }

    public static void main(String[] args) {
        GUIAnadirProducto AP = new GUIAnadirProducto();
    }
    
    public void addBtnListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    public String getCodigo() { return codigo.getText(); }
    public String getDecripcion() { return descripcion.getText(); }
    public Double getPrecio() { return Double.parseDouble(precio.getText()); }
    public int getIVA() { return Integer.parseInt(IVA.getText()); }
    public Boolean isGranel() { return granel.isSelected(); }
    public JButton getbAceptar() { return bAceptar; }
    public JButton getbCancelar() { return bCancelar; }
}
