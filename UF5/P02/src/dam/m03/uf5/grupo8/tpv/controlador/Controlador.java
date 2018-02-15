package dam.m03.uf5.grupo8.tpv.controlador;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.vista.GUIAnadirCliente;
import dam.m03.uf5.grupo8.tpv.vista.GUIAnadirProducto;
import dam.m03.uf5.grupo8.tpv.vista.GUIBuscarCliente;
import dam.m03.uf5.grupo8.tpv.vista.GUICajaRegistradora;
import dam.m03.uf5.grupo8.tpv.vista.GUIListaYTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private GUICajaRegistradora GUICaja;
    private CajaRegistradora caja;

    public Controlador(GUICajaRegistradora GUICaja, CajaRegistradora caja) {
        this.GUICaja = GUICaja;
        this.caja = caja;
        
        this.GUICaja.addBtnListener(GUICaja.getbNewCompra(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ControladorBuscarCliente(new GUIBuscarCliente(), caja);
            }
        });
        
        this.GUICaja.addBtnListener(GUICaja.getbAddCliente(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ControladorAnadirCliente(new GUIAnadirCliente(), caja);
            }
        });
        
        this.GUICaja.addBtnListener(GUICaja.getbAddProducto(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ControladorAnadirProducto(new GUIAnadirProducto(), caja);
            }
        });
        
        this.GUICaja.addBtnListener(GUICaja.getbListCompras(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIListaYTicket lista = new GUIListaYTicket();
                lista.setListado(caja.listarCompras());
            }
        });
    } 
}
