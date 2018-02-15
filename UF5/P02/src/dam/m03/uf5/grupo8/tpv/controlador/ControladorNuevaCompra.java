package dam.m03.uf5.grupo8.tpv.controlador;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.modelo.Cliente;
import dam.m03.uf5.grupo8.tpv.modelo.Compra;
import dam.m03.uf5.grupo8.tpv.modelo.Producto;
import dam.m03.uf5.grupo8.tpv.vista.GUIListaYTicket;
import dam.m03.uf5.grupo8.tpv.vista.GUINuevaCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorNuevaCompra {
    private GUINuevaCompra GUINueva;
    private CajaRegistradora caja;
    private Cliente cliente;
    private Compra compra;

    public ControladorNuevaCompra(GUINuevaCompra GUINueva, CajaRegistradora caja, Cliente cliente) {
        this.GUINueva = GUINueva;
        this.caja = caja;
        this.cliente = cliente;
        
        this.GUINueva.addBtnListener(GUINueva.getbAnadir(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto producto = caja.getProducto(GUINueva.getCodigo());
                    if (producto.isGranel()) {
                        String peso = JOptionPane.showInputDialog("Introduce el peso:");
                        compra = caja.nuevaCompra(cliente, producto, peso);
                    } else
                        compra = caja.nuevaCompra(cliente, producto);
                    JOptionPane.showMessageDialog(null, String.format("Producto %s - %.2f€ (con IVA) añadido", 
                            producto.getDescripcionCorta(), producto.getPrecioConIVA()));
                    GUINueva.setCodigo("");
                } catch (Exception err) { JOptionPane.showMessageDialog(null, err.getMessage()); }
            }
        });
        
        this.GUINueva.addBtnListener(GUINueva.getbFinalizar(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new GUIListaYTicket().setListado(caja.getTicket(compra));
                    GUINueva.dispose();
                } catch (Exception err) { JOptionPane.showMessageDialog(null, err.getMessage()); }
            }
        });
    }
    
    
}
