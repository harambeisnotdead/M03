package dam.m03.uf5.grupo8.tpv.controlador;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.modelo.Producto;
import dam.m03.uf5.grupo8.tpv.vista.GUIAnadirProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorAnadirProducto {
    private GUIAnadirProducto GUIProducto;
    private CajaRegistradora caja;

    public ControladorAnadirProducto(GUIAnadirProducto GUIProducto, CajaRegistradora caja) {
        this.GUIProducto = GUIProducto;
        this.caja = caja;
        
        this.GUIProducto.addBtnListener(GUIProducto.getbAceptar(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    caja.getListaProductos().addProducto(
                            new Producto(GUIProducto.getCodigo(),
                                         GUIProducto.getDecripcion(),
                                         GUIProducto.getPrecio(),
                                         GUIProducto.getIVA(),
                                         GUIProducto.isGranel()));
                    GUIProducto.dispose();
                } catch (Exception err) { JOptionPane.showMessageDialog(null, err.getMessage()); }
            } 
        });
        
        this.GUIProducto.addBtnListener(GUIProducto.getbCancelar(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIProducto.dispose();
            }
        });
    }
}
