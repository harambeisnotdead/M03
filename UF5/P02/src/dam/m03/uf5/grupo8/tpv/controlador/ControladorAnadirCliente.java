package dam.m03.uf5.grupo8.tpv.controlador;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.vista.GUIAnadirCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorAnadirCliente {
    private GUIAnadirCliente GUICliente;
    private CajaRegistradora caja;

    public ControladorAnadirCliente(GUIAnadirCliente GUICliente, CajaRegistradora caja) {
        this.GUICliente = GUICliente;
        this.caja = caja;
        
        this.GUICliente.addBtnListener(GUICliente.getbAceptar(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = GUICliente.getNombre();
                String apellido = GUICliente.getApellido();
                String nif = GUICliente.getNif();
                try {
                    caja.altaCliente(nombre, apellido, nif);
                    GUICliente.dispose();
                } catch (Exception err) { JOptionPane.showMessageDialog(null, err.getMessage()); }
            }
        });
    }
}
