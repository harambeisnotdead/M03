package dam.m03.uf5.grupo8.tpv;

import dam.m03.uf5.grupo8.tpv.modelo.CajaRegistradora;
import dam.m03.uf5.grupo8.tpv.controlador.Controlador;
import dam.m03.uf5.grupo8.tpv.modelo.ProductoException;
import dam.m03.uf5.grupo8.tpv.vista.GUICajaRegistradora;

public class Main {
    public static void main(String[] args) throws ProductoException {
        GUICajaRegistradora GUICaja = new GUICajaRegistradora();
        CajaRegistradora caja = new CajaRegistradora("a", "b", "c", "d");
        Controlador controlador = new Controlador(GUICaja, caja);
    }
}
