package dam.m03.uf5.grupo8.tpv.controlador;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.modelo.Cliente;
import dam.m03.uf5.grupo8.tpv.vista.GUIBuscarCliente;
import dam.m03.uf5.grupo8.tpv.vista.GUINuevaCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorBuscarCliente {
    private GUIBuscarCliente GUIBuscar;
    private CajaRegistradora caja;

    public ControladorBuscarCliente(GUIBuscarCliente GUIBuscar, CajaRegistradora caja) {
        this.GUIBuscar = GUIBuscar;
        this.caja = caja;
        
        this.GUIBuscar.addBtnListener(GUIBuscar.getbAceptar(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = caja.getCliente(GUIBuscar.getIdCliente(), GUIBuscar.getTipoId());
                    new ControladorNuevaCompra(new GUINuevaCompra(), caja, cliente);
                    GUIBuscar.dispose();
                } catch (Exception err) { JOptionPane.showMessageDialog(null, err.getMessage()); }
            }   
        });
    }
    
}
