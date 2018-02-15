package dam.m03.uf5.grupo8.tpv.vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIBuscarCliente extends JFrame {
    private JComboBox<String> tipoId;
    private JTextField idCliente;
    private JButton bAceptar;
    
    public GUIBuscarCliente() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel ventana = new JPanel(new GridLayout(0,1,10,10));
        bAceptar = new JButton("Aceptar");
        JLabel lblClie = new JLabel("Buscar Cliente");
        String[] opciones = {"NIF", "Codigo"};
        tipoId = new JComboBox<>(opciones);
        idCliente = new JTextField();
        
        ventana.add(lblClie);
        ventana.add(tipoId);
        ventana.add(idCliente);
        ventana.add(bAceptar);
        ventana.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        this.add(ventana);
        this.setVisible(true);
        this.pack();
        this.setSize(400, 200);
    }
    
    public static void main(String[] args) {
        new GUIBuscarCliente();
    }
    
    public void addBtnListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }
    
    public String getIdCliente() { return idCliente.getText(); }
    public String getTipoId() { return tipoId.getSelectedItem().toString(); }
    public JButton getbAceptar() { return bAceptar; }
}
