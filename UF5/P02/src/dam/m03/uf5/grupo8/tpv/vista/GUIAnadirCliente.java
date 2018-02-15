package dam.m03.uf5.grupo8.tpv.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIAnadirCliente extends JFrame {

    private JTextField nombre;
    private JTextField apellido;
    private JTextField nif;
    private JButton bAceptar;

    public GUIAnadirCliente() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pRequisitos = new JPanel(new GridLayout(3, 2, 0, 10));
        JPanel pBoton = new JPanel(new BorderLayout());
        JPanel ventana = new JPanel(new BorderLayout());
        JLabel lblnombre = new JLabel("Nombre: ");
        JLabel lblApellidos = new JLabel("Apellidos: ");
        JLabel lblDNI = new JLabel("DNI: ");
        nombre = new JTextField();
        apellido = new JTextField();
        nif = new JTextField();
        bAceptar = new JButton("Aceptar");
        pBoton.add(bAceptar);
        pRequisitos.add(lblnombre);
        pRequisitos.add(nombre);
        pRequisitos.add(lblApellidos);
        pRequisitos.add(apellido);
        pRequisitos.add(lblDNI);
        pRequisitos.add(nif);
        ventana.add(pRequisitos, BorderLayout.NORTH);
        ventana.add(pBoton, BorderLayout.SOUTH);
        this.add(ventana);
        ventana.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        this.setVisible(true);
        this.pack();
        this.setSize(300, 200);
    }

    public static void main(String[] args) {
        GUIAnadirCliente gAC = new GUIAnadirCliente();
    }
    
    public void addBtnListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }
    
    public String getNombre() { return this.nombre.getText(); }
    public String getApellido() { return this.apellido.getText(); }
    public String getNif() { return this.nif.getText(); }
    public JButton getbAceptar() { return bAceptar; }
}
